﻿# GraphTraversal
## Project Description
This repository contains a Java program that implements breadth-first and depth-first traversals on graphs. The program uses two different representations for a graph: adjacency list and adjacency matrix. The program reads the graph from a file and performs the traversals, outputting the traversal order and duration.

## Files
- `Graph.java`: Defines the graph structure and supports both adjacency list and adjacency matrix representations.
- `Traverse.java`: Main class to handle the input parsing, graph operations, and output of the traversal order and duration.
- `test1.txt`, `test2.txt`, `test3.txt`, `test4.txt`, `test5.txt`: Sample graph files for testing.

## Algorithm Explanation

### Graph Class
The `Graph` class manages the nodes and edges of the graph and provides methods to manipulate and traverse the graph:
- `addEdge(String node1, String node2)`: Adds an edge between two nodes in the graph.
- `breadthFirstTraversal(String startNode)`: Performs a breadth-first traversal starting from the given node.
- `depthFirstTraversal(String startNode)`: Performs a depth-first traversal starting from the given node.
- `convertToAdjacencyMatrix()`: Converts the graph representation to an adjacency matrix.
- `convertToAdjacencyList()`: Converts the graph representation to an adjacency list.

### Traverse Class
The `Traverse` class contains the main method to run the graph traversal application:
- Parses the input arguments to extract the filename, starting node, traversal type (BF or DF), and graph representation type (AL or AM).
- Reads the graph from the file and constructs the graph using the `Graph` class.
- Performs the specified traversal and prints the traversal order and duration.

### Example Workflow
1. The user inputs the filename, starting node, traversal type, and graph representation type as command line arguments:
2. The program reads the graph from `graph.txt` and constructs the graph.
3. The program performs the specified traversal and prints the traversal order and duration.

### Example Usage
For the given `graph.txt`:
A - B
C - D
A - C
B - E
D - F
G - F
H - I



Example 1:
Input:
java Traverse graph.txt A -BF -AL
Output:
Breadth-first : A - B - C - E - D - F - G
Time : 0.01



Example 2:
Input:
java Traverse graph.txt A -DF -AM
Output:
Depth-first : A - B - E - C - D - F - G
Time : 0.03
