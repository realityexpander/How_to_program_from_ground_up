// Kotlin example of inheritance, subtyping and polymorphism (all essentially the same thing)

open class Media() {  // <-- the "base class" or "superclass", `open` means it can be subclasses (extended/inherited)
   protected var name: String = "Untitled"  // <-- the `name` property is protected, so it can be accessed by subclasses, and not from outside the class.

   constructor(name: String) : this() { // <-- the primary constructor of the class, it takes a single parameter `name` of type `String`
      this.name = name
   }

   open fun play() {
      println("Playing Unknown Media: " + this.name)
   }
}

open class MP3(
   name: String
): Media(name) {   // <-- the "subclass" or "derived class"; it `extends` (inherits) from the superclass (Media),

   // NOTICE: No constructor is defined, so the `default constructor` in the superclass will be used `Media(name)`

   override fun play() {
      println("Playing MP3: " + this.name)
   }
}

class Video(
   name: String
): Media(name) { // NOTICE: No constructor is defined, so the `default constructor` in the superclass will be used `Media(name)`

   override fun play() {
      println("Playing Video: " + this.name)
   }
}

class ProtectedMP3(
   name: String,
   private val password: String
): MP3(name) {  // NOTICE: No constructor is defined, so the `default constructor` in the superclass will be used `Media(name)`
   private var authenticated: Boolean = false
   
   fun authenticate(password: String) {
      if (this.password == password) {
         this.authenticated = true
         println("Authenticated.")
      }
   }
   override fun play() {
      if (this.authenticated == true) {
         println("Playing Protected MP3: " + this.name)
      } else {
         println("Not Authenticated! Submit password to authenticate.")
      }
   }
}

// Start of program
fun main() {
   val doc0: Media = Media("MyMedia")  // Since the `Media` class is `open` and not `abstract`, an object can be created from it.
   val doc1: Media = MP3("MyMP3")
   val doc2: Media = Video("MyVideo")
   
   fun playMedia(media: Media) {  // Note that the parameter is of type `Media` and not `MP3` or `Video` or `ProtectedMP3`
      media.play()
   }
   
   playMedia(doc0)  // <-- will print "Playing: MyMedia"
   playMedia(doc1)  // <-- will print "Playing MP3: MyMP3.mp3"
   playMedia(doc2)  // <-- will print "Playing Video: MyVideo.mp4"

   // println(doc0.name)  // <-- will not compile because `name` is `protected` and cannot be accessed from outside the class.

   // Note: `doc3` is of type `ProtectedMP3` and not `MP3` or `Media` because we want to access the `authenticate` method,
   //       which is not available in the `Media` class or the `MP3` class.
   val doc3: ProtectedMP3 = ProtectedMP3("MyProtectedMP3", "MySecretPassword123")

   playMedia(doc3)  // <-- will print "Not Authenticated! Submit password to authenticate."
   doc3.authenticate("MySecretPassword123")  // <-- will print "Authenticated!"
   playMedia(doc3)  // <-- will print "Playing Protected MP3: MyProtectedMP3.mp3"


   // Bonus type-casting
   val doc4: Media = ProtectedMP3("MyOtherProtectedMP3", "password2")
   // doc4.authenticate("password2")  // <-- will not compile, because `doc4` is of type `Media` and not `ProtectedMP3`.
   (doc4 as ProtectedMP3).authenticate("password2")  // <-- will print "Authenticated."
}

// Output:
// Playing Unknown Media: MyMedia
// Playing MP3: MyMP3
// Playing Video: MyVideo
// Not Authenticated! Submit password to authenticate.
// Authenticated.
// Playing Protected MP3: MyProtectedMP3
// Authenticated.