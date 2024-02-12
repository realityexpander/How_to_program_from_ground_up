- ## Class Oriented Programming (COP) 1970s-Present
    - ### BIG IDEA - We can simulate real-world objects and their interactions with each other!
    
    - Usually misnamed "Object Oriented Programming," as "Objects" are _not_ the main focus, "Classes" are!
    - Based on Simula 67, a language designed to simulate real-world systems. The creator gave "head nods" to
      "Smalltalk" but took a different and more "procedural" approach to the class and object concepts explored in
      Smalltalk, primarily to use more practical aspect of the ideas for the needs of the time.
    - Examples of Class-Oriented Programming languages are "Simula," "C++", "C#" and "Java"
    - Collected ideas around:
        - ### Encapsulation
            - Data & code are "encapsulated," (or enclosed) into a `class` (
                - also called a "Template", it is similar to a blueprint for a house as it describes what will be created when the house is built)
            - A `class` is a template for creating an in-memory instance of the class (called an "Object") which contains the
              state and pointers to the "methods" (functions) of the `class`
            - When a new Object is created from a class template, the Object is called an "instance" of the class.
            - An Object is just a structure in memory that contains the values (or "state") of the variables and pointers to
              the methods of the class
            - A "Method" is just a normal function in the class that manipulates the variables in the object,
              or call other methods in the object or other objects
                - The process of calling a method on an object is referred to as "sending a message" to the object
                - (THIS IS TERRIBLE WORDING! bc it's not a message! It's just calling a function!!!! THIS IS NOT MESSAGING! AAAAHH!)
            - The values of the variables ("state") of the object are often made inaccessible from outside the class (ie: "private")
              and only accessible by the methods of the class, or the methods in the inherited subclasses of the class.
            - Methods of the class can be made `public` to be globally accessible by other classes to provide the functionality of the class.
            - Some methods of the `class` can be labeled `protected` and only accessible by subclasses of the class
            - There is a special modifier called `static` makes a variable or method accessible without needing an instance of the class (object)
                - This loophole is the main reason why I call it "Class Oriented Programming" is not "object" oriented programming!
                - It's a way to make the class act like a "namespace" to group together the "methods" and "variables" that are related to each other
                - This was not the original intent of the "class" and "object" paradigm, but was a way to fit the COP
                  paradigm into the "procedural" paradigm.
            - The use of the word "constructor" is a bit of a misnomer, as the memory space for the Object has been allocated
              and the `constructor` is called to set the initial values of the variables in the object ("initialize" the state.)

        - ### Using Classes and Objects "Name Spaces/Scopes" for Procedural-Style Code Implementations
            - In COP languages, the `class` is used as a "namespace" to group together various methods and variables that
              are related to each other (known as "high cohesion") into a single class or "namespace".
                - Variables and methods can be called via a common name, like: `Person.age` or `Person.setName()`
            - All code must be inside an object OR be declared as a `static` member of a `class` to be accessible without an object
                - This use of `static` functions is a primary indication of the COP paradigm is being followed.

            - #### Issues with Static Methods and Attributes
                - This often lead to "collections of static methods" that simply extended the "procedural" paradigm, except the
                  code blocks now had a name (the name of the Class) and were grouped together instead of being globally accessible.
                - The `static` methods were passed in data as parameters and returned data as a result, just like the "procedural" paradigm.
                    - When `static` is used this way, it completely breaks encapsulation. The objects are just bags to hold code,
                      and the data is fully exposed to anyone who wants to access it, as it is not retained as state within the object.
                - This `static` way of programming lead to the same exact problems as the "procedural" paradigm, but with the
                  added complexity of the "class" and "object" paradigm.
                - These were popularized by web frameworks such as Java's Spring Boot and Many Others
                  > - The Pain of OOP, Lecture #2: Static methods and attributes are evil
                  >   - https://www.youtube.com/watch?v=lELJSj9mWbI
                - One of the main problems is that `static` methods and data lead to issues with "testing" the code, as the
                  `static` methods and data are not "stateful" and are not "encapsulated" in the object, so they are not
                  easily "mocked" or "stubbed" for testing purposes.
                - Another side-effect of `static` methods and data is that they are not "thread-safe" and can lead to
                  data corruption
                - And the largest issue is that `static` is shared mutable state and is the root of all evil in programming as it
                  leads to "side effects" and tough to understand "state" of the program which leads to unnecessary complexity and bugs.
                  > - What's Wrong About Utility Classes? (Static Methods)
                  >   - https://www.youtube.com/watch?v=psrp3TtaYYI

        - ### Interfaces
            - An `interface` is an agreement or "contract" that the class will have certain defined methods & variables in the class.
            - It's a way to tell the compiler AND the programmer that the class must have certain "methods" and "variables" in it to be considered a valid "subclass" of the interface
            - The `interface` is implemented by the `subclass`, where the methods and variables are defined by the "concrete implementing" `class`
              ```mermaid
              ---
              title: Interface Example
              ---
              classDiagram
              Document <|-- PDF : implements
              Document <|-- Email : implements
              Document <|-- Song : implements
                
              class Document { 
                 expects method view()*
              }
              <<interface>> Document
              class PDF{
                  override method view()
              }
              class Email{
                  override method view()
              }
              class Song{
                  override method view()
              }
              ```
            - Example (in pseudo-code similar to common COP languages):
              ```Text
              // OOP Pseduo-Code
                
              interface Document {     // <-- interfaces only define the "signature" of the methods it expects to be in the subclass
                expects method view()  // this interface expects a method called "view" 
              }  
                  
              // PDF is one "concrete implementing" class of the "Document" interface
              class PDF implements Document { // PDF is a subclass of Document, and must implement the "view" method
                  override method view() { // <-- the implementation of the interface (uses the "override" keyword) 
                     print "Launch PDF Viewer"  
                  } 
              }
                    
              // Email is one "concrete implementing" class of the "Document" interface
              class Email implements Document { // Email is a subclass of Document, and must implement the "view" method
                  override method view() { // <-- the implementation of the interface (uses the "override" keyword)
                     print "Launch Email App"  
                  }
              }
                    
              // Song is one "concrete implementing" class of the "Document" interface
              class Song implements Document { // <-- the implementation of the interface (uses the "override" keyword)
                  override method view() { 
                     print "Launch Music Player"  
                  } 
              }
                    
              // Start of program
              method main() {
                  Document doc1 = new PDF()
                  Email doc2 = new Email()  
                  Song doc3 = new Song() 
                       
                  function viewDocument(Document doc) {  // Note that the parameter is of type `Document` and not `PDF` or `Email` or `Song` 
                      doc.view() // Will call the appropriate "view" method of the subclass
                  }
                        
                  viewDocument(doc1)  // <-- will print "Launch PDF Viewer"
                  viewDocument(doc2)  // <-- will print "Launch Email App"
                  viewDocument(doc3)  // <-- will print "Launch Music Player"
              }
              ```
              > Live Code Example: [How Interfaces Work in Kotlin](src/main/kotlin/interfaceExample.kt)

                - Interfaces allow a developer to add multiple different implementations of the same named method by defining a
                  new `class` that `implement`s the superclass `interface` by defining code for the methods in the subclass
                    - This makes it easier to add new subclasses of the `interface` to the program without changing any existing code
                    - This also make it easier to write "testing" code that can be used to automatically verify the correctness of the methods
                      of the `class` by using "testing" implementations of the `interface`
                - The `interface` is `implement`ed by a `class` and the methods are finished by the implementing `subclass`
                  according to the method signatures in the `interface`
                - "Subclassing" is also called "Subtyping" or "Inheritance" and is the basis for "Polymorphism" and "Dynamic Binding"

        - ### Inheritance
            - Inheritance is the idea that a new `class` can inherit from another `class` all of its methods and variables,
              and then add new methods or override methods in the subclass that will modify the behavior of the
              original `class`
            - Classes can inherit from other classes to reuse code and "state", and to create "subtypes/subclasses"
            - The class that is inherited from is called the "superclass" and the class that inherits is called the "subclass"
            - The "subclass" is also called a "derived class" and the "superclass" is also called a "base class"

          ```mermaid
          ---
          title: Inheritance Example Diagram
            
          ---
          classDiagram
          Media <|-- MP3 : extends
          Media <|-- Video : extends
          MP3 <|-- ProtectedMP3 : extends      
            
          Media: expects method play()*
          class MP3 {
             override method play()
          }
          class Video {
             override method play()
          }
          class ProtectedMP3 {
             private String password
             private Boolean isAuthenticated
            
             override method play()
             method authenticate(password)
          }
          ```

            - Example of inheritance (in pseudo-code, which is similar to common COP languages):
           ```Text
            // OOP pseudo-code
              
            open class Media {   // <-- the "base class" or "superclass", `open` means it can be subclasses (extended/inherited)
              // Note: there is no visible constructor, so the default constructor will be used -> Media(), which takes no parameters and does not initialize any variables.
              String name = ""  // <-- the "state" of the object is stored in the variables of the class
                
              open method play() { 
                print "Playing: " + this.name 
              } 
            }  
            
            open class MP3 extends Media {   // <-- the "subclass" or "derived class"; it `extends` (inherits) from the superclass (Media).
                // NOTICE: No constructor is defined, so the default constructor in the superclass will be used -> Media()
            
                override method play() { 
                   print "Playing MP3: " + this.name 
                } 
            }
            
            class Video extends Media { 
                // NOTICE: No constructor is defined, so the default constructor in the superclass will be used -> Media()
                
                override method play() { 
                   print "Playing Video: " + this.name 
                } 
            }
            
            class ProtectedMP3 extends MP3 {  // note: "Concrete Class" MP3 must be declared as `open` in order to be subclassed
                String password
                Boolean authenticated = false
            
                constructor ProtectedMP3(String name, String password) {  // <-- the constructor of this class, its called to initialize the object
                    super(name)  // <-- calls the constructor of the superclass (MP3)
                    this.password = password    // Sets the password for the password protected MP3
                }
            
                method authenticate(String password) {
                    if (this.password == password) {
                        this.authenticated = true
                        print "Authenticated!"
                    }
                } 
                override method play() {
                   if (this.authenticated == true) {
                        print "Playing Protected MP3: " + this.name 
                   } else {
                        print "Not Authenticated!"
                   }
                } 
            }
            
            // Start of program
            method main() {
                Media doc0        = new Media()  // Since the `Media` class is `open` and not `abstract`, an object can be created from it.
                Media doc1        = new MP3()
                Media doc2        = new Video()
                ProtectedMP3 doc3 = new ProtectedMP3("MyProtectedMP3.mp3", "MySecretPassword123")  // note that the `ProtectedMP3` type is required to call the `authenticate` method
    
                function playMedia(Media media) {  // Note that the parameter is of type `Media` and not `MP3` or `Video` or `ProtectedMP3`
                    media.play()
                }
            
                playMedia(doc0)            // <-- will print "Playing: MyMedia"
                playMedia(doc)             // <-- will print "Playing MP3: MyMP3.mp3"
                playMedia(doc2)            // <-- will print "Playing Video: MyVideo.mp4"
            
                playMedia(doc3)            // <-- will print "Not Authenticated!"
                doc3.authenticate("MySecretPassword123")  // <-- will print "Authenticated!"
                playMedia(doc3)            // <-- will print "Playing Protected MP3: MyProtectedMP3.mp3"
            }
            
            // Output:
            // Playing: MyMedia
            // Playing MP3: MyMP3.mp3
            // Playing Video: MyVideo.mp4
            // Not Authenticated!
            // Authenticated!
            // Playing Protected MP3: MyProtectedMP3.mp3
            ```
          > - Live Code Example: [How Inheritance Works in Kotlin](src/main/kotlin/inheritanceExample.kt)

        - ### Abstract Classes
            - Very similar to interfaces but can have default implementations of the methods & include variables.
            - I like to forget the word `abstract` and think of "The General Category" instead of a specific case,
              like "documents" is the general category (abstract idea) of a generic "thing to structure and retain data."
            - PDFs, Excel files and Text files are specific "concrete" kinds (or "implementations") of the
              abstract idea of "documents."
            - The `abstract class` is usually `extend`ed by the subclass and then the methods are overridden by the subclass
              ```mermaid
              ---
              title: Abstract Class Example Diagram
                
              ---
              classDiagram
              File <|-- Excel : extends
              File <|-- Memo : extends
              File <|-- Photo : extends
                
              <<abstract>> File 
              class File {
                  expects method view()*
              }
                
              class Excel {
                  override method view()
              }
              class Memo {
                  override method view()
              }
              class Photo {
                  override methodview()
              }
              ```
            - Example for abstract classes in pseudo-code (similar to common COP languages):
           ```Text
            // OOP pseudo-code
            
            abstract class File { 
              String name = ""  // <-- Abstract classes can have variables.
            
              File(String name) {  // <-- Abstract classes can have "default" constructors.
                  this.name = name
              }
              expects method view()  // Expects a method called "view" and has no default implementation.
              expects method showName() {  // Expects a method called "showName" and has a default implementation.
                  print "File Name: " + this.name // <-- The "default implementation" for any subclass that doesn't override the method.
              } 
            }  
            
            class Excel extends File {  // <-- Excel is a subclass of File.
                override method view() { // <-- the implementation of the abstract class "view".
                   print "View Excel: " + this.name  
                } 
            }
            
            class Memo extends File { // <-- Memo is a subclass of File.
                String to
                String from
                String subject
          
                Memo(String to, String from, String subject) {  // <-- the custom constructor of this class, its called to 
                                                                //     initialize the variables of the object.
                    super("Memo to:" + to)  // <-- calls the constructor of the superclass (File)
                    this.to = to
                    this.from = from
                    this.subject = subject
                }
              
                override method view() {  // <-- the implementation of the abstract class "view".
                   super.showName(to)     // <-- Calls the "default implementation" of the abstract superclass.
                                          // Note: Calls to the super class are not required, but can be used to call any 
                                          // implementations of the superclass.
                 
                   print "View Memo: from= " + this.from + ", to= " + this.to + ", subject= " + this.subject 
                }
                override method showName() { // <-- overrides the "default implementation" of the abstract superclass.
                   print "Memo from: " + this.from + ", to: " + this.to
                } 
            }
            
            class Photo extends File { // <-- Photo is a subclass of Document
                override method view() {  // <-- the implementation of the abstract class "view"
                     print "View Photo: " + this.name
                } 
            }
            
            // Start of program
            method main() {
                // File doc0 = new File("MyFile")  // Since the `File` class is `abstract`, an object cannot be created from it. 
                                                   // This will cause a compiler error.
                File file1 = new Excel("MyExcel.xls")
                File file2 = new Photo("MyPhoto.jpg")
                Memo file3 = new Memo(to="Chris", from="Bob", subject="Meeting")
            
                function viewFile(File file)  // Note that the parameter `doc` is of type `File` and not `Excel` or `Photo` or `Memo`.
                    file.view(name)
                }
            
                viewFile(file1)  // <-- will call the "view" method of the Excel class
                viewFile(file2)  // <-- will call the "view" method of the Photo class 
                viewFile(file3)  // <-- will call the "view" method of the Memo class
            }
            
            main()
          
            // Output:
            // View Excel: MyExcel.xls
            // View Photo: MyPhoto.jpg
            // File Name: Memo to: Chris
            // View Memo: from= Bob, to= Chris, subject= Meeting
            // Memo from: Chris to: Bob
            // Sending Memo: from= Bob, to= Chris, subject= Meeting
          
            ```
          > - Live Code Example: [How Abstract Classes Work in Kotlin](src/main/kotlin/abstractClassExample.kt)

        - ### Polymorphism
            - Yet another overcomplicated word for a very basic idea.
            - Polymorphism is the idea that a method can be called on an object and the method will behave differently
              based on the "type" of the "object" that the "method" is called on
                - This is the basis for overriding methods in subclasses and `interfaces` and `abstract class`es
                - In the example above, the `viewDocument` function can be called with any `Document` object and the `view` method
                  will behave differently based on the "type" of the `Document` object that is passed in

        - ### Controlled Mutability and Visibility of Variables
            - Use of explicit `private` and `protected` and `public` to control the visibility of the variables and methods
              of the class.
            - Making a variable `private` means that it can only be accessed by the methods of the class and not by any
              other class.
            - Making a variable `protected` means that it can only be accessed by the methods of the class and any subclass
              of the class.
            - Encouraged to use getters and setters to control the access to the variables of the class (which has since
              been shown to be a bad idea due to misuse and overuse of the pattern)

        - ### Issues from Abuse of Inheritance
            - Use of Inheritance Lead to immense & unnecessary complexity to fit in the "simulation" paradigm, as programmers tried to shove the
              "Procedural Paradigm" into the fancy new "Class Oriented" paradigm with less than stellar results.
            - Inheritance is a usually a bad idea for many reasons, and very overused beyond its original intent.
                - The hype around reusability was so strong that it was often used to justify the use of inheritance in places
                  where it was not appropriate.
                - This lead to "fragile" and "rigid" code that was hard to understand and hard to modify, leading to a lot
                  of waste and costs.
                - Many popular ways of dealing with the "procedural approach" to COP were turned into "design patterns"
                  that were used to "fix" the problems of the "procedural approach" to `COP. Many of these ideas were just
                  hacks to fit the "procedural approach" into the "COP" paradigm.
                - The promise of "reusability" was not fulfilled by COP languages.
                  > - Banana, Monkey, Jungle Problem
                      >   - https://crystal-villanueva.medium.com/the-banana-and-the-gorilla-problem-92c9a4717fd6

            - ### Allowing for "Multiple Inheritance" in C++ was a mistake, and it was removed from Java and C# for good reason.
                - Multiple Inheritance is the idea that a class can inherit from more than one class, and then have access to
                  all the methods and variables of the superclasses.

                - Diagram of Multiple Inheritance:
                - ```mermaid
                  flowchart TD
                     X["The Problem with Mutliple Inheritance"]
                     Animal["
                       abstract Animal
                       expects method makeSound()
                     "] -->|inherits| Cat["🐈 Cat
                        method makeSound()
                     "] & Dog["🐕 Dog
                         method makeSound()
                     "]-->|inherits| Cog???["Cog???"]
                       
                     Cog??? -..-> Y((("
                     When `Cog` makes a sound, 
                     (ie: method `makeSound()` is called) 
                     does it Meow or Bark?"))) 
                     ```
                - Example of attempt to use "Multiple Inheritance" in C++:
                  ```C++
                  class Animal {
                    public:
                      void makeSound() {
                        cout << "Animal Sound" << endl;
                      }
                  };
                    
                  class Cat : public Animal {
                    public:
                      void makeSound() {
                        cout << "Meow" << endl;
                      }
                  };
                    
                  class Dog : public Animal {
                    public:
                      void makeSound() {
                        cout << "Bark" << endl;
                      }
                  };
                    
                  class Cog : public Cat, public Dog {
                  };
                    
                  int main() {
                      Cog c;
                      c.makeSound();
                  }
                    
                  main()   
                    
                  // Output:
                  // "Meow" or "Bark"??
                    
                  ```
                    - In C++, calling Cog's `makeSound()` method will print `Meow`, but in Python, calling
                      Cog's `makeSound()` will print `Bark`!
                    - This behavior is _completely arbitrary_ and up to the designers of the language to decide which
                      method will be called, and it's not consistent across different languages!
                    - It's also up to you to remember these kinds of details, as you are likely to be working in multiple
                      languages in the same day, and it's easy to forget which language you are working in!
                    - UGH!
                      > - Java's language Designers Rejected Multiple Inheritance - Here's Why
                      >   - https://www.youtube.com/watch?v=1-JBFJ8Xar0

                      > - If you _really_ want to achieve multiple inheritance (_you should never need to, but here's how to do it_):
                      >  - https://www.youtube.com/watch?v=3X9Eo2vzY1I
                      >  - Live Code Example: [How to Achieve Multiple Inheritance in Kotlin](src/main/kotlin/multipleInheritanceExample.kt)
                      
- [Continue Reading - Back-to-Object-Oriented Programming](./10-BackToObjectOrientedProgramming.md)
- [Back to Index](README.md)