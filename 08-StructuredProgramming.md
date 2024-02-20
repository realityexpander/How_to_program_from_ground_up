## Structured Programming 1960s-Present <a name="structured-programming"></a>

### BIG IDEA - Put different parts of a program into distinct sections, or "code blocks" or "scopes" to limit the visibility of variables and functions to other parts of the program in order to reduce cognitive load to understanding code, make modifying code easier and enabling re-use of code via libraries.

### Scopes <a name="scopes"></a>
###### scopes
- No more "goto" statements, only subroutines and conditional branching were allowed.
- The concept of "scopes" (or "code blocks") to limit the use of "globally mutable" variables and visibility of functions.
  - This is the origin of "encapsulation" and first introduced to limit the visibility of the "local" variables
    and functions to only the "scope" or "block" that they were defined in, and to limit the "side effects" of the program.
  - Scopes have names and can be nested inside other scopes, and the "local" variables and functions are only visible
    to the "scope" that they are defined in. The inner scope has access to it's outer scope as well. But the outer scope
    does not have access to the inner scope.
  - By reducing the area that needs to be understood. it makes the program easier to understand and maintain and
    allowed for larger teams to work on the same program without stepping on each other's toes.
  - This is also the reason for the "Structured Programming" paradigm, as it was the first time that the "state"
    of the program was "structured" and "encapsulated" into "scopes" or "code blocks"
  - Example of structured language (C):
      - Note: The `//` symbols means the rest of the line is comment, it is not part of the program,
        it's just for explanation and is ignored by the compiler.
    ```C
    int main() {  // <-- start of the program & opens scope, `int` means the function returns an integer, `main` is the name of the function
      int y = 100;
      int x = 10; 
      
      { // <-- The "open curly bracket" denotes the start of a scope or "code block" or just "block."
        int y = 32; // Inside the brackets is "Inner" or "Local" to the scope.
        int z = 55; // <-- Only visible to the scope it's defined in, ie: this one.
        
        x = x + y;  // <-- Uses the local variable `y` and variable `x` from the Outer `main` function scope. 
      } // <-- The "close curly braket" denotes the end of the scope.
      
      printf("%d", x); // <-- Print the value of x as a decimal number 
                       //     (%d means use decimal value of x, 42.)
      printf("%c", x); // <-- Print the value of x as a character 
                       //     ("%c means use the ASCII value of x, 42 is character '*')
    
      // printf("%d", z); // <-- This line would cause a "compile error" because the variable "z" is not visible in this scope.
    } // <-- The "close curly braket" denotes the end of the `main` scope.
    
    main();  // <-- Call the "main" function, runs the program
    
    // Output: 
    // 42
    // *
    ```
  - Live Code Example in Kotlin: [Structured Programming Example with Scopes: `structuredExample.kt`](src/main/kotlin/structuredExample.kt)

### Types <a name="types"></a>
##### types
- The concept of "types" (or "kinds") was introduced to define the size & intended purpose of "primitive"
  data types
  - Procedural langauges only had a few simple types: "number" or "character" or "string of characters" or "array"
  - Primitive types are: `int`, `long`, `float`, `char`, and `bool`
  - Primitive types are the "building blocks" of all other types defined in `struct`s
  - Example of Types (C):
    ```C
    struct Point {  // <-- `Point` is a programmer-defined type that is made up of other types (Structure or "struct")
       int x;
       int y;
       char colorIdChar;  // <-- `char` is a type that represents a single ASCII character (1 byte.)
    };
    
    int main() { 
       int x = 5; 
       float y = 6.128; 
       char z = 'A'; 
       struct Point p = { 10, 42, 'G' };
       
       printf("Output: %d %f %c   %d   %d   %c", 
                        x, y, z, p.x, p.y, p.colorIdChar);
    }
    
    main();
    
    // Output: 5 6.128000 A 10   42   G
     
    ```
    - Live Code Example in Kotlin: [Types Example: `typesExample.kt`](src/main/kotlin/typesExample.kt)

- This allowed easier code reuse and easier to understand "state" of the program than procedural languages
- This allowed libraries and "modules" to be easily produced to create standard "subroutines" and
  "data structures" into "packages" and "system utilities" and "frameworks" to be used by other programmers
    - Started the concept of "published interfaces" that could be imported into another program and used to
      provide the functionality of the "library."
    - These libraries were collections of functions and data structures that were related to each other for a specific task.
- Structure languages were also much more portable and reusable than procedural languages as they were not
  tied to any specific computer hardware or operating system. The computer manufacturer only had to create the
  compiler for their particular machine, and then the same code could be run on any machine that had a compiler
  for the language.
  
  > Procedural Programming: It’s Back? It Never Went Away - Kevlin Henney [ACCU 2018]
  > - https://www.youtube.com/watch?v=mrY6xrWp3Gs
 
  > Comparing C to machine language - Ben Eater
  > - https://www.youtube.com/watch?v=yOyaJXpAYZQ

- [Continue Reading - Class Oriented Programming](./09-ClassOrientedProgramming.md)
- [Back to Index](README.md)