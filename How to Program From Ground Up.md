# How to Program From Ground Up

## Introduction
  - Discussion from the fundamentals of physical logic representation to the high level programming languages.
  - Everything in computing is REPRESENTING something "as" something else.
  - Types of representations
    - Knots on a string
    - Physical indentations in clay
    - Beads on an abacus
    - Ink Marks on paper
    - Punched Holes in a card
    - Remnants of a photon strike on a piece of glass coated with a thin layer of phosphor
    - Detectable polarization of spots on a sheet of metal via electronic means
    - Detectable electrical capacitance in a tiny area of silicon
## Low Level
  - ### The Wire & the Light Bulb & the Battery
    - Can Represents Logic "state"
    - Connected or not connected
    - Light on or off (1 or 0)
    - Even though the light has in reality many, many different states constantly 
      changing over time, we can still use it to represent a single state at time: Either on or off.
  - ### The Simple switch
    - Easier to manipulate for humans than a bare wire
    - Can be manipulated using electricity to change state with a magnet
    - Logic States & Boolean Arithmetic
      - switch in series represents logical AND operations
        - AND (&&)
          - 0 && 0 = 0
          - 0 && 1 = 0
          - 1 && 0 = 0
          - 1 && 1 = 1
      - switch in parallel represents logical OR operations
        - OR (||) 
          - 0 || 0 = 0
          - 0 || 1 = 1
          - 1 || 0 = 1
          - 1 || 1 = 1
      - Boolean logic requires one more operation to be complete: The logical NOT operation
  - ### The Magnificent magnet
    - Magnets can be electrically controlled to cause mechanical actions on certain metallic materials
    - Certain Metallic Materials can be "magnetized" and "polarized" using electricity to represent a "state"
      - Magnetized or not (1 or 0) 
      - North or South (1 or 0)
      - It's magnificent bc its so useful and versatile
  - ### The Raucous Relay
    - uses electromagnet to control a switch (or multiple switches)
    - the first electrical computer were made of relays (extremely slow but faster than writing by hand)
    - If relay is setup to turn OFF a switch, this creates a logical NOT gate, 
      so using the relay allows us to represent any other logic gate.
    - NOT (!)
        - !0 = 1
        - !1 = 0
    - The relay can be used to represent any other logic gate
    - It's raucous because it makes a lot of noise
  - ### the Voracious Vacuum Tube
    - How Vacuum Tubes Work: https://www.youtube.com/watch?v=nA_tgIygvNo  
    - Uses the unique behavior of electricity in a vacuum to represent a state, just like a mechanical switch
    - Tube made for use in logic (Triode) consists of 3 parts:
      - Cathode 
        - Essentially a light bulb filament tied to the common "ground/negative" terminal of the power supply
        - Used to "emit" electrons
      - Anode (positive part of the tube hooked to the "load" and the positive terminal of the power supply)
        - Used to "collect" electrons and powers the load to complete the circuit
      - A "Grid" - this acts as a switch also called a "valve" when referring to tubes
    - The Grid can be used to control the flow of electricity between the cathode and anode
      - ie: when the grid is positively charged, the flow of electricity from cathode to the anode is allowed
      - ie: when the grid is negatively charged, the flow of electricity from cathode to the anode is deterred
      - This acts by default like a "NOT" gate
    - The tube can be used to represent any other logic gate
    - The vacuum tube is voracious because it consumes a lot of power and generates a lot of heat
  - ### The Tiny Transistor
    - Very similar behavior to the vacuum tube, but much smaller and faster
    - No vacuum required, just a the semiconductor materia
      - Uses photographic techniques to create the object, not regular metallic parts
    - The transistor consists of 3 parts:
      - drain 
        - ("anode" in the vacuum tube) 
        - also known as "collector" or "sink" often connected to "load" 
        - (not always "positive" in modern transistors, but usually is)
      - source 
        - ("cathode" in the vacuum tube) 
        - also known as "emitter" often connected to "ground" 
        - (not always "negative" in modern transistors, but usually is) 
      - gate ("grid" in the vacuum tube) 
        - also known as "base" often connected to the "control" 
        - (not always "positive" in modern transistors, but usually is)  
    - The transistor can be used to represent any other logic gate and is the current basis for all modern computing
    - The transistor is tiny because it is very small and fast, bumping up against the limits of physics on how small it can be made
  - ### The Interchangeable integrated Chip (groups of logic gates)
    - the logic gate "package" (groups of transistors for a specific logic operation)
      - OR, AND, NOT, NAND package (usually 2 in the same package)
      - Why is NAND gates so special?
        - most flexible, can be combined to create any other logic gates and more complex operations
        - like tie inputs A & B together to create a NOT gate
        - like tie inputs A & B together to create with a NOT gate to create an OR gate
        - like normally and invert (NOT) the output to create an AND gate
      - Flip-Flop (memory)
      - Much can be done with just these 4 types of gates, many early digital electronic computers were made with just these
    
  - ### The Microprocessor (groups of integrated chips -> all put on one chip)
    - Usually contains a CPU (Central Processing Unit) and a small amount of very fast memory (called "Registers") 
  - ### The Computer
    - RAM (Random Access Memory)
    - ROM
    - IO & Peripherals & Storage
    - All just more variations of the same thing, using the same principles to represent logic states

