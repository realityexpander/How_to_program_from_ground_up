// Liskov Substitution Principle Example

interface Shape {
	val name: String
	fun area(): Float
}

open class Rectangle(
	val width: Float,
	val height: Float
): Shape {
	override val name = "Rectangle"
	override fun area() = width * height
}

class Circle(val radius: Float): Shape {
	override val name = "Circle"
	override fun area(): Float = (3.14 * radius * radius).toFloat()
}

class Square(val side: Float): Rectangle(side, side) {  // <-- Square is a subclass of `Rectangle`, still a `Shape`.
	override val name = "Square"
}

// Start of the program
fun main() {
	val rectangle = Rectangle(10f, 20f)
	val square = Square(10.0f)
	val circle = Circle(10.0f)
	// val someShape = Shape() // <-- This will not compile because Shape is an interface and cannot be instantiated.

	// Can call area() method on all shapes
	println("Rectangle area: ${rectangle.area()}")
	println("Square area: ${square.area()}")
	println("Circle area: ${circle.area()}")

	// Can use a list of Shapes
	val listOfShapes: List<Shape> = listOf(rectangle, square, circle) // <-- Allocates a list of Shapes and adds the shapes to it
	listOfShapes.forEach {
		println("Area for shape ${it.name}: ${it.area()}")
	}

	// Can't have a Circle in a list that only accepts Rectangles
	// val listOfRectangles: List<Rectangle> = listOf(rectangle, square, circle) // <-- This will not compile
}


// Output:
// Rectangle area: 200.0
// Square area: 100.0
// Circle area: 314.0
// Area for shape Rectangle: 200.0
// Area for shape Square: 100.0
// Area for shape Circle: 314.0
