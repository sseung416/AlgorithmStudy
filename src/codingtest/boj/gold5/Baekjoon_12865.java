package codingtest.boj.gold5;

import java.io.*;
import java.util.*;

// 평범한 배낭: https://www.acmicpc.net/problem/12865
// dp
public class Baekjoon_12865 {
    static int n, k;
    static int[] weight = new int[101];
    static int[] value = new int[101];
    static int[][] dp = new int[101][100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 1; i <= n; i++) { // 진행 값
            for (int j = 1; j <= k; j++) { // 가방 무게
                if (weight[i] <= j) { // 가방에 넣을 수 있다
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                } else {
                    // 넣을 수 없다면 이전 가치 값이 현재 가치 값이 됨
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
