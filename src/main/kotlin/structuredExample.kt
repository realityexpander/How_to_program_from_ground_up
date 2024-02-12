

fun main() {  // <-- start of the program, int means the function returns an integer
	var y: Int = 100
	var x: Int = 10

	run { // <-- start of a scope or "code block" or just "block"
		var y: Int = 32 // Inside the brackets "Inner" or "Local" to the scope.
		var z: Int = 54 // <-- Only visible to the scope it's defined in, ie: this one.

		x = x + y
	} // <-- end of the "scope"

	println(x) // <-- print the value of x as a decimal number
	println(x.toChar()) // <-- print the value of x as a character (the ASCII value of x)
	// println(z) // <-- this will cause a compile error, because `z` is not defined in this scope
}

// Output:
// 42
// *