import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

fun main() {
	runBlocking { // <-- `runBlocking` creates a coroutine context and runs the code inside it.
		threadVsCoroutinesPerformanceDifference()
	}
}

// Example of using coroutines and threads to compare performance for 100_000 tasks. (the _ is just for human readability, and ignored by the compiler.)
@OptIn(DelicateCoroutinesApi::class, ExperimentalTime::class)
suspend fun threadVsCoroutinesPerformanceDifference() {  // <-- `suspend` keyword means this function can be called from a coroutine.
	val counter = AtomicInteger(0)
	val numParallelTasks = 100_000

	println("\nThread vs Coroutines Performance Difference:")

	// Using coroutines
	println("Coroutines running...")
	val job = GlobalScope.launch {
		repeat(numParallelTasks) {// <-- `repeat` runs the given task 100_000 times.
			launch {// <-- `launch` creates a new coroutine with the given task.
				// The task:
				counter.incrementAndGet() // <-- this is the task.
				delay(3.milliseconds)
			}
		}
	}
	var startTime = System.currentTimeMillis()
	job.join()  // <-- `join` waits for the coroutine to finish.
	println("Coroutines result: ${counter.get()}")
	println("Time taken: ${System.currentTimeMillis() - startTime}ms")

	// Using threads
	println("\nThreads running...")
	val threadList = List(numParallelTasks) {// <-- `List` creates a list of 100_000 elements.
		Thread {  // <-- `Thread` creates a new thread with the given task.
			// The task:
			counter.incrementAndGet()
			Thread.sleep(3) // 3ms
		}
	}
	counter.set(0)
	startTime = System.currentTimeMillis()
	threadList.forEach(Thread::start)  // <-- `start` starts running the task in a new thread.
	threadList.forEach(Thread::join) // <-- `join` waits for the thread to finish.
	println("\nThreads result: ${counter.get()}")
	println("Time taken: ${System.currentTimeMillis() - startTime}ms")
}

// Output:
//	Coroutines result: 100000
//	Time taken: 33ms
//
//	Threads result: 100000
//	Time taken: 5956ms