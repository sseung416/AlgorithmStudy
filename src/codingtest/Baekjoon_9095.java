package codingtest;

import java.io.*;

// 1, 2, 3 더하기: https://www.acmicpc.net/problem/9095
public class Baekjoon_9095 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            sb.append(dfs(n)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    static int dfs(int n) {
        if (n < 1) return 0;
        if (dp[n] != 0) return dp[n];
        return dp[n] = dfs(n - 1) + dfs(n - 2) + dfs(n - 3);
    }
}
