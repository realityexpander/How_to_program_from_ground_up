# Conclusion

## Paradigms are Just Different Styles to Structure and Organize Software
  - The different paradigms are not better or worse than each other, they are just different styles to structure the
    state and behavior of software to provide a solution.
  - Different paradigms can be combined together to create a program that is easier to understand and maintain.
  - Paradigms are not frozen and are constantly evolving as new ideas are added to the software development
    methods to make creating software easier and more effective.
  - Each paradigm has their own trade-offs and costs that must be considered when
    choosing which paradigm is appropriate for a particular problem. Sometimes, the best solution is the simplest one.
  - Paradigms are not dogma, and should not be followed blindly, but should be used as a guide to help
    structure and organization the program to be easiest to understand and change.
  - Paradigms are not independent, and are often used together to create a program that is easier to
    understand and maintain.
 
## Programming Will Always Be a Human Activity - AI Cannot Solve Everything and Requires Human Guidance
  - Solution methods will become a bit more abstract in the future using tools like GitHub copilot, but the
    programmer will still need to know all these details to get the machine to do EXACTLY what they want it to do.
  - We are always going to need people who have various tastes and understandings about humans and the world to
    create software that is useful and effective FOR HUMANS.

## History Graph of Programming languages from This Document
  ```mermaid
    graph TB
        MachineLanguage[Machine Language] -->|human readable| AssemblyLanguage
        AssemblyLanguage[Assembly Language] -.->|for GOTOs|Basic
        AssemblyLanguage[Assembly Language] -->|Procedural|COBOL
        AssemblyLanguage[Assembly Language] -->|Procedural|Fortran
        AssemblyLanguage[Assembly Language] -->|Structured|Algol68
        AssemblyLanguage[Assembly Language] -->C
        COBOL["COBOL"] -->Basic
        Basic["BASIC"] ---> VisualBasic
        Fortran["Fortran"] -->Basic
        Algol68[Algol68] -.->|for Structure|C
        C["C"] -->Cplusplus
        Simula67 -->|for COP ideas|Cplusplus
        Cplusplus["C++"] -->|for COP/pseudo-OOP ideas|Java
        Smalltalk -.->|pilfered OOP term|Cplusplus
        Java[Java] -->Kotlin
        Java -->CSharp
        CSharp["C#"]
        Fortran -->Algol68
        Algol68 --->Smalltalk
        Smalltalk["Smalltalk
                  Originator of OOP term"] -->|for OOP ideas|Javascript
        Smalltalk -->|for OOP ideas|Ruby
        Basic -.-> |for Interpreted|Smalltalk
        AssemblyLanguage-.->|for self-changing @ runtime|Smalltalk
    
    Note["Conceptual Inheritance Graph of Selected Languages.
          
          Not Exhaustive, not to time scale."]
  ```

- [Back to Index](README.md)