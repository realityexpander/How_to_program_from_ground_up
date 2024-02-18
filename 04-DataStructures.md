# Data Structures
  - ### BIG IDEA — It's easier for humans to deal with names of ways to lay out representations of data in memory ("structures") than just hex code addresses.

    > ## "How something is arranged is 80 IQ points of the problem."
    > — Alan Kay

  - "Data structures" is the overall name for the various named concepts for common ways humans have invented to 
    represent data, and often predate modern computing.
  - They represent real world items and concepts in a way that a computer can be programmed to represent and solve a problem.
  - For example, a "list" is a common data structure for a series of "items" (or "elements") usually in a specific order.
    - A list can be used to represent a "orders to be shipped," "to-do items" or a "names and addresses to send a letter to."
    - Each item in the list is called an "element" or "item" or "member" of the list.
    - Items in lists can be accessed by their "index" which is a number that represents the position of the item in
      the list count from the beginning of the list.
  
    > - 100+ Computer Science Concepts Explained in less than 15 minutes
    >   - https://www.youtube.com/watch?v=-uleG_Vecis
    > - 10 Math Concepts for Programmers
    >   - https://www.youtube.com/watch?v=bOCHTHkBoAs

## Numbers or Individual Characters? Or something else? <a name="numbers"></a>
###### numbers
- ### BIG IDEA - Everything in a computer is represented as a series of "bits" (1s and 0s) in memory.

### Number (Integer or Floating Point)
  - Positive integers are represented as unsigned non-floating point numbers, ie: only positive whole numbers.
    - 1 byte (8 bits) can represent unsigned 0 to 255 (known as a `byte`, `octet`, `char`, `unsigned char` or `unsigned byte`)
    - 2 bytes (16 bits) can represent unsigned 0 to 65535 (known as a "short", sometimes "word" as number of bytes can vary by CPU architecture.)
    - 4 bytes (32 bits) can represent unsigned 0 to 4294967295 (known as an `int`, sometimes a `long`)
  - Negative integers are stored as "signed" binary using "2's Complement" representation.
    - They are "signed" because they can represent both positive and negative numbers ("negative sign" or "positive sign".)  
    - 2's Complement is the most common way to represent negative numbers in binary.
    - 2's Complement is a simple binary inversion with 1 extra step, or "complement" of the number ("flipping" the bits) and then adding 1.
    - 2's Complement is used to represent negative numbers in binary because it makes the addition and
      subtraction of numbers easier.
      > - Twos complement: Negative numbers in binary
      >   - https://www.youtube.com/watch?v=4qH4unVtJkE
    - 1 byte (8 bits) can represent signed -128 to 127
    - 2 bytes (16 bits) can represent signed -32768 to 32767
    - 4 bytes (32 bits) can represent signed -2147483648 to 2147483647
  - "Floating point" numbers are usually represented in standard "IEEE 754" format
    - Floating point is used to represent extremely large or extremely small values including fractional decimal values.
    - Floating point is so named because the "point" can "float" to represent very large or very small numbers
    - 4 bytes (32 bits) can represent a floating point number value from -3.4E38 to 3.4E38
    - 8 bytes (64 bits) can represent a double precision floating point number value from -1.7E308 to 1.7E308
    - Floating point numbers will use a "mantissa" and an "exponent" to represent the number in scientific notation
    - Due to the way floating point numbers are represented, they are not exact! And will have rounding errors!
      > - Why Is This Happening?! Floating Point Approximation!
      >   - https://www.youtube.com/watch?v=2gIxbTn7GSc
      > - https://eibx.com/interactive-visualization-of-floating-point-ieee-754/ 
      > - https://evanw.github.io/float-toy/ 
      > - https://bartaz.github.io/ieee754-visualization/
      > - https://tools.timodenk.com/ieee-754-floating-point
  
### Characters/Letters are usually represented in ASCII (1 byte) or Unicode(1 or more bytes) <a name="characters"></a>
###### characters
  - ### BIG IDEA - Characters are just numbers that represent letters and symbols.
  
  - ASCII is a 1 byte (8 bit) representation of the most common letters and symbols.
  - ASCII stands for "American Standard Code for Information Interchange" and was created in 1963.
  - Unicode is a 1 or more bytes representation of all the letters and symbols in all the world's languages.

