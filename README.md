# Generic Class Overview - Abstract Mathematics

Computer science engineers/developers spend a significant amount of their time learning new domains.  Organizations often need frameworks created around domains outside computer science. 
- Investment banks need implementations that align with local, state, and federal regulations.
- Sportsbook betting platforms need integrations with standardized casino accounts and online wallets.
- DoD contractors often need to implement protocols that are very unique to the application.
- Software drivers need to be created that allow hardware devices (networking equipment, robots, cars, etc) to be integrated to online environments for control and configurations.

Software engineers and developers spend much more time collaborating about framework/protocol approaches than actually writing code. As such, a significant amount of time is spent learning the specifics about an application/domain to create tools that experts in the domain will use. 

## Abstract Mathematics

Abstract mathematics often describes the behavior and properties associated with very high level mathematical objects that can be applied to countless concrete implementations.  This project will require you to come up to speed with a few abstract mathematical objects.  You will be creating objects in code, possibly highly recursive with respect to types, that will allow arbitrary flexibility in utililization using `Generic` classes. 

### Overview of Mathematical Objects

Let's take a look at the objects you will be creating.

- Magma - A magma is simply a set $S$ and a binary operation with the following properties.
   - clousure -  $a+b \in S$ for all $a,b \in S$
- SemiGroup - A semigroup is a magma that has is associative.
- Monoid - A monoid is a semigroup that has an identity element $e$.
   - $a + e = a$ for all $a \in S$.
- Group - a group is a monoid where every element has an inverse.
- Abelian Group - an abelian group is a group that is commutative.
- Ring - a ring is a set with two operations $+$ and $\cdot$ with the following properties.
  - Under $+$ the elements form an abelian group.
  - The operation $\cdot$ is
    - closed
    - associative
    - distributes over $+$.
  - $a \cdot e = e$ for all $a \in S$ and $e$ is the additive identity (behaves like zero)
- Identity Ring - a ring with a multiplicative identity ($a \cdot 1 = a$ for all $a \in S$)
- Field - A field is a ring and all elements (except additive identity) has a multiplicative inverse

To reduce complexity, the objects above are abstract generalizations for arithmetic.

- Magmas represent when you learned to add.
- Monoid represents when you learned about zero.
- Group is where you learned how to subtract (additive inverses)
- Ring is where you learned to add, subtract, and multiply
- Field is where you learned to add, subtract, multiply, and divide

## Structures

Notice that when you multiply two polynomials you need to multiply coefficients and then combine like terms requires adding.
Notice that when you multiply two matrices you need to calculate dot products that require addition and multiplication.

The coefficients of polynomials and entries in a matrix require objects that allow addition and multiplication.   In calculus multivariate optimization, you learned that polynomials can be entries in matrices.  Block operations on matrices are really matrices as elements of other matrices.  Imagine a scenario where this nesting feature may go quite deep.

You need to create polynomial and matrix generic classes that will allow any entries that allow addition and multiplication.  More to the point, the polynomials and matrices themselves will become ring elements in other matrices and polynomials. 
