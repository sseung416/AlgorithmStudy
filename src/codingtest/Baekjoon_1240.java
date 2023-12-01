package codingtest;

import java.io.*;
import java.util.*;

// 노드사이의 거리: https://www.acmicpc.net/problem/1240
// 트리, DFS
public class Baekjoon_1240 {

    static List<Integer>[] nodes; // 양방형 그래프
    static int[][] distances; // distance[노드1][노드2] = 노드1과 노드2의 거리 값
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n + 1];
        distances = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            // 양방형 그래프 연결
            nodes[node1].add(node2);
            nodes[node2].add(node1);
            // 두 노드 간 거리 연결
            distances[node1][node2] = distances[node2][node1] = distance;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            visited = new boolean[n + 1];
            sb.append(dfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
        }
        br.close();

        System.out.print(sb);
    }

    public static int dfs(int current, int target) { // 현재 노드와 목표 노드
        if (visited[current]) return 0;

        visited[current] = true;
        // 해당 노드에 연결된 노드를 탐색
        for (int node : nodes[current]) {
            if (node == target) {
                // 연결된 노드가 목표 노드와 동일하다면 거리를 반환함
                return distances[current][node];
            }

            int distance = dfs(node, target);
            if (distance != 0) {
                // 탐색했는데 distance가 0이 아니면(목표 노드를 찾았다면) 현재 거리 값에 탐색한 거리 값을 더해서 반환!
                return distance + distances[current][node];
            }
        }
        return 0;
    }
}