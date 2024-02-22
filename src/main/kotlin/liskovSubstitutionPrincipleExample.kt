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

	// Can call `area()` method on any subclass of `Shape`:
	println("Rectangle area: ${rectangle.area()}")
	println("Square area: ${square.area()}")
	println("Circle area: ${circle.area()}")

	// Can create a `Shape`-s list that accepts any subclass of Shape:
	val shapes: List<Shape> = listOf(rectangle, square, circle) // <-- Allocates a list of Shapes and adds the shapes to it.
	shapes.forEach { shape ->
		println("Area for shape ${shape.name}: ${shape.area()}")
	}

	// Can't have a Circle in a list that only accepts Rectangles:
	// val rectangles: List<Rectangle> = listOf(rectangle, circle) // <-- This will NOT compile.

	// Can't add a Rectangle to a list of Circles:
	val circle2 = Circle(20.0f)
	val circles: List<Circle> = listOf(circle, circle2) // <-- This will compile.
	// circles.add(Rectangle(10f, 20f)) // <-- This will NOT compile.
}


// Output:
// Rectangle area: 200.0
// Square area: 100.0
// Circle area: 314.0
// Area for shape Rectangle: 200.0
// Area for shape Square: 100.0
// Area for shape Circle: 314.0
