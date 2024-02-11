- ## Back-to Object Oriented Programming 1980s-Present
    - Alan Kay Style BOOP (Back-to-Object Oriented Programming)
        - Based on the idea of "messaging" between objects, VERY poorly named "object oriented programming", admitted 
          by Alan Kay himself, the inventor of the term.

        > - What's Wrong With Object-Oriented Programming?
        >   - https://www.youtube.com/watch?v=K_QEOtYVQ7A
    
    - All state is fully retained in the Object and methods are used to "send messages" to the "object" to
      change its state. This "messaging" metaphor stands up because internal state is not directly accessible. You
      must politely ask the object to change its state, and the object can choose to respond to the message or not.
      Unlike in COP where internal state is commonly exposed and directly manipulated via static methods and variables.
    - Any state that needs to be exposed is only via "messages" to the object, and the object can choose to respond to
      the message or not.
    - No `static` methods or variables, only instance variables that are private to the object.
    - `protected` methods are allowed, but discouraged as they lead to "fragile" and "rigid" code.
    - Use of inheritance is explicitly discouraged, and prefer composition over inheritance. Exceptions for shallow
      hierarchies of 2-3 levels maximum meant to model the real world objects, not to create a "hierarchy of types."
    - Use of interfaces is limited to Classes that require testing, and are not automatically added for every class.
    - Use of `setters` and `getters` is specifically disallowed. Instead, the object is expected to respond to messages to change its
      state, and to respond to messages to get its state.
    - Specific COP patterns are *NOT* permitted, such as:
        - Factory Pattern
        - Use of `null`
        - Getters and Setters
        - Reflection & Type Casting
        - Inheritance
        - Mutable State - All state in BOOP is immutable, and the object is expected to return a new object with the new state.
    - Amazingly, the dreaded Singleton Pattern is allowed to manage global state in BOOP.
    - There are only a few BOOP languages, "Smalltalk" and, _incredibly_, "Javascript" are among the most popular ones.
    - Example of BOOP in Kotlin:

       ```mermaid
       flowchart LR
       
       subgraph Application
          subgraph Book
             subgraph Pages
                A("📄 Page 1 Content")-->|enclosed in| D
                B("📄 Page 2 Content") -->|enclosed in| D
                C("📄 Page 3 Content") -->|enclosed in| D
             end
              D("📑 List of Pages") -->|enclosed in| E(Book)
          end
          E("📖 Book") -->|enclosed in| F("🖥️ Application")
       end
       click F "https://github.com/realityexpander/How_to_program_from_ground_up/blob/main/src/main/kotlin/boopExample.kt" _blank
       
       ```
    - Back-to Object Oriented Programming Example (Kotlin):
      ```Kotlin
      class Page(  // <-- the Page class constructor
         private val content: String  // <-- the "val" keyword means the variable is immutable and can only be assigned once.
      ) {
        fun view() {
           println("Page: $content")
        }
        
        fun updateContent(newContent: String): Page {
           return Page(newContent)  // <-- the "updateContent" method is expected to return a new object with the new state.
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
            pages.forEach { it.view() }
         }
         
         fun updateTitle(newTitle: String): Book {
            return Book(newTitle, pages)  // <-- The "updateTitle" method returns a new object with the new state.
         }
         
         fun updatePages(newPages: List<Page>): Book {
             return Book(title, newPages)  // <-- The "updatePages" method returns a new object with the new state.
         }
      }
 
      class Application(
         private val book: Book  // <-- The "Application" class, the "val" keyword means the variable is immutable.
      ) {
         fun view() {
            println("Application Viewing: ${book.title}")
            book.view()
         }
 
         fun updateBook(newBook: Book): Application {
            return Application(newBook)  // <-- The "updateBook" method returns a new object with the new state.
         }
      }
      
      // Start of Program
      fun main() {
         // Setup the App in the familiar "Imperative" Style:
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
                                     // Every other variable is a "val" and is immutable.
 
         // The above code could be arranged in the functional style, where the state of the program is created in 
         // a single line!
         //
         // Now, setup the app with the same content, but in the "Functional" Style:
         // - This style is also known as "declarative" style, as opposed to the familiar "imperative" style.
         // - Using declaritive style, the code is more about "what" is being done, rather than "how" it's being done.
         // - You only see the high-level view, as the implementation details are hidden deeper in the code.
         // - Functions are called from the inside out, and the state of the program is created in a single line. 
         
         // The code executes from the innermost function to the outermost function (step 1 to step 5.)
         app = Application( // <-- Step 5 Creates a new Application object with the book object.
            Book( // <-- Step 4 Creates a new Book object with the
               title = "MyBook.txt",
               pages = listOf(  // <-- creates a new list of Page objects with the content "Page 1 Content", "Page 2 Content", "Page 3 Content"
                  Page("Page 1 Content"), // <-- Step 1 Creates a new Page object with the content "Page 1 Content"
                  Page("Page 2 Content"), // <-- Step 2 Creates a new Page object with the content "Page 2 Content"
                  Page("Page 3 Content")  // <-- Step 3 Creates a new Page object with the content "Page 3 Content"
               )
            )
         )
 
         app.view()  // <-- will print the same as the imperative style:
                     // Application Viewing: MyBook.txtimp
                     // Book: MyBook.txt, # of Pages: 3
                     // Page: Page 1 Content
                     // Page: Page 2 Content
                     // Page: Page 3 Content
      
         ////////////////////////////////////////////   
         // Changing the State of the Application  //
         ////////////////////////////////////////////
        
         // app.book = Book("UpdatedBook.txt", emptyList())  // <-- will not compile, as the variable `book` is immutable
                                                             //     and cannot be modified. It can only be replaced.
         
         // To change the state of the application, a whole new object must be created with the new state,
         // usually based on a copy the old state, with modifications to reflect the new state.
         val newPages = pages
             .filter { page ->  // instead of using imperative "for" loops, "filter" internally uses a loop to create
                                // a new list of pages.
                page.inspectContent() != "Page 2 Content" // <-- removes the 2nd page from the list.
             }
             .toMutableList()  // <-- converts the immutable list to a mutable list to allow for adding a new page.
             .apply { // <-- creates a new list of pages with the same content as the original list, but with 
                      //     the 2nd page removed.
                add(  // <-- adds a new page to the list.
                   Page("New Page 4 Content")  // <-- creates a new page with the content "New Page 4 Content"
                )
             }
             .toList()  // <-- converts the mutable list back to an immutable list.
         
         // The `updateBook` method is called to update the `book` which will create a `app` with the new state.
         app = app.updateBook(
            app.book // <-- Using the `book` from the current state of the application to copy the state of the `book`.
               .updateTitle("UpdatedBook.txt") // <-- Creates a new book with the updated name and the same `pages`.
               .updatePages(newPages)  // <-- Creates a new book with the updated `pages` and the same `title`.
         )
         
         app.view()  // <-- will print:
                     // Application Viewing: UpdatedBook.txt
                     // Book: UpdatedBook.txt, # of Pages: 3
                     // Page: Page 1 Content
                     // Page: Page 3 Content
                     // Page: New Page 4 Content
      }
      
      main()
 
      // Output:
      // Application Viewing: MyBook.txt
      // Book: MyDocument.txt, # of Pages: 3
      // Page: Page 1 Content
      // Page: Page 2 Content
      // Page: Page 3 Content
      // Application Viewing: UpdatedBook.txt
      // Book: UpdatedBook.txt, # of Pages: 3
      // Page: Page 1 Content
      // Page: Page 3 Content
      // Page: New Page 4 Content
      
      ```
      > Live Code Example: [BOOP example](src/main/kotlin/boopExample.kt)   

[Continue Reading](FunctionalProgramming.md)