## Machine Code
  - Machine Code is the "language" of logical operations that the computer can perform
    - It's really just human cleverness setting up problems in a way 
        that the machine can perform simple logical operations to give 
        us a representation of the result of the problem
    - Anything the computer can do is just a combination of these simple logical operations, designed by people
      to represent the problem space that can be solved by the computer using a series of logical operations.
    - The specific instructions for the CPU are called "opcodes", and are just strings of binary numbers like 1010101011010101
    - These numbers are usually represented in hexadecimal (base 16) to make them easier to read and write (as opposed to binary, base 2)
    - The opcodes are the most primitive logical operations that the CPU can perform
    - The opcodes are usually followed by "operands" which are the "arguments" to the operation
  - The Machine opcodes are unwieldy for humans to remember, so we use "mnemonics" to represent them
    - Mnemonics are just human-readable names for the opcodes, like "LOAD" or "STORE" or "ADD" or "SUBTRACT"
    - The mnemonics are then translated into the binary opcodes by a "compiler" or "assembler"
  - The machine opcode instructions are basic operations like:
    - LOAD (load a value from main memory into a register)
    - MOV (move a value from one register to another)
    - STO (store a value from a register into main memory)
    - JMP (jump to a different location in main memory by updating the Program Counter)
    - ADD (add the values in two registers and store the result in a third register)
    - CMP (compare the values in two registers and update the "flags" register)
    - JNZ (jump to a different location in main memory if the "flags" register is not zero)
  - Clock
    - Everything in the computer happens one step at a time, and the "clock" is the thing that makes the "ticks"
    - Each "tick" of the clock is called a "cycle"
  - Program Counter
    - The "program counter" (PC) is a special register that keeps track of the current memory location of the
      current instruction that the CPU will execute/is executing
  - Fetch-Decode-Execute Cycle
    - Fetch means to get the next instruction from main memory and put it into the "instruction register"
    - Decode means to figure out what the instruction is and what it means
      - The instruction may require more than one cycle to complete
      - The instruction may need to fetch more data from main memory
    - Execute means to actually perform the operation
      - The operation may require more than one cycle to complete
      - The operation may need to store the result back into main memory or into one or more registers
  - Registers
    - Registers are a small amount of very fast memory that is part of the CPU
    - The registers are used to store the results of the instructions, and current operands being executed
    - The registers are used to store the "state" of the CPU