### Need To Represent Something else?
  - ### BIG IDEA - Bits can represent anything!

    > Humans live in a representation of the world, not the world itself.
    > This is commonly referred to as "The Map is not the Territory" in philosophy and psychology.
    >> A BIG problem in computing is that giving metaphors for concepts is that people often confuse all aspects of the metaphor with the concept that were not included in the metaphor. 
    >> - For example, the "desktop" metaphor for a computer's "desktop" is not the same as a physical desktop. 
    >> - You can't take the pencil from the drawing app and start scribbling on the "desktop" like you can with a physical desktop.
    > ### Metaphors often break down when extended too far. 
    >> Therefore, it is important to know what is ACTUALLY happening, than just the metaphor of what is happening.
    >> - ie: There is no "numbers" or "letters" in memory, just a series of "bits" (1s and 0s) that represent numbers and letters.
    >> - There is no "add" or "subtract", its just a series of logical operations that represent "add" and "subtract" for us.
  
  - Numbers and Characters are the most common things to represent in memory, but anything can be represented in memory
  - Colors, Sounds, Images, Videos, Programs, Documents, etc.
  - Anything that can be represented as a series of values can be represented in memory.
  - For example, images are usually represented as a series of "pixels" or "picture elements" which are a series of
    "color values" that represent the red, green, and blue brightness levels when combined to create a color.
  - `01010101` could represents votes of 8 people, or 8 switch settings, or some kind of status for 8 different sensors.
  - The same eight bits can represent many different things, it's just a matter of how humans want to interpret the meaning of the bits.

# Common Data Structures Used In Programming <a name="data-structures"></a>
###### data-structures
  - ### BIG IDEA — Giving names to common ways of representing data in memory makes it easier for people to communicate with each other about what the data represents.
  
  - These various ways of representing things is called "type"
  - Types consist of the various representations of data in memory:
    - numbers.
    - characters (ASCII or Unicode.)
    - strings or even other arrays (multi-dimensional arrays.)
    - pointers (values representing _other_ locations in memory.)
    - Some languages allow functions to be represented as a type and passed around as a variable.
    - data structures (records, objects) made up of other types.
      > - Animated Interactive Visualizations with pseudocode for many common data structures
      >   - https://www.cs.usfca.edu/~galles/visualization/Algorithms.html

## Array (1D, 2D, 3D, etc.) <a name="array"></a>
###### array
  - ### BIG IDEA - Arrays are a way to represent a "list" of values in memory. Computers are really good at processing lists!
  
  - A way to represent a "list" of values in memory.
  - The values are usually all the same size & type & are all stored in a contiguous block of memory.
  - The values are usually accessed by an "index" which is a number that represents the position of the "thing" in the array.

  - 1D (One-Dimensional) Arrays
    - A single list of values in memory.

      [<img src="assets/arrays.png" width="350"/>]()

  - 2D (Two-Dimensional) Arrays
    - A list of lists of values in memory, or a "grid" of values.

      [<img src="assets/2d_arrays.png" width="350"/>]()

  > - 2D Array Representation in Computer Languages
  >   - Other computer languages may flip the order of rows and columns.
  >   - C is a "row-major" language, meaning the rows is the first index and the columns is the second index
  >   - Python is a "column-major" language, meaning the columns is the first index and the rows is the second index
  >>    [<img src="assets/2dArraysInC.png" width="450"/>]()
  >   - Yeah this not confusing at all!!!

## String (Array of Characters) <a name="string"></a>
###### string
  - ### BIG IDEA - Strings are just a way to represent a list of single letters (characters) in memory, "strung" together to represent words and sentences and paragraphs and documents.

  - A way to represent a list of single letters (characters) in memory, "strung" together to represent words and
    sentences and paragraphs and documents.
  - The characters are usually stored in a contiguous block of memory.
  - Characters are sometimes terminated by a special "end of string" character, or have a length stored somewhere.
  - Characters are usually accessed by an "index" which is just a number that represents the position of the
    "characters" in the string, sometimes called an "offset"
  - Strings are also interchangably called "substring", ie: "start" and "end" indexes, also known as a "slice" or "span"

    [<img src="assets/strings.png" width="350"/>]()


