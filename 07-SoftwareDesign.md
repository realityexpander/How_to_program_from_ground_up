# Software Design

  - ### BIG IDEA — How do we talk about these things with other people efficiently and effectively?

## Algorithms - How are we gonna solve this? <a name="algorithms"></a>
###### algorithms
  - ### BiG IDEA - Let's give names to the clever ways we humans have found to solve problems.

  - Algorithms are just a set of instructions that are used to solve a problem or perform a task, all based on the
    cleverness and creativity of the designer. People have invented many ways to solve problems, and some of these
    are so common that they have been given names, like "sorting" and "searching" algorithms.
    > - Binary Search Algorithm - Code walk-through and Complexity Analysis
    >   - https://www.youtube.com/watch?v=LdjkZ2vQapI
    > - Animated Interactive Visualizations with pseudocode for many common data structures
    >   - https://www.cs.usfca.edu/~galles/visualization/Algorithms.html
    > - Quick Sort [Visual Explanation] 
    >   - https://www.youtube.com/watch?v=WprjBK0p6rw
    > - 15 Sorting Algorithms in 6 Minutes
    >   - https://www.youtube.com/watch?v=kPRA0W1kECg
    > - Sorting Algorithms Explained Visually
    >   - https://www.youtube.com/watch?v=RfXt_qHDEPw

