# Code Review Checklist

## Javadoc Comments
- Are there clear and correct Javadoc comments for the class, methods, and attributes?
- Note that both public and private methods and attributes should have Javadoc comments.
- For this assignment, assume that the required Javadoc comments are missing.

## Code Structure
- Does the code satisfy all provided specifications?
- Is the code consistently formatted? 
  - **Note:** For this course, use the "Format Document" command in Visual Studio Code for correct Java formatting.
- Do all methods have a clear purpose?
- Is there any debugging code still present that should be commented out or removed for production?
- What repeated code is present that could be refactored into a single method? (DRY: Don’t Repeat Yourself)
- Are there any “magic number” constants that should be redefined as `final` variables?
- Should any variables be `static` so they can be accessed directly by other objects?
- Can complexity be simplified by breaking logic into multiple, clearer methods?

## Variables
- Do all variables (attributes and local) have reasonable types and identifiers?
- Does each variable have a single, clear purpose in its scope?
  - Example: A variable used for one array index should not later be reused for another array index.
- Whenever the code assigns a value to a variable, does it ensure type consistency? (e.g., appropriate casting)
- Are there any redundant or unused variables that should be removed?

## Arithmetic Operations
- Are there any places where floating-point numbers are compared for equality? If so, can these comparisons be improved for robustness?
- Are divisions properly tested for divide-by-zero errors?

## Loops and Conditional Statements
- Are there any errors in the nesting of loops and conditional statements?
- In an `if-else` chain or `switch` statement, are the **most common conditions tested first**?
- Does each `if-else` chain or `switch` statement account for **all possible cases**?
  - **Note:** Ensure `else` and `default` blocks handle unexpected cases.
- Can readability and robustness be improved by converting an `if-else` statement into a `switch`?
- Do loops (`for`, `while`, or `for-each`) have properly initialized index variables?
- Are loop termination conditions guaranteed to be met?
- Are there statements inside loops that could be moved **outside** for efficiency?

## General Programming Practices
- Are indexes tested against array bounds to prevent out-of-bounds errors?
- Are all return values assigned and returned correctly?
- Do methods avoid unnecessary `print` statements and instead return values or strings?
- Does each statement operate on the correct data type and structure?
- Does the code provide reasonable results across a **wide range of test cases**, including edge cases?

## Other Code Review Items
- Are there any other issues in the code worth mentioning that do not fit into the above categories?
