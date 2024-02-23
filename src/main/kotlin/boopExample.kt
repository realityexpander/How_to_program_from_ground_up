// BOOP Programming Example (Back-to Object Oriented Programming, Alan Kay's original vision of OOP)

class Page(  // <-- the "Page" class constructor, the "val" keyword means the variable is immutable.
	private val content: String // <-- content is only accessible by calling the `inspectContent` method.
) {
	fun view() {
		println("Page: ${inspectContent()}")
	}

	fun updateContent(newContent: String): Page {
		return Page(newContent)  // <-- The "updateContent" method returns a new object with the new state.
	}

	fun inspectContent(): String {
		return content
	}
}

class Book(
	val title: String,  // <-- Its OK to access the title directly, as it's primitive, immutable and cannot be modified.
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
	// Setup the App in the familiar Imperative Style:
	// Create the list of Page objects
	val pages = listOf(  // <-- the "val" keyword means the variable is immutable and can only be assigned once.
		Page("Page 1 Content"),
		Page("Page 2 Content"),
		Page("Page 3 Content")
	)
	// Create the book object using the list page objects
	val book = Book(
		"MyBook.txt",
		pages
	)
	// Create the application object using the book object
	var app = Application(book) // <-- The "var" keyword means the variable is mutable,
										 //     `app` is a "var" because it's expected to change state.
										 //     Every other variable is a "val" and is immutable.

	// The above code could be arranged in the functional style, where the state of the program is created in
	// a single line!
	//
	// - This style is also known as "declarative" style, as opposed to the familiar "imperative" style.
	// - Using declaritive style, the code is about "what" needs to be done, rather than step-by-step "how" to do it.
	// - As a programmer, you only see the high-level view, as the implementation details are hidden deeper
	//   in the code, "abstracted" away in the functions.
	// - Functions are called and executed from the innermost brackets first to the outermost assignment last.
	// - The state of the program is created in a single call to the `Application` constructor.

	// Setup the App in Functional Style:
	app = Application(
		Book(
			title = "MyBook.txt",
			pages = listOf(
				Page("Page 1 Content"),
				Page("Page 2 Content"),
				Page("Page 3 Content")
			)
		)
	)
	app.view()  // <-- will print the same as the imperative style:
					// Application Viewing: MyBook.txt
					// Book: MyBook.txt, # of Pages: 3
					// Page: Page 1 Content
					// Page: Page 2 Content
					// Page: Page 3 Content

	// app.book = Book("UpdatedBook.txt", emptyList())  // <-- will not compile, as the variable `book` is immutable
	                                                    //     and cannot be modified. It can only be replaced.

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
//	Application Viewing: MyBook.txt
//	Book: MyBook.txt, # of Pages: 3
//	Page: Page 1 Content
//	Page: Page 2 Content
//	Page: Page 3 Content
//	Application Viewing: UpdatedBook.txt
//	Book: UpdatedBook.txt, # of Pages: 3
//	Page: Page 1 Content
//	Page: Page 3 Content
//	Page: New Page 4 Content