## Assembly Language Basics
  - Jump - Usually mnemonic JMP
    - The "goto" statement of machine code
    - Changes the program counter (PC) to point to a different location in memory
    - Also known a "branch" or "loop"
    - No limits to where the jump can go, it be anywhere in memory. If it's wrong, the machine will likely halt
      or do something unexpected, also called a "crash"
  - Conditional Jump - Usually mnemonic JNZ (Jump if Not Zero)
    - The "if" statement of machine code
    - Changes the program counter (PC) to point to a different location in memory based on the result of a previous operation
    - The results of the previous operation is kept in a "register" (a tiny bit of memory that is part of the CPU)
    - Also known as "branch if" or "branch if not"
    - The "if" statement is the most important part of programming, it's the basis for all decision making
  - Variables
    - Just Memory locations that are used to store data
    - The data is a representation of something else, like a number or a letter, or a color, or a sound, or computer code
    - Variables are a convenient way to give a name to a location in memory
  - Subroutines
    - A way to "call" a "function" or "procedure" or "method" in machine code
    - The "call" statement of machine code
    - The "return" statement of machine code
    - The "call" statement changes the program counter (PC) to point to a different location in memory
    - The "return" statement changes the program counter (PC) back to where it was before the "call" statement
    - Subroutines are the basis for all "structured" programming

