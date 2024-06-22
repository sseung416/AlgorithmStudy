package codingtest.boj.gold4;

import java.io.*;
import java.util.*;

// 빙산: https://www.acmicpc.net/problem/2573
// DFS
public class Baekjoon_2573_2 {
    static int[][] arr;
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int year = 0;
        while (true) {
            int iceBurgCnt = 0;
            visited = new boolean[n][m];
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (!visited[i][j] && arr[i][j] > 0) {
                        dfs(i, j);
                        iceBurgCnt++;
                    }
                }
            }

            if (iceBurgCnt == 0) {
                System.out.println(0);
                return;
            }
            if (iceBurgCnt >= 2) {
                System.out.println(year);
                return;
            }
            year++;
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        arr[x][y] -= getMeltingCount(x, y);

        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if (!visited[ax][ay] && arr[ax][ay] > 0) {
                dfs(ax, ay);
            }
        }
    }

    public static int getMeltingCount(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if (!visited[ax][ay] && arr[ax][ay] <= 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
