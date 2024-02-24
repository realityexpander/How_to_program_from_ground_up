# Class Oriented Programming Style (COP) 1970s-Present <a name="class-oriented-programming"></a>
  - ### BIG IDEA — We can simulate real-world objects and their interactions with each other by using "classes" and "objects" in our code.
  
    > [<img src="assets/bjarne2.png" width="300">](https://en.wikiquote.org/wiki/Bjarne_Stroustrup)
    > 
    > Bjarne Stroustrup, the creator of C++, said that C++ _**was never meant to be the OOP (Object Oriented Programming)**_ that Alan-Kay was referring to.
    >> Originator of several poorly applied ideas which still haunt and confuse people to this day, but were appropriate for his use-case at the time, and still is for many lower-level of performance-intensive applications.
    >> - My main beef is that the "OOP" that was popularized by C++ and Java is not the "OOP" that Alan-Kay was referring to and many ideas are not compatible.

  - Usually misnamed "Object Oriented Programming (OOP)," as "Objects" are _not_ the main focus of the paradigm, "Classes" are!
  - The main idea in COP is to use templates (called a "`class`") to group together functions and variables that are 
    related to each other (highly cohesive) and then create `objects` from the class to simulate 
    real-world objects and interactions.
  - A `class` is a template for a structure in memory (called an "Object") that contains the values ("state") of the 
    variables and pointers to the methods (just functions) of the class.
    - Just like the `struct` in C, but:
      - Adding functions that can access the data in the `struct`,
      - The data is `private` and only accessible by the functions inside the `struct` (or expressly marked as `public`.)
  - COP is Based on ["Simula 67"](13-Conclusion.md), a language specifically designed to simulate real-world systems. 
  - The creator gave "head nods" to "Smalltalk" but took a different and more Structured-style approach to the class 
    and object concepts explored in Simula, primarily to use more practical aspect of the ideas for the needs of the time.
  - The practical hardware limitations outweighed the theoretical purity of OOP, and shortcuts were made for the sake of
    performance and practicality, such as use of `static` functions to manipulate data directly instead of calling 
    methods on objects to manipulate the data indirectly.
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
      - ⚠️ THIS IS TERRIBLE NAMING! Because it not a "message" at all.  
        - It's just calling a _function!!!!_ THIS IS NOT MESSAGING!
        - "Messaging" implies that something is "sent" to the object and the object can decide what to do with the message.
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

  - ## Problem: Using Classes and Objects as "Name-Spaces/Scopes" Leads to Procedural-Style Code Implementations <a name="using-classes-and-objects-as-name-spaces"></a>
    - ###### using-classes-and-objects-as-name-spaces
    - In COP languages, the `class` is used as a "name-space" to group together various methods and variables that
      are related to each other (known as "high cohesion") into a single class or "name-space".
        - Variables and methods can be called via a common name, like: `Person.age` or `Person.setName()`
    - All code must be inside an object OR be declared as a `static` member of a `class` to be accessible without an object
        - This use of `static` functions is a primary indication of the COP paradigm is being followed.
      > Objects vs. Static Methods
      > - https://www.youtube.com/watch?v=D0dqC_3Bch8
    ###### static-methods
    - Diagram of the `class` `PersonManager` used as a "name-space" to dump a collection of `static` methods to manipulate the data of `Person` objects:
    
    ```mermaid
    ---
    title: The `PersonManager` class is a "name-space" for a grouping of static methods that manipulate the data of the `Person` objects.
    ---
    classDiagram
    direction TB 
  
    Person <|-- PersonManager: Only contains static methods to modify the data of `Person` objects.
    
    class PersonManager["class PersonManager"] {
       data NO DATA HERE // ⬅︎ No data here, just a set of `static` methods to manipulate the `Person` objects. 
    
       static method changeName(Person person, String newName)
       static method changeAge(Person person, int newAge)
       static method changeHeight(Person person, double newHeight)
       static method changeWeight(Person person, double newWeight)
       static method changeAddress(Person person, String newAddress)
    }
    
    class Person["class Person"] { 
       String name
       int age
       double height
       double weight
       String address
    
       method NO METHODS HERE()  // ⬅︎ No methods here, just the data for a `Person` object.
    }
    ```
    
    ```mermaid
       flowchart TB
    
       PersonManager -- "
          1. Only changes data in `Person` objects
          ✍️ only writes/reads ->🧍
          " --> Person:::Object
       PersonManager -- "
          2. Only changes data in `Person` objects
          ✍️ only writes/reads ->🧍
          " --> Person2:::Object 
      
      
       subgraph Person["Object “Person”  🧍@CAFE882A"]
          personObjectAgeInt["int age = 3"]:::Object
          personObjectNameString["String name = “John Doe”"]:::Object 
          
          HasNoMethods["NO METHODS HERE"]
       end
      
       subgraph Person2["Object “Person”  🧍@45F7BABE"]
          personObjectAgeInt2["int age = 32"]:::Object
          personObjectNameString2["String name = “Jim Jones”"]:::Object 
          
          HasNoMethods2["NO METHODS HERE"]
       end
    
       subgraph PersonManager["Class “PersonManager” 🙇‍"]
          note["Note: This is not an object instance, 
                it only contains function pointers to static methods.
                
                Is this OO💩?
          "]
          PersonManagerClassChangeAgeMethodFunctionPointer{{"
             static method changeAge(Person p, int newAge) @DEAD2BC8:
             { p.age = newAge }
             ✍️"}}:::Object
          PersonManagerClassChangeNameMethodFunctionPointer{{"
             static method changeName(Person p, String newName) @2DCABEEF:
             { p.name = newName }
             ✍️"}}:::Object
          
          HasNoData["NO DATA HERE"]
       end
    
    
       style PersonManager fill:#444, stroke:#FFF, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5 
       classDef Object fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
    ```
    
    ```Kotlin
    // Kotlin Example of Using a Class as a "Name-Space" to Group Together Methods
    // - Using COP style mashed together with Procedural style.
    
    data class Person(  // 🧍
       var name: String = "John Doe",
       var age: Int = 0,  // never store age like this, always calculate it from the birthdate.
       var height: Double = 0.0,
       var weight: Double = 0.0
    ) { 
       fun printPerson() {
           println("Name: ${this.name}, Age: ${this.age}, Height: ${this.height}, Weight: ${this.weight}")
       }
    }
    
    class PersonManager {  // 🙇‍
       // Note: No variables here. Just a set of `static` methods to manipulate the data of the `Person` object.
    
       companion object {  // <-- creates a `static` set of functions that can be accessed without an instance/object of the `PersonManager` class.
          fun changeName(person: Person, newName: String) {  // only modifies the data of the `Person` object.
             person.name = newName
          }
    
          fun changeAge(person: Person, newAge: Int) {  // only modifies the data of the `Person` object.
             person.age = newAge
          }
    
          fun changeHeight(person: Person, newHeight: Double) {  // only modifies the data of the `Person` object.
             person.height = newHeight
          }
          
          fun changeWeight(person: Person, newWeight: Double) { // only modifies the data of the `Person` object.
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
       PersonManager.changeName(person, "Chris Day")
       PersonManager.changeAge(person, 35)
       PersonManager.changeHeight(person, 6.5)
       PersonManager.changeWeight(person, 180.0)
       person.printPerson()
    }
    
    // Output:
    // Name: Jane Doe, Age: 25, Height: 5.5, Weight: 150.0
    // Name: Chris Day, Age: 35, Height: 6.5, Weight: 180.0
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
    variables in any subclass that `implement`-sim the `interface`.
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
  - NEVER MEANT FOR "CODE-RE-USE"! It was meant to create "subtypes" of the original class with modifications.
  - "Subtyping," "Subclassing," and "Inheritance" are all the same concept, and the basis for "polymorphism."

    ```mermaid
    ---
    title: Class Inheritance Example Diagram
      
    ---
    classDiagram
    direction TB
    Media <|-- MP3 : extends
    Media <|-- Video : extends
    MP3 <|-- ProtectedMP3 : extends      
      
    class Media["class Media"] {
       protected String name*
    
       constructor Media(String name) this.name = name
       open method play(): print("Playing Unknown Media: " + this.name)
    }
    class MP3["class MP3 extends Media"] {
       constructor MP3(String name): --> super(name + ".mp3")
       override method play(): print("Playing MP3: " + this.name)
    }
    class Video["class Video extends Media"] {
       constructor Video(String name): --> super(name + ".mp4")
       override method play(): print("Playing Video: " + this.name)
    }
    class ProtectedMP3["class ProtectedMP3 extends MP3"] {
       private String password*
       private Boolean isAuthenticated*
       
       constructor ProtectedMP3(String name, String password) --> super(name)
       override method play(): if(this.isAuthenticated == true) then print("Playing Protected MP3: " + this.name) else print("Not Authenticated!")
       method authenticate(password): if(this.password == password) then this.isAuthenticated = true 
    }
    ```

    ### Example of Inheritance (in pseudocode, and is similar to common COP languages):
      ```Text
      // COP pseudo-code
        
      open class Media {   // <-- the "base class" or "superclass", `open` means it can be subclasses (extended/inherited.)
         protected String name = ""  // // <-- the `name` property is protected, so it can be accessed by subclasses, and it's private to other classes.
      
         constructor Media(String name) {  // <-- Constructor is called to initialize the object variables.
            this.name = name  // <-- Sets the name variable in the object just created (allocated in memory).
         }     
      
         open method play() { // <-- `open` means that the method can be overridden in a subclass.
            print "Playing Unknown Media: " + this.name  // <-- Default implementation of the method. 
         } 
      }  
      
      open class MP3 extends Media {   // <-- the "subclass" or "derived class"; it `extends` (inherits) from the superclass (Media).
      
         constructor MP3(String name) {  // <-- the constructor of this class, its called to initialize the object.
            super(name + ".mp3")  // <-- calls the constructor of the superclass (Media).
         }
      
         override method play() { 
            print "Playing MP3: " + this.name 
         } 
      }
      
      class Video extends Media { 
         
         constructor Video(String name) {  // <-- the constructor of this class, its called to initialize the object.
            super(name + ".mp4")  // <-- calls the constructor of the superclass (Media).
         }
      
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
               print "Authenticated."
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
         Media doc0        = new Media("MyMedia")  // Since the `Media` class is `open` and not `abstract`, an object can be created from it.
         Media doc1        = new MP3("MyMP3")
         Media doc2        = new Video("MyVideo")
      
         function playMedia(Media media) {  // Note that the parameter is of type `Media` and not `MP3` or `Video` or `ProtectedMP3`.
            media.play()
         }
      
         playMedia(doc0)            // <-- prints "Playing Unknown Media: MyMedia".
         playMedia(doc1)            // <-- prints "Playing MP3: MyMP3.mp3".
         playMedia(doc2)            // <-- prints "Playing Video: MyVideo.mp4".
    
         // println(doc0.name)  // <-- will not compile because `name` is `protected` and cannot be accessed from outside the class.
      
         ProtectedMP3 doc3 = new ProtectedMP3("MyProtectedMP3", "MySecretPassword123")  // note that the `ProtectedMP3` type is required to call the `authenticate` method.
         playMedia(doc3)            // <-- prints "Not Authenticated!".
         doc3.authenticate("MySecretPassword123")  // <-- prints "Authenticated.".
         playMedia(doc3)            // <-- prints "Playing Protected MP3: MyProtectedMP3.mp3".
      }
      
      // Output:
      // Playing Unknown Media: MyMedia
      // Playing MP3: MyMP3.mp3
      // Playing Video: MyVideo.mp4
      // Not Authenticated!
      // Authenticated.
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
        > - The Design of C++ , lecture by Bjarne Stroustrup (section about code re-use)
        >   - https://youtu.be/69edOm889V4?si=JEwAkYjnK1wjzmDF&t=708
        > - Inheritance vs. Subtyping (webinar #24)
        >   - https://www.youtube.com/watch?v=DjrA7_Uymok
        > - The Pain of OOP, Lecture #8: Inheritance [object oriented programming crash course]
        >   - https://www.youtube.com/watch?v=m0OEOoGgIuM
        > - The Flaws of Inheritance
        >   - https://www.youtube.com/watch?v=hxGOiiR9ZKg

## Abstract Classes = The Name of a "General Category or Grouping"  <a name="abstract-classes"></a>
###### abstract-classes
  - ### BIG IDEA — Can we use a `class` as way to define a general category of things, and optionally define the default implementation details in the general `class`? 
    - ### That way we can create many different kinds of objects with the same "method signature," but have different implementations of the methods.

  - ## ⚠️ Confusing Terminology Alert!
  - I suggest forgetting the word `abstract` and substitute the phrase **_"The General Category."_**
      - When I was learning about the `abstract` programming concept, I kept confusing it with the "abstract" concept in art, and "abstract" concept in philosophy, and other
        meanings of the word. People also seemed to use it in many different ways, and it was very confusing.
      - The `abstract` term used in computing **_ONLY_** MEANS THE  **"GENERAL CATEGORY"** of something. 
      - ##### And NEVER the artistic, or philosophical meaning of the word, unless the speaker **_specifically_** points out that particular connection. Otherwise, just replace it with the phrase _"the general category."_
      - Many people who attempted to explain the "abstract" keyword were likely unaware of the other meanings of the word
        and confused many people due to ignorance.
      - They could have just said what I just told you, but they didn't, and that's why I'm here to help you. 🙂
  
  - ### "Function signature" = `function name` + `parameter types` + `return type`
      - Also called "method signature" in the context of a `class`.
      - Its the _"definition"_ of the method, and not the _"implementation"_ of the method.
    - ie: `method view()` is the method signature, and it expects no parameters and returns nothing.
    - ie: `function view(String name)` is the function signature, and it expects a `String` parameter and returns nothing.
    - ie: `method view(): String` is the method signature, and it expects no parameters and returns a `String`.
 
  - ## An `abstract class` is very similar concept as `interface`, additionally `abstract class`-es can have "default" implementations of their methods, as well as declare variables that are expected to be in the subclass.
  
  - ### Some Examples:
    - An `abstract class File` that has a single method defined named `view`, and does NOT implement how a 
      `view`, it only includes it's function signature, just like an interface.
      - Attempting to instantiate a `File` object will result in a compile-time error, as it does not make logical realistic sense to have a "general" concept of "file" as an _actual_ object. 
        - It's a concept and can't have an object. _I'm being pedantic because this is an important distinction, as this is not a technical limitation, this is a logical limitation._
          > - Programmer: CREATE A CONCEPTUAL `FILE`! 
          > - computer: What kind of file?
          > - Programmer: IDK, JUST MAKE ONE! ...and make sure it's only the idea of a `FILE`!
          > - computer: 🤔 Which one, though?
          > - Programmer: 🤬 THE CONCEPT OF "FILE!" — SIMPLY INSTANTIATE THE CONCEPT!
          > - computer: 🤔 🤷‍ 💣 💥 _...not logically possible._
    - The `File` class is an `abstract class` and the `class Photo`,`class ExcelDoc` and `class Memo` are the 
      _"concrete classes." 
    - You can't create a generic `File` object, BUT you can create a `Photo` or `ExcelDoc` or `Memo` object that is 
      is a subclass of the `abstract class File` class.
    - Any object that is a subtype of "Document" must have the `view` method implemented, as it is the 
      "expectation" (or "contract") of the `abstract class File`.
      - also called "implementing classes" or "implementations" of the `File` class.
    - An `abstract class` is a template for a _"concrete"_ `class`, and cannot to be instantiated,
      only `extend`-ed and be used as a "general" type to group together the implementing sub-classes into a common type.
    - ie: `File` is the general category of a "thing to structure and retain some kind of data."
    - The `abstract class` is `extend`—ed by the subclass and the subclass methods `override` the superclass methods by
      implementing the method in the subclass(es).
  
    - ### ONE MORE EXAMPLE OF A SIMPLE IDEA LEADING TO OVERCOMPLICATED CODE
    - Leading to unwieldy and hard to understand code, often used in places where it was not necessary.
        > - Object-Oriented Programming - Brian Will
        >   - https://www.youtube.com/watch?v=lbXsrHGhBAU 
        > - Abstraction Can Make Your Code Worse
        >   - https://www.youtube.com/watch?v=rQlMtztiAoA 

  - ### Example of `abstract class` diagram:
    ```mermaid
    ---
    title: Abstract Class Example Diagram
      
    ---
    classDiagram
    direction TB
    File <|-- ExcelDoc : extends
    File <|-- Memo : extends
    File <|-- Photo : extends
      
    class File["abstract class File"] {
       abstract open String fileName  // Abstract classes can have variables, and are "abstract" and "open" by default, meaning they must be defined and overridden in the subclass.
       
       constructor File(String fileName) this.fileName = fileName // Abstract classes can have "default" constructors.
        
       abstract method view() // default implementations of methods are optional.
       open method showName(): print("File Name: " + this.fileName) // A default implementation.
    }
    <<abstract>> File 
      
    class ExcelDoc["class ExcelDoc extends File"] {
       override String fileName // Subclasses must declare abstract variables.
    
       constructor ExcelDoc(String name) --> super(name)
    
       override method view(): print("View ExcelDoc: " + this.fileName) 
    }
    class Photo["class Photo extends File"] {
       override String fileName // Subclasses must declare abstract variables.
    
       constructor Photo(String name) -> super(name)
       
       override method view(): print("View Photo: " + this.fileName)
    }
    class Memo["class Memo extends File"] {
       override String fileName //  Subclasses must declare abstract variables.
       String to  // <- Subclasses can have additional variables.
       String from
       String subject
    
       constructor Memo(String to, String from, String subject) --> super("Memo-" + to +"|"+ from +"|"+ subject + ".memo")
       
       override method view(): print("View Memo: from= " + this.from + ", to= " + this.to + ", subject= " + this.subject) 
       override method showName(): print("Memo from: " + this.from + ", to: " + this.to)
    }
    ```
  - Example for `abstract` `class`-es in pseudo-code (similar to common COP languages):
    ```Text
     // COP pseudo-code
     
     abstract class File { 
        abstract String fileName // <-- Abstract classes can have variables.
        
        constructor File(String fileName) {  // <-- Abstract classes can have "default" constructors.
           this.fileName = fileName
        }
    
        abstract method view()  // Expects a method called "view" and has no default implementation.
        abstract method showName() {  // Expects a method called "showName" and has a default implementation.
           print "File Name: " + this.fileName // <-- The default implementation for any subclass that doesn't override the method.
        } 
     }  
     
     class ExcelDoc extends File {  // <-- ExcelDoc is a subclass of File.
        override String fileName // <-- Subclasses must declare the abstract variables from superclass.
    
        override method view() { // <-- the implementation of the abstract class "view".
           print "Viewing ExcelDoc: " + this.fileName  
        } 
     }
    
     class Photo extends File { // <-- Photo is a subclass of Document
         override String fileName // <-- Subclasses must declare the abstract variables from superclass.
         
         override method view() {  // <-- the implementation of the abstract class "view".
            print "Viewing Photo: " + this.fileName
         } 
     }
     
     class Memo extends File { // <-- Memo is a subclass of File.
        override String fileName // <-- Subclasses must declare the abstract variables from superclass.
        String to
        String from
        String subject
    
        constructor Memo(String to, String from, String subject) {  // <-- the custom constructor of this class, its called to 
                                                                    //     initialize the variables of the object.
           super("Memo-" + to +"|"+ from +"|"+ subject + ".memo")   // <-- calls the constructor of the superclass (File).
           
           this.to = to
           this.from = from
           this.subject = subject
        }
       
        override method view() {  // <-- The implementation of the abstract method "view".
           super.showName()       // <-- Calls the "default implementation" of the abstract superclass. (This is just to show how it's done.)
                                  //     Note: Calls to the `super` class are not required, but can be used to call any 
                                  //           methods of the superclass.
         
           print "Viewing Memo: from= " + this.from + ", to= " + this.to + ", subject= " + this.subject 
        }
        override method showName() { // <-- overrides the "default implementation" of the abstract superclass.
           print "Memo from: " + this.from + ", to: " + this.to  // <-- NOTE: Shows addressee names of the memo, 
                                                                 //     **NOT** the filename... 
                                                                 //     & design problems are already creeping in!
        } 
     }
     
     // Start of program
     function main() {
         // File file0 = new File("MyFile.txt")  // Since the `File` class is `abstract`, an object cannot be created from it, 
                                                // and attempting this will result in a compiler error.
         File file1 = new ExcelDoc("MyExcelDoc.xls")
         File file2 = new Photo("MyPhoto.jpg")
         Memo file3 = new Memo(to="Chris", from="Bob", subject="Meeting") // note: correct type is used so that the `showName` method can be called.
     
         function viewFile(File file)  // Note that the parameter `doc` is of type `File` and not `ExcelDoc` or `Photo` or `Memo`.
            file.view(name)
         }
     
         viewFile(file1)  // <-- will call the "view" method of the ExcelDoc class.
         viewFile(file2)  // <-- will call the "view" method of the Photo class .
         viewFile(file3)  // <-- will call the "view" method of the Memo class.
    
         println() // <-- just to add a blank line to the output.
         file1.showName()  // <-- will call the "showName" method of the ExcelDoc class. Note: outputs the file name.
         file3.showName()  // <-- will call the "showName" method of the Memo class. Note: outputs the addressee names.
     }

     // Output:
     // Viewing ExcelDoc: MyExcelDoc.xls
     // Viewing Photo: MyPhoto.jpg
     // File Name: Memo-Chris|Bob|Meeting.memo
     // Viewing Memo: from= Bob, to= Chris, subject= Meeting
     //
     // File Name: MyExcelDoc.xls
     // Memo from: Bob, to: Chris
    
     ```
     - Live Code Example: [How Abstract Classes Work in Kotlin](src/main/kotlin/abstractClassExample.kt)

## Full COP Diagram of `abstract` Classes, `extended` Classes and Objects, Stored in Memory
   ```mermaid
     flowchart TB
   
     ExcelDocObjectViewMethodFunctionPointer -- calls --> ExcelDocClassViewMethod
     ExcelDocClassAgeInt -- stores value of --> ExcelDocObjectAgeInt 
     
     ExcelDocObject:::Object
     subgraph ExcelDocObject["[object instance ExcelDoc @19CAFE42]"]
         ExcelDocObjectAgeInt["String name = 'MyExcelDoc.xls'"]
         ExcelDocObjectViewMethodFunctionPointer{{"
            method View(): 
            calls 
            function @4269BEEF
            in class ExcelDoc
            👈
            "}}
         ExcelDocObjectShowNameMethodFunctionPointer{{"
            method showName(): 
            calls 
            function @844221FF
            in abstract class File
            👈
            "}}   
     end
     ExcelDocObjectShowNameMethodFunctionPointer -- calls --> abstractShowNameMethod
     ExcelDocObjectViewMethodFunctionPointer:::Abstract
     ExcelDocObjectShowNameMethodFunctionPointer:::Abstract
     
     subgraph classExcelDoc["class ExcelDoc extends File"]
         ExcelDocClassViewMethod{{"
            function @4269BEEF:  
            method View() =
            { print ''Viewing ExcelDoc: '' + this.fileName  }
            🖨️
            "}}
         ExcelDocClassAgeInt["String fileName"]
     end
     abstractAgeInt -.- expects -.-> ExcelDocClassAgeInt
     abstractViewMethod -.- expects2{{"expects"}} -.-> ExcelDocClassViewMethod:::Object
     ExcelDocClassAgeInt -- implements ---> abstractAgeInt:::Abstract
   
     note["
        EXPLANATION: 
        The ExcelDoc Object @19CAFE42 
        is an instance of the ExcelDoc class.
        ExcelDoc class is a subclass of the 
        abstract class File.
        📁 ➤➤ 🗄️"]
     
     classExcelDoc --- instantiates ---> ExcelDocObject
     classExcelDoc --- extends --> abstractFile:::Abstract
     ExcelDocClassViewMethod -- implements --> abstractViewMethod:::Abstract
     
     subgraph abstractFile["abstract class File"]
       abstractAgeInt["abstract String fileName"]
       abstractShowNameMethod{{"function @844221FF
                                method showName() =
                               { print ''File: ''  + this.fileName }
                               🖨️
                             "}}:::Object

       abstractViewMethod{{"
          abstract method 
          View()
          ⎙
          "}}
          
     end
   
     classDef Abstract fill:#222, stroke:#0F0, stroke-width:1px, color:#fff, stroke-dasharray: 5 5
     
     classDef Class fill:#444, stroke:#00F, stroke-width:1px, color:#000, stroke-dasharray: 5 5
     %% For nodes that are the source of a link, the style must be defined in the link, not the classDef. 
     style classExcelDoc fill:#444, stroke:#DDD, stroke-width:1px, color:#000, stroke-dasharray: 5 5
     style ExcelDocClassAgeInt fill:#444, stroke:#DDD, stroke-width:1px, color:#FFF, stroke-dasharray: 5 5
     
     classDef Object fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
     style ExcelDocObjectAgeInt fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff
     style ExcelDocObjectViewMethodFunctionPointer fill:#222, stroke:#DDD, stroke-width:1px, color:#000, stroke-dasharray: 5 5
   ```

## Polymorphism <a name="polymorphism"></a>
###### polymorphism
  - ### BIG IDEA — A method can be called on an object and the method will behave differently based on the `class` of the object.
  - In COP, the `interface`-s and `abstract class`-s are implementations of the idea of polymorphism.

  - ### ⚠️ ANOTHER EXAMPLE OF A SIMPLE IDEA WITH A RIDICULOUSLY OVERCOMPLICATED NAME!
    - Yet _another_ overcomplicated name for a very basic, exceedingly simple idea.
    - Polymorphism is the idea that a method can be called on an object and the method will behave differently
      based on the "type" of the "object" that the "method" is called on
        - This is the basis for `override`-ing methods in subclasses and `interfaces` and `abstract class`-es
        - In the example above, the `view()` method can be called with any `Document` object and the `view` method
          will behave differently based on the type of the `Document` object that is passed in.
  - ### Associated with Liskov Principle
    - The "Liskov Substitution Principle" comes from "Set theory" and is the idea that "objects of a superclass shall be
      replaceable with objects of its subclasses without affecting the functionality of the program."
    - That's it. That's the whole idea. 
    - It's just a fancy way of saying that "subclasses should work the same as their superclass."
    - Live Code Example: [Liskov Substitution Principle in Kotlin](src/main/kotlin/liskovSubstitutionPrincipleExample.kt)
    - #### 🛑 "POLYMORPHISM" IS A GREAT EXAMPLE OF USING FANCY SOUNDING TERMS FOR VERY BASIC CONCEPTS THAT BARELY NEED EXPLAINING, I'VE SAID ENOUGH ALREADY.
      - ### 🫤 A lot of dick-swinging contests around words among the aspy-addled crowd. Please someone tell them they are being assholes when they suggest a fancy new word for something super basic!

## Controlled Scope of Visibility of Variables and Methods <a name="controlled-visibility"></a>
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
  - COP encouraged to use getters and setters to control the access to the variables of the class (which has since
    been shown to be a bad idea due to misuse and overuse of the pattern.) It was again using procedural ideas in a
    class oriented paradigm.
  - Live Code Example: [Controlled Visibility in Kotlin](src/main/kotlin/controlledVisibilityExample.kt)

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
       Cog cog;  // <-- Create a new Cog object.
       
       cog.makeSound(); // <-- What will this print? "Meow" or "Bark"??? (Will result in a compile error!)
                                         
    
       // Solution - you have to pick:
       // cog.Dog::makeSound(); // <-- You have to tell the compiler which one, which adds confusion.
       // cog.Cat::makeSound(); // <-- Requires intimate knowledge of internal details everytime you use diamond inheritance.
    }
    
    // THIS IS *NOT* THE OUTPUT:
    // Does the Cog "Meow" or "Bark"???
    
     ```
  - In C++, calling `Cog`'s `makeSound()` method give a compiler error, _BUT_ in Python, calling
    `Cog`'s `makeSound()` will print `Bark`!
    > Copy and paste the code into a C++ compiler and see for yourself: https://www.onlinegdb.com/online_c++_compiler
  
  - This behavior is _completely arbitrary_ and up to the designers of the language to decide which
    method will be called, and it's _not_ consistent across different languages.
  - It's also up to you to remember these kinds of details, as you are likely to be working in multiple
    languages in the same day. Furthermore, it's quite easy to forget which language you are working in which lead to weird bugs.
  - UGH!
  
    > Java's language Designers Rejected Multiple Inheritance - Here's Why
    >   - https://www.youtube.com/watch?v=1-JBFJ8Xar0
    
    > NOTE: If you _really_ want to achieve multiple inheritance... (_you should never need it, but here's how:_)
    >   - https://www.youtube.com/watch?v=3X9Eo2vzY1I
    >   - Live Code Example: [How to Achieve Multiple Inheritance in Kotlin](src/main/kotlin/multipleInheritanceExample.kt)

## Some thoughts on Software Complexity <a name="some-thoughts-on-software-complexity"></a>
###### some-thoughts-on-software-complexity
- ### BIG IDEA — There are 2 kinds of complexity: "essential" and "accidental" complexity.
- "Essential" complexity is the complexity that is inherent in the problem that the software is trying to solve.
- "Accidental" complexity is the complexity that is added to the software by the programmers and the tools that
  they use to solve the problem.

  > Th.e cmplxty (The Complexity) - Jonathan Crossland
  > - https://www.youtube.com/watch?v=SVyaKFOxZlU

## More Thoughts on Class Oriented Programming & Design <a name="some-thoughts-on-object-oriented-programming"></a>
  > - Kevlin Henney - Object? You Keep Using that Word - Trójmiasto JUG [30.05.2016]
  >   - https://www.youtube.com/watch?v=IA-RyzKE7oc
  > - What the BDUF (Big-Design Up-Front) - Jonathan Crossland
  >   - https://www.youtube.com/watch?v=Z-9wXpfVjac
  > - Naming things in Code - CodeAesthetic
  >   - https://www.youtube.com/watch?v=-J3wNP6u5YU

## Design Patterns <a name="design-patterns"></a>
###### design-patterns
  - ### BIG IDEA — There are common problems and ways of solving them that humans have already figured out and named them.
 
  - "Design Patterns" became popular around the time of C++ due to the new complexity of the language and the
    need to solve the problems of the "procedural approach" to COP.
  - These "patterns" were discovered by programmers dealing with C++ language design limitations, and these common solutions were
    shared on public forums and then copied into many books from different authors. The solutions were given in talks 
    at software development conferences, emphasizing different ideas and approaches to particular problems that arose 
    from C++ programming, not necessarily the OOP paradigm.
  - Most of these so-called "patterns" were just _common hacks_ to fit the procedural approach into the COP paradigm.
  - Many programmers accepted these patterns as some kind of gospel, and they were often used to justify the
    use of inheritance (and other language features) in places where it was not appropriate.
  - For example, **"The "Gang of Four"** book is the most famous book on the subject, and it is often touted to as the "Bible" for OOP programming, especially in C++.
    - Upon closer inspection and research, it turns out to simply be a collection of ideas and implementations that 
      worked in a _particular situation_ and was not meant to be a "one-size-fits-all" solution to the myriad of problems
      attempting to apply the "procedural approach" to the "COP" paradigm.
    - The promoters (shills?) of these books and resources rarely talk about the limits of their ideas, and programmers often
      misunderstood and misapplied the ideas and used them in places where they are not appropriate, and counterproductive. 
  - Although some ideas in the book are useful, many of the ideas are just "generally-accepted" hacks to fit the "procedural
    approach" into the "COP" paradigm. And due to the lack of programmers needing to adapt to a different paradigm, they
    saw these "design patterns" as the "one-size-fits-all" solution to their complex problems.
  
    > - Design Patterns and Anti-Patterns, Love and Hate - Yegor Bugayenko
    >   - https://www.yegor256.com/2016/02/03/design-patterns-and-anti-patterns.html
    > - Patterns, Anti-Patterns, and Refactoring - Yegor Bugayenko
    >   - https://www.youtube.com/watch?v=LrTBIcFhawI
    

  - ### Many of the problems in COP could have been avoided by exploring what the originator of the term "Object Oriented", Alan Kay, originally meant by the term "Object Oriented."
 
- [Continue Reading - Functional Programming](10-FunctionalProgramming.md)
- [Back to Index](README.md)