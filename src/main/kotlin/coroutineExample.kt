import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

private const val NUMBER_OF_CYCLES = 100 // may need 200 to guarantee the problem will occur.

fun main() {
	coroutineWithUpdateProblem()

	fixedCoroutineUpdateProblemWithAtomicUpdates()
}

@OptIn(DelicateCoroutinesApi::class, ExperimentalTime::class)
fun coroutineWithUpdateProblem() {
	var x = 0

	val job1 = GlobalScope.launch {
		for (i in 1..NUMBER_OF_CYCLES) {
			x++
			println("Coroutine 1: $i, x=$x")
			delay(10.milliseconds)
		}
	}
	val job2 = GlobalScope.launch {
		for (i in 1..NUMBER_OF_CYCLES) {
			x++
			println("Coroutine 2: $i, x=$x")
			delay(10.milliseconds)
		}
	}

	runBlocking {
		job1.join()
		job2.join()
	}

	println("Final value of x: $x, should be ${NUMBER_OF_CYCLES * 2}")
}

// Output:
//	Coroutine 2: 1, x=1
//	Coroutine 1: 1, x=2
//	Coroutine 2: 2, x=3
//	Coroutine 1: 2, x=4
//	Coroutine 2: 3, x=5
//	Coroutine 1: 3, x=6
//	Coroutine 2: 4, x=7
//	Coroutine 1: 4, x=8
//	Coroutine 2: 5, x=9
//	Coroutine 1: 5, x=10
//	Coroutine 2: 6, x=11
//	Coroutine 1: 6, x=12
//	Coroutine 1: 7, x=14 // <-- Notice the order of the output is inconsistent, as the coroutines run concurrently.
// ...
//	Coroutine 1: 8, x=14 // <-- Notice the value of `x` is inconsistently incrementing, as the updates are NOT "atomic."
//	Coroutine 2: 8, x=14
//	Coroutine 1: 9, x=16
//	Coroutine 2: 9, x=17
// ...
//	Coroutine 2: 99, x=192
//	Coroutine 1: 99, x=193
//	Coroutine 1: 100, x=194
//	Coroutine 2: 100, x=195
// Final value of x: 195, should be 200 // <-- Notice the final value of `x` is not correct.

// Fix the issue with the atomic updates by using the `StateFlow` class.
@OptIn(ExperimentalTime::class, DelicateCoroutinesApi::class)
fun fixedCoroutineUpdateProblemWithAtomicUpdates() {
	val x = MutableStateFlow(0)

	println("\nFixed Coroutine Update Problem using Atomic updates (StateFlow)")

	val job1 = GlobalScope.launch {
		for (i in 1..NUMBER_OF_CYCLES) {
			x.update { it + 1}
			println("Coroutine 1: i=$i, x=${x.value}")
			delay(10.milliseconds)
		}
	}

	val job2 = GlobalScope.launch {
		for (i in 1..NUMBER_OF_CYCLES) {
			x.update { it + 1}
			println("Coroutine 2: i=$i, x=${x.value}")
			delay(10.milliseconds)
		}
	}

	runBlocking {
		job1.join()
		job2.join()
	}

	println("Final value of x: ${x.value}, should be ${NUMBER_OF_CYCLES * 2}")
}

// Output:
//	Fixed Coroutine Update Problem
//	Coroutine 2: 1, x=2
//	Coroutine 1: 1, x=1
//	Coroutine 2: 2, x=4
//	Coroutine 1: 2, x=3
//	Coroutine 2: 3, x=5
//	Coroutine 1: 3, x=6  // <-- Notice that the order of the output is inconsistent, as the coroutines run concurrently.
//	Coroutine 1: 4, x=8
//	Coroutine 2: 4, x=7  // <-- Notice the value of `x` IS consistently incrementing, as the updates are `atomic`.
//	Coroutine 1: 5, x=9
//	Coroutine 2: 5, x=10
//	Coroutine 2: 6, x=12
// ...
// Final value of x: 200, should be 200 // <-- Notice the final value of `x` is correct.