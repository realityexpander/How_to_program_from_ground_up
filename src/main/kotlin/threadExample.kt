private const val NUMBER_OF_CYCLES = 100

fun main() {
	threadsWithUpdateProblem()

	fixedThreadUpdateProblemWithAtomicUpdates()
}

fun threadsWithUpdateProblem() {
	var x = 0

	val thread1 = Thread {
		for (i in 1..NUMBER_OF_CYCLES) {
			x++
			println("Thread 1: i=$i, x=$x")
			Thread.sleep(10) // milliseconds
		}
	}
	val thread2 = Thread {
		for (i in 1..NUMBER_OF_CYCLES) {
			x++
			println("Thread 2: i=$i, x=$x")
			Thread.sleep(10) // milliseconds
		}
	}

	thread1.start()
	thread2.start()
	thread1.join()
	thread2.join()

	println("Final value of x: $x, should be ${NUMBER_OF_CYCLES * 2}")
}

// Output:
//	Thread 2: 1, x=0
//	Thread 1: 1, x=0
//	Thread 2: 2, x=2
//	Thread 1: 2, x=2
//	Thread 2: 3, x=4
//	Thread 1: 3, x=5
//	Thread 2: 4, x=6
//	Thread 1: 4, x=7  // <-- Notice that the order of the output is not consistent, as the threads are running concurrently.
//	Thread 1: 5, x=8
//	Thread 2: 5, x=8
//	Thread 1: 6, x=10
//	Thread 2: 6, x=10 // <-- Notice the value of `x` is not consistently incrementing, as the updates are not `atomic`.
//	Thread 1: 7, x=12
//	Thread 2: 7, x=13
// ...
//	Thread 1: i=98, x=186
//	Thread 2: i=99, x=187
//	Thread 2: i=100, x=188
//	Thread 1: i=99, x=189
//	Thread 1: i=100, x=190
// Final value of x: 190, should be 200  // <-- Notice the final value of `x` is not 200, as expected.

fun fixedThreadUpdateProblemWithAtomicUpdates() {
	var x = 0
	val lock = Any() // Doesn't matter what the type is. It's just used as a lock or "flag" to synchronize the threads.

	println("\nFixed Thread Update Problem (race condition) using Atomic updates (synchronized)")

	val thread1 = Thread {
		for (i in 1..NUMBER_OF_CYCLES) {
			synchronized(lock) {  // <-- `synchronized` tells the execution to wait here until the lock is released.
				// the update is locked here, so the other thread can't update `x` until the current thread is done.
				x++
				println("Thread 1: i=$i, x=$x")
			} // <-- The lock is released here at the end of the synchronized block.
			Thread.sleep(10) // milliseconds
		}
	}
	val thread2 = Thread {
		for (i in 1..NUMBER_OF_CYCLES) {
			synchronized(lock) {
				x++
				println("Thread 2: i=$i, x=$x")
			}
			Thread.sleep(10) // milliseconds
		}
	}

	thread1.start()
	thread2.start()
	thread1.join()
	thread2.join()

	println("Final value of x: $x, should be ${NUMBER_OF_CYCLES * 2}")
}

// Output:
//	Fixed Thread Update Problem (Atomic updates)
//	Thread 1: i=1, x=1
//	Thread 2: i=1, x=2
//	Thread 1: i=2, x=3
//	Thread 2: i=2, x=4
//	Thread 2: i=3, x=5  // <-- Notice that the order of the output is inconsistent, as the threads are running concurrently.
//	Thread 1: i=3, x=6
//	Thread 1: i=4, x=7
//	Thread 2: i=4, x=8
//	Thread 2: i=5, x=9
// ...
//	Thread 2: i=98, x=195
//	Thread 1: i=98, x=196
//	Thread 2: i=99, x=197
//	Thread 1: i=99, x=198
//	Thread 2: i=100, x=199  // <-- Notice the value of `x` IS consistently incrementing, as the updates are `atomic`.
//	Thread 1: i=100, x=200
//	Final value of x: 200, should be 200