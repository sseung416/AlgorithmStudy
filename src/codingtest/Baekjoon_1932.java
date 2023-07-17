package codingtest;

import java.io.*;
import java.util.*;

// 정수 삼각형: https://www.acmicpc.net/problem/1932
public class Baekjoon_1932 {
    static int[][] rectangle, dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rectangle = new int[n + 1][n];
        dp = new int[n + 1][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                rectangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == n + 1 || y == n) return 0;
        if (dp[x][y] > 0) return dp[x][y];
        return dp[x][y] = rectangle[x][y] + Math.max(dfs(x + 1, y), dfs(x + 1, y + 1));
    }
}