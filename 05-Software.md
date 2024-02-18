# SOFTWARE - The Easily Changeable Machine

## Machine Language Code — The Operation Commands for the CPU <a name="machine-code"></a>
###### machine-code
  - ### BIG IDEA - Logic gates can be built up to create a general-purpose machine that can execute easily changeable programs (called "Software") instead of arranging discrete physical components. 
  
  - The software can be changed, at any time, to change the behavior of the machine instead of physically creating a 
    new machine for that specific task.
  - ITS IMPORTANT TO KNOW THAT ANY software COULD be implemented in hardware, but the costs of doing so rarely make it practical, 
    other than a few very specialized problems like graphics cards to compute 3D graphics, crypto mining and AI training.
    > - What's an FPGA? (Field-Programmable Gate Array - Software in Hardware)
    >   - https://www.youtube.com/watch?v=iHg0mmIg0UU
    > - CPU vs FPGA
    >   - https://www.youtube.com/watch?v=BML1YHZpx2o
  - Machine Code is the "language" of logical operations that the computer can perform.
    - It's really just human cleverness setting up problems in a way that a machine can perform simple logical
      operations to give a representation of the results.
    - Anything the computer can do is just a combination of these simple logical operations, designed by people
      to represent the problem to be solved using a series of logical operations & states.
    - The specific instructions for the CPU are called operation codes, or "opcodes", and are just strings of
      arbitrary binary numbers like 1010101111010111 that represent a particlar set of logical operations that the CPU
      should can perform.
    - The opcode values are completely dependent on the specific CPU, and are usually defined by the manufacturer of the CPU.
    - These opcodes are usually represented in hexadecimal (base 16) to make them easier to read and write (as opposed to binary, base 2)
    - The opcodes are the most primitive logical operations that the CPU can perform.
    - The opcodes are usually followed by "operands" which are the "arguments" or "parameters" to the operation.
      - ie: the source and destination of the operation, or a value to be used in the operation.
  - The Machine hex value opcodes are unwieldy for humans to remember, so we use "mnemonics" to represent them.
    - Mnemonics are simply human-readable names for the opcodes, like `LOAD`, `STORE`, `ADD`, `COMPARE`, and `JUMP` used to
      represent the opcodes values.
    - These mnemonics are translated into the binary opcodes by a compiler or assembler program.

## Representation of Data in Computer Memory <a name="representing-values-in-memory"></a>
###### representation-of-data
  - ### BIG IDEA - If we can represent numbers in binary, we can then perform logical operations to build complex arithmetic operations.
  - ### Binary Counting <a name="binary-counting"></a>
  - ###### binary-counting
 
    [<img src="assets/8-bit-counting-2.png" width="450">](assets/8-bit-counting-2.png)
    > Learn how computers add numbers and build a 4 bit adder circuit
    > https://www.youtube.com/watch?v=wvJc9CZcvBc

  - ### 8 bits are called a "byte" and can represent 256 different values (0-255)
      - A "word" is the smallest unit of memory that can be addressed by a particlar CPU.
      - When microcomputers were introduced, the common thought was that 16-60 bits were the minimum needed to
        represent the smallest chunk of data addressable by the CPU.
      - The term "byte" was popularized during the microcomputer revolution to be in contrast with the "big metal"
        of the mainframe computers, which used 16-60 bit "words" as the smallest unit of memory.
    > They call it a "byte" because its a play on the word "bite" and it's the smallest amount of memory that
    > can be "eaten" by a microcomputer CPU (HAR HAR HARDY HAR Computer people are soooooo funnnnnny!)
    >
    > My conspiracy theory of the origin of Pac-Man...
    >
    >  [<img src="assets/pacman_bytes.png" width="150">](./assets/pacman_bytes.png) ⬅  ︎🅿🅐🅒-🅼🅐🅝 eating 1 byte.
    > 
    > 4 bits are called a "nibble" and can represent 16 different values (0-15).  

  - ### Hexadecimal Counting <a name="hexadecimal-counting"></a>
  - ###### hexadecimal-counting
    - ### BIG IDEA - Hexadecimal is a compact way to represent binary values in a way that is easier for humans to read and write.
    
      [<img src="assets/hexadecimal.png" width="350">](assets/hexadecimal.png)

  - ### Standardized ASCII Representation of Alpha-numeric Characters <a name="standardized-ascii"></a>
  - ###### standardized-ascii
      - ### BIG IDEA - Standardized way to represent roman characters and numbers in memory.
      
      - ASCII is a 1 byte (8 bit) representation of the most common letters and symbols used in English
      - ASCII stands for "American Standard Code for Information Interchange"
      - Note: The bits are used to categorize the characters into different groups & very intentionally designed
      - The first 32 characters are "control characters" and are not printable.
        The control codes are used to synchronize communication between devices, like "start of text" or "end of transmission"
      - ### ASCII table using Binary
      - Look at the numbers in the ASCII table and see if you can see the pattern
        
        [<img src="assets/ASCII-binary.png" width="450">](assets/ASCII-binary.png)
          - Note: The Capital letters are 1 bit higher than the lowercase letters.

      - ### ASCII table using Hexadecimal
      - Easier to read by humans, much more compact than binary
      - 2 Hexadecimal Characters can represent a 1 byte value in memory

        [<img src="assets/ascii_hexadecimal.png" width="450">](assets/ascii_hexadecimal.png)

