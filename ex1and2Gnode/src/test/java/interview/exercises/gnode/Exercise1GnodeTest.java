package interview.exercises.gnode;

import interview.exercises.gnode.model.GNode;
import interview.exercises.gnode.model.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Test class to help show Exercise 1 functionality
 */
public class Exercise1GnodeTest {
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

}

