abstract class File(
   val fileName: String
) {
   abstract fun view()      // Expects a fun called "view" and has no default implementation.
   open fun showName() {    // Expects a fun called "showName" and has a default implementation.
      println("File Name: " + this.fileName) // <-- The "default implementation" for any subclass that doesn't override the fun.
   }
}

class Excel(
   fileName: String
): File(fileName) {  // <-- Excel is a subclass of File, also called a "type" of File.
   override fun view() { // <-- the implementation of the abstract class "view".
      println("View Excel: " + this.fileName)
   }
}

class Photo(
   fileName: String
): File(fileName) { // <-- Photo is a subclass of File, also called a "type" of File.
   override fun view() { // <-- the implementation of the abstract class "view".
      println("View Photo: " + this.fileName)
   }
}

class Memo(
   fileName: String = "TEMPORARY_FILE_NAME.memo", // <-- Default value for the parameter "filename" if not provided.
   val to: String,
   val from: String,
   val subject: String
): File(fileName) { // <-- Memo is a subclass of File.
   constructor(to: String): this(to=to, from="Unknown", subject="No Subject")  // <-- Secondary constructor.
   constructor(to: String, from: String): this(to=to, from=from, subject="No Subject")  // <-- Another secondary constructor.
   
   override fun view() {   // <-- The implementation of the abstract class "view".
      super.showName()     // <-- Calls the "default implementation" of the abstract superclass.
                           //     Calls to the superclass are not required, but often used to call any
                           //     implementations of the superclass. This is a way to reuse code functionality.
      
      println("View Memo: from= " + this.from + ", to= " + this.to + ", subject= " + this.subject)
   }
   
   override fun showName() { // <-- overrides the "default implementation" of the abstract superclass.
      // Displays name of who the memo is "to" & "from"
      println("Memo: ${this.to} to ${this.from}") // <-- different from the "default implementation" of the superclass.
   }
   
   fun send() {
      println("Sending Memo: from= " + this.from + ", to= " + this.to + ", subject= " + this.subject)
   }
}

// Start of program
fun main() {
   // val file0: File = File("MyFile") // <-- Since the `File` class is `abstract`, an object
                                       // cannot be created from it. this will cause a compiler error.
   val file1: File = Excel("MyExcel.xls")
   val file2: Photo = Photo("MyPhoto.jpg")
   val file3: Memo = Memo(to="Chris", from="Bob", subject="Meeting") // <-- `file3` is of type `Memo` and not
                                                                     // `File` because we want to access the
                                                                     // `send` method.
   
   fun viewFile(file: File) {  // <-- Parameter `file` is type `File` and not `Excel` or `Photo` or `Memo`.
      file.view()
   }
   
   viewFile(file1)  // <-- will call the "view" fun of the Excel class
   viewFile(file2)  // <-- will call the "view" fun of the Memo class
   viewFile(file3)  // <-- will call the "view" fun of the Photo class

   file3.showName()  // <-- will call the "showName" fun of the Memo class
   file3.send()  // <-- will call the "send" fun of the Memo class
}

// Output:
//   View Excel: MyExcel.xls
//   View Photo: MyPhoto.jpg
//   File Name: TEMPORARY_FILE_NAME.memo
//   View Memo: from= Bob, to= Chris, subject= Meeting
//   Memo: Chris to Bob
//   Sending Memo: from= Bob, to= Chris, subject= Meeting
