package codingtest.boj.silver3;

import java.io.*;
import java.util.*;

// N과 M (1): https://www.acmicpc.net/problem/15649
// 백트랙킹
public class Baekjoon_15649 {

    static boolean[] visited = new boolean[8];
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int n, m;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[m];
            dfs(0);
            br.close();
            System.out.print(sb.toString());
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
