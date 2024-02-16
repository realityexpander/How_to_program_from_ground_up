fun main() {
	val addFun = { x: Int, y: Int -> x + y }  // <-- a lambda that takes 2 integers and returns the sum of the integers.
	val multiplyFun = { x: Int, y: Int -> x * y }  // <-- a lambda that takes 2 integers and returns the product of the integers.
	val firstThenSecond = {  // <-- a lambda that takes 4 arguments, 2 functions and 2 integers, and returns the result of the 2 functions.
			first: (Int, Int) -> Int, // <-- a lambda that takes 2 integers and returns an integer, it's executed first.
			second: (Int, Int) -> Int,  // <-- a lambda that takes 2 integers and returns an integer, it's executed second.
			a: Int,
			b: Int ->
		second(first(a, b), b)  // <-- calls the `first` lambda with the 2 integers (a & b),
		//     then calls the `second` lambda with the result of `first()` and the 2nd integer (b).
	}

	val result = firstThenSecond(addFun, multiplyFun, 10, 2) // <-- calls the lambda with the 2 functions and 2 integers.
	println(result) // the result will be 24.
}

// Output:
// 24