package codingtest.boj.bronze1;

import java.io.*;

// 피보나치 수 2: https://www.acmicpc.net/problem/2748
// dp
public class Baekjoon_2748 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        dp = new long[n + 1];
        System.out.print(fibo(n));
    }

    public static long fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] > 0) return dp[n];
        return dp[n] = fibo(n - 2) + fibo(n - 1);
    }
}