## Pointer <a name="pointer"></a>
###### pointer
  - ### BIG IDEA - A value that represents the "address" of another location in memory
  - A Pointer's value "points-to" the address of another location in memory.
  - Diagram:
    ``````
    - Address: Value 
    - 0x00000000: 0x00  // 0x00000000 is the address, 0x00000004 is the value of this pointer (little Endian)
    - 0x00000001: 0x00  
    - 0x00000002: 0x00
    - 0x00000003: 0x04  // This is a pointer's value is 0x00000004, so it's "pointing" to address 0x00000004
    - 0x00000004: 0x2A  // 0x00000004 is the address, 0x2A is ACII character '*' or the integer number 42

  - The pointer stored at 0x00000000 has the value 0x00000004, so it's pointing to address 0x00000004.
  - Address 0x00000004 contains the value 0x41, which represents the character 'A' or number 65 as an unsigned byte integer.
  - In this case, it's stored in "Little Endian" format, so the least significant bytes are stored first.
  - Pointers usually have a type associated with them, so the compiler knows how long the block of memory that
    the pointer is pointing to is, and how to interpret the values in that block of memory,
    ie: long int, char, float, struct, etc.
  - In the case of a "address pointer", it's usually 4-16 bytes long, depending on the number of bits in the CPU's
    "address bus" of the CPU.
    - example: 32-bit CPU can address 2^32 (4,294,967,296) different memory locations, or 4GB of memory, so each
      "address pointer" is 4 bytes long (32 bits)

    [Another pointer diagram](assets/pointer.png)
    ```mermaid
    graph TD
    A[Address 0x00000000 has value 0x00000004] -->|"
       pointer at 0x00000000 
       points to 
       address 0x00000004
       🟩 0x00000000 ➡️ 0x00000004
       "| B["
         Address 0x00000004 has value 0x2A 
         Integer 42 or ASCII “*”
         🟩 ➡️ 42 or *️⃣
       "]
  
    note["`
      The pointer stored at **0x00000000** has a value _0x00000004_, 
      so it is pointing to address **0x00000004**.
    
      Said another way:
      The pointer at 0x00000000 is pointing to value 0x2A, 
      which is 42 
      or the ASCII asterisk character *
      🟩 ➡️ 42 or *️⃣
    `"]
    ```

## "Data Structures" or just "Structures" <a name="data-structures"></a>
###### data-structures
  - ### BIG IDEA - We can represent anything in memory as a "structured" list of more basic types.
  
  - Also known as "Records," "Data Classes," "Data Objects," "Data Types," "Data Models," or "Data Entities"
    - also called as "structs", sometimes referred to as "Classes" and "Objects"
    - Data to humans is _very important_, so we have given lots of different names to the same basic idea.
    - meaning it has a standard format of possibly mixed "types" representing a cohesive "thing" (sometimes called "shape" or "form")
  - The "structure" can represent anything
    - like a person, a car, a house, a company, a country, a planet, a solar system
    - Keep in mind, it's just a representation, not an actual thing and can only track the representative data
    - Programmers will often refer to the representation as the "thing" itself, which can lead to confusion and errors.
    - The classic Computer Science GI-GO (Garbage In, Garbage Out) problem.
      - The solution can only ever be as good as the data and the metaphorically representational model of the problem.
      - Creating useful models of the real world is the most important part of programming, and the most difficult.
  - The structure is usually made up of a list of "fields" which are the individual pieces of data that make up the structure.
  - Fields are also called "properties", "attributes", "members", and sometimes "elements"
  - The fields are usually accessed by a name which is the human-readable label for the field
  - The fields of a strcuture are usually stored in a contiguous block of memory, but not always.
  - The fields can be of different types (like numbers, letters, strings, dates, times, arrays, and other
    programmer-defined data structures.)

  - Example of a "Person" Data Structure (in C)
    ```C
    struct Person {
        char name[32];  // 32 characters to represent the name
        int age;        // 4 bytes to represent the age as an integer (not decimal or fraction)
        float height;   // 4 bytes to represent the height as a floating point number (decimal)
        float weight;   // 4 bytes to represent the weight as a floating point number (decimal)
    };
     ```

