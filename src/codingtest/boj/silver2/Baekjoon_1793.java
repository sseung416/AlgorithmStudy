package codingtest.boj.silver2;

import java.io.*;
import java.math.*;

// 타일링: https://www.acmicpc.net/problem/1793
// dp
public class Baekjoon_1793 {
    static BigInteger[] dp = new BigInteger[251];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = new BigInteger("1"); // 배치하지 않는 것도 하나의 경우의 수에 포함..
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        search(250);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(dp[Integer.parseInt(line)]);
        }
        br.close();
    }

    public static BigInteger search(int n) {
        if (n == 0) return new BigInteger("0");
        if (dp[n] != null) return dp[n];
        return dp[n] = search(n - 1).add(search(n - 2).multiply(new BigInteger("2")));
    }
}
