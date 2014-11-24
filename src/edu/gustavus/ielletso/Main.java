package edu.gustavus.ielletso;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> input = new Stack<String>();
        while (true) {
            input.push(scanner.nextLine());
            if (input.peek().equals("-1")) {
                input.pop();
                break;
            }
        }
        scanner.close();

        Graph graph = new Graph();
        StringBuilder sb = new StringBuilder();
        int caseNum = 0;
        sb.append("Case ").append(++caseNum).append(":\n");
        while (!input.isEmpty()) {
            String[] line = input.pop().split(" ");
            if (line[0].equals("add")) {
                if (line.length == 2) {
                    graph.addNode(new Node(line[1]));
                    System.out.println(graph.getNodes());
                }
                else {
                    graph.addEdge(new Node(line[1]), new Node(line[2]));
                    System.out.println(graph.getNodes());
                }
            }
            if (line[0].equals("connections"))
                sb.append(graph.getConnections(new Node(line[1])));
            if (line[0].equals("associated"))
                sb.append(graph.getAssociation(new Node(line[1]), new Node(line[2])));
        }
        sb.append("----------\n");
        System.out.print(sb);
    }
}
