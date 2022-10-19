package sseung.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1991
public class Sseung_Baekjoon_1991 {

    public static void run() {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        Tree tree = new Tree();
        Tree.Node parentNode = tree.addNode("A");
        Tree.Node currentNode;

        for (int i=0; i<count; i++) {
            String[] input = sc.nextLine().split(" ");

            currentNode = tree.getNodeByData(input[0]);
            currentNode.addLeft(tree.addNode(input[1]));
            currentNode.addRight(tree.addNode(input[2]));
        }

        tree.printPreOrder(parentNode);
        System.out.println();
        tree.printInOrder(parentNode);
        System.out.println();
        tree.printPostOrder(parentNode);
    }
}

class Tree {
    private List<Node> nodeList; // 각 노드를 저장

    public Tree() {
        nodeList = new ArrayList<>();
    }

    class Node {
        Object data;
        Node right;
        Node left;

        private Node(Object data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }

        public void addRight(Node node) {
            right = node;
        }

        public void addLeft(Node node) {
            left = node;
        }
    }

    Node addNode(Object data) {
        if (!data.equals(".")) {
            Node node = new Node(data);
            nodeList.add(node);
            return node;
        }
        return null;
    }

    Node getNodeByData(Object data) {
        for (Node node : nodeList) {
            if (node.data.equals(data)) {
                return node;
            }
        }
        return null;
    }

    void printPreOrder(Node node) {
        if (node == null) return;

        System.out.print(node.data);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.print(node.data);
        printInOrder(node.right);
    }

    void printPostOrder(Node node) {
        if (node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data);
    }
}