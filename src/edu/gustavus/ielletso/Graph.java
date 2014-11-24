package edu.gustavus.ielletso;

import java.util.*;

/**
 * Created by ian on 11/23/14.
 */
public class Graph {
    private List<Node> nodes;
    private Set<Node> unvisited;
    private Set<Node> visited;
    private Map<Node, Integer> distance;
    private final int BIG = Integer.MAX_VALUE;

    public Graph() {
        nodes = new ArrayList<Node>();
        distance = new HashMap<Node, Integer>();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
            distance.put(node, BIG);
        }
    }

    public void addEdge(Node u, Node v) {
        if (!u.getAdjacentNodes().contains(v))
            u.addNode(v);
        if (!v.getAdjacentNodes().contains(u))
            v.addNode(u);
        this.addNode(u);
        this.addNode(v);
    }

    public String getConnections(Node u) {
        if (!this.getNodes().contains(u)) return "target does not exist\n";
        Map<Integer, Integer> hops = this.connections(u);
        StringBuilder sb = new StringBuilder();
        if (hops.size() == 0)
            sb.append("no connections\n");
        else
            for (Integer i : hops.keySet()) sb.append(i).append(": ").append(hops.get(i)).append("\n");
        this.reset();
        return sb.toString();
    }

    public String getAssociation(Node u, Node v) {
        if ((!this.getNodes().contains(u)) || (!this.getNodes().contains(v)))
            return "target does not exist\n";
        int hops = this.associated(u,v);
        StringBuilder sb = new StringBuilder();

        if (hops == -1)
            sb.append("no\n");
        else {
            sb.append("yes: ").append(hops).append("\n");
        }
        this.reset();
        return sb.toString();
    }

    private int associated(Node u, Node v) {
        djk(u);
        int hops = -1;
        if (!(distance.get(v) == BIG))
            hops = distance.get(v) - 1;
        return hops;
    }

    private Map<Integer, Integer> connections(Node u) {
        djk(u);
        Map<Integer, Integer> hopMap= new HashMap<Integer, Integer>();
        for (Map.Entry<Node, Integer> entry : distance.entrySet()) {
            if ((entry.getValue() == 0) || entry.getValue() == BIG)
                continue;
            int hops = entry.getValue() - 1;
            if (!hopMap.containsKey(hops))
                hopMap.put(hops, 1);
            else {
                int hopsToAdd = hopMap.get(hops) + 1;
                hopMap.put(hops, hopsToAdd);
            }
        }
        return hopMap;
    }

    private void djk(Node u) {
        unvisited = new HashSet<Node>();
        visited = new HashSet<Node>();
        distance.put(u, 0);
        unvisited.add(u);

        while (!unvisited.isEmpty()) {
            Node v = this.getMinDist(unvisited);
            unvisited.remove(v);
            visited.add(v);
            checkNeighbors(v);
        }
    }

    private Node getMinDist(Set<Node> nodes) {
        Node min = null;
        for (Node node : nodes) {
            if (min == null)
                min = node;
            else if (distance.get(node) < distance.get(min))
                min = node;
        }
        return min;
    }

    private void checkNeighbors(Node u) {
        for (Node node : u.getAdjacentNodes()) {
            if (visited.contains(node))
                continue;
            int dist = 1 + distance.get(u);
            if (dist < distance.get(node)) {
                distance.put(node, dist);
                unvisited.add(node);
            }
        }
    }

    private void reset() {
        for (Node node : distance.keySet()) distance.put(node, BIG);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : this.getNodes())
            sb.append(node).append("\n");
        return sb.toString();
    }

}
