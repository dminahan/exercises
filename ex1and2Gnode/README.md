#  Interview Challenge Excercises 1 and 2 - GNode (Graph/Tree walkGraph and paths)

## Requirement
Exercise 1 and 2 build on each other and have to do with node and path logic or tree/branch/leaf logic.
Please see each numbered exercise below for specifics.

1. Imagine we have an interface "GNode" that looks like this:

   public interface GNode {
     public String getName();
    public GNode[] getChildren();
   }

   ** Observe that this GNode can be thought of as defining a graph.
   ** In implementing the functions below, you can assume that any
      graph defined by a GNode is acyclic (no cycles).
   ** Assume that when a GNode has no children, getChildren() returns
      a array of size 0, and *not* null.
   ** You can also assume that all children returned by getChildren()
      are not null.

   Implement a function with the following signature:

       public ArrayList walkGraph(GNode);

   which should return a ArrayList containing every GNode in the
   graph. Each node should appear in the ArrayList exactly once
   (i.e. no duplicates).


2. Implement a function with the following signature:

        public ArrayList paths(GNode node);

   which should return a ArrayList of ArrayLists, representing all
   possible paths through the graph starting at 'node'. The ArrayList
   returned can be thought of as a ArrayList of paths, where each path
   is represented as an ArrayList of GNodes.

   Example:
   Assume the following graph:

   A
     B
       E
       F
     C
       G
       H
       I
     D
       J

   paths(A) = ( (A B E) (A B F) (A C G) (A C H) (A C I) (A D J) )

## Tasks which are out of scope
*   Did not see a requirement to allow loading of custom graph so this sets up the default data above
*   Just used system out versus logger to log file

## How to run

In script directory there is a shell script that you can execute and pass in walkGraph or path to see the output of both.  Also there are unit tests that can be run.  It assumes you have compiled the code and the jar file is over in ../target.

To run type:
./runGNode.sh <action>, where action is walkGraph or path so ./runGNode.sh walkGraph
