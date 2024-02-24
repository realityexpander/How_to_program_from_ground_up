// Kotlin example of controlled visibility and inheritance using COP style.
// This example shows how to control the visibility of properties and methods in a class hierarchy.

open class Publication(
	public val fileName: String,
	private var content: String
) {
	protected var numTimesViewed = 0 // This property can be accessed by any subclass of "Publication".
	private var numTimesUpdated = 0    // Only this "Publication" class can access this property.

	// ⬇︎-- This method is public, so it can be called from anywhere.
	fun viewContent() {
		incrementTimesViewed()
		println("Viewing file ${this.fileName}: ${this.content}, times viewed=${this.numTimesViewed}")
	}

	// ⬇︎-- This method is protected, so it can only be called from within the class or any subclass.
	protected fun updateContent(content: String) {
		this.content = content
		incrementTimesUpdated()
		println("Updated: ${this.fileName}, times updated=${this.numTimesUpdated}")
	}

	// ⬇︎-- This methods is private to the class, so it can only be called from within the class.
	private fun incrementTimesViewed() {
		numTimesViewed++
	}

	// ⬇︎-- This method is private to the class, so it can only be called from within the class.
	private fun incrementTimesUpdated() {
		numTimesUpdated++
	}
}

class Magazine(
	fileName: String,
	content: String
): Publication(fileName, content) { // note: The constructor values are passed to the primary constructor of the superclass.

	private var lastUpdatedByName: String = ""

	// ⬇︎-- This method is public, so it can be called from anywhere.
	fun update(content: String, updatedByName: String) {
		super.updateContent(content)

		// ⬇︎-- The `fileName` property is public, so it can be accessed from anywhere.
		println("Updating: ${this.fileName}")

		// ⬇︎-- The `lastUpdatedBy` property is private, so it can only be accessed from within the `Magazine` class.
		this.lastUpdatedByName = updatedByName

		// ⬇︎-- This line will not compile, as `numTimesUpdated` is private to class Publication.
		// super.numTimesUpdated = 0

		// ⬇︎-- This line will not compile, as `incrementTimesUpdated` is private to class Publication.
		// super.incrementTimesUpdated()

		// ⬇︎-- This line will not compile, as `numTimesUpdated` is private to class Publication.
		// println("times updated=${this.numTimesUpdated} times")

		// ⬇︎-- The `numTimesViewed` property is protected, so it can be accessed from any subclass.
		println("File: ${this.fileName} has been viewed ${this.numTimesViewed} times, last updated by: ${this.lastUpdatedByName}")
	}
}


class SomeOtherClass {  // <-- IMPORTANT NOTE: This class is **NOT** a subclass of `Publication` or `Magazine`.

	// ⬇︎-- This method is public, so it can be called from anywhere.
	fun tryToDoStuffToPublication(publication: Publication) {
		publication.viewContent()

		// ⬇︎-- This line will not compile, as `content` is private to class Publication.
		// publication.content = "New Content"

		// ⬇︎-- This line will not compile, as `updateContent` is protected inside class Publication.
		// publication.updateContent("New Content")

		// ⬇︎-- This line will not compile, as `incrementTimesViewed()` is private to class Publication.
		// publication.incrementTimesViewed()

		// ⬇︎-- This line will not compile, as `numTimesUpdated` is private to class Publication.
		// println(publication.numTimesUpdated)

		// ⬇︎-- This line will not compile, as `numTimesViewed` is private to class Publication.
		// println(publication.numTimesViewed)

		// ⬇︎-- This line will compile, as `fileName` is public, and the type of `publication` is `Publication`.
		println("File name: ${publication.fileName}")
	}

	// ⬇︎-- This method is public, so it can be called from anywhere.
	fun tryToDoStuffToMagazine(magazine: Magazine) {
		magazine.viewContent()

		// ⬇︎-- This line will not compile, as `content` is private to class Publication
		// magazine.content = "New Content"

		// ⬇︎-- This line will not compile, as `updateContent` is protected inside class Publication.
		// magazine.updateContent("More Updated Content")

		// ⬇︎-- This line will not compile, as `incrementTimesViewed()` is private to class Publication
		// magazine.incrementTimesViewed()

		// ⬇︎-- Now `update` works, as the `update` method is public, and the type of `magazine` is `Magazine`.
		magazine.update("More Updated Content", "Jim")
		magazine.viewContent()
	}
}

// Start of program
fun main() {

	val magazine = Magazine("Magazine.txt", "Initial Content")
	magazine.viewContent()
	magazine.update("New Content", "Chris")
	magazine.viewContent()

	println() // <-- Just a blank line to separate the output.
	val someOtherClass = SomeOtherClass()
	someOtherClass.tryToDoStuffToPublication(magazine)
	someOtherClass.tryToDoStuffToMagazine(magazine)
}

// Output:
//	Viewing file Magazine.txt: Initial Content, times viewed=1
//	Updated: Magazine.txt, times updated=1
//	Updating: Magazine.txt
//	File: Magazine.txt has been viewed 1 times, last updated by: Chris
//	Viewing file Magazine.txt: New Content, times viewed=2
//
//	Viewing file Magazine.txt: New Content, times viewed=3
//	Viewing file Magazine.txt: New Content, times viewed=4
//	Updated: Magazine.txt, times updated=2
//	Updating: Magazine.txt
//	File: Magazine.txt has been viewed 4 times, last updated by: Jim
//	Viewing file Magazine.txt: More Updated Content, times viewed=5