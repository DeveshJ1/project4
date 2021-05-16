# project4
You are going to write a program that uses our new data structures, stack and queue, to explore a maze and, hopefully, find a way out of it. There are many algorithms that use different data structures and different strategies to explore mazes. In this assignment you will try two such approaches. In both of these approaches you will start from some initial position within the maze and evaluate the neighboring spaces until either you find a way out, or you discover that there is no way out. The rough outline of both approaches is to examine spaces around the current position and decide which need to be examined further and which definitely do not lead to an exit (more details below in the algorithm description).


Main goal: the main goal of this programming project is to get out of a maze.

The other goal of this programming project is for you to master (or at least get practice on) the following tasks:

working with multi-file programs
writing classes
implementing existing interfaces
working with existing code
implementing your own doubly linked list
implementing your own stack and queue

PROGRAM USAGE
The program is started from the command line (or run within an IDE). It expects two command line arguments.

The program should be given the array to work with via command line arguments (this is the args array parameter to the main method). This means that the program should be run using, for example:

java WayFinder 3 6 4 1 3 4 2 5 3 0

The command line arguments represent the values for the array. Restrictions:

all values have to be non-negative integers in the range of 0 to 99 inclusive
the last value has to be zero
If the program is executed with non-existent or invalid command line arguments, it should print an error message and terminate.

The program \textbf{should not be interactive}. All input should be provided as the command line arguments. The user should not be prompted for any additional information.

RESULTS/OUTPUTS
The program has to calculate and display all possible solutions to the puzzle or determine that no such solutions exist. The output of the program should match the format described below exactly (the correctness of the solutions will be determined based on textual matching of the program's output to the correct solution).

The output for multiple paths through the puzzle should be separated by a single blank line. The last line (after all the paths are printed) should conclude the total number of paths that can be successfully taken to solve the puzzle.

For each path, every step through the puzzle has to be displayed. For each step, the entire array should be printed and the current location should be indicated with either L or R indicating which direction the next step is taken in.

Each value in the array should be printed within a 2 digit field (right aligned) with additional space, or character L or R (for the current value) following the number. The values should be separated by the commas and spaces immediately following the commas. The entire array should be surrounded by square brackets.

The format of a 6-element array should be:

[DDS,SDDC,SDDS,SDDS,SDDS,SDDS]

where D stands for a digit, S stands for a space character, C stands for a character (either L or R) indicating the direction. Note that there should only be one value in the entire array that is followed by the direction character!

Here are a few examples:

[ 3 , 4 , 11 , 2L, 25 , 0 ] means that the current location is at index 3 and the next move will be two to the left

[ 3 , 4 , 11 , 2R, 25 , 0 ] means that the current location is at index 3 and the next move will be two to the right

[ 3R, 4 , 11 , 2 , 25 , 0 ] means that the current location is at index 0 and the next move will be three to the left

Hint: If you are not familiar with the String.format() method, this may be a good idea to learn more about it.

PROGRAM EXECUTION EXAMPLE
Here are a few examples of the program execution.

Program run using:

java WayFinder 3 -2 9 0

ERROR: the puzzle values have to be positive integers.
Program run using:

java WayFinder 3 6 0 1 3 4 2 5 3 0

No way through this puzzle.
Program run using:

java WayFinder 2 1 2 0

No way through this puzzle.
Program run using:

java WayFinder 3 6 4 1 3 4 2 5 3 0

[ 3R,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1L,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4R,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2R,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3L,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4R,  2 ,  5 ,  3 ,  0 ]

[ 3R,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1R,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3L,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6R,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5L,  3 ,  0 ]
[ 3 ,  6 ,  4R,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2R,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3L,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4R,  2 ,  5 ,  3 ,  0 ]

[ 3R,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1R,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3R,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5L,  3 ,  0 ]
[ 3 ,  6 ,  4R,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2R,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3L,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4R,  2 ,  5 ,  3 ,  0 ]

There are 3 ways through the puzzle.
Program run using:

java WayFinder 6 9 3 10 2 1 5 8 9 1 2 5 4 8 10 7 6 0

[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5L,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9R,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2L,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]

[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5L,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9R,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2R,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4L,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]

[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5R,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5R,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6L,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2L,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]

[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5R,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5R,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6L,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2R,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4L,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]

There are 4 ways through the puzzle.

