package codingtest;

import java.io.*;

// 01타일: https://www.acmicpc.net/problem/1904
// dp
public class Baekjoon_1904 {
    static int[] dp = new int[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 2;
        System.out.println(search(n - 1));
    }

    public static int search(int n) {
        if (dp[n] != 0) return dp[n];
        return dp[n] = (search(n - 1) + search(n - 2)) % 15746;
    }
}