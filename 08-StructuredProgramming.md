## Structured Programming 1960s-Present <a name="structured-programming"></a>

- ### BIG IDEA - Put different parts of a program into distinct sections, or "code blocks" or "scopes" to limit the visibility of variables and functions from other parts of the program. This is done to reduce the cognitive load for understanding code, make modifying code easier and enabling portable re-use of code via libraries.

### Scopes <a name="scopes"></a>
###### scopes
- No more `GOTO` statements, ONLY subroutines and conditional branching (`if-then-gosub`'s) are allowed.
- "Scopes" define the visibility of variables and functions to other parts of the program.
  - Scopes are also called:
    - "code blocks"
    - "blocks" 
    - "local"
    - "inner"
    - "nested"
    - "enclosed inside"
    - "contained within"
    - "limited in"
    - "restricted to"
    - "encapsulated"
    - "private"
    - "protected"
    - "hidden"
    - "isolated" 
    
    > JEEPERS CREEPERS! That's a lot of names for the same thing, people!
    >> ### Humans like to give many names to things that are important and/or common problems to manage.  

- The concept of scopes was introduced to limit the use of "globally mutable" variables and visibility of functions.
  - This is the origin of "encapsulation" and first introduced to limit the visibility of the "local" variables
    and functions to only the "scope" or "block" that they were defined in, and to limit the "side effects" of the program.
  - Scopes have names and can be nested inside other scopes, and the local variables and functions are only visible
    to the scope that they are defined in. The inner scope has access to it's outer scope as well. 
    _But_ the outer scope does not have access to the inner scope.
  - By reducing the "cognitive area" that needs to be understood. it makes the program easier to understand and maintain and
    allows for larger teams to work on the same program without stepping on each other's toes.
  - This is the main reason for the "Structured Programming" approach, as it was the first time that the "state"
    of the program was structured and encapsulated into localized scopes or "code blocks"
    
    > Names of the scope symbols:
    > - `{` and `}` are called "curly brackets" or "curly braces."
    > - `(` and `)` are called "parentheses", "parens" and sometimes "round brackets."
    > - `[` and `]` are called "square brackets" or just "brackets." (not confusing at all... 😬)
    > - `<` and `>` are called "angle brackets" or "chevrons."
    > - `/*` and `*/` are called "comment delimiters."
    > - `//` is called the "comment symbol."

  - Example of structured language (C):
      - Note: The `//` symbols means the rest of the line is comment, it is not part of the program,
        it's just for explanation and is ignored by the compiler.
    ```C
    // C program to demonstrate the use of scope in structured programming.
    #include <stdio.h>  // <-- Include the standard input/output library.
    
    int main() {  // <-- start of the program & "opens" the scope, `int` means the function returns an integer, `main` is the name of the function.
       int x = 10; // Assigns the value of 10 to the variable `x` of type `int` (integer)
       int y = 100;
       
       { // <-- The "open curly bracket" denotes the start of a scope. This is an "inner" or "nested"  scope.
          int y = 32; // Inside the brackets is "Inner" or "Local" to the scope.
          int z = 55; // <-- Only visible to the scope it's defined in, ie: this one.
          
          x = x + y;  // <-- Uses the local variable `y` and variable `x` from the Outer `main` function scope. 
          
          { // <-- another "nested" scope, or "inner" scope, or "local" scope.
             int y = 72; // <-- This is a different `y` than the one in the `main` scope.
             printf("%d %d\n", x, y); // <-- Print the value of y as a decimal number, ("\n" means "go to next line")
                                      //     (%d means use decimal value of x and y, 42 and 72.)
          } // <-- The "close curly bracket" denotes the end of the scope.
          
          printf("%d %d %d\n", x, y, z); // <-- Print the value of x, y, and z as a decimal number 
                                         //     (%d means use decimal value of x, y, and z, 42, 32, and 55.) 
       } // <-- The "close bracket" denotes the end of the scope.
       
       printf("%d %d\n", x, y); // <-- Print the value of x and y as a decimal number
                                //     (%d means use decimal value of x and y, 42 and 100.)
       // printf("%d", z); // <-- This line would cause a "compile error" because the variable "z" is not visible in this scope.
    
    } // <-- The "close curly bracket" denotes the end of the `main` scope.
    
    
    // Output:
    // 42 72
    // 42 32 55
    // 42 100
    ```
  - Copy and Paste the above code into an online C compiler to see the output: https://www.onlinegdb.com/online_c_compiler
  - Live Code Example in Kotlin: [Structured Programming Example with Scopes: `structuredExample.kt`](src/main/kotlin/structuredExample.kt)

  ```mermaid
     flowchart RL
  
     subgraph main_scope["main() scope"]
       y01["y=100"]
       x1["x=10"]
       x3 ---> x1
       x2 --> x1
       subgraph innerScope["an inner scope"]
         x2["x"]
         y2["y=32"]
         z1["z=55"]
         z2 --> z1
         subgraph nestedScope["a nested scope"]
           y3["y=72"]
           x3["x"]
           z2["z"]
         end
       end
       
       printf2
     end
  
     subgraph stdio["stdio.h"]
       printf{{"function printf(…) { … }"}}
     end
  
     printf2{{"printf(…)"}} ----> printf:::Object
     
     classDef Object fill:#55F, stroke:#FFF, stroke-width:3px, color:#fff   
  ```

### Types <a name="types"></a>
##### types
- The concept of custom types (or "kinds") was introduced to define more complex groupings of primitives to be seen as a single type.
  - Procedural languages only had a few primitive types: "integer," "character," "string of characters" or "array"
  - Having "structured" types allowed for more complex data to be defined and used in the program, instead of only using the primitive types.
  - Primitive types are: `int`, `long`, `float`, `char`, and `bool` (note the `bool` type was not introduced until later in C++ and C99.)
  - Primitive types are the "building blocks" of all other types defined in `struct`-s
  - Example of Types (C):
    ```C
    // C program to demonstrate the use of "primitive types" and "structs" in structured programming.
    #include <stdio.h>  // <-- Include the standard input/output library.
    
    struct Point {  // <-- `Point` is a programmer-defined type that is made up of other types (Structure or "struct".)
       int x;
       int y;
       char colorIdChar;  // <-- `char` is a type that represents a single ASCII character (1 byte.)
    };
    
    int main() { 
       int x = 5; 
       float y = 6.128; 
       char z = 'A'; 
       struct Point p = { 10, 42, 'G' };  // <-- `p` is a variable of type `Point` that is `assigned` values of 10, 42, and 'G'.
       
       printf("Output: %d %f %c   %d   %d   %c", 
                        x, y, z, p.x, p.y, p.colorIdChar);
    }
    
    // Output: 5 6.128000 A   10   42   G
     
    ```  
    - Copy and Paste the above code into an online C compiler to see the output: https://www.onlinegdb.com/online_c_compiler
    - Live Code Example in Kotlin: [Types Example: `typesExample.kt`](src/main/kotlin/typesExample.kt)

- This allowed easier code reuse and easier to understand state of the program than procedural languages.
- Structured programming allowed the creation of "libraries" and "modules" to be easily produced to create standard subroutines and
  data structures into complete software packages and system utilities and frameworks to be used by other programmers.
- This allowed for more complex programs to be created and maintained by smaller teams of programmers.
    - C started the concept of "published interfaces" that could be imported into another program and used to
      provide the functionality of libraries.
    - These libraries were just collections of functions and data structures that were related to each other for a specific task.
- Structured languages allowed for much more portable and reusable code than procedural languages as they were not
  tied to any specific computer hardware or operating system. The computer manufacturer only had to create the
  compiler for their particular machine, and then the same code could be run on any machine that had a compiler
  for the language.
 
### Comparing C to Assembly Language <a name="c-to-assembly-language"></a>
##### c-to-assembly-language
- C was meant to be a "high-level portable shorthand" for Assembly Language, which was a high-level shorthand for Machine Language.
- All of high-level languages are eventually compiled into machine language by a compiler program.
  > - Comparing C to machine language - Ben Eater
  >   - https://www.youtube.com/watch?v=yOyaJXpAYZQ
  > - How computer processors run conditions and loops
  >   - https://www.youtube.com/watch?v=Ui6QyzcD3_E
  

### Bonus: History of Procedural to Structured Programming <a name="procedural-to-structured"></a>
  > - Procedural Programming: It’s Back? It Never Went Away - Kevlin Henney [ACCU 2018]
  >   - https://www.youtube.com/watch?v=mrY6xrWp3Gs
  > - History and Spirit of C - Olve Maudal
  >   - https://www.youtube.com/watch?v=xGVRF-Y--hI 

- [Continue Reading - Class Oriented Programming](./09-ClassOrientedProgramming.md)
- [Back to Index](README.md)
