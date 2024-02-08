data class Point(  // <-- `Point` is a programmer-defined type that is made up of other types
	val x: Int,  // <-- `Int` is a type that represents a whole number (32 bits)
	val y: Int,  // <-- `Int` is a type that represents a whole number (32 bits)
	val colorIdChar: Char  // <-- `char` is a type that represents a single ASCII character (1 byte)
)

fun main() {
	val x: Int = 5
	val y: Float = 6.128f
	val z: Char = 'A'
	val p: Point = Point(10, 42, 'G')

	println("Output: $x $y $z ${p.x} ${p.y} ${p.colorIdChar}")
}

// Output: 5 6.128 A 10 42 G