// Program to demonstrate time complexity of various algorithms.

// Algorithm: Binary Search
// Performs a binary search on a sorted array - O(log n)
// Returns the index of the value in the array, or -1 if the value is not found.
fun Array<Int>.binarySearch(searchValue: Int): Int {
	var low = 0
	var high = size - 1
	while (low <= high) {
		val mid = (low + high) / 2
		val midVal = this[mid]
		when {
			midVal < searchValue -> low = mid + 1
			midVal > searchValue -> high = mid - 1
			else -> return mid
		}
	}

	return -1 // -1 = value not found
}

// Algorithm: Quick Sort
// Perform recursive quicksort - O(n log n)
// Returns a new sorted array.
fun Array<Int>.quickSort(): Array<Int> {
	if (size < 2) return this
	val pivot = this[randomInt(size - 1)]

	val less = filter { it < pivot }.toTypedArray().quickSort()
	val equal = filter { it == pivot }.toTypedArray()
	val greater = filter { it > pivot }.toTypedArray().quickSort()

	return less + equal + greater
}

fun randomInt(max: Int) = (0..max).random()

fun main() {
	val x = Array(2_000) { randomInt(100) } // <-- O(n) - Fill Array `x` with 2000 random integers
	var result: Long = 0

	var start = System.currentTimeMillis()
	result = x[500].toLong() // <-- O(1)
	println("Constant Time Lookup O(1) = Result: $result, Time: ${System.currentTimeMillis() - start}ms")


	start = System.currentTimeMillis()
	result = 0
	for (i in 0 until x.size) { // <-- O(n)
		result = x[i] + result
	}
	println("Linear Time Lookup O(n) = Result: $result, Time: ${System.currentTimeMillis() - start}ms")


	start = System.currentTimeMillis()
	result = 0
	for (i in 0 until x.size) { // <-- O(n)
		for (j in 0 until x.size) { // <-- O(n^2)
			result = x[i] + x[j] + result
		}
	}
	println("Quadratic Time Lookup O(n^2) = Result: $result, Time: ${System.currentTimeMillis() - start}ms")


	// Notice how this one takes MUCH, MUCH longer than the previous ones.
	start = System.currentTimeMillis()
	result = 0
	for (i in 0 until x.size) { // <-- O(n)
		for (j in 0 until x.size) { // <-- O(n^2)
			for (k in 0 until x.size) { // <-- O(n^3)
				result = x[i] + x[j] + x[k] + result
			}
		}
	}
	println("Cubic Time Lookup O(n^3) = Result: $result, Time: ${System.currentTimeMillis() - start}ms")


	start = System.currentTimeMillis()
	val sorted = x.quickSort() // <-- O(n log n)
	println("Logarithmic Time Lookup O(n log n) = Result (size): ${sorted.size}, Time: ${System.currentTimeMillis() - start}ms")


	start = System.currentTimeMillis()
	val y = sorted.binarySearch(50) // <-- O(log n)
	println("Linearithmic Time Lookup O(log n) = Result: $y, Time: ${System.currentTimeMillis() - start}ms")
}
