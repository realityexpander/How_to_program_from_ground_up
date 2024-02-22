package org.example

interface Document {     // <-- interfaces only define the "signature" of the functions it expects to be in the subclass
   fun view()  // this interface expects a function called "view"
}

// PDF is one "concrete implementing" class of the "Document" interface
class PDF: Document { // PDF is a subclass of Document, and required to implement the "view" function
   override fun view() { // <-- the implementation of the interface (uses the "override" keyword)
      println("Launch PDF Viewer")
   }
}

// Email is one "concrete implementing" class of the "Document" interface
class Email: Document { // Email is a subclass of Document, and must implement the "view" function
   override fun view() { // <-- the implementation of the interface (uses the "override" keyword)
      println("Launch Email App")
   }
}

// Song is one "concrete implementing" class of the "Document" interface
class Song: Document { // <-- the implementation of the interface (uses the "override" keyword)
   override fun view() {
      println("Launch Music Player")
   }
}

// Start of program
fun main() {
   val doc1: Document = PDF();
   val doc2: Email= Email()
   val doc3: Song = Song()
   
   fun viewDocument(doc: Document) {  // Note that the parameter is of type `Document` and not `PDF` or `Email` or `Song`
      doc.view() // Will call the appropriate "view" function of the subclass
   }
   
   viewDocument(doc1)  // <-- will print "Launch PDF Viewer"
   viewDocument(doc2)  // <-- will print "Launch Email App"
   viewDocument(doc3)  // <-- will print "Launch Music Player"
}

// Output:
// Launch PDF Viewer
// Launch Email App
// Launch Music Player