## Data Structures
  - Data structures are just common ways humans have come up with to represent data in memory
  - Numbers and Individual Characters
    - Numbers are usually represented in binary (base 2)
      - Positive integers are usually represented in "unsigned" binary
        - 1 byte (8 bits) can represent unsigned 0 to 255 (known as a "byte" or "octet" or "char")
        - 2 bytes (16 bits) can represent unsigned 0 to 65535 (known as a "short", sometimes "word")
        - 4 bytes (32 bits) can represent unsigned 0 to 4294967295 (known as an "int", sometimes "long")
      - Negative integers are usually represented in "signed" binary
        - 1 byte (8 bits) can represent signed -128 to 127 
      - Floating point numbers are usually represented in "IEEE 754" format
        - 4 bytes (32 bits) can represent a floating point number
        - 8 bytes (64 bits) can represent a double precision floating point number
        - Floating point numbers will use a "mantissa" and an "exponent" to represent the number in scientific notation
        - Due to the way floating point numbers are represented, they are not exact, and can have rounding errors!
        - Why Is This Happening?! Floating Point Approximation https://www.youtube.com/watch?v=2gIxbTn7GSc
    - Individual characters are usually represented in Ascii (1 byte) or Unicode(1 or more bytes)
      - Ascii is a 1 byte (8 bit) representation of the most common letters and symbols
      - Unicode is a 1 or more byte representation of all the letters and symbols in all the world's languages
  - Arrays
    - A way to represent a "list" of things in memory
    - The "things" can be anything, like numbers, letters, strings or even other arrays (multi-dimensional arrays)
    - The "things" are usually all the same size & type
    - The "things" are usually all stored in a contiguous block of memory
    - The "things" are usually accessed by an "index" which is a number that represents the position of the "thing" in the array
  - Strings
    - A way to represent a list of letters in memory, to represent words and sentences and paragraphs and documents
    - The "characters" are usually stored in a contiguous block of memory
    - The "characters" are sometimes terminated by a special "end of string" character, or have a length stored somewhere
    - The "characters" are usually accessed by an "index" which is a number that represents the position of the "characters" in the string
  - Pointer
    - A number that represents the "address" of another location in memory
    - Diagram:
      - Address: Value 
      - 0x00000001: 0x00000003  `// 0x00000000 is the address, 0x00000003 is the value of the pointer, pointing to address 0x00000003`
      - 0x00000001: 0x00000000  
      - 0x00000002: 0x00000000
      - 0x00000003: 0x00000041  `// 0x00000003 is the address, 0x00000041 is character 'A'`
    - The pointer at 0x00000001 is pointing to the address 0x00000003, which contains the character 'A'
  - Structures 
    - Known as "Records" or "Data Classes" 
      - also called as "structs", sometimes referred to as "classes" and "objects"
    - A way to represent a "structured data" in memory
      - meaning it has a standard format of mixed "types" representing a cohesive "thing" (sometimes called "shape" or "form")
    - The "structure" can represent anything
      - like a person, a car, a house, a company, a country, a planet, a solar system
      - Keep in mind, it's just a representation, not an actual thing and can only track the representative data
      - The classic GI-GO (Garbage In, Garbage Out) problem
    - The "structure" is usually made up of a list of "fields" which are the individual pieces of data that make up the "structure"
    - The "fields" are usually accessed by a "name" which is a human-readable label for the "field"
    - The "fields" are usually stored in a contiguous block of memory
    - The "fields" are usually different types (like numbers, letters, strings, dates, times, arrays, and other Records)
  - Stack
    - A way to represent a "last in, first out" list of things in memory, similar to a stack of dinner plates
    - The "things" are usually all the same size & type
    - The "things" are usually all stored in a contiguous block of memory
    - The "things" are usually accessed by a "stack pointer" which is a number that represents the position of the top-most "thing" in the stack
    - Efficient for adding and removing items from the list, but not efficient for accessing items in the list
  - Queue
    - A way to represent a "first in, first out" list of things in memory, similar to a line of people waiting for a bus
    - The "things" are usually all the same size & type
    - The "things" are usually all stored in a contiguous block of memory
    - The "things" are usually accessed by a "head" and "tail" which are numbers that represent the position of the first and last "thing" in the queue
    - Efficient for adding and removing items from the list, but not efficient for accessing items in the list
  - Linked List
    - A way to represent a "list" of things in memory, where each "thing" points ONLY to the next "thing" in the list
    - The "things" are usually all the same size & type
    - The "things" are NOT stored in a contiguous block of memory, which is the main difference between an array and a linked list
    - The "things" are usually accessed by a "pointer" which is a number that represents the location of the "thing" in memory
    - Used to represent a "dynamic" list, where the size of the list is not known ahead of time
    - Efficient for adding and removing items from the list, but not efficient for accessing items in the list
  - Tree
    - A way to represent a "hierarchical" list of things in memory, where each "thing" points to one or MORE "things" in the list
    - The "things" are usually all the same size & type
    - The "things" are NOT stored in a contiguous block of memory, which is the main difference between an array and a tree
    - The "things" are usually accessed by a "pointer" which is a number that represents the location of the "thing" in memory
    - Used to represent a "hierarchical" list, like a family tree, or a company organization chart
    - Special Case of a tree is a "Binary Tree" where each "thing" points to only two "things" in the list
      - Binary Trees are used to represent "sorted" lists, where each "thing" is greater than the "thing" to the left, and less than the "thing" to the right 
  
## High-Level Language Styles
 - ### Procedural 50s-60s
   - First style of high level language after assembly language
   - Based on the idea of "subroutines" to deal with the use of "JMP/goto" statements which lead to confusing "spaghetti code"
   - The "subroutines" are usually called "functions" or "procedures" or "methods"
   - Early examples of procedural languages are "Fortran" and "C"
   - The "subroutines" are usually "called" and "returned" using a "stack" to keep track of the "state" of the program
   - Variables were usually "global" and "mutable" which lead to "side effects" and hard to understand "state" of the program
   - Each program was very "linear," "sequential," "imperative," and not portable or reusable, which lead to a lot of waste
   - Data and Code were kept separate.
     - Code was loaded into the computer, and then data was separately loaded and processed in "batches"
 
 - ### Structured 60s-70s
   - No more "goto" statements, only "subroutines" and "conditional jumps"
   - The concept of "scopes" and "blocks" to limit the use of "globally mutable" variables
     - This was the origin of "encapsulation" and introduced to limit the visibility of the variables and functions to
       only the "scope" or "block" that they were defined in, and to limit the "side effects" of the program.
   - Allowed more code reuse and easier to understand "state" of the program than procedural languages
   - This allowed libraries and "modules" to be more easily produced to create standard "subroutines" and
     "data structures" into "packages" and "system utilities" and "frameworks" to be used by other programmers
   - The concept of "types" was introduced to define the "shape" of the "data" and the "methods" that could be used on the "data"
   - Structure languages were also much more portable and reusable than procedural languages as they were not
     tied to any specific computer hardware or operating system. The computer manufacturer only had to create the 
     compiler for their particular machine, and then the same code could be run on any machine that had a compiler for the language.

