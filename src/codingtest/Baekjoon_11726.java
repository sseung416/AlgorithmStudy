package codingtest;

import java.io.*;

// 2×n 타일링: https://www.acmicpc.net/problem/11726
// dp
// 오버 플로우를 주의합시다..
public class Baekjoon_11726 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        dp = new long[n + 1];
        System.out.print(search(n));
    }

    public static long search(int n) {
        if (n <= 2) return n;
        if (dp[n] > 0) return dp[n];
        return dp[n] = (search(n - 2) + search(n - 1)) % 10007;
    }
}