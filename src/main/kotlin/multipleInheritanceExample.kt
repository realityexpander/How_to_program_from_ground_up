package org.example

// Multiple inheritance Example

interface Add1 {
   abstract val a: Int
   abstract val b: Int

   fun add(): Int {
      return a + b          // <-- different default implementations
   }
   
   fun subtract(): Int {
      return a - b
   }
}

interface Add2 {
   abstract val a: Int
   abstract val b: Int

   fun add(): Int {
      return a + a + b + b  // <-- different default implementations
   }
   
   fun subtract(): Int {
      return a - b - b
   }
}

interface Add3 {
   abstract val a: Int
   abstract val b: Int
   
   fun add(): Int {
      return a + a + a + b + b + b  // <-- different default implementations
   }
   
   fun subtract(): Int {
      return a - b - b - b
   }
}

class Calculator(
   override val a: Int = 0,  // <-- must override the properties for the interface to define the default values
   override val b: Int = 0   // <-- must override the properties for the interface to define the default values
) : Add1, Add2, Add3 {  // <-- Inherit("Subclass"/"Subtype"/"Derive") from three interfaces (multiple inheritance)

   // Must override `add` when there are 2 conflicting definitions in the interfaces
   override fun add(): Int {
      return super<Add1>.add()  // <-- call the desired implementation in Add1
   }
   
   // Must override `subtract` when there are 2 conflicting definitions in the interfaces
   override fun subtract(): Int {
      return super<Add3>.subtract()  // <-- call the desired implementation in Add3
   }
}

fun main() {
   val calc = Calculator(1, 2)
   println("sum=${calc.add()}")  // <-- 3
   
}
