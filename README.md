# clojureTasks
Simple tasks for understending basis of functional programming

Tasks description.
1. Define the functions my-map and my-filter, similar to map (for one list) and filter, expressing them through reduce and basic list operations (cons, first, concat, etc.)

2. The set (alphabet) of characters in the form of a list and the number n are given. Describe a function that returns a list of all strings of length n consisting of these characters and not containing two identical characters following in a row. Recursion in any form is not allowed. For converting lists it is allowed to use map, reduce, filter and basic operations (concat, etc.)
Example: for the alphabet ("a" "b" "c") and n = 2, the result should be ("ab" "ac" "ba" "bc" "ca" "cb") up to permutation.

3. Implement a function (operator) that takes a function as a function of one variable f and returns a function of one variable that evaluates (numerically) the expression "integrate [0..x] f(t)dt". Optimize using memoization for tasks such as graphing (i.e., multiple function calls at different points). Use the trapezoid method with a constant step. Show performance gains using time. Provide minimum test coverage. 
