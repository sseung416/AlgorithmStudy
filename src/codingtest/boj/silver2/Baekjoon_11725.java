package codingtest.boj.silver2;

import java.io.*;
import java.util.*;

// 트리의 부모 찾기: https://www.acmicpc.net/problem/11725
// dfs
public class Baekjoon_11725 {
    static List<Integer>[] tree; // 양방향 그래프 선언
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        result[1] = 1;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int parent) {
        for (int node : tree[parent]) {
            if (result[node] != 0) {
                continue;
            }
            result[node] = parent;
            dfs(node);
        }
    }
}