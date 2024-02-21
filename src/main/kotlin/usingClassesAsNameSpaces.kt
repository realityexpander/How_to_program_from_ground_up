// Kotlin Example of Using a Class as a "Name-Space" to Group Together Methods
// - Using COP style mashed together with Procedural style.

// The `Person` class is used as a "structure" to group together data that is related to a person.
// It's COP because it has a method that operates on its own object's data.
data class Person(
	var name: String = "John Doe",
	var age: Int = 0,  // never store age like this, always calculate it from the birthdate.
	var height: Double = 0.0,
	var weight: Double = 0.0
) {
	// This is a method that is part of the `Person` class. This makes it a COP `class` and not a `struct`.
	fun printPerson() {
		println("Name: ${this.name}, Age: ${this.age}, Height: ${this.height}, Weight: ${this.weight}")
	}
}

// Here's just a bunch of functions that operate on the `Person` class / "structure", like in procedural and structured programming.
fun printPerson(person: Person) {
	println("Name: ${person.name}, Age: ${person.age}, Height: ${person.height}, Weight: ${person.weight}")
}
fun changeName(person: Person, newName: String) {
	person.name = newName
}
fun changeAge(person: Person, newAge: Int) {
	person.age = newAge
}
fun changeHeight(person: Person, newHeight: Double) {
	person.height = newHeight
}
fun changeWeight(person: Person, newWeight: Double) {
	person.weight = newWeight
}

// This class is used as a "name-space" to group together methods that operate on the `Person` class.
class PersonManager {
	companion object { // <-- creates a `static` set of functions that can be accessed without an instance of the `PersonManager` class.
		fun changeName(person: Person, newName: String) {
			person.name = newName
		}
		fun changeAge(person: Person, newAge: Int) {
			person.age = newAge
		}
		fun changeHeight(person: Person, newHeight: Double) {
			person.height = newHeight
		}
		fun changeWeight(person: Person, newWeight: Double) {
			person.weight = newWeight
		}
	}
}

// This class is used as a "name-space" to group together methods that operate on the `Person` class.
class PersonManager2 {
	fun changeName(person: Person, newName: String) {
		person.name = newName
	}
	fun changeAge(person: Person, newAge: Int) {
		person.age = newAge
	}
	fun changeHeight(person: Person, newHeight: Double) {
		person.height = newHeight
	}
	fun changeWeight(person: Person, newWeight: Double) {
		person.weight = newWeight
	}
	fun printPerson(person: Person) {
		println("Name: ${person.name}, Age: ${person.age}, Height: ${person.height}, Weight: ${person.weight}")
	}
}

// Start of Program
fun main() {
	val person = Person("John Doe", 30, 6.0, 200.0)

	// Directly accessing the data, like in procedural & structured programming.
	person.name = "Jane Doe"
	person.age = 25
	person.height = 5.5
	person.weight = 150.0
	person.printPerson()  // <-- "touch" of COP because a method is being called on the `person` object, not "just" a function.

	// Using functions like in the procedural and structured programming.
	changeName(person, "Jane Doe")
	changeAge(person, 25)
	changeHeight(person, 5.5)
	changeWeight(person, 150.0)
	printPerson(person)

	// Using the `static` methods of the `PersonManager` class to manipulate the data of the `Person` object.
	PersonManager.changeName(person, "Jane Doe")
	PersonManager.changeAge(person, 25)
	PersonManager.changeHeight(person, 5.5)
	PersonManager.changeWeight(person, 150.0)
	person.printPerson()

	// Another common mistake, that is equivalent to above.
	val pm = PersonManager2()  // <-- Creating an object just to call a method is a waste of memory. Why not just call a function?
	pm.changeName(person, "Jane Doe")
	pm.changeAge(person, 25)
	pm.changeHeight(person, 5.5)
	pm.changeWeight(person, 150.0)
	pm.printPerson(person)
}

// Output:
// Name: Jane Doe, Age: 25, Height: 5.5, Weight: 150.0
// Name: Jane Doe, Age: 25, Height: 5.5, Weight: 150.0
// Name: Jane Doe, Age: 25, Height: 5.5, Weight: 150.0
// Name: Jane Doe, Age: 25, Height: 5.5, Weight: 150.0