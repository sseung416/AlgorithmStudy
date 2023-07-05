package codingtest;

import java.io.*;
import java.util.*;

// DFS와 BFS: https://www.acmicpc.net/problem/1260
public class Baekjoon_1260 {
    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int value1 = Integer.parseInt(st.nextToken());
                int value2 = Integer.parseInt(st.nextToken());
                setupList(value1, value2);
                setupList(value2, value1);
            }
            br.close();
            dfs(v);
            Arrays.fill(visited, false);
            System.out.println();
            bfs(v);
        } catch (IOException ignore) {}
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int node : graph.getOrDefault(start, new ArrayList<>())) {
            if (!visited[node])
                dfs(node);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.offer(start);
        while (!needVisit.isEmpty()) {
            int node = needVisit.poll();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
                needVisit.addAll(graph.getOrDefault(node, new ArrayList<>()));
            }
        }
    }

    private static void setupList(int key, int value) {
        ArrayList<Integer> list = graph.getOrDefault(key, new ArrayList<>());
        list.add(value);
        Collections.sort(list);
        graph.put(key, list);
    }
}
