package codingtest.boj.silver4;

import java.io.*;
import java.util.*;

// 동전 0: https://www.acmicpc.net/problem/11047
// 그리디
public class Baekjoon_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = n - 1; i >= 0; i--) {
            count += k / coins[i];
            k %= coins[i];
            if (k == 0) {
                break;
            }
        }
        System.out.println(count);
    }
}
