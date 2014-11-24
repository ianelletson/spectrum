package edu.gustavus.ielletso;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ian on 11/23/14.
 */
public class Node {
    private List<Node> adjacentNodes;
    final private String name;

    public Node() {
        this("unnamed");
    }

    public Node(String name) {
        this.adjacentNodes = new LinkedList<Node>();
        this.name = name;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public String getName() {
        return name;
    }

    public void addNode(Node node) {
        adjacentNodes.add(node);
    }

    @Override public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Node v = (Node) obj;
        return getName().equals(v.getName());
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        for (Node node : getAdjacentNodes())
            sb.append(", ").append(node.getName());
        return sb.toString();
    }
}
