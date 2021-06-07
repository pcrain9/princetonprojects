# princetonprojects
List of projects I completed for Princeton's Algorithms, Part I

RandomDeque:  This program will take in list of objects and return a random object from the list.

Mergebm:  This program is a take on week 3's merge sort introduction.  After researching mergesort, I decided to adapt the bottom-up mergesort that Professors Wayne and Sedgewick suggested.  My research took me to Professor Cheung of Emory University.  His bottom-up mergesort improves the one suggested by the Princeton profs in that you don't have to copy the arrray to an auxiliary array at the beginning of each merge call.  The copy occurs instead after each successive incrementation of the width variable.  This saves a bit of space for sure.  The link to Professor Cheung's code is here: http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/7-Sort/merge-sort5.html.

Board and Solver.java:  Together, these two files will allow the user to create an 8 puzzle from a tile layout of the user's choosing (Board.java creates the puzzle logic, Solver.java's main is where user will input the numbers) and it will then solve the puzzle by performing an adapted Priority Queue.  More importantly, before attempting to solve the puzzle, it will check to see if the puzzle is solvable!!! Credit for solvability logic goes to: https://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/.

BST.java: Simple implementation of Java's Binary Search Tree functionality.  Program will read a file of names in from command line and arrange them in alphabetical order.
