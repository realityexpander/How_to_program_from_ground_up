# Class Oriented Programming Style (COP) 1970s-Present <a name="class-oriented-programming"></a>
  - ### BIG IDEA — We can simulate real-world objects and their interactions with each other by using "classes" and "objects" in our code.
  
    > [<img src="assets/bjarne2.png" width="300">](https://en.wikiquote.org/wiki/Bjarne_Stroustrup)
    > 
    > Bjarne Stroustrup, the creator of C++, said that C++ _**was never meant to be the OOP**_ that Alan-Kay was referring to.
    >> Originator of several poorly applied ideas which still haunt and confuse people to this day, but were appropriate for his use-case at the time, and still is for many lower-level of performance-intensive applications.
    >> - My main beef is that the "OOP" that was popularized by C++ and Java is not the "OOP" that Alan-Kay was referring to and many ideas are not compatible. 

  - Usually misnamed "Object Oriented Programming (OOP)," as "Objects" are _not_ the main focus of the paradigm, "Classes" are!
  - A "Class" is just a template for a structure in memory (an "Object") that contains the values ("state") of the 
    variables and pointers to the methods (just functions) of the class.
  - COP is Based on "Simula 67," a language specifically designed to simulate real-world systems. 
  - The creator gave "head nods" to "Smalltalk" but took a different and more Structured-style approach to the class 
    and object concepts explored in Simula, primarily to use more practical aspect of the ideas for the needs of the time.
  - The practical hardware limitations outweighed the theoretical purity of OOP, and shortcuts were made for the sake of
    performance and practicality, such as use of `static` functions to manipulate data directly instead of calling 
    methods on objects to manipulate the data indirectly.
  - The main idea is to use templates (called a "`class`") to group together methods and variables that are 
    related to each other (highly cohesive) and then create `objects` from the class to simulate 
    real-world objects and interactions.
  - Think of simulating a hospital with a `class` named `Doctor` and a `class` named `Patient` and a `class` named `Hospital`.
    - The `class Doctor` would have methods like `treatPatient()` and `writePrescription()`.
    - The `class Patient` would have methods like `getTreated()` and `payBill()` and `pickupPrescription()`.
    - The `class Hospital` would have methods like `admitPatient()` and `assignDoctor()` and `paySalary()`.
  - Examples of Class-Oriented Programming languages are "Simula," "C++", "C#" and "Java"
  
## COP Tried to Introduce a New Style of Programming, Resulting in Confusing Mixed Results <a name="cop-tried-to-introduce"></a>
###### cop-tried-to-introduce
  - COP was a way to for most programmers to fit the procedural paradigm into a "Class and Object" paradigm, 
    with very mixed results.
  - Due to the new blast of terminology and lack or effective learning resources, along with many differing opinions about how
    to apply the COP paradigm, many aspects of COP were misused and abused. 
  
    > - This widespread confusion lead to inefficiently structured programs that became increasingly difficult understand and maintain. 
    > - The same problems that plagued the Procedural paradigm were also now present in the "Class and Object" paradigm, mainly due to the misuse of `static` methods and publicly mutable data used to mimic the procedural paradigm methods.

## C++ Was Never Meant to Be the OOP that Alan-Kay Was Referring To <a name="design-of-c-plus-plus"></a>
###### design-of-c-plus-plus
- Bjarn Stroustrup, the creator of C++, has said that C++ was never meant to be the OOP that Alan-Kay was referring to.
- Many design decisions in C++ were made to fit the procedural paradigm into the OOP paradigm, so when programmers
  tried to use C++ as a "pure" OOP language, they ran into many problems, as outlined in this section.

  > The Design of C++ , lecture by Bjarne Stroustrup
  > - https://www.youtube.com/watch?v=69edOm889V4
  
## Encapsulation <a name="encapsulation"></a>
###### encapsulation
  - ### BIG IDEA — Can we put data and the code that manipulates the data into a "container" that is only accessible by the code in the container?
  - Think of a `struct` in C, but with functions that can access the data in the `struct`, and the data is
    `private` and only accessible by the functions inside the `struct`, or expressly marked as `public`.
  - Data & code are "encapsulated," (or enclosed) into classes.
      - `class` is also referred to as a "template", it is similar to a blueprint for a house as it describes 
        what will be created when the house is built)
    - A `class` is a template for creating an in-memory instance of the class (called an `object`) which contains the
      state and pointers to the methods (functions) of the `class`.

      ```Text
      // COP Pseudo-Code
      class Cat {
         int age
         
         constructor Cat(int age) {  // <-- Called when a new object is created (allocated in memory) from the class.
            this.age = age // <-- "this" refers to the object that is being created.
         }
         
         method makeSound() {
            println(“Meow”)
         }
      }
        
      // Start of program
      function main() {
         Cat cat1 = new Cat(3)  // <-- Allocates memory for a new object of the class "Cat" and
                                //     assigns its address to variable `cat1`, ie: "Instantiates" the class.
         cat1.makeSound()  // <-- will print "Meow".
      }
      ```
      ### Simplistic Overview of a Class and an Object Instance of the Class <a name="simplistic-overview"></a>
      - ###### simplistic-overview
      ```mermaid
         flowchart TB
         
         subgraph catObject["Object “Cat” 🐈 @BFFC882A"]
            catObjectMakeSoundMethodFunctionPointer{{"
                 method makeSound(): 
                 { println(“Meow”) }
                 😺"}}
            catObjectAgeInt["int age = 3"] 
         end
         subgraph catClass["Class “Cat” 🐱"]
            catClassAgeInt["int age"]
            catClassMakeSoundMethodFunctionPointer{{"
               method makeSound():
               { println(“Meow”) }
               😺"}}
         end
      
         catClassAgeInt -- 2. stores value of --> catObjectAgeInt
         catClass -- "
            1. Instantiate = allocate 
            space in physical memory for 
            the data defined in the class
            🐱➤➤🐈
            " --> catObject:::Object 
         
         
         style catClass fill:#444, stroke:#FFF, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5
         style catClassAgeInt fill:#444, stroke:#FFF, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5
         style catClassMakeSoundMethodFunctionPointer fill:#444, stroke:#FFF, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5 
         
         classDef Object fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
         style catObjectAgeInt fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
         style catObjectMakeSoundMethodFunctionPointer fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff 
       
      ```
      ### More Sophisticated Diagram of a Class and Object Instance
      - ###### sophisticated-diagram

      ```mermaid
         flowchart TB
      
         catClass -- "
            1. creates 
            (or “instantiates”)
            a “Cat” object in memory
            using the class ‟Cat”
            as a template
            🐱➤➤🐈
            " --> catObject:::Object
         subgraph catObject["Object “Cat” 🐈 @BFFC882A"]
            catObjectMakeSoundMethodFunctionPointer{{"
               method makeSound(): 
               calls function defined 
               in class “Cat” 
               🐱
            "}}
            catObjectAgeInt["int age = 3"] 
         end
      
         subgraph catClass["Class “Cat” 🐱"]
            catClassMakeSoundMethodFunctionPointer{{"
               method makeSound() @79B6ECA2:
               { println(“Meow”) }
               😺"}}
            catClassAgeInt["
               int age
               2. value is stored in object
               ⬇︎
            "]
         end
         catObjectMakeSoundMethodFunctionPointer -- calls --> catClassMakeSoundMethodFunctionPointer:::Object
      
      
         style catClass fill:#444, stroke:#FFF, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5
         style catClassAgeInt fill:#444, stroke:#FFF, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5
         style catClassMakeSoundMethodFunctionPointer fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff 
         
         classDef Object fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
         style catObjectAgeInt fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
         style catObjectMakeSoundMethodFunctionPointer fill:#444, stroke:#FFF, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5 
         
      ```
  - ## Instantiation or "Allocating Memory" for an Object of a Certain Class <a name="instantiation"></a>
    - ###### instantiation
    - When a new object is created from a `class` template, the `object` is called an "instance" of the `class`.
      - The special `constructor` method is called to set the initial values of the variables in the object ("initialize" its state.)
      - The `constructor` method is called when the `object` is created from the `class` template.
      - The `constructor` method is always the same name as the `class`.
    - An `object` is just a structure in memory that contains the values (or "state") of the variables and pointers to
      the methods of the class.
      - The fact that the object only contains POINTERS to its superclass methods and NOT copies of the methods 
        is one of the main reasons why COP languages are not truly "Object-Oriented" and are more accurately described 
        as "Class-Oriented." The ability to change the methods of the `class` or `object` at runtime is a feature of 
        true OOP paradigm languages like Smalltalk and JavaScript, but not in COP languages like Java and C++. 
  - A "Method" is just a normal function that is inside a class. It can manipulate the variables of its `object`,
      or call other methods in its `object` or call other methods in objects from other classes.
      - The process of calling a method on an object is referred to as "sending a message" to the object in COP.
      - THIS IS TERRIBLE NAMING FOR COP! Because it not a "message" at all.  
        - It's just calling a function!!!! THIS IS NOT MESSAGING!
        - This misnomer lead to a lot of confusion for reasons that will be made clear in this document.
  - The use of the word "constructor" is a bit of a misnomer, as the memory space for the Object has already been allocated, its only purpose is to initialize the state of the object.
  
  - ## Object Instance Variable Values = "State" of the Object <a name="object-instance-variable-values"></a>
    - ###### object-instance-variable-values
    - The values of the variables ("state") of the object are often made inaccessible from outside the class (ie: `private`)
      and only accessible by the methods of the class, or the methods in the inherited subclasses of the class.
    - Methods of the class can be made `public` to be globally accessible by other classes to provide the functionality of the class.
    - Some methods of the `class` can be labeled `protected` and only accessible by subclasses of the class
    - There is a special modifier called `static` makes a variable or method accessible without needing an instance of the class (object)
      - This loophole is the main reason why I call it "Class"-oriented programming and _not_ "Object"-oriented programming!
      - Using `static` is a way to use a `class` as a "name-space" to group together the methods and variables that 
        are related to each other to work on the same data, which is often not part of the `class`. An example of this is
        the `Math` class in Java, which contains only `static` methods and no data.
      - This was not the original intent of the Class and Object use-cases, but it was a way to fit the COP
        paradigm into the "procedural" paradigm.

  - ## Problem: Using Classes and Objects as "Name-Spaces/Scopes" Lead to Procedural-Style Code Implementations <a name="using-classes-and-objects-as-name-spaces"></a>
    - ###### using-classes-and-objects-as-name-spaces
    - In COP languages, the `class` is used as a "name-space" to group together various methods and variables that
      are related to each other (known as "high cohesion") into a single class or "name-space".
        - Variables and methods can be called via a common name, like: `Person.age` or `Person.setName()`
    - All code must be inside an object OR be declared as a `static` member of a `class` to be accessible without an object
        - This use of `static` functions is a primary indication of the COP paradigm is being followed.
      > Objects vs. Static Methods
      > - https://www.youtube.com/watch?v=D0dqC_3Bch8
    
    ```Kotlin
    // Kotlin Example of Using a Class as a "Name-Space" to Group Together Methods
    // - Using COP style mashed together with Procedural style.
    
    data class Person(
       var name: String = "John Doe",
       var age: Int = 0,  // never store age like this, always calculate it from the birthdate.
       var height: Double = 0.0,
       var weight: Double = 0.0
    ) { 
       fun printPerson() {
           println("Name: ${this.name}, Age: ${this.age}, Height: ${this.height}, Weight: ${this.weight}")
       }
    }
    
    class PersonManager {
       // Note: No variables here. Just a set of `static` methods to manipulate the data of the `Person` object.
    
       companion object {  // <-- creates a `static` set of functions that can be accessed without an instance of the `PersonManager` class.
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
    
    // Start of Program
    fun main() {
       val person = Person("John Doe", 30, 6.0, 200.0)
        
       // Directly accessing the data, just like in the Procedural & Structured paradigms.
       person.name = "Jane Doe"
       person.age = 25
       person.height = 5.5
       person.weight = 150.0
       person.printPerson()   
     
       // COP style using the `static` methods of the `PersonManager` class to manipulate the data of the `Person` object.
       PersonManager.changeName(person, "Jane Doe")
       PersonManager.changeAge(person, 25)
       PersonManager.changeHeight(person, 5.5)
       PersonManager.changeWeight(person, 150.0)
       person.printPerson()
    }
    
    // Output:
    // Name: Jane Doe, Age: 25, Height: 5.5, Weight: 150.0
    // Name: Jane Doe, Age: 25, Height: 5.5, Weight: 150.0
    ```
    - Live Code Example: [Using Classes as Name-Spaces in Kotlin](src/main/kotlin/usingClassesAsNameSpaces.kt) 
    - We shall cover the solution to this in the BOOP section of this document.

  - ## Problems Arising from Abusing `Static` Methods and Attributes <a name="problems-arising-from-abusing-static"></a>
    - ###### problems-arising-from-abusing-static
    - Using `static` breaks the encapsulation of the object and leads to Procedural style programming because it
      allows the data to be accessed and manipulated directly without the creating an object of the `class`.
    - Misuse of `static` keyword often lead to "collections of `static` methods" that simply extended the procedural 
      paradigm, except the code blocks now had a name (the name of the `class`) and were grouped together instead of 
      being globally accessible.
    - The `static` methods are passed in the data as parameters and returned the result, just like the procedural paradigm.
        - When `static` is used this way, it completely breaks encapsulation. 
        - The objects are just bags to hold code (a name-space"), and the data is fully exposed to anyone who wants 
          to access it, as it is not privately retained as state within the object. 
    - This `static` way of programming lead to the same exact problems as the procedural paradigm, but with the
      extra needless complexity of the "Class and Object" paradigm.
    
    - These were popularized by web frameworks such as Java's Spring Boot and Many Others.
      > - The Pain of OOP, Lecture #2: Static methods and attributes are evil
      >   - https://www.youtube.com/watch?v=lELJSj9mWbI
    
    - One of the main problems is that `static` methods and data lead to issues with creating automated testing for 
      the program, as the `static` methods and data are stateful and are not encapsulated in an object. This ends up
      making the methods and data not easily "mocked" or "stubbed" for automatic testing purposes
      - Automated testing is simply creating and calling classes with "known" data to verify the correctness of the 
        `class` and it's methods.
    - Another side-effect of `static` methods and data is that they are not "thread-safe" and can easily lead to
      data corruption.
    - And the largest issue is that `static` is shared mutable state and is the root of all evil in programming as it
      leads to undesired side-effects and tough to follow states of the program which leads to unnecessary complexity 
      and difficult to fix bugs.
      > - What's Wrong About Utility Classes? (Static Methods)
      >   - https://www.youtube.com/watch?v=psrp3TtaYYI

## Interfaces <a name="interfaces"></a>
###### interfaces
  - ### BIG IDEA — Can we swap out different implementations of the behavior of methods with the same names to allow for more flexible code?
     - ### Similar to the reason we dont have appliances directly wired to our houses, allowing the ability to plug in different electrical appliances to the same kind of electrical outlet, the "outlet" and "plug" configuration are the `interface` and the appliances are the different `implement`-ations.
 
       >  [<img src="assets/electrical_outlet.png" width="140"/>](assets/electrical_outlet.png)
          [<img src="assets/tv_with_plug.png" width="150"/>](assets/tv_with_plug.png)
          [<img src="assets/toaster.png" width="200"/>](assets/toaster.png)
          [<img src="assets/plugs_and_adapters.png" width="150"/>](assets/plugs_and_adapters.png)
    
    - ie: Can we have a method called `view` that runs different code depending on the `type` of the `object`?
  
  - An `interface` is an "agreement" or "expectation" (also called "contract") that the class will have certain defined methods & 
    variables in any subclass that `implements` the `interface`.
  - It's a way to tell the compiler _AND_ the programmer that the implementing `class` must have certain methods 
    and variables in it to be considered a genuine subclass (or subtype) of the `interface`.
  - The `interface` is implemented by the subclass, where the methods and variables are defined by the 
    concrete implementing `class`.
    
    ```mermaid
    ---
    title: Interface Example
    ---
    classDiagram
    direction TB 
    Document <|-- PDF : implements & inherits
    Document <|-- Email : implements & inherits
    Document <|-- Song : implements & inherits
     
    class Document["interface Document"] { 
       expects method view()* [No implementation here!]
    }
    <<interface>> Document
    class PDF["class PDF"] { 
        override method view() Launch PDF Viewer 
    }
    class Email["class Email"] {
        override method view() Launch Email App
    }
    class Song["class Song"] {
        override method view() Launch Music Player
    }
    
    ```
  - Interface Example (in pseudo-code similar to common COP languages):
    ```Text
    // COP Pseudocode
      
    interface Document {     // <-- Interfaces only define the "signature" of the methods it expects to be in the subclass.
       expects method view()  // <-- This interface expects a method called "view", there is no implementation here.
    }  
        
    // PDF is one "concrete implementing" class of the "Document" interface.
    class PDF implements Document { // <-- PDF is a subclass of Document, and must implement the "view" method.
       override method view() { // <-- The implementation of the interface (uses the "override" keyword) 
          print "Launch PDF Viewer"  
       } 
    }
          
    // Email is one "concrete implementing" class of the "Document" interface.
    class Email implements Document { // <-- Email is a subclass of Document, and must implement the "view" method.
       override method view() { // <-- The implementation of the interface (uses the "override" keyword.)
          print "Launch Email App"  
       }
    }
          
    // Song is one "concrete implementing" class of the "Document" interface.
    class Song implements Document { // <-- the implementation of the interface (uses the "override" keyword.)
       override method view() { 
          print "Launch Music Player"  
       } 
    }
          
    // Start of program
    function main() {
       Document doc1 = new PDF()  // <-- Creates a new object of the class "PDF" and assigns its address pointer to variable `doc1`.
       Email doc2 = new Email()   
       Song doc3 = new Song() 
            
       function viewDocument(Document doc) {  // Note that the parameter is of type `Document` and not `PDF` or `Email` or `Song`. 
          doc.view() // Will call the appropriate "view" method of the subclass.
       }
             
       viewDocument(doc1)  // <-- will print "Launch PDF Viewer".
       viewDocument(doc2)  // <-- will print "Launch Email App".
       viewDocument(doc3)  // <-- will print "Launch Music Player".
    }
    
    main()
    
    // Output:
    // Launch PDF Viewer
    // Launch Email App
    // Launch Music Player
    ```
    > Live Code Example: [How Interfaces Work in Kotlin](src/main/kotlin/interfaceExample.kt)

    - Interfaces allow a developer to add multiple different implementations of the same named method by defining a
      new `class` that `implement`-s the superclass `interface` by defining code for the methods in the subclass
        - This makes it easier to add new subclasses of the `interface` to the program without changing any existing code
        - This also make it easier to write "testing" code that can be used to automatically verify the correctness of the methods
          of the `class` by using "testing" implementations of the `interface`
    - The `interface` is `implement`ed by a `class` and the methods are finished by the implementing `subclass`
      according to the method signatures in the `interface`
    - "Subclassing" is also called "Subtyping" or "Inheritance" and is the basis for Polymorphism as it allows
      different implementations of the same named method to be used interchangeably in the program.
      > ### ⚠️ MORE OVERCOMPLICATED TERMINOLOGY THAT MAKES IT HARDER TO LEARN! 
      >> The **"Liskov Substitution Principle"** Explained in 2 Minutes
      >> - https://www.youtube.com/watch?v=gV4P-fewa9M
      >> - Live Code Example in Kotlin: [Liskov Substitution Principle Example](src/main/kotlin/liskovSubstitutionPrincipleExample.kt)

## Inheritance <a name="inheritance"></a>
###### inheritance
  - ### BIG IDEA - Can we create a new class that inherits all the methods and variables of another class and then add new methods or override methods in the subclass?
  
  - Inheritance is the idea that a new `class` can copy from another `class` all of its methods and variables,
    and then add new methods or override existing methods in the subclass that can modify the behavior of the
    original parent (super) `class`.
  - Classes can inherit from other classes to reuse code and state, and to create "subtypes/subclasses" of the 
    original class with modifications.
  - The class that is inherited from is called the "superclass" and the class that inherits is called the "subclass."
  - The "subclass" is also called a "derived class" and the "superclass" is also called a "base class."
  - "Subtyping," "Subclassing," and "Inheritance" are all the same concept, and are the basis for polymorphism and dynamic binding.

    ```mermaid
    ---
    title: Class Inheritance Example Diagram
      
    ---
    classDiagram
    direction TB
    Media <|-- MP3 : extends
    Media <|-- Video : extends
    MP3 <|-- ProtectedMP3 : extends      
      
    class Media {
       String name
       open method play()
    }
    class MP3 {
       override method play()
    }
    class Video {
       override method play()
    }
    class ProtectedMP3 {
       private String password*
       private Boolean isAuthenticated*
      
       override method play()
       method authenticate(password)
    }
    ```

    - ### Example of inheritance (in pseudocode, and is similar to common COP languages):
      ```Text
      // COP pseudo-code
        
      open class Media {   // <-- the "base class" or "superclass", `open` means it can be subclasses (extended/inherited.)
         // Note: there is no visible constructor, so the default constructor will be used -> Media(), which takes no parameters and does not initialize any variables.
         String name = ""  // <-- the "state" of the object is stored in the variables of the class.
           
         open method play() { // <-- `open` means that the method can be overridden in a subclass.
            print "Playing Unknown Media: " + this.name  // <-- Default implementation of the method. 
         } 
      }  
      
      open class MP3 extends Media {   // <-- the "subclass" or "derived class"; it `extends` (inherits) from the superclass (Media).
         // NOTICE: No constructor is defined, so the default constructor in the superclass will be used -> Media().
      
         override method play() { 
            print "Playing MP3: " + this.name 
         } 
      }
      
      class Video extends Media { 
         // NOTICE: No constructor is defined, so the default constructor in the superclass will be used -> Media().
         
         override method play() { 
            print "Playing Video: " + this.name 
         } 
      }
      
      class ProtectedMP3 extends MP3 {  // note: "Concrete Class" MP3 must be declared as `open` in order to be subclassed.
         String password
         Boolean authenticated = false
      
         constructor ProtectedMP3(String name, String password) {  // <-- the constructor of this class, its called to initialize the object.
            super(name)  // <-- calls the constructor of the superclass (MP3).
            this.password = password    // Sets the password for the password protected MP3.
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
      function main() {
         Media doc0        = new Media()  // Since the `Media` class is `open` and not `abstract`, an object can be created from it.
         Media doc1        = new MP3()
         Media doc2        = new Video()
         ProtectedMP3 doc3 = new ProtectedMP3("MyProtectedMP3.mp3", "MySecretPassword123")  // note that the `ProtectedMP3` type is required to call the `authenticate` method.
      
         function playMedia(Media media) {  // Note that the parameter is of type `Media` and not `MP3` or `Video` or `ProtectedMP3`.
            media.play()
         }
      
         playMedia(doc0)            // <-- will print "Playing: MyMedia".
         playMedia(doc)             // <-- will print "Playing MP3: MyMP3.mp3".
         playMedia(doc2)            // <-- will print "Playing Video: MyVideo.mp4".
      
         playMedia(doc3)            // <-- will print "Not Authenticated!".
         doc3.authenticate("MySecretPassword123")  // <-- will print "Authenticated!".
         playMedia(doc3)            // <-- will print "Playing Protected MP3: MyProtectedMP3.mp3".
      }
      
      main()
      
      // Output:
      // Playing: MyMedia
      // Playing MP3: MyMP3.mp3
      // Playing Video: MyVideo.mp4
      // Not Authenticated!
      // Authenticated!
      // Playing Protected MP3: MyProtectedMP3.mp3
       ```
      > - Live Code Example: [How Inheritance Works in Kotlin](src/main/kotlin/inheritanceExample.kt)
   
## Problems Arising from the Abuse of Inheritance <a name="problems-arising-from-the-abuse-of-inheritance"></a>
###### problems-arising-from-the-abuse-of-inheritance
  - ### BIG IDEA — The hype around reusability was so strong at the time that it was often used to justify the use of inheritance in places where it was not appropriate.

  - Misuse of inheritance lead to immense unnecessary complexity to fit in the "simulation" paradigm, 
    as programmers tried to shove the Procedural paradigm into the fancy new "Class Oriented" paradigm with less 
    than stellar results.
  - Inheritance is a usually a bad idea for many reasons, and very overused beyond its original intent.
      - The hype around reusability was so strong that it was often used to justify the use of inheritance in places
        where it was not appropriate.
      - This lead to "fragile" and "rigid" code that was hard to understand and hard to modify, leading to a lot
        of waste and costs.
      - Many popular ways of dealing with the procedural approach to COP were turned into official sounding "design patterns"
        that were used to "fix" the problems of the "procedural approach" to COP. Many of these ideas were just
        common hacks to fit the "procedural approach" into the "COP" paradigm.
      - The promise of "code reusability" was not fulfilled by COP languages.
        > - The Flaws of Inheritance
        >   - https://www.youtube.com/watch?v=hxGOiiR9ZKg
        > - Banana, Monkey, Jungle Problem
        >   - https://crystal-villanueva.medium.com/the-banana-and-the-gorilla-problem-92c9a4717fd6

## Abstract Classes = The Name of a "General Category or Group"  <a name="abstract-classes"></a>
###### abstract-classes
  - ### BIG IDEA — Lets have a class that defines a general category of objects, but doesn't define the implementation details of the objects. That way we can create many different kinds of objects that all have the same "method signature," but have different implementations of the methods.
   
    - ie: Like an `abstract class Document` that has a method called `view` doesn't necessarily implement how a 
      document is viewed, only it's method definition. Any object that is a subtype of "Document" must have a `view` 
      method implemented.
    - You can't create a generic `Document` object, BUT you can create a `PDF` or `Excel` or `Text` object that is 
      is a subclass of the `abstract class Document` class, as they will require a `view` method to be implemented.
    - The `Document` class is an `abstract class` and the `class PDF`,`class Excel,` and `class Text` are the 
      "concrete classes."
  
  - #### Very similar to interfaces but can have default implementations of the methods & define variables that are expected to be in the subclass.
  
  - #### ANOTHER EXAMPLE OF A SIMPLE IDEA LEADING TO OVERCOMPLICATED CODE
    - Leading to unwieldy and hard to understand code, often used in places where it was not necessary.
    > Abstraction Can Make Your Code Worse
    > - https://www.youtube.com/watch?v=rQlMtztiAoA 
  
  - An `abstract class` is a template for a "concrete" (or specific) `class`, and cannot to be instantiated itself, 
    only `extend`-ed and be used as a "general" `class` to group the "specific" classes into categories or "types."
  - I like to forget the word `abstract` and replace it wih the phrase "The General Category."
    - I kept confusing it with the "abstract" concept in art, and "abstract" concept in philosophy.
    - The `abstract` used in computing ONLY means the "general category" of a class of objects.
    - Many people who attempted to explain the "abstract" keyword were likely unaware of the other meanings of the word
      and likely confused many people who were trying to learn the concept.
      - They could have just said what I just told you, but they didn't, and that's why I'm here to help you. 
    - ie: "documents" is the general category (abstract idea) of a generic "something to structure and retain data."
  - The `abstract class` is `extend`—ed by the subclass and the subclass methods `override` the superclass methods by
    implementing the method in the subclass. 
    ```mermaid
    ---
    title: Abstract Class Example Diagram
      
    ---
    classDiagram
    direction LR
    File <|-- Excel : extends
    File <|-- Memo : extends
    File <|-- Photo : extends
      
    class File["abstract class File"] {
       String name  // ⬅︎ Abstract classes can have variables.
       open method view(): Launch(Basic_Text_Editor)  // "default" implementation.
       open method showName():  Print("File Name: " + this.name // "default" implementation".
    }
    <<abstract>> File 
      
    class Excel["class Excel extends File"] {
       override String name // ⬅︎ Subclasses must declare abstract variables.
       override method view(): Launch(Excel_Viewer) 
    }
    class Memo["class Memo extends File"] {
       override String name // ⬅︎ Subclasses must declare abstract variables.
       String to  // ⬅︎ Subclasses can have additional variables.
       String from
       String subject
       override method view(): Launch(Memo_Viewer) 
       override method showName(): Print "Memo from: " + this.from + ", to: " + this.to
    }
    class Photo["class Photo extends File"] {
       override method view() Launch(Photo_Viewer)
    }
    ```
  - Example for abstract classes in pseudo-code (similar to common COP languages):
    ```Text
     // COP pseudo-code
     
     abstract class File { 
        abstract String name // <-- Abstract classes can have variables.
        
        constructor File(String name) {  // <-- Abstract classes can have "default" constructors.
           this.name = name
        }
        abstract method view()  // Expects a method called "view" and has no default implementation.
        abstract method showName() {  // Expects a method called "showName" and has a default implementation.
           print "File Name: " + this.name // <-- The "default implementation" for any subclass that doesn't override the method.
        } 
     }  
     
     class Excel extends File {  // <-- Excel is a subclass of File.
        override String name // <-- Subclasses must declare the abstract variables from superclass.
    
        override method view() { // <-- the implementation of the abstract class "view".
           print "View Excel: " + this.name  
        } 
     }
     
     class Memo extends File { // <-- Memo is a subclass of File.
        override String name // <-- Subclasses must declare the abstract variables from superclass.
        String to
        String from
        String subject
    
        constructor Memo(String to, String from, String subject) {  // <-- the custom constructor of this class, its called to 
                                                                    //     initialize the variables of the object.
           super("Memo to:" + to)  // <-- calls the constructor of the superclass (File).
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
         override String name // <-- Subclasses must declare the abstract variables from superclass.
         
         override method view() {  // <-- the implementation of the abstract class "view".
            print "View Photo: " + this.name
         } 
     }
     
     // Start of program
     function main() {
         // File doc0 = new File("MyFile")  // Since the `File` class is `abstract`, an object cannot be created from it. 
                                            // Attempting this will result in a compiler error.
         File file1 = new Excel("MyExcel.xls")
         File file2 = new Photo("MyPhoto.jpg")
         Memo file3 = new Memo(to="Chris", from="Bob", subject="Meeting")
     
         function viewFile(File file)  // Note that the parameter `doc` is of type `File` and not `Excel` or `Photo` or `Memo`.
            file.view(name)
         }
     
         viewFile(file1)  // <-- will call the "view" method of the Excel class.
         viewFile(file2)  // <-- will call the "view" method of the Photo class .
         viewFile(file3)  // <-- will call the "view" method of the Memo class.
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
     - Live Code Example: [How Abstract Classes Work in Kotlin](src/main/kotlin/abstractClassExample.kt)

## Full Diagram of with `abstract` Classes, `extended` Classes and Objects, Stored in Memory
   ```mermaid
     flowchart LR
   
     ExcelFileObjectPrintContentMethodFunctionPointer -- calls --> ExcelFileClassPrintContentMethod:::Object
     ExcelFileClassAgeInt -- stores value of --> ExcelFileObjectAgeInt 
     subgraph ExcelFileObject["[object instance ExcelFile @19FCA68D]"]
         ExcelFileObjectAgeInt["int content = 3"]
         ExcelFileObjectPrintContentMethodFunctionPointer{{"method PrintContent(): 
            calls 
            function @C62F3842
            in class ExcelFile
            🖨️
            "}}
     end
     subgraph classExcelFile["class ExcelFile extends File"]
         ExcelFileClassAgeInt["int content"]
         ExcelFileClassPrintContentMethod{{"function @C62F3842:  
            method PrintContent() =
            { print this.content }
            🖨️
            "}}
     end
     abstractAgeInt -- expects --> ExcelFileClassAgeInt
     abstractPrintContentMethod -- expects --> ExcelFileClassPrintContentMethod:::Object
     ExcelFileClassAgeInt -- implements --> abstractAgeInt:::Abstract
   
     note["
        EXPLANATION: 
        The ExcelFile Object @19FCA68D 
        is an instance of the ExcelFile class.
        ExcelFile class is a subclass of the 
        abstract File class.
        📁 ➤➤ 🗄️"]
     
     classExcelFile -- "instantiates 
                        object
                        ⬇️" --> ExcelFileObject:::Object
     classExcelFile -- extends ---> abstractFile:::Abstract
     ExcelFileClassPrintContentMethod -- implements --> abstractPrintContentMethod:::Abstract
     subgraph abstractFile["abstract class File"]
       abstractAgeInt["abstract int content"]
       abstractPrintContentMethod{{"
          abstract method 
          PrintContent()
          ⎙
          "}}
     end
   
     classDef Abstract fill:#222, stroke:#0F0, stroke-width:1px, color:#fff, stroke-dasharray: 5 5
     
     classDef Class fill:#444, stroke:#00F, stroke-width:1px, color:#000, stroke-dasharray: 5 5
     %% For nodes that are the source of a link, the style must be defined in the link, not the classDef. 
     style classExcelFile fill:#444, stroke:#DDD, stroke-width:1px, color:#000, stroke-dasharray: 5 5
     style ExcelFileClassAgeInt fill:#444, stroke:#DDD, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5
     
     classDef Object fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
     style ExcelFileObjectAgeInt fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
     style ExcelFileObjectPrintContentMethodFunctionPointer fill:#222, stroke:#DDD, stroke-width:1px, color:#000, stroke-dasharray: 5 5
   ```

## Polymorphism <a name="polymorphism"></a>
###### polymorphism
  - ### BIG IDEA — The idea that a method can be called on an object and the method will behave differently based on the `class` of the object that is called.
  - In COP, the `interface` and `abstract class` are implementations of the idea of polymorphism.

  - #### ANOTHER EXAMPLE OF A SIMPLE IDEA WITH AN OVERCOMPLICATED NAME!
    - Yet _another_ overcomplicated name for a very basic, exceedingly simple idea.
    - Polymorphism is the idea that a method can be called on an object and the method will behave differently
      based on the "type" of the "object" that the "method" is called on
        - This is the basis for `override`ing methods in subclasses and `interfaces` and `abstract class`es
        - In the example above, the `viewDocument` function can be called with any `Document` object and the `view` method
          will behave differently based on the "type" of the `Document` object that is passed in
  - ### Associated with Liskov Principle
    - #### MORE MAKING FANCY TERMS FOR VERY BASIC CONCEPTS THAT BARELY NEED EXPLAINING, I'VE SAID ENOUGH ALREADY.
    - The "Liskov Substitution Principle" comes from "Set theory" and is the idea that "objects of a superclass shall be
      replaceable with objects of its subclasses without affecting the functionality of the program."
    - That's it. That's the whole idea. It's just a fancy way of saying that "subclasses should work the same as
      their superclass."
    - There is a lot of confusion around this principle, but it's just a fancy way of saying that "subclasses should
      work the same as their superclass."
    - Live Code Example: [Liskov Substitution Principle in Kotlin](src/main/kotlin/liskovSubstitutionPrincipleExample.kt)

## Controlled Visibility of Variables and Methods <a name="controlled-visibility"></a>
###### controlled-visibility
  - ### BIG IDEA — Global mutable variables is a big problem, so lets control the visibility of the variables and 
    methods of the class to other classes and subclasses.
  - ie: Making a variable `private` means that it can only be accessed by the methods of the class and not by any other class.

  - Use of explicit `private` and `protected` and `public` to control the visibility of the variables and methods
    of the class.
  - Making a variable `private` means that it can only be accessed by the methods of the class and not by any
    other class.
  - Making a variable `protected` means that it can only be accessed by the methods of the class and any subclass
    of the class.
  - Encouraged to use getters and setters to control the access to the variables of the class (which has since
    been shown to be a bad idea due to misuse and overuse of the pattern)


## Allowing for "Multiple Inheritance" in C++ was a mistake, and it was removed from Java and C# for very good reasons. <a name="multiple-inheritance-removed"></a>
###### multiple-inheritance-removed
  - Multiple Inheritance is the idea that a class can inherit from more than one class, and then have access to
    all methods and variables of the superclasses.

  - Diagram of Multiple Inheritance:
    ```mermaid
      flowchart TD
         X["The Problem with Multiple Inheritance"]
         Animal["
            abstract class Animal
            expects method makeSound()
            ⬇︎
         "] -->|inherits| Cat["
            🐈 Class Cat
            method makeSound()
            ⬇︎
         "] & Dog["
            🐕 Class Dog
            method makeSound()
            ⬇︎
            "]-->|inherits| Cog???["
               class Cog(???) extends Cat & Dog
               ⬇︎
            "]
      
         Cog??? -..-> Y((("
            When 
            “Cog” makes a sound, 
            (ie: method “makeSound()” is 
             called on object Cog) 
            
            Does it “Meow” or “Bark?”
            🐈+🐕 = ⚙️(???)
            ⧗⧫⧖
         "))) 
      ```
  - Example of an attempt to use "Multiple Inheritance" in C++:
    ```C++
    #include <iostream>
    using namespace std;
    
    class Animal {
       public:
          void makeSound() {
             cout << "Make animal sound" << endl;
          }
    };
    
    class Cat : public Animal {  // <-- Cat inherits from Animal.
       public:
          void makeSound() {
            cout << "Meow" << endl;
         }
    };
    
    class Dog : public Animal { // <-- Dog inherits from Animal.
       public:
          void makeSound() {
            cout << "Bark" << endl;
          }
    };
    
    class Cog : public Cat, public Dog {  // <-- Multiple Inheritance.
       // nothing defined here.
    };
    
    int main() {
       Cog c;  // <-- Create a new Cog object.
       
       c.makeSound(); // <-- What will this print? "Meow" or "Bark"???
    }
    
    // THIS IS *NOT* THE OUTPUT:
    // Does the Cog "Meow" or "Bark"???
    
     ```
  - In C++, calling `Cog`'s `makeSound()` method will print `Meow`, _BUT_ in Python, calling
    `Cog`'s `makeSound()` will print `Bark`!
  - This behavior is _completely arbitrary_ and up to the designers of the language to decide which
    method will be called, and it's _not_ consistent across different languages!
  - It's also up to you to remember these kinds of details, as you are likely to be working in multiple
    languages in the same day. Furthermore, it's quite easy to forget which language you are working in which lead to weird bugs.
  - UGH!
  
    > Java's language Designers Rejected Multiple Inheritance - Here's Why
    >   - https://www.youtube.com/watch?v=1-JBFJ8Xar0
    
    > NOTE: If you _really_ want to achieve multiple inheritance... (_you should never need it, but here's how:_)
    >   - https://www.youtube.com/watch?v=3X9Eo2vzY1I
    >   - Live Code Example: [How to Achieve Multiple Inheritance in Kotlin](src/main/kotlin/multipleInheritanceExample.kt)

## More Thoughts on Class Oriented Programming <a name="some-thoughts-on-object-oriented-programming"></a>
  > Kevlin Henney - Object? You Keep Using that Word - Trójmiasto JUG [30.05.2016]
  > - https://www.youtube.com/watch?v=IA-RyzKE7oc

## Design Patterns <a name="design-patterns"></a>
###### design-patterns
  - ### BIG IDEA — There are common problems and ways of solving them that humans have already figured out and named them.
 
  - "Design Patterns" became popular around the time of C++ due to the new complexity of the language and the
    need to solve the problems of the "procedural approach" to COP.
  - These "patterns" were discovered by programmers dealing with C++ language issues, and these common solutions were
    shared on public forums and in many books from different authors, given in talks at software development conferences, 
    emphasizing different ideas and approaches to particular problems that arose from C++ programming.
  - Most of these so-called "patterns" were just hacks to fit the "procedural approach" into the "COP" paradigm.
  - Many programmers accepted these patterns as some kind of gospel, and they were often used to justify the
    use of inheritance (and other language features) in places where it was not appropriate.
  - For example,"The "Gang of Four" book is the most famous book on the subject, and it is often referred to as the "Bible."
    - It is just a collection of ideas that worked in a particular situation and was not meant to be a "one-size-fits-all" solution.
    - The promoters of these books and resources rarely talk about the limits of thier ideas, and programmers often
      misunderstand the ideas and apply them in places where they are not appropriate. 
  - Although some ideas in the book are good, many of the ideas are just generally-accepted hacks to fit the "procedural
    approach" into the "COP" paradigm.
  
  - ### Many of the problems in COP could have been avoided by exploring what the originator of the term "Object Oriented", Alan Kay, originally meant by the term "Object Oriented."
 
- [Continue Reading - Functional Programming](10-FunctionalProgramming.md)
- [Back to Index](README.md)