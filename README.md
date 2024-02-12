# How to Program From The Ground Up with Minimal BS

- [Introduction](#introduction)
- [The Essence of Computing](2-TheEssentialQuestion-WhatAreWeComputing)
- [Hardware](3-Hardware.md)
  - Low Level Hardware Implementations
    - [The Wire & the Light Bulb & the Battery](3-Hardware#the-wire--the-battery)
    - [The Simple Switch](3-Hardware#the-simple-switch)
    - [The Magnificent Magnet](3-Hardware#the-magnificent-electromagnet)
    - [The Raucous Relay](3-Hardware#the-raucous-relay)
    - [The Voracious Vacuum Tube](3-Hardware#the-voracious-vacuum-tube)
    - [The Tiny Transistor](3-Hardware#the-tiny-transistor)
    - [The Interchangeable Integrated Chip (IC)](3-Hardware#the-interchangeable-integrated-chip-ic)
    - [The Mighty Microprocessor](3-Hardware#the-mighty-microprocessor)
- [Data Structures](4-DataStructures.md)
  - The Representations of Data in Memory
  - [Numbers](4-DataStructures.md#numbers) 
  - [Characters](4-DataStructures.md#characters)
  - [Array](4-DataStructures.md#array)
  - [String](4-DataStructures.md#string)
  - [Pointer](4-DataStructures.md#pointer)
  - ["Data Structures"](4-DataStructures.md#data-structures)
  - [Stack](4-DataStructures.md#stack)
  - [Queue](4-DataStructures.md#queue)
  - [Linked List](4-DataStructures.md#linked-list)
  - [Map](4-DataStructures.md#map)
  - [Tree](4-DataStructures.md#tree)
- [Software](5-Software.md)
  - [Machine Code](5-Software.md#machine-code)
  - 

## Introduction
  - How to guide for budding software engineers who need a primer overview of software development concepts 
    from the fundamentals of physical logic representation to high-level programming languages.
  - ### The goal is to understand more the "why" and "how" of programming, not just the "what" and "where."
    - This is my curated list of information to take you on a realistic and grounded journey of understanding
      the essential part of computing to create effective software.
    - There will be some technical details, but only enough to understand the fundamental principles, not to be an expert.
    - I cover the areas that I had difficulty understanding when I was learning to program.

  
  > I have since discovered that the majority of my confusion derived from how things were presented to me. 
  > Instructors often completely misunderstood correct application and limits of metaphors and lacked real-world 
  > experience of the things they were teaching. Many just repeated what they were taught without understanding.
  > When challenged about their knowledge, they would often become defensive and dismissive, and sometimes even hostile.
    
  > Many of the concepts are, in retrospect, full of needless jargon and unnecessary complexity. I now understand that
  > the complexity was often used to make the instructor seem more knowledgeable and to make the subject seem more
  > difficult than it actually is.
      
  > I would like to say at the outset that there is a TREMENDOUS number of technical-sounding words with all
  > referring to the same basic core ideas. I will do my best to be as consistent as possible, and also work to 
  > point out the multiple definitions and reduce the jargon and clarify the core meanings and ideas.

## The Essence of Computing
  - People used to do all computing by hand, and now we use various machines to do the same thing, 
    in a much faster and more reliable way.
    - When we use a machine to do computing, we are just using the machine to represent the problem and the 
      solution in a different way.
    - The machine knows nothing about the problem. it's only following orders created by clever humans using 
      boolean logic to represent the problem and its sequence of actions to solve it.
    - Each operation in the computer was once done by teams of people working in groups, logically delineated in 
      nearly the same way as the computer's components are arranged.
        - There were specialized roles for each person, for example, the "storage" would be a set of filing cabinets 
          and a clerk to store and retrieve them.
          - This is now done by the "hard drive" and the "file system" in the computer.
        - The arithmetic would be done by a person called a "calculator" who would perform the operations and record the results.
          - This is now done by the "Arithmetic Logic Unit" and stored in the "Registers" in the computer.

    ## SOME IMPORTANT ITEMS TO KEEP IN MIND
    - THERE IS NO MAGIC IN COMPUTING, ONLY _HUMAN_ CLEVERNESS, SYSTEMIC THINKING AND INGENUITY.
      - If you hear anyone say _"it's magic"_ or _"it's a black box"_ or _"it's kind of like a person,"_ 
        they are: 
        1) Being lazy, 
        2) indicating it's not relevant at the moment.
        3) (USUALLY) they don't understand the problem or the solution enough to explain it and get hand-wavy.
    - ### ITS ALWAYS JUST _HUMAN_ CLEVERNESS AND INGENUITY, REPRESENTING ONE THING AS ANOTHER, NOTHING MORE.
      - The machines will _NEVER_ understand the problem or the solution in the way humans conceive of the problem.
      - These machines are only following the logical operations that humans have carefully designed to represent 
        the problem and a solution "space." There is no inherent "understanding" in the machine, and can never be.
      - The only way the machine would ever know the full human context of the problem and the solution is if 
        the machine was a human, and then it would be a human, not a machine. 
      - Mistaking the machine for having intelligence is known as "The Eliza Effect."

[Continue Reading - The Essential Question](2-TheEssentialQuestion-WhatAreWeComputing.md)