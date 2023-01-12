# Data-Structures-from-Scratch-Java

Problem 1: Hashing

You are supposed to input a string which may consist of:
  i. Lower case alphabets (a-z)
  ii. Upper case alphabets (A-Z)
  iii. Spaces
  iv. Numbers (0-9)
  v. Special characters like !, - ,… etc.

You are supposed to find out which character occurs the maximum number of times and the
number of its occurrence, in the given string. If two characters occur an equal number of
times, you have to output the character with the lower ASCII code.
For example, if your string was: aaaaAAAA, your output would be: A 4, because “A” has
lower ASCII value (ASCII:65) than “a” (ASCII: 97).
You are supposed to deal with any string whose maximum length can be 1000 characters.
You have to use hashing and build your own hash table in your algorithm

Input format:

The input will contain a string.

Output format:

You've to output two things which will be separated by a space:
  i) The character which occurs the maximum number of times.
  ii) The number of its occurrence.

Sample input

Faculty of Computers and Data Science
Sample output
Space 5



Problem 2: Binary Search Tree

Given a set of N elements that contain exactly X distinct elements (while the rest are
repetitions), the redundancy ratio is defined as the ratio N/X.
You are supposed to write a program to input a set of integers, and keep track of the
redundancy ratio. Once the redundancy ratio reaches or exceeds a specific value r, the
program terminates and prints this ratio with a message indicating that your numbers have
“many repetitions”. If you want to force the program to terminate before the redundancy
ratio reaches r, you can input -1 as your input integer. In this case, the program prints the
current ratio with a message indicating that your numbers have “only few repetitions”.

Input format:

First line contains the redundancy ratio r as a real number greater than 1.
Next lines contain integers one per line.

Output format:

Print the required answer.

Sample input 1
1.5
1
4
2
5
2
2
Sample output 1
ratio=6/4=1.5
many repetitions

Sample input 2
1.2
1
2
4
5
1
Sample output 2
ratio=5/4=1.25
many repetitions

Sample input 3
2.0
4
6
8
2
5
5
2
-1
Sample output 3
ratio=7/5=1.4
only few repetitions



Problem 3: Topological Sorting

There are many islands that are connected by one-way bridges, that is, if a bridge connects
islands a and b, then you can only use the bridge to go from a to b but you cannot travel back
by using the same. If you are on island a, then you select (uniformly and randomly) one of
the islands that are directly reachable from a through the one-way bridge and move to that
island. You are stuck on an island if you cannot move any further. It is guaranteed that if
there is a directed path from one island to the second there is no path that leads from the
second back to the first. In other words the formed graph is a Directed Acyclic Graph.
Find the island that you are most likely to get stuck on; that is the island that you can
possibly reach with the maximum number of paths from all other islands.
Input format:
First line: Three integers n (the number of islands), m (the number of one-way bridges), and r
(the index of the island you are initially on)
Next m lines: Two integers ui and vi representing a one-way bridge from island ui to vi.
Output format:
Print the index of the island that you are most likely to get stuck on. If there are multiple
islands, then print them in the increasing order of indices (space separated values in a single
line).

Sample input

5 7 1
1 2
1 3
1 4
1 5
2 4
2 5
3 4

Sample output

4


Problem 4: Minimum Spanning Trees

You are given an undirected connected graph consisting of n nodes. All the nodes have
distinct numbers from 1 to n. There are no self-loops in the graph. Now, you are allowed to
remove edges from the graph.
The cost of removing an edge is |node1−node2| where node1 and node2 are the vertex
numbers of node1 and node2 respectively, and the edge being removed has node1 and node2
as its endpoints.
By performing the above-mentioned operation as many times as you want, you need to
convert the given graph into a single tree by using minimum possible cost. In the output,
print the minimum cost required to achieve the given task.

Input format:

First line will contain two integers n and m where n denotes the number of nodes and m
denotes the number of edges in the graph respectively.
The next m lines contain two integers ui and vi denoting an undirected edge between the
vertices ui and vi.

Output format:

Print the required total minimum cost of removing edges.

Sample input

5 5
1 2
2 3
3 4
4 5
1 3

Sample output

1
