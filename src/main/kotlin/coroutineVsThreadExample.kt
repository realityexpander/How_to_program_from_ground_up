import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

fun main() {
	runBlocking {
		threadVsCoroutinesPerformanceDifference()
	}
}

// Example of using coroutines and threads to compare performance for 100_000 tasks.
@OptIn(DelicateCoroutinesApi::class, ExperimentalTime::class)
suspend fun threadVsCoroutinesPerformanceDifference() {
	val counter = AtomicInteger(0)
	val numParallelTasks = 100_000

	println("\nThread vs Coroutines Performance Difference:")

	// Using coroutines
	println("Coroutines running...")
	val job = GlobalScope.launch {
		repeat(numParallelTasks) {
			launch {
				counter.incrementAndGet()
				delay(3.milliseconds)
			}
		}
	}
	job.join()
	var startTime = System.currentTimeMillis()
	println("Coroutines result: ${counter.get()}")
	println("Time taken: ${System.currentTimeMillis() - startTime}ms")

	// Using threads
	println("\nThreads running...")
	val threadList = List(numParallelTasks) {
		Thread {
			counter.incrementAndGet()
			Thread.sleep(3) // 3ms
		}
	}
	counter.set(0)
	startTime = System.currentTimeMillis()
	threadList.forEach(Thread::start)
	threadList.forEach(Thread::join)
	println("\nThreads result: ${counter.get()}")
	println("Time taken: ${System.currentTimeMillis() - startTime}ms")
}

// Output:
//	Coroutines result: 100000
//	Time taken: 33ms
//
//	Threads result: 100000
//	Time taken: 5956ms