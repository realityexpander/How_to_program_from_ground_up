## Functional Programming 1950s-Present
  - ### BIG IDEA - Shared mutable state is a big problem, especially for parallel processing task. 

  - ### The Functional style requires:
    1) Calling functions will NEVER change anything outside the function being called.
    2) Functions passed in with certain arguments will ALWAYS return the same result.
    2) Functions can be passed as arguments to other functions.

- ### Immutability & No Side Effects
  - Mutability means something can be changed, and immutability means it cannot be changed once it's created.
    - Functional Programming's main idea is to avoid "side effects" and "shared mutable state" of the program.
    - One way is to is to make the state of the program unchangeable. Changes can only be made by creating a new state
      based on the a copy of the old state, and then returning the new state as the result of a function.
    - BOOP style is a form of "Functional Programming" as the state of the program is immutable and passed as arguments
      to the functions, and a new state is returned as the result of the calls to the functions.
- All functions in the core of the application return a value and have no "side effects" on any other "state" of
  the program.
- It's more of a style of programming than a "paradigm" as it can be used in any language, but it's most effective
  in languages that are designed to be "functional" from the ground up.
- The reason for this is that the "state" of the program is "immutable" and passed as arguments to the functions,
  and a new state is returned as the result of the calls to the functions.
- This makes the program easier to understand and maintain, and allows for "parallel" and "concurrent" programming
  to be done more easily.
- It also eliminates whole classes of bugs that are caused by "side effects" and "shared mutable state" of the program.
- The state of the program is immutable and passed as arguments to the functions
- A new state is returned as the result of the calls to the functions
- Functions are "first-class citizens" and can be passed as arguments to other functions, just like normal variables and objects
    - This allows customization of the functions by passing in any function as an argument to another function
    - This allows the functions to be "composed" together to create new functions from existing functions
    - These functions are called "lambdas," "closures," "anonymous functions" or "function literals,"
      and "higher-order functions" all interchangeably. It's all just functions!
- Examples of functional languages are "Lisp", "Clojure" and "Javascript" and "Kotlin"

- Example of Functional style (Kotlin):
  ```Kotlin
  fun main() {
     val add = { a: Int, b: Int -> a + b }  // <-- a lambda that takes 2 integers and returns the sum of the integers.
     val multiply = { a: Int, b: Int -> a * b }  // <-- a lambda that takes 2 integers and returns the product of the integers.
     val firstThenSecond = {  // <-- a lambda that takes 4 arguments, 2 functions and 2 integers, and returns the result of the 2 functions. 
         first: (Int, Int) -> Int, // <-- a lambda that takes 2 integers and returns an integer, it's executed first.
         second: (Int, Int) -> Int,  // <-- a lambda that takes 2 integers and returns an integer, it's executed second.
         a: Int, 
         b: Int -> 
            second(first(a, b), b)  // <-- calls the `first` lambda with the 2 integers (a & b), 
                                    //     then calls the `second` lambda with the result of `first()` and the 2nd integer (b)
     }              
     
     val result = firstThenSecond(add, multiply, 10, 2) // <-- calls the lambda with the 2 functions and 2 integers 
     println(result) // result will be 24
  }
  
  main()
    
  // Output:Add 
  // 24
  ```
  > Live Code Example: [Functional Example](src/main/kotlin/functionalExample.kt)

- [Continue Reading - Parallel Processing](./12-ParallelProcessing.md)  
- [Back to Index](README.md)