// Kotlin program to pedantically demonstrate the concept of "side effects."

fun main() {
	var x = 0 // <-- Defines a variable that will be "affected" or "mutated" by the lambda.
	val add = { a: Int, b: Int -> // <-- Defines a lambda that takes two Ints and returns an Int.
		val result =  a + b + x
		x += a  // <-- Create a "side effect" by changing the value of `x` outside the lambda.

		result // <-- Return the result of the addition.
	}

	print(add(1, 2))  // <-- Print expected value the first time called (3).

	println(add(1, 2))  // <-- Print the unexpected value the second time called (4) due to the side effect.
}

// Output:
// 3   // <-- This value of is what we expected, only the first time though...
// 4   // <-- This value of is **NOT** what we expected due to the "side effect."
