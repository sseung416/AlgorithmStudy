package codingtest;

import java.io.*;
import java.util.*;

// 사탕 가게: https://www.acmicpc.net/problem/4781
// dp, 냅색
public class Baekjoon_4781 {

    static int[] kcal; // 칼로리 (가치)
    static int[] price; // 가격 (무게)
    static int[] dp; // dp[가격] = 최대 칼로리

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int m = Integer.parseInt(st.nextToken().replace(".", ""));
            kcal = new int[n];
            price = new int[n];
            dp = new int[m + 1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                kcal[i] = Integer.parseInt(st.nextToken());
                price[i] = Integer.parseInt(st.nextToken().replace(".", ""));
            }

            for (int i = 0; i < n; i++) { // 사탕의 항목
                for (int j = price[i]; j <= m; j++) { // 가격
                    // 포함할 수 있는 사탕 중 최대 칼로리를 찾음
                    dp[j] = Math.max(dp[j], dp[j - price[i]] + kcal[i]);
                }
            }

            sb.append(dp[m]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}