

fun main() {  // <-- start of the program, int means the function returns an integer
	val y = 100
	var x = 10
	run { // <-- start of a "scope" or "code block" or just "block"

		val y = 32 // local to the "scope"
		x = x + y
	} // <-- end of the "scope"

	println(x) // <-- print the value of x as a decimal number
	println(x.toChar()) // <-- print the value of x as a character (the ASCII value of x)
}

// Output:
// 42
// *