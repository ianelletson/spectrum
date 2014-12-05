package edu.gustavus.ielletso;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> input = new LinkedList<String>();
        while (scanner.hasNext())
            input.add(scanner.nextLine());
        scanner.close();

        Graph graph = new Graph();
        StringBuilder sb = new StringBuilder();
        int caseNum = 0;
        sb.append("Case ").append(++caseNum).append(":\n");
        Map<String, Node> dict = new HashMap<String, Node>();
        while (!input.isEmpty()) {
            String[] line = input.remove().split(" ");
            if (line[0].equals("reset")) {
                graph = new Graph();
                dict = new HashMap<String, Node>();
                sb.append("Case ").append(++caseNum).append(":\n");
            }
            if (line[0].equals("add")) {
                if (line.length == 2) {
                    if (!dict.containsKey(line[1]))
                        dict.put(line[1], new Node(line[1]));
                    graph.addNode(dict.get(line[1]));
                } else {
                    if (!dict.containsKey(line[1]))
                        dict.put(line[1], new Node(line[1]));
                    if (!dict.containsKey(line[2]))
                        dict.put(line[2], new Node(line[2]));
                    graph.addEdge(dict.get(line[1]), dict.get(line[2]));
                }
            }
            if (line[0].equals("connections")) {
                if (!dict.containsKey(line[1]))
                    dict.put(line[1], new Node(line[1]));
                sb.append(graph.getConnections(dict.get(line[1])));
            }
            if (line[0].equals("associated")) {
                if (!dict.containsKey(line[1]))
                    dict.put(line[1], new Node(line[1]));
                if (!dict.containsKey(line[2]))
                    dict.put(line[2], new Node(line[2]));
                sb.append(graph.getAssociation(dict.get(line[1]), dict.get(line[2])));
            }
        }
        sb.append("----------\n");
        System.out.print(sb);
    }
}
