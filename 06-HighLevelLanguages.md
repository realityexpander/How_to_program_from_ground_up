# High-Level Languages (1957-Present) <a name="high-level-languages"></a>
###### high-level-languages
  - ### BIG IDEA - English-like commands are easier for people to read and understand than cryptic assembly language.
  
  - High-level meaning more friendly to humans to work with, not necessarily more powerful or faster for the 
    computer to execute.
  - The first high-level languages were merely Assemblers that naively translated the mnemonics directy into machine 
    code for the CPU.
  - The next step was to create a language that was more "abstracted" meaning "general purpose" and "portable" 
    than assembly language, meaning source code from one machine could be run on another machine with a different CPU.
  - All languages, no matter how sophisticated, must eventually translated into machine code for a CPU to execute.
  - The High-level languages allowed for more widespread adoption of computers and programming, as the languages were 
    easier to learn and use than Assembly Language.
    
## Programming Styles <a name="programming-styles"></a>
###### programming-styles
  - The first programming styles were direct descedants of assembly language, and worked in the same way.
  - This way of working is generally referred to as "imperative" programming, as the programmer is giving the
    computer the exact set of steps to perform to solve a problem. There is another style of programming called
    "declarative" which we shall discuss later.

# Procedural Programming Style (1957-Present) <a name="procedural-programming"></a>
###### procedural-programming
  - ### BIG IDEA - Using `GOTOs` to jump around the program was an unscalable idea leading to unmaintainable code! We need to a better way!
  
  - Procedural code is executed top to bottom, one line at a time. 
  - Control flow is done with `IF` and `GOTO` statements.
  - `GOTO` was still commonly used to control flow of execution, as most people didn't know how to use 
    "subroutines" yet.
  - `GOTO` was easier to understand, at least first... (DUN, Dun, dun...)
  - This style of programming was extremely successful from 1957 to 1990's, and is still used today mostly in banking.
    > Computing and Computers - Batch Processing - BBC2 - 1980
    > - https://www.youtube.com/watch?v=fAselhq0Q8g
    
    > - Online playground to try these programs in Applesoft BASIC (1980's Apple IIe Beginner's All-purpose Symbolic Instruction Code)
    >   - https://www.calormen.com/jsbasic/
  - Some examples of Procedural languages are "Fortran" and "BASIC" and "COBOL."

  - ## Example of the Problem with Abusing the `GOTO` Command in Procedural Programming Style BASIC  <a name="abusing-goto"></a>
  - ###### abusing-goto
      ```Text
      5 REM PROGRAM TO ADD 2 NUMBERS, PRINT RESULT <-- "REM" is a "remark" or "comment"
      10 LET X = 10   <-- "LET" is a "statement" that assigns a value to a variable, all variables are global and mutable.
      20 LET Y = 32
      30 GOTO 100     <-- "GOTO" is a "statement" that changes the next line to execute to a different line.
      40 PRINT "Output: "; Z
      50 GOTO 150
      60 IF X = 10 THEN GOTO 190
      70 GOTO 10
      100 REM ADD 2 NUMBERS, RESULT IN Z  
      110 LET Z = X + Y   <-- All variables are global and mutable
      120 GOTO 40
      150 PRINT "THIS GOTO STUFF CAN GET CONFUSING"
      160 GOTO 60
      190 PRINT "HOW DID I GET HERE?"
      220 END
      
      RUN
      
      Output: 
      42
      THIS GOTO STUFF CAN GET CONFUSING
      HOW DID I GET HERE?
      
      ```
      - [Click for source code to copy and paste into the BASIC playground: `proceduralWithGoto.bas`](assets/proceduralWithGoto.bas)

  - ## Solution: The Painful Push for Subroutines & Some Structure <a name="solution-subroutines"></a>
    - ###### solution-subroutines
    - ### BIG IDEA - Reusable functions and procedures to avoid "spaghetti code" and enable working on teams. 
    
    - Programmers were eventually forced into using "subroutines" to deal with extreme overuse of `JUMP` and `GOTO`
      statements common to programming at that time which lead to extremely confusing, unreadable and unmaintainable
      "spaghetti code", so named because of the way the `GOTO` statements would jump around the program and get mixed
      up like a plate of spaghetti.
    - These subroutines are referred to "functions," "procedures," and "methods" in modern programming languages.
    - The "subroutines" are usually called and returned using a "stack" to keep track of where the program left off,
      instead of having to use `GOTO` statements
    - Variables were usually "global" and "mutable" which lead to "side effects" and hard to understand "state" of the program
    - Each program was very "linear," "sequential," "imperative," and not portable or reusable, which lead to a lot of waste
    - Data and Code were kept separate.
        - Code was loaded into the computer, and then data was separately loaded and processed in "batches"
    - ### Example of Procedural BASIC with Subroutines and `GOSUB`'s 
      - (the `GOSUB` command means `GO` to a "`SUB`routine"):
      ```Text
      5 REM PROGRAM TO ADD 2 NUMBERS, PRINT RESULT USING GOSUB
      10 LET X = 10
      20 LET Y = 32
      30 GOSUB 100
      40 PRINT "Output 1: "; Z
      50 LET X = 110
      70 GOSUB 100
      80 PRINT "Output 2: "; Z
      90 END
      100 REM ADD X + Y NUMBERS, RESULT IN Z  <-- This start of a "subroutine", REM is a "remark" or "comment" and is ignored by the program
      110 LET Z = X + Y 
      120 RETURN  <-- end of a "subroutine", return execution to the line after the "GOSUB" statement
      
      RUN
      
      Output 1: 42
      Output 2: 142
      
      ```
      - [Click for source code to copy and paste into the BASIC playground: `proceduralWithGosub.bas`](assets/proceduralWithGosub.bas)
  
  - ## Problem: Naive Solutions to Common Programmer Problems Lead to for High-Level Language Features <a name="naive-solutions"></a>
    - ###### naive-solutions
    - One problem with the low-level languages is that every programmer was left to their own creativity in how to
      structure their code, and this lead to a lot of "reinventing the wheel" and strange solutions that were hard to
      understand and maintain.
    - ### Example of a Common Naive Solution to Looping using `GOSUB` 
      - This approach is called an "unrolled loop", because each step is imperative and "unrolled" from the loop.
      - Interesting note: compilers will often "unroll" loops to make the code faster because it reduces the number of
        "conditional" statements that the CPU has to execute.
      ```Text
      5 REM PROGRAM TO DEMO "WITHOUT LOOPS" TO CREATE A CUMULATIVE ADDITION TABLE
      10 LET A = 1
      20 GOSUB 400
      30 PRINT A, B
      40 LET A = A + 1
      50 GOSUB 400
      60 PRINT A, B
      70 LET A = A + 1
      80 GOSUB 400
      90 PRINT A, B
      100 LET A = A + 1
      110 GOSUB 400
      120 PRINT A, B
      130 LET A = A + 1
      140 GOSUB 400
      150 PRINT A, B
      160 LET A = A + 1
      170 GOSUB 400
      180 PRINT A, B
      190 LET A = A + 1
      200 GOSUB 400
      210 PRINT A, B
      220 LET A = A + 1
      230 GOSUB 400
      240 PRINT A, B
      250 LET A = A + 1
      260 GOSUB 400
      270 PRINT A, B
      280 LET A = A + 1
      290 GOSUB 400
      300 PRINT A, B
      310 END
      400 REM ADD A PLUS B, RESULT IN B
      410 LET B = A + B
      420 RETURN
      
      RUN
      
      Output:
         1 1
         2 3
         3 6
         4 10
         5 15
         6 21
         7 28
         8 36
         9 45
         10 55
      
      ```
    - [Click for source code to copy and paste into the BASIC playground: `proceduralUnrolledLoops.bas`](assets/proceduralUnrolledLoops.bas)

  - ## Problem: Imperative "Looping" Style Leftover From Assembly Language <a name="problem-imperative-looping"></a>
    - ###### problem-imperative-looping
    - An example of common way of creating loops was to use `GOTO` and variables as indexes (also called "counters" or "iterators" or "loop variables")
    - In this case, its easy to see that the variable "A" is being used as an index to control the loop 
      that repeats the code between line 20 and 50, 10 times.
    - This is OK for small programs, but when programs become larger and more complex, it becomes more difficult to understand exactly what the 
      variables are used for, especially in a large program with many variables.
    - This style of programming is called "imperative" programming, as the programmer is giving the computer the exact set of steps to perform to solve a problem.
      ```Text
      5 REM PROGRAM TO DEMO "FOR LOOP" TO CREATE A CUMULATIVE ADDITION TABLE 
      10 LET A = 1
      20 GOSUB 100
      30 PRINT A, B
      40 LET A = A + 1
      50 IF A <= 10 THEN GOTO 20  <-- This is the "loop" that repeats the code between line 20 and 50, 10 times
      60 END
      100 REM ADD A PLUS B, RESULT IN B
      110 LET B = A + B
      120 RETURN
      
      RUN
       
      Output:
         1 1
         2 3
         3 6
         4 10
         5 15
         6 21
         7 28
         8 36
         9 45
         10 55
      ```
    - [Click for source code to copy and paste into the BASIC playground: `proceduralProgrammerMadeLoops.bas`](assets/proceduralProgrammerMadeLoops.bas)

  - ## Solution: Use High-Level Language Command (Like `FOR`,) to Create a "Standard" Loop instead of `GOTO` and `IF` <a name="solution-declarative-for-loop"></a>
    - ###### solution-declarative-for-loop
    - ### BIG IDEA - We can standardize common use-cases (like looping) into the language to reduce programming time, communicate intent of code to other people and minimize errors.
    
    - The `FOR` "loop" command was introduced to replace the programmer-implemented `GOTO` looping 
      implementations, as an attempt to make procedural code more structured and readable.
    - Now, when a programmer sees the `FOR` command, they know that a loop is being created, and they can 
      easily understand the structure of the loop, saving time and reducing errors.
    - Using `FOR` in this way is much easier to understand and maintain than the previous examples.
    - Using the language command `FOR` in this way is also called `declarative` programming, as the programmer is 
      declaring what they want to happen, rather than imperatively telling the computer what to do step by step.

    - ### Example using BASIC's `FOR` Loop
      ```Text
      5 REM PROGRAM TO DEMO "FOR LOOP" TO CREATE A CUMULATIVE ADDITION TABLE 
      10 FOR A = 1 TO 10 STEP 1  <-- The "FOR" statement changes the value of "A" from 1 to 10, incrementing by 1 at each NEXT statement
      15 GOSUB 100
      20 PRINT A, B
      30 NEXT A   <-- Execution continues at line after the "FOR" statement (15), unless "A" is 10, then it goes to next line (40) 
      40 END
      100 REM ADD A PLUS B, RESULT IN B
      110 LET B = A + B
      120 RETURN
      
      RUN
      
      Output:
         1 1
         2 3
         3 6
         4 10
         5 15
         6 21
         7 28
         8 36
         9 45
         10 55
      ```
    - [Click for source code to copy and paste into the BASIC playground: `proceduralWithForLoop.bas`](assets/proceduralWithForLoop.bas) 

- [Continue Reading - Software Design](./07-SoftwareDesign.md)
- [Back to Index](README.md)