package codingtest;

import java.io.*;

// 극장 좌석: https://www.acmicpc.net/problem/2302
// dp
public class Baekjoon_2302 {
    static long[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[41];
        dp = new long[41];
        for (int i = 0; i < m; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }
        br.close();

        dp[0] = dp[1] = 1;
        dp[2] = 2;
        int startIdx = 1; // 배열의 길이를 계산하기 위함
        long cnt = 1;
        for (int i = 1; i <= n; i++) {
            if (arr[i]) {
                cnt *= search(i - startIdx);
                startIdx = i + 1;
            }
        }
        cnt *= search(n - startIdx + 1);
        System.out.println(cnt);
    }

    public static long search(int n) {
        if (dp[n] != 0) return dp[n];
        return dp[n] = search(n - 1) + search(n - 2);
    }
}
