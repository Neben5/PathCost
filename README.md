# PathCost

## Introduction

This is a program that finds the shortest path from node 1 to node N, given that each edge from a to b has cost c given an input file in the format:

    N M
    a1 b1 c1
    a2 b2 c2
    ...

## How this fulfills / does not fulfill the specification

This does return the shortest possible path, as required, however it's output does not match the given ones, because the given ones don't match up to the inputs at all.

## Explanation of current errors (or anything that falls short of project specifications) and how you might fix them

If the costs of the inputs are too close to the maximum value of an integer, the program will fail and return a negative value.

## Overview of the code explaining, in broad strokes, the structure of it

Main calls Reader to request and read an input file from the user. Then it creates an adjacency matrix of the nodes, sets the target node, and passes these to ShortestPath, where Dijkatra's algorithm is used to get the distance of every node from node 1, and then the distance from node 1 to the target node is printed.

## Discussion of major challenges encountered in the process of making the code

I originally tried creating my own algorithm for fun, but began getting StackOverFlowErrors, and it was generally just slow. I gave up on that and just used Dijkatra's algorithm which was much faster.

## Acknowledgements (who helped you, what resources you used etc.)

GeeksForGeek's provided a good explanation of how the algorithm worked, which helped a lot.