## Time Complexity - How long is this gonna take? <a name="time-complexity"></a>
##### time-complexity
  - ### BiG IDEA — Let's have a standard way to communicate about how long an algorithm or program will take to execute.
  
  - The "time complexity" of a program is a measure of how the "running time" of the program grows as the "input size"
    of the program grows.
  - Also known as "Algorithmic Complexity" or "Big O notation"
  - The "time complexity" is usually expressed as a "big O" notation, which is a way to express the "upper bound" of
    the "running time" of the program, ie: the worst case scenario.
  - The "big O" notation is a way to express the "upper bound" or maximum expected of the worst-case running time of a program.
  - 6 Common Types of Time Complexity:
      - O(1) - "Constant Time" - The running time of the program does not change as the input size of the program grows.
      - O(n) - "Linear Time" - The running time of the program grows as the input size of the program.
      - O(n^2) - "Quadratic Time" - The running time of the program grows as the square of the input size of the program.
      - O(n^3) - "Cubic Time" - The running time of the program grows as the cube of the input size of the program.
      - O(log n) - "Logarithmic Time" - The running time of the program grows as the logarithm of the input size of the program.
      - O(n log n) - "Linearithmic Time" - The running time of the program grows as the product of the input size of the program and the logarithm of the input size of the program.
        
        [<img src="assets/bigo.png" width="350"/>](https://www.youtube.com/watch?v=XMUe3zFhM5c)
    
        > - Learn Big O notation in 6 minutes 📈
        >   - https://www.youtube.com/watch?v=XMUe3zFhM5c
  
  - ### Shorthand Guide & Sample Code <a name="time-complexity-example"></a>
    - ###### time-complexity-example
    - If you are doing a simple lookup in an array, it's O(1) because the time it takes to find the value in the array
      does not change as the size of the array grows.
    - If you are looping over items, it's O(n) because the time it takes to loop over the items grows as the size of the
      array grows.
    - If you are looping over items that are also looping over items, it's O(n^2) because the time it takes to loop over
      the items grows as the square of the size of the array grows.
    - Each time you add another loop, the time complexity grows as the square of the size of the array grows.
    - If you are doing a binary search, and each time you search you are cutting the size of the array in half,
      it's O(log n)
 
      ```Kotlin
      // Program in Kotlin to illustrate the time complexity of various operations
      
      // Algorithm: Binary Search
      // Perform binary search a sorted array - O(log n)
      // Returns the index of the value in the array, or -1 if the value is not found.
      fun Array<Int>.binarySearch(value: Int): Int {
          var low = 0
          var high = size - 1
          while (low <= high) {
              val mid = (low + high) / 2  // search 1/2 of the array each loop
              val midVal = this[mid]
              when {
                  midVal < value -> return low = mid + 1
                  midVal > value -> return high = mid - 1
                  else -> return mid
              }
          }
          
          return -1 // -1 = value not found
      }
      
      fun randomInt(max: Int): Int = (0..max).random() // <-- O(1) - Simple Lookup
      
      // Algorithm: Quick Sort
      // Perform recursive quicksort - O(n log n)
      // Returns a new sorted array.
      fun Array<Int>.quickSort(): Array<Int> {
          if (size < 2) return this
          val pivot = this[randomInt(size - 1)]
          
          val less = filter { it < pivot }.toTypedArray().quickSort() // recursive call
          val equal = filter { it == pivot }.toTypedArray()
          val greater = filter { it > pivot }.toTypedArray().quickSort() // recursive call
          
          return less + equal + greater
      }
      
    
      // Start of the program
      fun main() {
         val x: Array<Int> = Array(100) { randomInt(100) } // <-- O(n) - Fill Array `x` with 100 random integers
         
         val a: Int = x[50] // <-- O(1) - Simple Lookup
         
         for (i in 0 until x.size) { // <-- O(n) - Single Loop over items 1 time
             println(x[i])
         }
         
         for (i in 0 until x.size) { // <-- O(n^2) - Double Loop over items (squared)
             for (j in 0 until x.size) { // <-- O(n) 
                 println(x[i] + x[j])
             }
         }
         
         // Notice this one will take MUCH, MUCH longer than the previous ones.
         for (i in 0 until x.size) { // <-- O(n^3)- Triple Loop over items (cubed)
             for (j in 0 until x.size) { // <-- O(n^2)
                 for (k in 0 until x.size) { // <-- O(n) 
                     println(x[i] + x[j] + x[k])
                 }
             }
         }
         
         val sorted: Array<Int> = x.quickSort() // <-- O(n log n) - Fastest known sorting algorithm for general case.
         val y = sorted.binarySearch(50) // <-- O(log n) - Searches a sorted array for a value, halving the search space each loop.
      }
      
      // << NO OUTPUT - Just code illustrating the time complexity of the operations >> 
      // << - Run the live code example to generate output >>
      ```
        > Live Code Example: [Time Complexity Example](src/main/kotlin/timeComplexityExample.kt)

## Communicating Software Designs Visually <a name="communicating-software-designs"></a>
##### communicating-software-designs
  - ### BIG IDEA — How can we use drawings and diagrams to visually communicate about software designs? 
  
  - ### The Line, The Box and The Conceptual Layers
    - At the time when structured programming became popular, ideas around "Software Design" were developed to help
      people create more complex software systems with increasingly more complex requirements and coordinating work 
      with larger teams of people working together a shared codebase.
    > - Software Design: Ep1 : 1st law of Software Design (The Box)
    >   - https://www.youtube.com/watch?v=2icF3vvsxH8
    > - Software Design: Ep2 : 2nd Law of Software Design (The Line)
    >   - https://www.youtube.com/watch?v=fh1a74WWvJQ
    > - Software Design: Ep3 : Conceptual Layers 
    >   - https://www.youtube.com/watch?v=8R7hoC3OuPo
    > - Software Design: Ep4 : 3rd Law of Software Design 
    >   - https://www.youtube.com/watch?v=nCxhJ_51fjA
    > - Kevlin Henney — The Case for Technical Excellence
    >   - https://www.youtube.com/watch?v=LLEXAdO3X1o

## Some Thoughts on Common Software Production Methodologies
##### some-thoughts-on-common-software-production-methodologies
  - ### BIG IDEA — Are there ways to organize the work of discovering solutions and designing software that are better than others?
  
  - ### Agile
    - Great start, good and useful concepts, but... 
    - Widely misunderstood, misapplied, and soon co-opted into "Agile©®™ Certification©®™ Business."
  
  - ### Scrum
    - Can we use what worked in Japanese car production with Japanese culture to have the same success in software development? Nope.
    - Scrum is a "production management" methodology that was developed for managing the production of cars, and it
      was soon co-opted into the _"Agile® Certification Business"_ and turned into a "one-size-fits-all" process that was
      supposed to work for any kind of general software development, and it doesn't.
  
  - ### SAFe 
    - Another over-complicated process that tries to "productionize" the software development process.
    - It's a "one-size-fits-all" process that was supposed to work for all kinds of software development, and it doesn't.
  
  - ### Waterfall 
    - Was never a thing, it was a straw-man argument. Winston Royce, the creator the term "Waterfall," made it 
      clear on **page 2** of his famous 1970 paper _"Managing the Development of Large Software Systems"_ that he was not advocating
      for the "Waterfall" process, but was trying to make a point about how software development was being managed like
      a manufacturing process, and it is a **_counter-productive way to manage the knowledge work._**
      > It's Time For Waterfall To DIE
      > - https://www.youtube.com/watch?v=o3jDLVCpH1E
      - Managers never read the second page, and took it as a "best practice". _Poor Winston Royce._
        - Note to self: _Always read the second page, or put the most important information on the first page._ 
  
  - ## I call all of the above (and similar books and conferences) the **"Age of Conference©®™ Driven Development"**
    - The problems around planning and organizing ever-larger teams, and increasingly complex problems became so onerous
      that many people looked far and wide for _ANY_ solution to gain a foothold on the process and make it more
      predictable and manageable. Unfotunately, knowledge work is FUNDAMENTALLY risky and not possible to plan
      because its a process of DISCOVERY, not a process of manufacturing. 
    - The biggest risk to manage in software development is that we may **NEVER** find a workable solution in
      the time allotted._ This is not changeable. It's a fundamental ground-level understanding of knowledge work.
    - ### Dealing with the principal risks involved with knowledge work is the core problem in planning software development.

  - ## The Problem with Applying "Production Management" Methodologies to Software Development Knowledge Work
    - The main issues with all these approaches is that they assume that software development is just another
        manufacturing process, and that the people who are doing the work are just another kind of "resource" that
        can be managed like a replaceable manufactuing worker on an assembly line.
      - Software development is fundamentally knowledge work and a process of discovery. The people who are doing
        the work are not interchangeable cogs but "knowledge workers" who are doing creative work that requires a lot of
        thinking and discussion and failed attempts before success, and does not have predictable outcomes.
      - The "Agile Manifesto" was written to address this problem, and to help people understand that software development
        is a fundamentally different kind of work than manufacturing, and that the people who are doing the work are
        fundamentally different kinds of workers than the people who work in manufacturing. This was a good thing.
      - The problem is that the Agile movement was soon co-opted into the "Agile® Certification Business" and turned
        into a "one-size-fits-all" process that was supposed to work for all kinds of software development, and it
        doesn't. It's a cargo cult that doesn't work for most teams, as most teams implement the "rules" directly without
        understanding the "spirit" of the rules, which there are no rules... just some values:
    
      - ### The 4 Values of the Agile Manifesto
        - The Agile Manifesto was written to address the problem of trying to manage software development like a manufacturing
          process, and to help people understand that software development is fundamentally different than manufacturing.
        - The 4 Values of the Agile Manifesto are:
          1. Individuals and interactions over processes and tools.
          2. Working software over comprehensive documentation.
          3. Customer collaboration over contract negotiation.
          4. Responding to change over following a plan.
           
        - #### While we value the items on the right, we value the items on the left more.
      
      - ### The fundamental idea of Agile is "RESPONDING to CHANGE."  
        - How can we make software development more flexible and faster to respond to changes and refinements in the
          requirements of software?
        - Cumbersome processes allow managers to "monitor" using charts and graphs is a standard way for businesses
          to manage risk in a manufacturing environment, but it's not a good way to manage risk for knowledge work.
        - Agile was a response to the progression towards more and more cumbersome processes that were driving projects
          to a standstill. It was a way to get back to the "heart" of software development, which is "respond to change."
        - It's primary result is working in much smaller steps, and being able to change direction quickly and easily
          based on what is discovered taking those small steps.
        - Each small step creates some kind of "valuable working software" that can be shown to the customer, and the 
          customer can then give feedback on the working software, and the software can be changed based on that feedback.
          > ### Key finding of the Agile Manifesto 
          > - Humans rarely know what they want UNTIL they experience what they _don't_ want, the solution is to work 
              iteratively and get feedback often, integrate that feedback to make sure we are building the best 
              _known_ solution at the time.

- [Continue Reading - Class Oriented Programming](./09-ClassOrientedProgramming.md)
- [Back to Index](README.md)
