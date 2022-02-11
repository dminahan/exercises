package interview.exercises.gnode;

import interview.exercises.gnode.model.GNode;
import interview.exercises.gnode.model.Node;

import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ExerciseGnode {
    protected Node root=null;

    public ExerciseGnode() {
        root = initGraph();
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Initialize the graph data
     * @return
     */
    public Node initGraph() {
        Node node=new Node("A");

        Node branch1=this.createBranchNode("B", Arrays.asList("E", "F"), node);
        node.addChild(branch1);

        Node branch2=this.createBranchNode("C", Arrays.asList("G", "H", "I"), node);
        node.addChild(branch2);

        Node branch3=this.createBranchNode("D",Arrays.asList("J"), node);
        node.addChild(branch3);

        return node;
    }

    /**
     * Helper method to create a leaf node
     * @param dataValue
     * @param parent
     * @return
     */
    public Node createLeafNode(String dataValue, Node parent) {
        Node leafNode=new Node(dataValue);
        leafNode.setParent(parent);
        return leafNode;
    }

    /**
     * Helper method on creating the data for the Branch Node
     * @param dataValue
     * @param leaves
     * @param parent
     * @return
     */
    public Node createBranchNode(String dataValue, List<String> leaves, Node parent) {
        Node branchNode=new Node(dataValue);
        branchNode.setParent(parent);
        for(String leaf:leaves) {
            Node leafNode=createLeafNode(leaf, branchNode);
            branchNode.addChild(leafNode);
        }
        return branchNode;
    }

    /**
     * static main to help show the paths as loaded.
     * @param args
     */
    public static void main(String args[]) {
        ExerciseGnode gnodeMain = new ExerciseGnode();
        ArrayList<String> nodeList = gnodeMain.walkGraph(gnodeMain.root);

        if(args.length > 0) {
            String arg0=args[0];
            if(arg0.equals("walkGraph")) {
                ArrayList<String> graph = gnodeMain.walkGraph(gnodeMain.getRoot());
                System.out.println(Arrays.toString(graph.toArray()));
            } else if(arg0.equals("path")) {
                ArrayList<ArrayList<String>> pathsList=gnodeMain.paths(gnodeMain.getRoot());
                for(ArrayList<String>path:pathsList) {
                    System.out.println(Arrays.toString(path.toArray()));
                }
            } else {
                System.out.println("No valid functionality was selected");
            }

        }

    }


    /**
     * Walk the node graph to pull all names into a flat ArrayList.
     *
     * @param node
     * @return
     */
    public ArrayList<String> walkGraph(GNode node) {
        ArrayList<String> nodeList= new ArrayList<String>();
        nodeList.add(node.getName());

        //Get list of the children into a list
        ArrayList<GNode> childNodeList = new ArrayList<GNode>();
        for(GNode gnodeChild:node.getChildren()) {
            childNodeList.add(gnodeChild);
        }

        //Iterate and add to arraylist all children names;
        for(GNode childNode:childNodeList) {
            ArrayList<String> childList = this.walkGraph(childNode);
            for(String childString:childList ) {
                nodeList.add(childString);
            }
        }
        return nodeList;
    }

    /**
     * Method to build the Paths of a given node
     * @param node
     * @return
     */
    public ArrayList<ArrayList<String>> paths(GNode node) {
        Node nodeObj=(Node)node;
        ArrayList<ArrayList<String>> pathsList= new ArrayList<ArrayList<String>>();
        ArrayList<String> currentPath=new ArrayList<String>();
        currentPath.add(nodeObj.getName());
        if(nodeObj.hasChildren()) {
           List<Node> childNodes=getChildNodeList(nodeObj);
           for(Node child:childNodes) {
               pathsList=subPaths(child, pathsList, currentPath);
           }
        } else {
           pathsList.add(currentPath);
        }
        return pathsList;

    }

    /**
     * Helper method to get list of the Child Nodes
     * @param nodeObj
     * @return
     */
    private List<Node> getChildNodeList(Node nodeObj) {
        List<Node> children=new ArrayList<Node>();
        GNode[] childGnodes = nodeObj.getChildren();
        for(int i=0; i< childGnodes.length; i++) {
            children.add((Node)childGnodes[i]);
        }
        return children;
    }

    /**
     * Helper method to build the subPaths recursively
     *
     * @param node
     * @param pathsList
     * @param currentPath
     * @return
     */
    private ArrayList<ArrayList<String>> subPaths(Node node, ArrayList<ArrayList<String>> pathsList, ArrayList<String> currentPath) {
        ArrayList<String> subPath=new ArrayList<String>();
        subPath.addAll(currentPath);
        subPath.add(node.getName());
        //If this node is a leaf, at tend add the path to the array of arrays
        if(node.isLeaf()) {
          pathsList.add(subPath);
        } else {
          List<Node> childNodes=getChildNodeList(node);
          for(Node child:childNodes) {
            pathsList=subPaths(child, pathsList, subPath);
          }
        }
        return pathsList;
    }

}
