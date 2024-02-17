fun main() {
	var x = 0 // <-- a variable that will be "affected" or "mutated" by the lambda.
	val add = { a: Int, b: Int ->
		val result =  a + b + x
		x += a  // <-- Create a "side effect" by changing the value of `x` outside the lambda.

		result // <-- return the result of the addition.
	}

	print(add(1, 2))  // <-- print expected value the first time called (3).

	println(add(1, 2))  // <-- print the unexpected value the second time called (4) due to the side effect.
}

// Output:
// 3   // <-- The value of is what we expected, only the first time though.
// 4   // <-- This value of is not what we expected.
