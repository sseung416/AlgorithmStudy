package codingtest;

import java.io.*;
import java.util.*;

// 구간 합 구하기 5: https://www.acmicpc.net/problem/11660
// 누적합
public class Baekjoon_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] sum = new int[n + 1][n + 1];
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = arr[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
            }
            System.out.println(Arrays.toString(sum[i+1]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            sb.append(sum[y2][x2] - sum[y1-1][x2] - sum[y2][x1 - 1] + sum[y1 -1][x1-1]).append('\n');
        }
        br.close();
        System.out.print(sb);
    }
}