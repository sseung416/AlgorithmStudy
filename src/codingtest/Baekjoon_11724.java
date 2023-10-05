package codingtest;

import java.io.*;
import java.util.*;

// 연결 요소의 개수: https://www.acmicpc.net/problem/11724
// dfs
// 양방향 그래프!!
public class Baekjoon_11724 {
    static boolean[] visited; // 해당 연결요소 방문 여부
    static List<Integer>[] lists;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u  = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방형 그래프
            lists[u].add(v);
            lists[v].add(u);
        }
        br.close();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int edge : lists[start]) {
            if (!visited[edge]) dfs(edge);
        }
    }
}