- ### Class Oriented Programming 70s-2010s
  - Usually called "Object Oriented Programming" but that's a misnomer, as objects are not the main focus, classes are.
  - Collected ideas around: 
    - "Encapsulation" 
      - Data & code are "encapsulated," or enclosed into a "Class"
      - A "Class" is a template for creating an in-memory instance of the class called an "Object" which contains the 
        state and pointers to the "methods" (functions) of the class
      - When a new Object is created from a class template, the Object is called an "instance" of the class.
      - An "Object" is just a structure in memory that contains the values (or "state") of the variables from the class 
        template and a pointer to the "Methods" of the class
      - A "Method" is just a normal function in the class that operates on the data fields in the "class"
        - The process of calling a "method" on an "object" is called "sending a message" to the "object" 
        - (SO LAME! bc it's not a message! It's just calling a function!!!! THIS IS NOT MESSAGING!)
      - The values of the variables ("state") of the object are usually not accessible from outside the class (ie: "private") 
        and only accessible by the methods of the class, or the methods in the inhertited subclasses of the class.
      - The "methods" of the "class" are usually "public" and accessible by other "classes"
      - The "methods" of the "class" are usually "protected" and only accessible by "subclasses" of the "class"
      - There is a special modifier called "static" makes a variable or method accessible without needing an instance of the class (object)
    - "Inheritance" 
      - Inheritance is the idea that a new "class" can inherit from another "class" all of it's methods and variables,
        and then add new methods and variables to the new "class" that will modify the behavior of the original "class"
      - Classes can inherit from other classes to reuse code and "state", and to create "subtypes/subclasses"
      - The class that is inherited from is called the "superclass" and the class that inherits is called the "subclass"
      - The "subclass" is also called a "derived class" and the "superclass" is also called a "base class"
    - "Interfaces"
    - "Abstract classes"
    - "Polymorphism"
      - Polymorphism is the idea that a "method" can be called on an "object" and the "method" will behave differently
        based on the "type" of the "object" that the "method" is called on
    - Controlled Mutability and Visibility of variables
    - "Interfaces" and "Abstract Classes" to allow for "multiple inheritance" and "polymorphism" 
      - bad ideas for many reasons, and overused beyond its original intent
    - Examples of class oriented languages are "Simula" and "C++" and "Java"
 
 - ### Object Oriented Programming 80s-2020's
   - Alan Kay Style 
     - Based on the idea of "messaging" between objects, VERY poorly named "object oriented programming" (admitted by Alan Kay) 
   - State is fully retained in the "object" and "methods" are used to send & receive messages to the "object" to change it's "state"
   - No "global" variables, only instance variables that are private to the object
   - 
 
 - ### Functional Programming 50s-2020's
   - Main idea was to avoid "side effects" and "mutable state" of the program
   - All functions return a value, and have no "side effects" on the "state" of the program that were not 
     explicitly passed in as arguments
   - The "state" of the program is usually "immutable" and "passed" as "arguments" to the "functions"
   - The new "state" is returned as the "result" of the "function"
   - The "functions" are usually "first class" and "higher order" and can be "passed" as "arguments" to other "functions"
   - Examples of functional languages are "Lisp", "Clojure" and "F#" and "Kotlin"



























































