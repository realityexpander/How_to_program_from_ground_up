// BOOP Programming Example (Back-to Object Oriented Programming, Alan Kay's original vision of OOP)

class Page(  // <-- the "Page" class constructor, the "val" keyword means the variable is immutable.
	private val content: String
) {
	fun view() {
		println("Page: $content")
	}

	fun updateContent(newContent: String): Page {
		return Page(newContent)  // <-- The "updateContent" method returns a new object with the new state.
	}

	fun inspectContent(): String {
		return content
	}
}

class Book(
	val title: String,
	private val pages: List<Page>
) {
	fun view() {
		println("Book: $title, # of Pages: ${pages.size}")
		pages.forEach { it.view() }  // <-- The "forEach" method is a higher order function that takes a lambda function
                                   // `it` refers to the current element in the list, the `page` object.
	}

	fun updateTitle(newTitle: String): Book {
		return Book(newTitle, pages)  // <-- The "updateName" method returns a new object with the new state.
	}

	fun updatePages(newPages: List<Page>): Book {
		return Book(title, newPages)  // <-- The "updatePages" method returns a new object with the new state.
	}
}

class Application(
	val book: Book  // <-- The "Application" class, the "val" keyword means the variable is immutable.
) {
	fun view() {
		println("Application Viewing: ${book.title}")
		book.view()
	}

	fun updateBook(newBook: Book): Application {
		return Application(newBook)  // <-- The "updateBook" method returns a new object with the new state.
	}
}


// Start of program
fun main() {
	val pages = listOf(
		Page("Page 1 Content"),
		Page("Page 2 Content"),
		Page("Page 3 Content")
	)
	val book = Book(
		"MyDocument.txt",
		pages
	) // <-- The "val" keyword means the variable is immutable and can only be assigned once.
	var app = Application(book) // <-- The "var" keyword means the variable is mutable,
	//     `app` is a "var" because it's expected to change state.
	// Every other variable is a "val" and is immutable.

	// The above code could be arranged in the functional style and it's a bit harder to read.
	// This style is also known as "declarative" style, as opposed to the familiar "imperative" style.
	// Using declaritive style, the code is more about "what" is being done, rather than "how" it's being done.
	// You only see the high level view, and the implementation details are hidden deeper in the code.
	app = Application(
		Book(
			title = "MyDocument.txt",
			pages = listOf(
				Page("Page 1 Content"),
				Page("Page 2 Content"),
				Page("Page 3 Content")
			)
		)
	)


	app.view()  // <-- will print:
	// Application Viewing: MyBook.txt
	// Book: MyBook.txt, # of Pages: 3
	// Page: Page 1 Content
	// Page: Page 2 Content
	// Page: Page 3 Content

	// app.book = Book("NewBook.txt")  // <-- This will not compile,
                                      //     as the variable `book` is immutable and cannot be changed.

	// To change the state of the application, a whole new object must be created with the new state,
	// usually based on a copy the old state, with modifications to reflect the new state.
	val newPages = pages
		.filter { page ->  // Instead of using imperative "for" loops, "filter" internally uses a loop to create
			// a new list of pages.
			page.inspectContent() != "Page 2 Content" // <-- removes the 2nd page from the list.
		}
		.toMutableList()  // <-- converts the immutable list to a mutable list to allow for adding a new page.
		.apply { // <-- creates a new list of pages with the same content as the original list.
			add(  // <-- adds a new page to the list.
				Page("New Page 4 Content")
			)
		}
		.toList()  // <-- converts the mutable list back to an immutable list.

   app = app.updateBook(
      app.book // <-- Using the `book` from the current state of the application.
         .updateTitle("UpdatedBook.txt") // <-- Creates a new book with the updated name and the same pages.
         .updatePages(newPages)  // <-- Creates a new book with the updated pages and the same title.
   )

	app.view()  // <-- will print:
	// Application Viewing: UpdatedBook.txt
	// Book: UpdatedBook.txt, # of Pages: 3
	// Page: Page 1 Content
	// Page: Page 3 Content
	// Page: New Page 4 Content
}

// Output:
// Application Viewing: MyDocument.txt
// Book: MyDocument.txt, # of Pages: 3
// Page: Page 1 Content
// Page: Page 2 Content
// Page: Page 3 Content
// Application Viewing: UpdatedBook.txt
// Book: UpdatedBook.txt, # of Pages: 3
// Page: Page 1 Content
// Page: Page 3 Content
// Page: New Page 4 Content