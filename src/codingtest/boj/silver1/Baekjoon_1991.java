package codingtest.boj.silver1;

import java.io.*;
import java.util.*;

// 트리 순회: https://www.acmicpc.net/problem/1991
// 트리, 재귀
public class Baekjoon_1991 {

    public static Node[] nodes;
    public static StringBuilder sb = new StringBuilder();

    static class Node {
        char value;
        Node right, left;

        Node(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node parentNode = getNode(parent);
            parentNode.left = getNode(left);
            parentNode.right = getNode(right);
        }
        br.close();

        Node root = nodes[0];
        preOrder(root);
        sb.append('\n');
        inOrder(root);
        sb.append('\n');
        postOrder(root);

        System.out.print(sb);
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }

    public static Node getNode(char c) {
        if (c == '.') {
            return null;
        }

        int index = c - 65;
        if (nodes[index] == null) {
            return nodes[index] = new Node(c);
        }

        return nodes[index];
    }
}
