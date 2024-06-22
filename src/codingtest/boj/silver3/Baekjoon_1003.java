package codingtest.boj.silver3;

import java.io.*;

// 피보나치 함수: https://www.acmicpc.net/problem/1003
// 다이나믹 프로그래밍
public class Baekjoon_1003 {
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] value = fibonacci(n);
            sb.append(value[0]).append(" ").append(value[1]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    public static int[] fibonacci(int n) {
        if (dp[n][0] != 0 && dp[n][1] != 0) return dp[n];

        if (n == 0) {
            return new int[]{1, 0};
        } else if (n == 1) {
            return new int[]{0, 1};
        } else {
            int[] a = fibonacci(n - 1);
            int[] b = fibonacci(n - 2);
            return dp[n] = new int[]{a[0] + b[0], a[1] + b[1]};
        }
    }
}