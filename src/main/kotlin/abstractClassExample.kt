package org.example

abstract class Document1(
   var name: String
) {
   abstract fun view()      // Expects a fun called "view" and has no default implementation.
   open fun showName() {    // Expects a fun called "showName" and has a default implementation.
      println("Document Name: " + this.name) // <-- The "default implementation" for any subclass that doesn't override the fun.
   }
}

class PDF1(
   name: String
): Document1(name) {  // <-- PDF1 is a subclass of Document1.
   override fun view() { // <-- the implementation of the abstract class "view".
      println("View PDF: " + this.name)
   }
}

class Song1(
   name: String
): Document1(name) { // <-- Song1 is a subclass of Document1
   override fun view() { // <-- the implementation of the abstract class "view".
      println("Listen to Music Player: " + this.name)
   }
}

class Email1(
   val to: String,
   val from: String,
   val subject: String
): Document1(to) { // <-- Email1 is a subclass of Document1.
   constructor(to: String): this(to, "Unknown", "No Subject")  // <-- Secondary constructor.
   constructor(to: String, from: String): this(to, from, "No Subject")  // <-- Secondary constructor.
   
   override fun view() {   // <-- The implementation of the abstract class "view".
      super.showName()     // <-- Calls the "default implementation" of the abstract superclass.
                           //     Calls to the superclass are not required, but often used to call any
                           //     implementations of the superclass. This is a way to reuse code functionality.
      
      println("View Email: from= " + this.from + ", to= " + this.to + ", subject= " + this.subject)
   }
   
   override fun showName() { // <-- overrides the "default implementation" of the abstract superclass.
      super.showName()    // <-- calls the "default implementation" of the abstract superclass. 
      // note: What `name` represents depends on the context!
   }
   
   fun send() {
      println("Sending Email: from= " + this.from + ", to= " + this.to + ", subject= " + this.subject)
   }
}

// Start of program
fun main() {
   // val doc0: Document = Document1("MyDocument") // <-- Since the `Document` class is `abstract`, an object
                                                   // cannot be created from it. this will cause a compiler error.
   val doc1: Document1 = PDF1("MyPDF.pdf")
   val doc2: Song1 = Song1("MySong.mp3")
   val doc3: Email1 = Email1(to="Chris", from="Bob", subject="Meeting") // <-- `doc3` is of type `Email` and not
                                                                        // `Document` because we want to access the
                                                                        // `send` method.
   
   fun viewDocument(doc: Document1) {  // <-- Parameter `doc` is type `Document` and not `PDF` or `Email` or `Song`.
      doc.view()
   }
   
   viewDocument(doc1)  // <-- will call the "view" fun of the PDF1 class
   viewDocument(doc2)  // <-- will call the "view" fun of the Email1 class
   viewDocument(doc3)  // <-- will call the "view" fun of the Song1 class
   
   doc3.send()  // <-- will call the "send" fun of the Email1 class
}

// Output:
//   View PDF: MyPDF.pdf
//   Listen to Music Player: MySong.mp3
//   Document Name: Chris
//   View Email: from= Bob, to= Chris, subject= Meeting
//   Sending Email: from= Bob, to= Chris, subject= Meeting
