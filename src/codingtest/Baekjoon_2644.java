package codingtest;

import java.io.*;
import java.util.*;

// 촌수계산: https://www.acmicpc.net/problem/2644
// dfs
public class Baekjoon_2644 { // 양방향 그래프, dfs 탐색으로 원하는 값 찾을 때까지 탐색
    static List<Integer>[] list;
    static boolean[] visited;
    static int n, m, u1, u2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        u1 = Integer.parseInt(st.nextToken());
        u2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        br.close();

        System.out.println(dfs(u1, 0));
    }

    public static int dfs(int x, int depth) {
        if (x == u2) return depth;
        if (visited[x]) return -1;

        visited[x] = true;

        int max = -1;
        for (int y : list[x]) {
            max = Math.max(max, dfs(y, depth + 1));
        }
        return max;
    }
}
