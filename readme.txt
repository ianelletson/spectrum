# Spectrum problem (Homework 5 part 2)
## Garrison Meyer and Ian Elletson
(We each contributed equally to this assignment)

- Graph uses Dijkstra's Algorithm to compute the shortest path. This is used to
  compute hops.
- We chose Dijkstra's Algorithm because it was interesting to implement, and
  effective. We do note that a simpler algorithm may be used.
- test.txt is a text form of the given input in hardcoded form and in standard
  input form with expected results. You can copy and past the SI test into a new
  file and test standard input for yourself.
- The program reads from standard input and writes to standard output. To
  signify EOF press "ctrl-D". There is a bug that exists in some version of
  Eclipse that prevents the usage of "ctrl-D" to signify EOF.
- There is a working jar and test files included in the "TEST_HERE" directory.
  To use these files, open a terminal in the directory and run:
  `java -jar spectrum.jar $TEST` where `$TEST` is the name of the test file.
- The three included test files have correct output. The program does not loop.