## Stack <a name="stack"></a>
###### stack
  - ### BIG IDEA - A way to represent a "last in, first out" list of things in memory, similar to a stack of dinner plates.
  
  - Stacks of values are useful in sorting and searching algorithms, and lots of other algorithms.
  - The values are always the same size & type and usually stored in a contiguous block of memory, but not always.
  - The values are usually accessed by a "stack pointer" which is a number that represents the position of the
    top-most value in the stack, as a memory address or an index.
  - Efficient for adding and removing items from the list, but not efficient for accessing items in the list

    [<img src="assets/stack.png" width="450"/>]()
    > - Quick Animation of a Stack
    >   - https://www.youtube.com/watch?v=5JQxVmQFFHE
    > - Stack Data Structure Animation
    >   - https://www.youtube.com/watch?v=toRJakeYIKA

## Queue <a name="queue"></a>
###### queue
  - ### BIG IDEA - A way to represent a "first in, first out" list of values in memory, similar to a line of people waiting for a bank.
 
  - Queues of values are useful in many areas of computing, like "job queues" in operating systems, and "message queues" in networking.
  - The values are all the same type and usually stored in a contiguous block of memory, but not always. Sometimes
    a Queue is stored as a "linked list" instead of an Array. (next section)
  - The values are usually accessed by a "head" and "tail" which are numbers that represent the position of the first
    and last value in the queue as a memory address or an index.
  - Efficient for adding and removing items from the list, but not efficient for accessing items in the list
    
    ![Another Queue Image](assets/queue.png)
    > - Queue Data Structure Animation
    >   - https://www.youtube.com/watch?v=ojGf3SH7n48