# The Minimum Components of Any Computer System <a name="minimum-components"></a>
###### minimum-components
  
  - Computer Block Diagram
    > [<img src="assets/Computer_block_diagram.png" width="450">](assets/Computer_block_diagram.png)
    >
    > - `RAM` = Random Access Memory. Where all data is stored while the computer is running.
    > - `ROM` = Read Only Memory. Where the computer stores the "boot" program that starts the computer.
    > - `MPU` = Micro-Processor Unit. Where the execution of programs occurs.
    > - `XTAL` = Crystal Oscillator for the clock. 
    > - `CLOCK` = Clock Circuit. Sets the coordinating "heartbeat" for the computer. 
    > - `I/O BUS` = Input/Output Bus. The "highway" for data to come into and out of the computer.

  - ### The CPU or MPU (Central-Processing Unit ot Micro-Processor Unit) <a name="the-cpu-mpu"></a>
    - ###### the-cpu-mpu
    - The MPU is the part of the computer that executes the instructions in the program.
    - Also called the CPU - Central Processing Unit

    >  [<img src="assets/MPU.png" width="450">](assets/MPU.png)
    >
    >  - `MAR` = Memory Address Register — The current memory location that the CPU is accessing.
    >  - `PC` = Program Counter — The current memory location of the instruction that the CPU is/will execute.
    >  - `IR` = Instruction Register — The current opcode instruction being executed.
    >  - `Control Unit` — Synchronizes the operations of the CPU with the RAM, ROM, and other parts of the computer.
    >  - `ALU` = Arithmetic Logic Unit — Performs the basic arithmetic and logical operations.
    >  - `ACC` = Accumulator — Results of the last arithmetic or logic operation.
    >  - `X` & `Y` = Registers — Used to store the input operands for output to Accumulator Register (ACC.) via the ALU (Arithmetic Logic Unit.)

  - ### Clock — "The drum beat of the CPU to keep it all in sync" <a name="the-clock"></a>
    - ###### the-clock
    - Clock Circuit — Basically a emits a short pulse of electricity at a regular interval
        - A "pulse" or "tick" of the clock, like flashing a light to the beat.
        - Often uses a quartz crystal (`XTAL` in schematic) and the piezoelectric effect to keep a steady beat, like a watch.
        - Sometimes the common 555-timer IC chip is used to generate a clock signal.
    - Use to synchronize the operations of the CPU and access to the RAM, ROM, and other parts of the computer.
       > Example Implementation of a clock for a CPU
       > - How Does a 555 Timer Work?
       >  - https://www.build-electronic-circuits.com/how-does-a-555-timer-work/
       > - Astable 555 timer - 8-bit computer clock - part 1
       >  - https://www.youtube.com/watch?v=kRlSFm519Bo
   
    - Everything in the computer happens one step at a time, and the clock is the thing that makes the "steps"
    - Each "tick" of the clock is called a "cycle"
    - The cycle of the clock is not the same as the cycle of the CPU, but the CPU normally does one operation per cycle
      but some operations may take more than one clock cycle to complete.

  - ### Program Counter (PC) — "Where in memory is the current instruction being executed?" <a name="program-counter"></a>
    - ###### program-counter
    - The "program counter" (PC) is a special register that keeps track of the current memory location of the
      current instruction that the CPU will execute/is executing
    - All instructions are processed one at a time per CPU, and never more than 1 instruction at a time.
    - Starts at the first memory location(0x00000000), and then increments by 1 after each instruction is executed.
        > Program Counter Build
        >  - https://www.youtube.com/watch?v=tNwU7pK_3tk
    - The "program counter" is updated by the "clock" at the end of each "cycle", or when a "jump" instruction is executed

  - ### Common Machine Language Opcodes (actual opcode is for Motorola 6502 CPU) <a name="common-opcodes"></a>
    - ###### common-opcodes
    | 6502 Hex Opcode | Mnemonic | Description                                                                                                                         |
    |-----------------|----------|-------------------------------------------------------------------------------------------------------------------------------------|
    | `0xA9`          | `LDA`    | Load a value from main memory into a register                                                                                       |
    | `0xA2`          | `MOV`    | Move a value from one register to another                                                                                           |
    | `0x8D`          | `STA`    | Store a value from a register into main memory                                                                                      |
    | `0x4C`          | `JMP`    | Start executing next instruction at a different location in main memory by updating the Program Counter with a new value            |
    | `0x6D`          | `ADC`    | Add the values in two registers and store the result in a third register and update the "carry flag" register if there is a "carry" |
    | `0xCD`          | `CMP`    | Compare the values in two registers and update the "flags" register with the result                                                 |
    | `0xD0`          | `BNE`    | If the "flags" register is not zero, start executing at a different location in main memory ie: "conditional branching"             |


  - ### Fetch-Decode-Execute Cycle of the CPU — "The Dumb & Quick Work of the Machine" <a name="fetch-decode-execute"></a>
    - ###### fetch-decode-execute-cycle
    - Fetch means to get the next opcode instruction from main memory address in the PC and puts the opcode into
     the "Instruction register (IR)" on the CPU.
    - Decode means to figure out what the opcode operation is and what the operands are (if any.)
        - "Operands" are the "arguments" to the operation. ie: the "source" and "destination" of the operation.
        - The operation may need to fetch more data from main memory or from a register to get the operands for the instruction.
        - The operation may take more than one cycle to prepare for execution.
    - Execute means to actually perform the operation,
        - For example: opcode 0x6D means add the values in X & Y registers and store the result in the ACC register,
          then set a flags register if the result is negative or had to carry a bit.
        - The operation may require more than one cycle to complete (cpu-cycle.)
        - The number of cycles is totally dependent on the specific CPU and the specific operation.
        - The operation may need to store the result back into main memory or into one or more registers.
    - After the operation is complete, the program counter (PC) is updated with the address of the next instruction to
      be executed (or with a different location in memory if a "jump" instruction is executed.)
    - The "fetch-decode-execute" cycle is the basis for all computing, and is the most important part of the CPU.
       > 8-bit CPU control logic: Part 1
       >  - https://www.youtube.com/watch?v=dXdoim96v5A

  - ### Registers — "The Tiny Superfast Memory Nearest to the CPU & Keeps the State of the CPU" <a name="registers"></a>
    - ###### registers
    - ### BIG IDEA — Registers are a small amount of super fast memory that is built into the CPU.
    
    - Registers are a small amount of super fast memory that is built into the CPU.
    - Registers hold the current instruction (operator and operands) being executed in the "Instruction Register" (`IR`).
    - Registers hold address pointers to the current location in main memory in the "Program Counter" (`PC`) and
      the "Stack Pointer" (`SP`) and the "Memory Address Register" (`MAR`).
    - The `X` and `Y` registers are used to store the operands for the Accumulator Register (`ACC`) are used to store
      the results of the last arithmetic operation, like from an `ADD` or `SUBTRACT`.
      - Some registers are a series of "status flags", single bits used to store the result of the last operation.
      - Status flags are used to control the "conditional jumps" in the program.
      - Flags such as "zero" or "carry" are used to indicate the results of the last operation.
      - For example:
        - if the result of the last operation was zero, then the `zero` flag is set to 1; otherwise it's set to 0.
        - if the result of the last operation was negative, then the `negative` flag is set to 1; otherwise it's set to 0.
        - if the result of the last operation had to carry a bit, then the `carry` flag is set to 1; otherwise it's set to 0.

  - ### Arithmetic Logic Unit (ALU) — "The Calculator of the CPU" <a name="alu"></a>
   - ###### alu
   - ### BIG IDEA — The ALU is the part of the CPU that performs the basic arithmetic and logical operations in one place.
   
   - The ALU is the part of the CPU that performs the basic arithmetic and logical operations.
   - The ALU is used to perform the `ADD` and `SUBTRACT` and other math operations, results are stored in the 
     "Accumulator (ACC)" register and "flags" register are set.
     - Stores the result of the operation in the "Accumulator" register.
     - Sets the `carry` flag if the result of the operation had to "carry" a bit.
     - Sets the `negative` flag if the result of the operation was negative.
   - The ALU is used to perform the "Compare" operation, and all other logical operations operations.
     - Sets the `Zero` flag if the result of the operation was zero.
     - Sets the `Greater` flag if the result of the operation was greater than the other operand.
     - Sets the `Less` flag if the result of the operation was less than the other operand.
     - Sets the `Equal` flag if the result of the operation was equal to the other operand.
       > Learn how computers add numbers and build a 4 bit adder circuit
       >  - https://www.youtube.com/watch?v=wvJc9CZcvBc&list=WL

  - ### Control Unit — "The Traffic Light of the CPU" <a name="control-unit"></a>
    - ###### control-unit
    - ### BIG IDEA — The "Control Unit" is the part of the CPU that controls the "fetch-decode-execute" cycle.
    
    - The "Control Unit" is the part of the CPU that controls the "fetch-decode-execute" cycle.
    - It synchronizes the operations of the CPU with the RAM, ROM, and other parts of the computer.
    - It keeps track of the internal cpu-cycles for each instruction (different than clock cycles, as some operations 
      may take more than one clock cycle to complete.)
    - It updates the "program counter" with the next instruction to be executed, or with a different location in 
      memory if a `JUMP` instruction is executed.

  - ### Example Machine Language Program (Motorola 6502 CPU) <a name="example-machine-language-program"></a>
    ```
    Add 2 numbers and store the result in memory)
     
    Mnemonic   Opcode & Operand Hex Codes  // Explanation
    --------   --------------------------------    
    LDA #5     A905   // Load the value 5 into the "A" register, opcode: 0xA9 operand: 0x05.
    STA 0x0000 8D0000 // Store the value in the "A" register into memory location 0x0000, opcode: 0x8D operands: 0x00 0x00.
    LDA #7     A907   // Load the value 7 into the "A" register,  opcode: 0xA9 operand: 0x07.                                          
    STA 0x0001 8D0001 // Store the value in the "A" register into memory location 0x0001, opcode: 0x8D operands: 0x00 0x01.
    LDA 0x0000 A90000 // Load the value in memory location 0x0000 into the "A" register, opcode: 0xA9 operands: 0x00 0x00.                      
    ADC 0x0001 6D0001 // Add the value in memory location 0x0001 to the value in the "A" register, opcode: 0x6D operands: 0x00 0x01.
    STA 0x0002 8D0002 // Store the result of the addition into memory location 0x0002, opcode: 0x8D operands: 0x00 0x02.
    BRK        00     // Stops the CPU executing any more instructions, opcode: 0x00.
    ```
     
    // Memory state after the program has executed:
    0x0000: 0x05
    0x0001: 0x07
    0x0002: 0x0C      // <-- The result of the addition of 5 and 7 = 12, which is 0x0C in hexadecimal.
     
    // The result of the addition of 5 and 7 is 12, which is 0x0C in hexadecimal.
    ```
# Assembly Language - The First Human-Readable Language for Programming Computers <a name="assembly-language"></a>
###### assembly-language
  - ### BIG IDEA — Make the machine code easier for humans to read and write by using "mnemonics" to represent the opcodes instead of the actual hex values.
  
  - Assembly Language is a "human-readable" mnemonic representation of the "machine code" that the CPU can executes directly.
  - The mnemonics are translated into the binary opcodes by another program called an "Assembler."
  - The assembler converts and expands the mnemonics into the specific particular binary opcodes for each
    particular operation and arrangement of operands. It also calculates the memory addresses for the labels and
    variables in the program.
  - Assembly Language is the most "primitive" language that a human can reasonably use to program a computer in an efficient manner.
  - It's totally possible to program a computer using just "machine code" (the binary opcodes), but it's challenging and error-prone.
  - There is no "universal" assembly language, each CPU has it's own assembly language, so the assembly language is
    completely dependent on the specific CPU and is usually defined by the manufacturer of the CPU.
  - The complexity of the assembly language is usually directly related to the complexity of the CPU & the number of
    different operations that the CPU can perform in it's "instruction set" of opcodes.
  
    > How a CPU Works
    >  - https://www.youtube.com/watch?v=cNN_tTXABUA
  
    - ### Common Assembly Language Operations (Mnemonics representing Opcodes) <a name="common-assembly-operations"></a>
      - ###### common-assembly-operations
      >
      > - #### Jump  `JMP`
      >   - The "goto" statement of machine code.
      >   - Changes the program counter (PC) to point to a different location in memory.
      >   - Usually mnemonic `JMP [Label or Address]` where the operand is the label of the location in memory to jump to or a
      >     specific location in memory to jump to.
      >   - Also known a "branch" or "loop."
      >   - No limits to where the jump can go, it be anywhere in memory. If it's wrong, the machine will likely halt
      >     or do something unexpected, also called a "crash," "hang," "freeze," "fault," or "exception."
      > - #### Load `LDX`
      >   - Copies a value from a location in memory into a register (a tiny bit of memory that is part of the CPU)
      >   - Usually mnemonic `LDX [ADDR]` where X is the register to load into, and the operand is the location in memory to load from.
      >   - Also known as "fetch" or "read" or "get."
      > - #### Store `STX`
      >   - Copies a value from a register into a location in memory.
      >   - Usually mnemonic `STX [ADDR]` where X is the register to store from and the operand is the location in memory to store into.
      >   - Also known as "write" or "put."
      > - #### Move `MOV`
      >   - Copies a value from one register into another register.
      >   - Usually mnemonic `MOV X,Y` and an operand where X is the register to move from and Y is the register to move to.
      >   - Also known as "copy" or "transfer."
      > - #### Add `ADD`
      >   - Adds the values in two registers and stores the result in the Accumulator register.
      >   - Usually mnemonic `ADD`
      >   - Also known as "increment" or "plus."
      > - #### Subtract `SUB`
      >    - Subtracts the values in two registers and stores the result in a Accumulator register.
      >    - Usually mnemonic `SUB`
      >    - Also known as "decrement" or "minus."
      > - #### Compare `CMP`
      >   - Compares the values in two registers and updates the flag register with the result.
      >   - Usually mnemonic `CMP X,Y` and an operand where X is the register to compare with Y.
      >   - Also known as "test" or "equal."
      > - #### Conditional Jump `JNZ`
      >   - The `if` command of machine code, controls the flow of the program, branching execution to different
      >     locations in memory depending on the result of a previous operation.
      >   - Changes the program counter (PC) to point to a different location in memory based on the result of a previous operation.
      >   - The results of the previous operation is kept in an ALU (Arithmetic Logic Unit) "flag" register.
      >   - The `if` statement is the most important part of programming, it's the basis for all decision making.
      >   - Usually mnemonics:
      >       - `JNZ` (Jump if the register flag "Not Zero" is set.)
      >       - `JZ` (Jump if the register flag "Zero" is set.)
      >       - `JG` (Jump if the register flag "Greater" Flag is set.)
      >       - `JL` (Jump if the register flag "Less" is set.)
      >   - Also known as "branching" or "a conditional" or "loop."

  - ## Variables <a name="variables"></a>
    - ###### variables
    - ### BIG IDEA — "Variables" are just named memory locations used to store data, and easier for humans to remember and use.
    
    - "Variables" are just named values for memory locations used to store data.
        - Often called "fields," "attributes," "labels," or "properties."
    - The data is a representation of something else, like a number or a letter, or maybe a color, or an address
      for another location in memory.
    - Variables are a convenient way to give a name to a location in memory.
    - The assembler uses to the name of the variable to access the value of the variable, instead of the
      address of the variable in memory. This is much easier for humans to remember and use.
    - The naming is solely for the convenience of the human programmer, as the machine doesn't care what the variable is
      called or that it even has a name. This is just a way to reduce the complexity of the program for the people.

  - ## Subroutines <a name="subroutines"></a>
    - ###### subroutines
    ### BIG IDEA — Subroutines is an easier way to organize and reuse code, instead of a long list of instructions or `JMP` spaghetti code.
    
    - The `CALL` statement changes the program counter (PC) to point to a different location in memory.
    - The `RETURN` statement changes the program counter (PC) back to where it was before the `CALL` statement.
    - To start execution in a subroutine, the mnemonic `CALL [Label or Address]` is used.
        - Preserves the current state of the registers before jumping.
        - Pushes the current PC & Registers onto the stack, and then changes the PC to point to a different location in memory.
        - Execution continues until a "return" statement is executed.
    - To return execution of a subroutine back to the line after it was called, the mnemonic `RET` or `RETURN` is used.
    - Programmers use the phrase "call a function" to mean "set execution of next instruction to a location in memory
      where a function is stored."
    - The phrase "return from a function" to mean "set execution of next instruction to the location in memory where
      the function was called from."
    - Subroutines are the basis for all structured programming.

- [Continue Reading - High Level Languages](./06-HighLevelLanguages.md)
- [Back to Index](README.md)