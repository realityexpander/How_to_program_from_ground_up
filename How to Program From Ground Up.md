# How to Program From The Ground Up with Minimal BS

## Introduction
  - Discussion from the fundamentals of physical logic representation to the high level programming languages.
  - The goal is to understand more the "why" and "how" of programming, not just the "what" and "where"

  - People used to do all computing by hand, and now we use various machines to do the same thing, 
    in a much faster and more reliable way.
    - When we use a machine to do computing, we are just using the machine to represent the problem and the 
      solution in a different way.
    - The machine knows nothing about the problem. it's only following orders created by clever humans using 
      boolean logic to represent the problem and its sequence of actions to solve it.
    - Each operation in the computer was once done by teams of people working in groups, logically delineated in 
      nearly the same way as the computer's components are arranged.
        - There were specialized roles for each person, for example, the "storage" would be a set of filing cabinets and a clerk to store and retrieve them.
          - This is now done by the "hard drive" and the "file system" in the computer.
        - The arithmetic would be done by a person called a "calculator" who would perform the operations and record the results.
          - This is now done by the "Arithmetic Logic Unit" and the "Registers" in the computer.

# The Essence of Computing — What are we Representing?
  - Everything in computing is REPRESENTING digital information "as" something _else_.
  - Kinds of representations through history:
    
    - Knots & Beads on a string
      - [<img src="assets/beads_on_string.png" width="280">](https://www.peruforless.com/blog/quipu/)
    
    - Physical indentations in clay
      - [<img src="assets/cuneiform.png" width="280">](https://www.thoughtco.com/clay-tokens-mesopotamian-writing-171673)
      - [<img src="assets/phyiscal_indentations.png" width="280">](https://www.thoughtco.com/clay-tokens-mesopotamian-writing-171673)
    
    - Beads on an abacus
      - [<img src="assets/abacus2.png" width="280">](https://en.wikipedia.org/wiki/Abacus) 
    
    - Ink Marks on paper
        - [<img src="assets/paper_ledger.png" width="280">](https://www.moderntreasury.com/journal/history-of-ledgers)
    
    - Punched Holes in a paper card
      - Vast improvement over the paper ledger
      - Collection of data was standardized, fast and could be read by a machine
      - Data collected from the 1890 US Census was the first large scale use of punched cards
      - Allowed for the first "programmable" machines that could be used to perform relatively complex tasks 
        like sorting and counting of specific data
      - [<img src="assets/punched_card.png" width="280">](https://en.wikipedia.org/wiki/Punched_card)
      - [<img src="hollerith_counter.png" width="280">](https://en.wikipedia.org/wiki/Hollerith_machine)
    
    - Remnants of a photon strike on a piece of glass coated with a thin layer of phosphor
      - [<img src="assets/williams_tube.png" width="280">](https://en.wikipedia.org/wiki/Williams_tube)
      - [<img src="assets/williams_tube2.png" width="280">](https://en.wikipedia.org/wiki/Williams_tube)
      - [<img src="williams_tube3.png" width="280">](https://ub.fnwi.uva.nl/computermuseum/williamstube.html)
      
    - Magnetic polarization of specific areas on magnetic material, or the presence of a magnetic field in a specific area
      - Core Memory
        - [<img src="assets/core_memory.png" width="280">](https://en.wikipedia.org/wiki/Core_memory) 
      - Magnetic Tape
        - [<img src="assets/magnetic_viewer.png" width="280">](https://www.youtube.com/watch?v=aZOxn8ggX8w)
      - Magnetic Disk
      - [<img src="assets/10mb_hard_disk.png" width="280">](https://en.wikipedia.org/wiki/IBM_305_RAMAC)
    
    - Detectable electrical capacitance in a tiny area of silicon
      - [<img src="assets/DRAM.png" width="280">](https://en.wikipedia.org/wiki/Dynamic_random-access_memory)
  
  - Creating Machines to Use Boolean Logic Enables Complex Custom General Solutions to Certain Class of Problems
    - By building up from the simple logic of "AND", "OR", and "NOT" operations, humans can create an 
      arbitrarily complex sequence of logical operations
    - These logical operations are sequenced in time to create "state machines" that can perform complex tasks 
      and solve complex problems
    - These logical operations are built up using patterns called "algorithms" grouped together in "programs" that
      can be executed by a digital computer
    - All of this is based on human ingenuity and cleverness, as the computer knows nothing about the problem. 
    - It's just following the logical operations that humans have carefully designed to represent the problem and a solution.

# Low Level Hardware Implementations
  
  - ## The Wire & the Light Bulb & the Battery
    - Represents Logic "state" - the most basic representation of a "state" in computing
    - Connected or not connected
    - Light on or off (1 or 0)
    - Even though the light has in reality many, many different states constantly 
      changing over time, we can still use it to represent a single state at time: Either on or off.
  
  - ## The Simple Switch
    - Easier to manipulate for humans than a bare wire
    - Can be physically manipulated using electricity to change state using an electromagnet.
    - Simple switches can be used to represent boolean logic operations
    - These operations are called "gates", conceptually similar to someone following path crossing a fence through a gate
    - Logical Operations & Boolean Arithmetic
      - Two switches in series represents logical AND gate
        - AND ( the `&&` symbol )
          - 0 && 0 = 0
          - 0 && 1 = 0
          - 1 && 0 = 0
          - 1 && 1 = 1
      - Two switches in parallel represents logical OR gate
        - OR ( the `||` symbol) 
          - 0 || 0 = 0
          - 0 || 1 = 1
          - 1 || 0 = 1
          - 1 || 1 = 1
      - Boolean logic requires one more operation to be complete: The logical NOT operation
  
  - ## The Magnificent Magnet
    - Magnets can be electrically controlled to cause mechanical actions on certain metallic materials
    - Certain Metallic Materials can be "magnetized" and "polarized" using electricity to represent a "state"
      - Magnetized or not (1 or 0) 
      - North or South (1 or 0)
      - It's magnificent bc its so useful and versatile
    - How To Make an Electromagnet 
      - https://youtu.be/Vpb7IQ2Ib_Y
    - Magnetic Viewing Film - How it Works/Demos 
      - https://www.youtube.com/watch?v=slVL5nbTXd4
  
  - ## The Raucous Relay
    - Uses an electromagnet to control a switch (or multiple switches)
    - the first electrical computers were made of relays (extremely slow but faster than writing by hand!)
    - If a circuit is designed to turn a switch OFF when the relay is electrified, this creates a logical NOT gate, 
      so using a relay in this way allows us to represent any other logic gate.
    - NOT (!)
        - !0 = 1
        - !1 = 0
    - The relay can be used to represent any other logic gate
    - It's raucous because it makes a lot of noise
    - AND OR NOT gates with Relays
      - https://www.youtube.com/watch?v=FKub2SuugsQ
    - Computers built using Relays
      - https://youtu.be/e8DavnWmr1E?si=zTmgE0FgV0NcckZ7
      - https://youtu.be/NXeBR-lbnjI
  
  - ## The Voracious Vacuum Tube
    - How Vacuum Tubes Work 
      - https://www.youtube.com/watch?v=nA_tgIygvNo
      - Note: While the actual flow direction of electrons is from the "negative" terminal to the "positive" terminal, 
        the "conventional" flow direction of electricity is considered to go from the "positive" terminal to the 
        "negative" terminal. 
      - _Yes!_ this is somewhat confusing at first, and you can give thanks Ben Franklin for this technical debt we 
        all have to deal with at the beginning of learning electronics.
    - Electricity in a vacuum behaves differently than in normal atmosphere. Electrons can flow freely in a vacuum. 
      - Tubes exploit this behavior of electrons in a vacuum to perform like a switch or an amplifiers.
    - Tube made for use in logic (Triode) consists of three parts:
      - **"Cathode"** 
        - Essentially a light bulb filament tied to the common "ground/negative" terminal of the power supply
        - Negative terminal of the tube it used to "emit" electrons to the anode and complete the circuit
      - **"Anode"** 
        - Positive terminal of the tube hooked to the "load" and the positive terminal of the power supply.)
        - Used to "collect" electrons from the cathode and to indicate "state" and complete the circuit.
      - **"Grid"** 
        - this acts as a switch also called a "valve" when referring to tubes
    - The Grid can be used to control the flow of electricity between the cathode and anode.
      - ie: when the grid is positively charged, the flow of electricity from cathode to the anode is allowed.
      - ie: when the grid is negatively charged, the flow of electricity from cathode to the anode is deterred.
      - This acts by default like a logical "NOT" gate.
    - The tube can be used to represent any other logic gate
    - The vacuum tube is voracious because it consumes a lot of power to heat the cathode and generates a lot of heat
  
  - ## The Tiny Transistor
    - Very similar behavior to the vacuum tube, but much smaller and faster
    - No vacuum required, just a the semiconductor materia
      - Uses photographic techniques to create the object, not regular metallic parts
    - The transistor consists of three parts:
      - **"Drain"** 
        - (the "anode" in the vacuum tube) 
        - also known as "collector" or "sink" often connected to "load" 
        - (not always "positive" in modern transistors, but usually is)
      - **"Source"** 
        - (the "cathode" in the vacuum tube) 
        - also known as "emitter" often connected to "ground" 
        - (not always "negative" in modern transistors, but usually is) 
      - **"Gate"** (the "Grid" in the vacuum tube) 
        - also known as "base" often connected to the "control" 
        - (not always "positive" in modern transistors, but usually is)  
    - The transistor can be used to represent any other logic gate and is the current basis for all modern computing
    - The transistor is tiny because it is very small and fast, bumping up against the limits of physics on how small it can be made

    - ### How to Build Complex Logic Gates from Simple Transistors
      - Making logic gates from transistors 
        - https://www.youtube.com/watch?v=sTu3LwpF6XI
      - How does memory work?
        - SR Latch 
        - https://youtu.be/KM0DdEaY5sY

  - ## The Interchangeable Integrated Chip (IC - groups of logic gates packaged together to perform a specific purpose)
  - ![img_1.png](the_ic.png)
    - the logic gate "package" (groups of transistors for a specific logic operation)
      - OR, AND, NOT, NAND package (usually 2-4 in the same package)
      - Why is NAND gates so special?
        - It's the most flexible can be combined to create any other logic gate, ie: AND, OR, NOT, XOR, etc.
          1) tie inputs A & B together to create a NOT gate
          2) tie inputs A & B together combined with a NOT gate to create an OR gate
          3) use normal A & B inputs and combine with a NOT to create an AND gate
      - Everything in computers can be done with just these three types of gates
      - Most early digital electronic calculators were made solely with many IC's of these gates
    
  - ## The Mighty Microprocessor (groups of integrated chips -> all put on one chip)
    - Contains a CPU (Central Processing Unit) and a small amount of ultra fast memory (called "Registers")
    - Has a "clock" to synchronize the operations of the CPU
    - Has a "program counter" to keep track of the current instruction in memory that the CPU is executing
    - Has an "ALU" (Arithmetic Logic Unit) to perform basic arithmetic and logical operations
      - How does an ALU work? 
        - Learn how computers add numbers and build a 4 bit adder circuit 
        - https://youtu.be/wvJc9CZcvBc 
    - May contain a small amount of "cache" memory (very fast memory near the CPU circuits) to speed up access to main memory
    - CPU's are where the execution of each instruction happens
  
  - ## The Configurable Computer
    - RAM (Random Access Memory) 
      - https://www.youtube.com/watch?v=uYXwCBo40iA
    - ROM (Read Only Memory - usually contains the basic software to start the computer, sometimes called "firmware")
      - https://www.youtube.com/watch?v=3l5q0xaQEf8
    - IO & Peripherals & Removable Storage & More
      - All just more variations of the same thing
        - All built up from the same basic logic gates and transistors, or similar technology
        - Even video cameras, microphones, radios and speakers are just variations of the same basic technology
      - using the same principles to represent logic states and perform logical operations
      - Often electromagnets to control mechanical devices or other machines
        - The classic example is the "hard drive" which uses a spinning disk and a moving arm to read and write data
        - The "hard drive" is a "magnetic" storage device, and uses tiny spots of "magnetized" material to represent the "state" of the data
        - The arm is controlled by software and uses "magnets" to move the arm to the correct position to read and write the data
        - Some sort of electrified magnet is the usual way that computers interact physically with the world

# Machine Code — The Microcode Soft-Circuitry Commands of the CPU
  - Machine Code is the "language" of logical operations that the computer can perform
    - It's really just human cleverness setting up problems in a way 
        that the machine can perform simple logical operations to give 
        us a representation of the result of the problem
    - Anything the computer can do is just a combination of these simple logical operations, designed by people
      to represent the problem to be solved by a digital computer using a series of logical operations & states
    - The specific instructions for the CPU are called operation codes, or "opcodes", and are just strings of 
      arbitrary binary numbers like 1010101011010101 that represent the logical operations that the CPU can perform.
    - The opcode values are completely dependent on the specific CPU, and are usually defined by the manufacturer of the CPU.
    - These numbers are usually represented in hexadecimal (base 16) to make them easier to read and write (as opposed to binary, base 2)
    - The opcodes are the most primitive logical operations that the CPU can perform
    - The opcodes are usually followed by "operands" which are the "arguments" to the operation
  - The Machine opcodes are unwieldy for humans to remember, so we use "mnemonics" to represent them
    - Mnemonics are just human-readable names for the opcodes, like "LOAD" or "STORE" or "ADD" or "SUBTRACT"
    - The mnemonics are then translated into the binary opcodes by a "compiler" or "assembler"
  
  - ### Common Machine Code Opcodes (actual opcode is for Motorola 6502 CPU)
    - `Hex: Opcode Mnemonic` 
    - `0xA9: LDA` Load a value from main memory into a register 
    - `0xA2: MOV` Move a value from one register to another 
    - `0x8D: STA` Store a value from a register into main memory
    - `0x4C: JMP` Start executing next instruction at a different location in main memory by updating the Program Counter with a new value
    - `0x6D: ADC` Add the values in two registers and store the result in a third register and update the "flags" register if there is a "carry"
    - `0xCD: CMP` Compare the values in two registers and update the "flags" register with the result
    - `0xD0: BNE` If the "flags" register is not zero, start executing at a different location in main memory ie: "conditional branching"
  
  - ### Clock — "The heart beat of the CPU"
    - Clock Circuit - Basically a emits a short pulse of electricity at a regular interval
      - a "tick" of the clock, like flashing a light to the beat
    - Used synchronizes the operations of the CPU
      - Example Implementation - Astable 555 timer - 8-bit computer clock - part 1
      - https://www.youtube.com/watch?v=kRlSFm519Bo 
    - Everything in the computer happens one step at a time, and the clock is the thing that makes the "steps"
    - Each "tick" of the clock is called a "cycle"
    - The cycle of the clock is not the same as the cycle of the CPU, but the CPU normally does one operation per cycle
      but some operations may take more than one clock cycle to complete.
  
  - ### Program Counter - "Where is the current instruction to be executed?"
    - The "program counter" (PC) is a special register that keeps track of the current memory location of the
      current instruction that the CPU will execute/is executing
    - Defaults to the first memory location(0x00000000), and then increments by 1 after each instruction is executed
    - The "program counter" is updated by the "clock" at the end of each "cycle", or when a "jump" instruction is executed
  
  - ### Fetch-Decode-Execute Cycle of the CPU — "The Dumb Quick Work of the CPU"
    - Fetch means to get the next opcode instruction from main memory and put it into the "instruction register" on the CPU
    - Decode means to figure out what the opcode operation is and what the operands are (if any)
      - "Operands" are the "arguments" to the operation. ie: the "source" and "destination" of the operation 
      - The operation may need to fetch more data from main memory or from a register to get the operands for the instruction
      - The operation may take more than one cycle to prepare for execution
    - Execute means to actually perform the operation
      - ie: add the values in two registers and store the result in a third register, 
        then set a "flags register" if the result is zero, negative or had to "carry" a bit
      - The operation may require more than one cycle to complete
      - The number of cycles is totally dependent on the specific CPU and the specific operation
      - The operation may need to store the result back into main memory or into one or more registers
  
  - ### Registers — "The Tiny Superfast Memory of the CPU"
    - Registers are a small amount of very fast memory that is part of the CPU
    - The registers are used to store the results of the instructions, and current operands being executed
    - The registers are used to store the current "state" of the CPU, like the "program counter" and the "flags" register
      - Some registers store the values of the last arithmetic operation, like from an "ADD" or "SUBTRACT" 
      - Some registers are a series of "status flags", single bits used to store the result of the last operation
      - Status flags are used to control the "conditional jumps" in the program
      - Flags such as "zero" or "carry" are used to indicate the results of the last operation
      - For example: 
        - if the result of the last operation was zero, then the "zero" flag is set to 1; otherwise it's set to 0
        - if the result of the last operation was negative, then the "negative" flag is set to 1; otherwise it's set to 0
        - if the result of the last operation had to "carry" a bit, then the "carry" flag is set to 1; otherwise it's set to 0

- # Assembly Language
  - Assembly Language is a "human-readable" representation of the "machine code" that the CPU can execute
  - The "mnemonics" are translated into the binary opcodes by an "assembler" which is a program that 
    translates the "assembly language mnemonics" nearly directly into "machine code" for a particular CPU.
  - Assembly Language is the most "primitive" language that a human can reasonably use to program a computer in an efficient manner.
  - It's totally possible to program a computer using just "machine code" (the binary opcodes), but it's very difficult and error-prone.
  - There is no "universal" assembly language, each CPU has it's own assembly language, so the assembly language is 
    completely dependent on the specific CPU and is usually defined by the manufacturer of the CPU
  - The complexity of the assembly language is usually directly related to the complexity of the CPU & the number of 
    different operations that the CPU can perform.
  
  - ## Common Assembly Language Operations

  - ### Jump - Usually mnemonic `JMP`
    - The "goto" statement of machine code
    - Changes the program counter (PC) to point to a different location in memory
    - Also known a "branch" or "loop"
    - No limits to where the jump can go, it be anywhere in memory. If it's wrong, the machine will likely halt
      or do something unexpected, also called a "crash"
  
  - ### Load - Usually mnemonic `LOAD`
    - Copies a value from a location in memory into a "register" (a tiny bit of memory that is part of the CPU)
  - ### Store - Usually mnemonic `STO`
    - Copies a value from a "register" into a location in memory 
  - ### Move — Usually mnemonic `MOV`
    - Copies a value from one "register" into another "register" 
  - ### Add — Usually mnemonic `ADD`
    - Adds the values in two "registers" and stores the result in a third "register" 
  - ### Subtract - Usually mnemonic `SUB`
    - Subtracts the values in two "registers" and stores the result in a third "register" 
  - ### Compare - Usually mnemonic `CMP`
    - Compares the values in two "registers" and updates the "flags" register 

  - ## Conditional Jump — The Go-to of Machine Code
    - Usually mnemonics: 
      - `JNZ` (Jump if Not Zero)
      - `JZ` (Jump if Zero)
      - `JG` (Jump if Greater)
      - `JL` (Jump if Less)
    - The "`if`" statement of machine code
    - Changes the program counter (PC) to point to a different location in memory based on the result of a previous operation
    - The results of the previous operation is kept in a "register" (a tiny bit of memory that is part of the CPU)
    - The "if" statement is the most important part of programming, it's the basis for all decision making
    - Also known as "branching" or "conditional jump" or "loop"
  
  - ## Variables
    - Just named memory locations that are used to store data, sometimes called "fields" or "attributes" or "properties"
    - The data is a representation of something else, like a number or a letter, or a color, or a sound, or an address
    - Variables are a convenient way to give a name to a location in memory
  
  - ## Subroutines
    - Usually mnemonic CALL
      - Jumps to a location of a function in memory & preserve current state
      - Pushes the current PC & Registers onto the stack, and then changes the PC to point to a different location in memory
    - Usually mnemonic RETURN
      - A way to return from a function in machine code 
    - The "call" statement changes the program counter (PC) to point to a different location in memory
    - The "return" statement changes the program counter (PC) back to where it was before the "call" statement
    - Subroutines are the basis for all "structured" programming

# Data Structures
  - Data structures are names for common ways humans have come up with to represent and handle data, and predate computers.
  - Data structures help represent real world items and concepts in a way that a computer can be programmed to manipulate to solve a problem.
  - For example, a "list" is a common data structure that represents a series of items in a specific order, and 
    can be used to represent a "list of orders to be shipped," "to-do list" or a "list of names"

  - ## Numbers or Individual Characters? Or something else?
    
    - ### Numbers 
      - are usually represented in binary (base 2)
      - Positive integers are usually represented in "unsigned" binary
        - 1 byte (8 bits) can represent unsigned 0 to 255 (known as a "byte" or "octet" or "char" or "unsigned char" or "unsigned byte")
        - 2 bytes (16 bits) can represent unsigned 0 to 65535 (known as a "short", sometimes "word")
        - 4 bytes (32 bits) can represent unsigned 0 to 4294967295 (known as an "int", sometimes "long")
      - Negative integers are usually represented in "signed" binary 
        - 2's Complement is the most common way to represent negative numbers in binary
        - 2's Complement is the "complement" of the number (flipping the bits) and then adding 1
        - 2's Complement is used to represent negative numbers in binary because it makes the "addition" and "subtraction" of numbers easier
        - Twos complement: Negative numbers in binary 
          - https://www.youtube.com/watch?v=4qH4unVtJkE
        - 1 byte (8 bits) can represent signed -128 to 127
        - 2 bytes (16 bits) can represent signed -32768 to 32767
        - 4 bytes (32 bits) can represent signed -2147483648 to 2147483647
      - Floating point numbers are usually represented in "IEEE 754" format
        - 4 bytes (32 bits) can represent a floating point number
        - 8 bytes (64 bits) can represent a double precision floating point number
        - Floating point numbers will use a "mantissa" and an "exponent" to represent the number in scientific notation
        - Due to the way floating point numbers are represented, they are not exact! And will have rounding errors!
        - Why Is This Happening?! Floating Point Approximation 
          - https://www.youtube.com/watch?v=2gIxbTn7GSc
    
    - ### Characters/Letters are usually represented in ASCII (1 byte) or Unicode(1 or more bytes)
      - Ascii is a 1 byte (8 bit) representation of the most common letters and symbols
      - Unicode is a 1 or more byte representation of all the letters and symbols in all the world's languages
    
    - ### Something else?
      - Numbers and Characters are the most common things to represent in memory, but anything can be represented in memory
      - Colors, Sounds, Images, Videos, Programs, Documents, etc.
      - Anything that can be represented as a series of values can be represented in memory.
      - For example, images are usually represented as a series of "pixels" or "picture elements" which are a series of 
        "colors" which are a series of "numbers" that represent the red, green, and blue values of the color.
      - 01010101 could represents votes of 8 people, or 8 switch settings, or the connected status of 8 different sensors.
      - The same 8 bits can represent many different things, it's just a matter of how humans want to interpret the meaning of the bits.
  
- ## Commmon Data Structures
  - ### Arrays
    - A way to represent a "list" of things in memory
    - The "things" can be anything, like numbers, letters, strings or even other arrays (multi-dimensional arrays)
    - The "things" are usually all the same size & type
    - The "things" are usually all stored in a contiguous block of memory
    - The "things" are usually accessed by an "index" which is a number that represents the position of the "thing" in the array
  
  - ### Strings
    - A way to represent a list of letters in memory, to represent words and sentences and paragraphs and documents
    - The "characters" are usually stored in a contiguous block of memory
    - The "characters" are sometimes terminated by a special "end of string" character, or have a length stored somewhere
    - The "characters" are usually accessed by an "index" which is a number that represents the position of the "characters" in the string
  
  - ### Pointer
    - A number that represents the "address" of another location in memory
    - Diagram:
      - Address: Value 
      - 0x00000000: 0x00  `// 0x00000000 is the address, 0x00000004 is the value of this pointer, so it's pointing to address 0x00000004`
      - 0x00000001: 0x00  
      - 0x00000002: 0x00
      - 0x00000002: 0x04  `// This is a pointer's value is 0x00000004, so it's pointing to address 0x00000004`
      - 0x00000004: 0x41  `// 0x00000004 is the address, 0x41 is character 'A' as ASCII, or 65 as an unsigned byte integer`
    - The pointer stored at 0x00000000 has the value 0x00000004, so it's pointing to address 0x00000004
    - Address 0x00000004 contains the value 0x41, which represents the character 'A' or the number 65 as an unsigned byte integer
    - it's stored in "Little Endian" format, so the least significant bytes are stored first.
  
  - ### Structures 
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
  
  - ### Stack
    - A way to represent a "last in, first out" list of things in memory, similar to a stack of dinner plates
    - The "things" are usually all the same size & type
    - The "things" are usually all stored in a contiguous block of memory
    - The "things" are usually accessed by a "stack pointer" which is a number that represents the position of the top-most "thing" in the stack
    - Efficient for adding and removing items from the list, but not efficient for accessing items in the list
  
  - ### Queue
    - A way to represent a "first in, first out" list of things in memory, similar to a line of people waiting for a bus
    - The "things" are usually all the same size & type
    - The "things" are usually all stored in a contiguous block of memory
    - The "things" are usually accessed by a "head" and "tail" which are numbers that represent the position of the first and last "thing" in the queue
    - Efficient for adding and removing items from the list, but not efficient for accessing items in the list
  
  - ### Linked List
    - A way to represent a "list" of things in memory, where each "thing" points ONLY to the next "thing" in the list
    - The "things" are usually all the same size & type
    - The "things" are NOT stored in a contiguous block of memory, which is the main difference between an array and a linked list
    - The "things" are usually accessed by a "pointer" which is a number that represents the location of the "thing" in memory
    - Used to represent a "dynamic" list, where the size of the list is not known ahead of time
    - Efficient for adding and removing items from the list, but not efficient for accessing items in the list

  - ### Tree
    - A way to represent a "hierarchical" list of things in memory, where each "thing" points to one or MORE "things" in the list
    - The "things" are usually all the same size & type
    - The "things" are NOT stored in a contiguous block of memory, which is the main difference between an array and a tree
    - The "things" are usually accessed by a "pointer" which is a number that represents the location of the "thing" in memory
    - Used to represent a "hierarchical" list, like a family tree, or a company organization chart
    - Special Case of a tree is a "Binary Tree" where each "thing" points to only two "things" in the list
      - Binary Trees are used to represent "sorted" lists, where each "thing" is greater than the "thing" to the left, and less than the "thing" to the right
      
        ![tree.png](assets/tree.png)  

# High-Level Language Styles
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
    
    - ### Encapsulation 
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
    
    - ### Classes and Objects as Name Spaces
      - In most COP languages, the "class" is used as a "namespace" to group together the "methods" and "variables" that 
        are related to each other
      - This often lead to "collections of static methods" in order to continue the "procedural" paradigm
      - These were popularized by web frameworks such as Java's 
    
    - ### Inheritance 
      - Inheritance is the idea that a new "class" can inherit from another "class" all of it's methods and variables,
        and then add new methods and variables to the new "class" that will modify the behavior of the original "class"
      - Classes can inherit from other classes to reuse code and "state", and to create "subtypes/subclasses"
      - The class that is inherited from is called the "superclass" and the class that inherits is called the "subclass"
      - The "subclass" is also called a "derived class" and the "superclass" is also called a "base class"
    
    - ### Interfaces
      - An "interface" is a "contract" that a class can "implement" to define the "methods" that the class will have
      - It's a way to tell the compiler and the programmer that the class must have certain "methods" and "variables" in it
      - The "interface" is usually "implemented" by the class, and then the "methods" and "variables" are "defined" by the class
        - ie: `Interface Document` - expects `open()` method
        - `Class PDF implements Document` - implements `open()` method, opens a "PDF Viewer"
        - `Class Email implements Document` - implements `open()` method, opens an "Email Client"
      - Allows a developer to add multiple implementations of the same method by defining a new `class` that `implement`s 
        the interface by defining the code for the methods from the `interface`
        - This makes it easier to add new subclasses of the `interface` to the program without changing any existing code
        - This also make it easier to write "testing" code that can be used to automatically verify the correctness of the methods 
          of the `class` by using "testing" implementations of the `interface`
      - The `interface` is `implemented` by a `class` and then the methods are defined by the `class`
    
    - ### Abstract Classes
      - Very similar to "interfaces" but can have "methods" with "default" implementations of the "methods"
      - The "abstract class" is usually "extended" by the "subclass" and then the "methods" are "overridden" by the "subclass"
    
    - ### Polymorphism
      - Polymorphism is the idea that a "method" can be called on an "object" and the "method" will behave differently
        based on the "type" of the "object" that the "method" is called on
        - Abstract Class Document - expects "open" method
        - Class PDF extends Document - implements "open" method, opens a "PDF Viewer"
        - Class Email extends Document - implements "open" method, opens an "Email Client"
        - Class Song extends Document - implements "open" method, opens a "Music Player"
        - Polymorphism is the idea that a "method" can be called on an object that is a subclass of Document and the method will behave differently depending on the type of the object
          - ie: the "open" method will open a "PDF Viewer" if the object is a "PDF" and will open an "Email Client" if the object is an "Email" and will open a "Music Player" if the object is a "Song" 
    
    - ### Controlled Mutability and Visibility of variables
      - Use of explicit "private" and "protected" and "public" to control the visibility of the variables and methods of the class
      - Encouraged to use "getters" and "setters" to control the access to the variables of the class (which has since been shown to be a bad idea)
    
    - ### Issues from overuse of Inheritance and allowing for "multiple inheritance" in C++ 
      - Lead to immense & unnecessary complexity to fit in the paradigm, as programmers tried to fit the "class" oriented paradigm into the "procedural" paradigm
      - bad ideas for many reasons, and overused beyond its original intent
        - The hype around reusability was so strong that it was often used to justify the use of inheritance in places where it was not appropriate
        - This lead to "fragile" and "rigid" code that was hard to understand and hard to modify, leading to a lot of waste and costs
      - Banana, Monkey, Jungle Problem
        - https://crystal-villanueva.medium.com/the-banana-and-the-gorilla-problem-92c9a4717fd6
        
        
    - Examples of Class Oriented Programming languages are "Simula" and "C++" and "Java"
 
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



























