## Linked List <a name="linked-list"></a>
###### linked-list
 - ### BIG IDEA - A way to represent a "dynamic" list of values in memory, where the size of the list is not known ahead of time and may change over time.
 
  - Lists of changing size are useful to organize many areas of computing, like file systems and databases.
  - A data structure to represent a list of values in memory, each value is the same size & type.
  - Each value in the list is stored in a "node", where each node contains a value and a pointer that points
    ONLY to the _next_ node in the Linked List
  - The nodes are NOT stored in a contiguous block of memory, which is the main difference between an Array and a Linked List
  - The values are usually accessed by a pointer which is a number that represents the location of the node in memory
  - A Linked List is used to represent a "dynamic" list, where the size of the list is not known ahead of time and
    may change over time.
  - Efficient for adding and removing items from the list, but not efficient for searching for items in the list.
  - [Another linked List image](assets/linkedList.png)
    ```mermaid
    graph TD
    HEAD>"HEAD= Pointer to the first node of the list"] -->|points to | A[A= some data and a pointer to node B]
    A -->|points to |B[B= some data and a pointer to node C]
    B -->|points to | C[C= some data and a pointer to node D]
    C -->|points to | D[D= some data and a pointer to node E ]
    D -->|points to | E["E= some data and a pointer to ‟NULL” (the end of the list)"]
    E -->|points to | NULL>"NULL= pointer to ‟nothing” (0), meaning the end of list."]
    TAIL>"TAIL= pointer to the last node in the list"] -->|points to | E

## Map (or "Hash Table", "Hash Map", "Dictionary", "Associative Array") <a name="map"></a>
###### map
  - ### BIG IDEA - A way to represent a "mapping" of "keys" to "values" in memory, where each "key" is unique and "points to" a specific "value".
  
  - Mapping is very common in computers, like looking up a person's number in a phone book, or looking up a word in a dictionary.
  - A "Map" is a data structure to represent a "mapping" of "keys" to values.
  - A "key" is a value that represents the label to "look-up" another value.
    - This is called "mapping" or "associating" the key with a specific value.
    - example using JSON (JavaScript Object Notation) data format:
      ```JSON
      {
        "jim001": {"name": "John", "age": 42, "height": 6.2, "weight": 180},
        "chris123": {"name": "Chris", "age": 32, "height": 5.8, "weight": 160},
        "grg88922": {"name": "George", "age": 22, "height": 5.5, "weight": 140},
        "udu19fz": {"name": "Jeremy", "age": 19, "height": 5.9, "weight": 150}
      }
      ```
    - `jim001` is the key, and its value is `{"name": "John", "age": 42, "height": 6.2, "weight": 180}`
    - `chris123` is the key, and its value is `{"name": "Chris", "age": 32, "height": 5.8, "weight": 160}`
    - `grg88922` is the key, and its value is `{"name": "George", "age": 22, "height": 5.5, "weight": 140}`
    - `udu19fz` is the key, and its value is `{"name": "Jeremy", "age": 19, "height": 5.9, "weight": 150}`
  - The values are normally all the same type are always accessed by a unique "key" instead of an "index".
  - The keys are always unique, meaning that no two keys can be the same value.
      - There can be no duplicate keys.
      - The values the keys are associated with can be the same, meaning 2 different keys can point to the same value.
  - The key type is usually a string, but it can be any type, like another data structure or a simple number.
      - The map uses a special "hash function" to convert the key into a number that represents the location of the
        value in memory.
      - This hash function simply takes all the data for the value the key represents and converts it into a single
        number (called the "hash") that represents the location of the value in memory.
  - Used to represent a "key-value" list, where each "thing" is accessed by a "key" instead of an "index"
  - Efficient for adding and removing items from the list, and efficient for accessing items in the list
  - [Another map diagram](assets/Map.png)
    > - Hash tables in 4 minutes
    >   - https://www.youtube.com/watch?v=knV86FlSXJ8
    > - Implementation details of a Map (An implementation of a Hash Map)
    >   - https://www.youtube.com/watch?v=9zqGQQly0To

    ```mermaid
      graph LR
         key1[key1] -->|maps to / refers to / points to| id1[Value X]
         key2[key2] -->|maps to / refers to / points to| id2[Value Y]
          key3[key3] -->|maps to / refers to / points to| id3[Value Z]
    ``` 
## Tree <a name="tree"></a>
###### tree
  - ### BIG IDEA - A way to represent a "hierarchical" list of nodes in memory, where each node contains a values and "points to" one or MORE other nodes that are direct descendants of the node.
  
  - Trees are used to represent a "hierarchical" list, like a sorted list of items, or a company organization chart.
  - Trees keep track of list of nodes in memory, where each node contains a values and 
    "points to" one or MORE other nodes that are direct descendants of the node.
    - The descendants are called "children" and the node is called the parent, and the parent is also a child of another node.
    - The "root" is the top-most node in the tree, and has no parent.
    - If there are 2 children, it's called a "binary tree", if there are 3 children, it's called a "ternary tree", 
      and so on.
  - The values are the same size & type and are NOT stored in a contiguous block of memory.
  - The values are accessed by starting with a reference to the root node, which is then used to "traverse" 
    (visit nodes) the tree to find the matching value.
  - A Tree is used to represent a "hierarchical" list, like a sorted list of items, or a company organization chart.
  - Special Case of a tree is a "Binary Tree" where each node only points to only two and only 2 nodes in the tree.
  - Binary Trees are often used to represent sorted lists, where each node is greater than the node to the left, 
    and less than the node to the right.
  - Pointing to a null node is called a "leaf" node, and is the end of the tree.

    ```mermaid
    graph TD
    N((("
      A ⚪️ Node contains: 
      A Value (of some type),
      1 pointer to its left node 🔴⇦, 
      1 pointer to its right node ⇨🟣
    "))) -->|left pointer points to| N1((("
      Another Node
      🔴
      ⇦⇨"))) 
    N -->|right pointer points to| N2((("
      Another Node
      🟣
      ⇦⇨")))
    
    X[Example of a Node for a Binary Tree]
    ```
- [Another tree diagram](assets/tree.png)
  > - Tree Data Structure Summary
  >   - https://www.youtube.com/watch?v=2gu3ACsq2jI

  ## 🚫🔄 Notice: no cycles or loops in the graph 
    ```mermaid
      graph TD
      Y([Root Pointer]) -..->|root points to start of tree | A((("node A 
      value=50
      ⇦⇨")))
      A -->|left points to | B((("node B
   value=25
      ⇦⇨")))
      A -->|right points to | C((("node C
   value=75
      ⇦⇨")))
      B -->|left points to | D((("node D
   value=10
      ⇦⇨")))
      B -->|right points to | E((("node E
   value=35
      ⇦⇨")))
      C -->|left points to | F((("node F
   value=60
      ⇦⇨")))
      C -->|right points to | I>NULL]
      E -->|left points to | H>NULL]
      E -->|right points to | G1((("node G
   value=39
      ⇦⇨")))
      D -->|left points to | J1>NULL]
      D -->|right points to | K1>NULL]
      F -->|left points to | L1>NULL]
      F -->|right points to | M2>NULL]
      G1 -->|left points to | N2>NULL]
      G1 -->|right points to | O2>NULL]
      
      X["Example of a Binary Tree
         The Left ⇦ node values are always
         less than the parent node.
         The Right ⇨ node values are always
         greater than the parent node.
  
         (also known as a Directed Acyclic Graph 
         because it has not cycles or loops in the graph.)
         🚫🔄
  "]
    ```

## Graph <a name="graph"></a>
###### graph
  - ### BIG IDEA - A way to represent a "network" of nodes in memory, where each node contains a value and "points to" one or MORE other nodes that are NOT necessarily direct descendants of the node.
  
  - Graphs are used to represent a "network" of nodes, like a social network, or a map of roads.
  - Graphs can have loops and don'd necessarily have a "root" node.
  - Graphs keep track of list of nodes in memory, where each node contains a value and 
    "points to" one or MORE other nodes that are not necessarily direct descendant like in Trees.
    - The descendants are also called "neighbors".
    - If there are 2 children, it's called a "binary tree", if there are 3 children, it's called a "ternary tree", 
      and so on. 
    - Trees are a special case of a graph which have no "cycles" or "loops" in the graph.
    - "Binary Tree" usually indicates that the contents are in a sorted order, where each node's value is greater than the value of it's node on the left, and less than the node to it's right.
    - "Directed Acyclic Graphs" are also a kind of tree where each node points to one or more sub-nodes, but there are no "cycles" or "loops" in the graph.
  - The node values are the same size & type and are NOT stored in a contiguous block of memory.
  - The values are accessed by starting with a reference to the root node, which is then used to "traverse" 
    (visit nodes) the tree to find the matching values, using "search" algorithms like "Dijkstra's Path Search Algorithm" or "A* Search Algorithm."
  - A Graph is used to represent a "network" of nodes, like a social network, or a map of roads.
  - A node that does not pointing to any other node is called a "leaf" or "terminal" node.
  - A node that is not pointed to by any other node is called an "orphan" node.

    ```mermaid
    graph TD
    A((("
      A 🟣 Node contains: 
      A Value (of some type),
      Zero to many pointers to other nodes
      1 pointer to its B node ⇨🟣
      1 pointer to its C node ⇨🟣
      1 pointer to its D node ⇨🟣
      1 pointer to its E node ⇨🟣 
    "))) -->|1 pointer points to| B((("
      B Node
      🟣
      ⇦⇨"))) 
    A -->|1 pointer points to| C((("
      C Node
      🟣
      ⇦⇨")))
    A -->|1 pointer points to| D((("
        D Node
        🟣
        ⇦⇨")))
    A --->|1 pointer points to| E((("
        E Node
        🟣
        ⇦⇨")))
    D -->|1 pointer points to| C((("
        C Node
        🟣
        ⇦⇨")))
    E --> B((("
        B Node
        🟣
        ⇦⇨")))
    F((("
      F Node
      🟣
      ⇦⇨"))) --> C
    G((("
        G Node
        🟣
        ⇦⇨"))) --> B
    F ---> D
    H((("
        H Node
        🟣
        ⇦⇨"))) ---> B
    H --> C
    B --> C
    B --> G
    H --> G
    F --> C
    
    X["⬅️ Example of a Node for a Network Graph"]

- [Continue Reading - Software](./05-Software.md)
- [Back to Index](README.md)