graph TD
    Y([Root Pointer]) -..->|root points to | A((("node A
    value=50")))
    A -->|left points to | B((("node B
 value=25")))
    A -->|right points to | C((("node C
 value=75")))
    B -->|left points to | D((("node D
 value=10")))
    B -->|right points to | E((("node E
 value=35")))
    C -->|left points to | F((("node F
 value=60")))
    C -->|right points to | I>NULL]
    E -->|left points to | H>NULL]
    E -->|right points to | G1((("node G
 value=39")))
    D -->|left points to | J1>NULL]
    D -->|right points to | K1>NULL]
    F -->|left points to | L1>NULL]
    F -->|right points to | M2>NULL]
    G1 -->|left points to | N2>NULL]
    G1 -->|right points to | O2>NULL]

    X["Example of a Binary Tree
       The Left node values are always
       less than the parent node.
       The Right node values are always
       greater than the parent node."]