# Roman Numerals kata

Implementation 1 uses recursion and the common logarithm to find the base through the exponential function 10^x. It uses duplicated blocks to represent each base group. This version is for illustration only to show how the pattern of 1-4-5-9 repeats itself - it's far from the best solution.

Implementation 2 also uses recursion and the common logarithm, but has removed all the duplicates. It uses an one dimensional array to represent the conversion and the recursion happens only on it's tail. While being an extremely compressed solution with a mathematical approach, it still has a high complexity.

Implementation 3 uses no recursion or logarithms. Its based only on loops and arrays.