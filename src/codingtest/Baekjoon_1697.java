package codingtest;

import java.io.*;
import java.util.*;

// 숨바꼭질: https://www.acmicpc.net/problem/1697
// BFS
public class Baekjoon_1697 {
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();
        System.out.println(bfs(n, k));
    }

    public static int bfs(int n, int k) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == k) return cur.cnt;

            int[] pos = {cur.x - 1, cur.x + 1, cur.x * 2};
            for (int i = 0; i < 3; i++) {
                if (pos[i] <= 100000 && pos[i] >= 0) {
                    if (!visited[pos[i]]) {
                        visited[pos[i]] = true;
                        q.offer(new Point(pos[i], cur.cnt + 1));
                    }
                }
            }
        }
        return 0;
    }

    static class Point {
        int x, cnt;

        Point(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
