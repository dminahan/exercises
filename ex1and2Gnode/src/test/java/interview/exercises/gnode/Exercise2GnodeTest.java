package interview.exercises.gnode;

import interview.exercises.gnode.model.GNode;
import interview.exercises.gnode.model.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Test class to show the Exercise 2 functionality
 */
public class Exercise2GnodeTest {
    ExerciseGnode gnode;
    @Before
    public void setUp() {
        gnode=new ExerciseGnode();
    }

    @Test
    /**
     * Method to test walking of the graph and what values are in the
     * returned ArrayList.  This walks hte full graph.
     */
    public void testWalkGraph() {
        ArrayList<String> nodes = gnode.walkGraph(gnode.getRoot());
        assertEquals(10, nodes.size());

        assertEquals("A", nodes.get(0));
        assertEquals("B", nodes.get(1));
        assertEquals("E", nodes.get(2));
        assertEquals("F", nodes.get(3));
        assertEquals("C", nodes.get(4));
        assertEquals("G", nodes.get(5));
        assertEquals("H", nodes.get(6));
        assertEquals("I", nodes.get(7));
        assertEquals("D", nodes.get(8));
        assertEquals("J", nodes.get(9));

    }

    @Test
    /**
     * Test that if you walk just a branch you only get the branch.
     */
    public void testWalkBranch() {
        Node root = gnode.getRoot();

        GNode[] childNodes = root.getChildren();
        Node child = (Node) childNodes[0];
        GNode[] leafNodes = child.getChildren();
        assertEquals("B", child.getName());
        assertEquals(2, leafNodes.length);
        assertEquals("E",leafNodes[0].getName() );
        assertEquals("F",leafNodes[1].getName() );
    }

    @Test
    public void testFullPaths() {
        ArrayList<ArrayList<String>> paths = gnode.paths(gnode.getRoot());

        assertEquals(6, paths.size());

        //Verify paths
        //Path 1
        ArrayList<String> path1=paths.get(0);
        assertEquals(3, path1.size());
        assertEquals("A", path1.get(0));
        assertEquals("B", path1.get(1));
        assertEquals("E", path1.get(2));

        //Path 2
        ArrayList<String> path2=paths.get(1);
        assertEquals(3, path2.size());
        assertEquals("A", path2.get(0));
        assertEquals("B", path2.get(1));
        assertEquals("F", path2.get(2));

        //Path 3
        ArrayList<String> path3=paths.get(2);
        assertEquals(3, path3.size());
        assertEquals("A", path3.get(0));
        assertEquals("C", path3.get(1));
        assertEquals("G", path3.get(2));

        //Path 4
        ArrayList<String> path4=paths.get(3);
        assertEquals(3, path4.size());
        assertEquals("A", path4.get(0));
        assertEquals("C", path4.get(1));
        assertEquals("H", path4.get(2));

        //Path 5
        ArrayList<String> path5=paths.get(4);
        assertEquals(3, path5.size());
        assertEquals("A", path5.get(0));
        assertEquals("C", path5.get(1));
        assertEquals("I", path5.get(2));

        //Path 6
        ArrayList<String> path6=paths.get(5);
        assertEquals(3, path6.size());
        assertEquals("A", path6.get(0));
        assertEquals("D", path6.get(1));
        assertEquals("J", path6.get(2));

    }

    @Test
    public void testSubPaths() {
        Node root = gnode.getRoot();

        GNode[] childNodes = root.getChildren();
        Node child = (Node) childNodes[0];

        ArrayList<ArrayList<String>> paths = gnode.paths(child);

        assertEquals(2, paths.size());

        //Verify paths
        //Path 1
        ArrayList<String> path1=paths.get(0);
        assertEquals(2, path1.size());
        assertEquals("B", path1.get(0));
        assertEquals("E", path1.get(1));

        //Path 2
        ArrayList<String> path2=paths.get(1);
        assertEquals(2, path2.size());
        assertEquals("B", path2.get(0));
        assertEquals("F", path2.get(1));
    }

    @Test
    public void testLeaf() {
        Node root = gnode.getRoot();

        GNode[] childNodes = root.getChildren();
        //First Child
        Node child = (Node) childNodes[0];

        //Get Leaf
        GNode[] leafNodes = child.getChildren();
        Node leaf = (Node) leafNodes[0];


        ArrayList<ArrayList<String>> paths = gnode.paths(leaf);

        assertEquals(1, paths.size());

        //Verify simple leaf path
        //Path 1
        ArrayList<String> path1=paths.get(0);
        assertEquals(1, path1.size());
        assertEquals("E", path1.get(0));
    }

}

