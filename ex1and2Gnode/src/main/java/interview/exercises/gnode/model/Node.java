package interview.exercises.gnode.model;

import java.lang.String;
import java.util.LinkedList;
import java.util.List;

/**
 * The implementing Node class to store the graph/paths data
 */
public class Node implements GNode {

    protected String data;
    protected Node parent;
    protected List<Node> children;

    public Node(String data) {
        this.data = data;
        this.children = new LinkedList<Node>();
    }

    public void setParent(Node parent) {
        this.parent=parent;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public boolean isRoot() {
        if(this.parent==null)
            return true;
        return false;
    }

    public boolean isLeaf() {
        if(this.children==null || this.children.size()==0)
            return true;
        return false;
    }

    public boolean hasChildren() {
        if(this.children!=null && this.children.size()>0)
            return true;
        return false;
    }


    @Override
    public String getName() {
        return data;
    }

    @Override
    public GNode[] getChildren() {
        if(this.children==null) {
            return (GNode[])new LinkedList<GNode>().toArray(new GNode[0]);
        } else {
            return (GNode[]) this.children.toArray(new GNode[this.children.size()]);
        }
    }

}