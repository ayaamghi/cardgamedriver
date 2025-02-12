# Code Review Checklist

## Javadoc Comments
- Are there clear and correct Javadoc comments for the class, methods, and attributes?

No, there are not. Went through and added Javadoc comments to multi-line methods, using @param and @return tags when needed. Also added Javadoc descriptors to classes. 

## Code Structure
- Does the code satisfy all provided specifications?

Technically no,   public Hand getPool() is an incorrect method signature as README.md says pool() instead, as well as specifications stating that there should be two getPlayer1Hand() methods but code has getPlayer2Hand(). All method/variable specifications other then these are met, and comments have been added to each one stating meets specifications. 

- Is the code consistently formatted? 

No, reformatted code using VSCode "Format Document", led to 6 files being modified. 

- Do all methods have a clear purpose?

Yes, all methods have a clear purpose. There are no uncalled non-getter/setter methods. 

- Is there any debugging code still present that should be commented out or removed for production?

No, there is not. All println statements have been commented out and do not run in production. 

- What repeated code is present that could be refactored into a single method? (DRY: Don’t Repeat Yourself)

Multiple usages of a "reset" method that should be abstracted into a abstract method, since implementation is very different between Lamarkian and Blackjack, but a "deal" method should be abstracted into a superclass method with parameters for number of times drawn to hand, since only difference is two vs four cards. 

- Are there any “magic number” constants that should be redefined as `final` variables?

There are several magic number constants that come from the rules of Blackjack, such as 16 for player and 17 for dealer being magic numbers. These could be extracted into either a static configuration file or final variables in their respective classes. 

- Should any variables be `static` so they can be accessed directly by other objects?

Enum for Card should be static as we frequently call the ordinal, which does not change across instantiations. 

- Can complexity be simplified by breaking logic into multiple, clearer methods?

No methods are overly long, except for the lamarkian poker game simulation method. This could be split into multiple stages, although it is still readable as one long method. 

## Variables
- Do all variables (attributes and local) have reasonable types and identifiers?

Yes, they do. No overly shortened or illegible abbrievations are used, and all numerical values are integers as makes sense for Cards. 
- Does each variable have a single, clear purpose in its scope?

  Yes, no variables are misplaced across scopes. 
- Whenever the code assigns a value to a variable, does it ensure type consistency? (e.g., appropriate casting)

No-- all numerical values are integers, so no casting required. 

- Are there any redundant or unused variables that should be removed?

iTurn in Lamarckian Poker is set to 0 inside of a method, but this does not actually do anything. Could be removed. 

## Arithmetic Operations
- Are there any places where floating-point numbers are compared for equality? If so, can these comparisons be improved for robustness?

There are no places where floating point numbers are compared. 


- Are divisions properly tested for divide-by-zero errors?


No divisions. 

## Loops and Conditional Statements
- Are there any errors in the nesting of loops and conditional statements?

No, there are not. 

- In an `if-else` chain or `switch` statement, are the **most common conditions tested first**?

The switch for Card values in Hand is equally likely for all values, in the compareTo for Hand number is checked before suit, so yes. 

- Does each `if-else` chain or `switch` statement account for **all possible cases**?

Yes, as all 
- Can readability and robustness be improved by converting an `if-else` statement into a `switch`?

There are no if-else statements that should be converted to switches. 

- Do loops (`for`, `while`, or `for-each`) have properly initialized index variables?

Yes, all index variables are within the current scope. 
- Are loop termination conditions guaranteed to be met?

Yes, although there are some issues with bounds. 

- Are there statements inside loops that could be moved **outside** for efficiency?

No, all statements within loops need to be within them. 

## General Programming Practices
- Are indexes tested against array bounds to prevent out-of-bounds errors?

No, they are not, as there are IllegalArguments from Lamarckian Poker and ocassionally Blackjack. 
- Are all return values assigned and returned correctly?

Yes, all return values are correct. 

- Do methods avoid unnecessary `print` statements and instead return values or strings?

There are no methods that print in production, so yes. 

- Does each statement operate on the correct data type and structure?

A HashMap could be an improvement to the Enum system, preventing calling ordinal which is less readable and instead calling a direct value-- would also improve the Hand scoring, removing the switch statement entirely. 


- Does the code provide reasonable results across a **wide range of test cases**, including edge cases?

No user input, but for randomly selected cases, there are several points that throw errors, which have been already detailed. 

## Other Code Review Items
- Are there any other issues in the code worth mentioning that do not fit into the above categories?

No errors that have not already been detailed. 