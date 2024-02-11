# High-Level Language Styles

- ## Procedural Programming 1950s-Present (for amateurs, 1960s-1990s for professionals)
    - ### BIG IDEA - USE ENGLISH-LIKE COMMANDS instead of cryptic and tedious assembly language
    - First style of high-level language after assembly language
    - Considered "high level" because it was abstracted from the assembly language. The language was actually just
      another program that translated the "high level" language into "machine code" for the CPU, usually at runtime.
    - Examples of Procedural languages are "Fortran" and "BASIC" and "COBOL"
    - Procedural code is executed top to bottom, one line at a time. Control flow is done with "IF" and "GOTO" statements
    - GOTO was still commonly used, as most people didn't know how to use "subroutines" or "functions" yet and
    - GOTO was easier to understand, at least first.
      > - Online playground for BASIC to try these programs
      >   - https://www.calormen.com/jsbasic/

    - Example of Procedural-Oriented Programming with GOTO's in BASIC (Beginner's All-purpose Symbolic Instruction Code)
      ```Text
      5 REM PROGRAM TO ADD 2 NUMBERS, PRINT RESULT <-- "REM" is a "remark" or "comment"
      10 LET X = 10   <-- "LET" is a "statement" that assigns a value to a variable
      20 LET Y = 32
      30 GOTO 100     <-- "GOTO" is a "statement" that changes the next line to execute to a different line
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
        - [Click for source code to copy and paste into the BASIC playground](/assets/proceduralWithGoto.bas)

    - ### The Painful Push for Subroutines & Some Structure
        - BIG IDEA - REUSABLE FUNCTIONS instead of lots of GOTO's
        - Programmers were eventually forced into using "subroutines" to deal with extreme overuse of "JUMP/GOTO"
          statements common to programming at that time which lead to extremely confusing, unreadable and unmaintainable
          "spaghetti code", so named because of the way the "GOTO" statements would jump around the program and get mixed
          up like a plate of spaghetti.
        - These subroutines are referred to "functions," "procedures," and "methods" in modern programming languages.
        - The "subroutines" are usually called and returned using a "stack" to keep track of where the program left off,
          instead of having to use "GOTO" statements
        - Variables were usually "global" and "mutable" which lead to "side effects" and hard to understand "state" of the program
        - Each program was very "linear," "sequential," "imperative," and not portable or reusable, which lead to a lot of waste
        - Data and Code were kept separate.
            - Code was loaded into the computer, and then data was separately loaded and processed in "batches"
        - Example of Procedural BASIC with Subroutines and `GOSUB`'s (the `GOSUB` command is a `GOTO` a "SUBroutine"):
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
        - [Click for source code to copy and paste into the BASIC playground](/assets/proceduralWithGosub.bas)

    - Example without Loops (also called an "unrolled loop", because each step is imperative and "unrolled" from a loop)
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
        - [Click for source code to copy and paste into the BASIC playground](/assets/proceduralUnrolledLoops.bas)

    - #### Programmer Written "looping" Leftover From Assembly Language
        -  Example using programmer-made loops using GOTO's and Indexes (also called "counters" or "iterators" or "loop variables")
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
        - [Click for source code to copy and paste into the BASIC playground](/assets/proceduralProgrammerMadeLoops.bas)

    - ### Loops instead of GOTOs
        - BIG IDEA - The FOR "loop" statement was introduced to replace the "GOTO" statement, as an attempt to make procedural
          code more "structured."
        - The "loop" statement was used to repeat a block of code a certain number of times, or until a certain condition was met.

        - Example in BASIC:
          ```Text
          5 REM PROGRAM TO DEMO "FOR LOOP" TO CREATE A CUMULATIVE ADDITION TABLE 
          10 FOR A = 1 TO 10 STEP 1 <-- The "FOR" statement changes the value of "A" from 1 to 10, incrementing by 1 at each NEXT statement
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
        - [Click for source code to copy and paste into the BASIC playground](/assets/proceduralWithForLoop.bas) 