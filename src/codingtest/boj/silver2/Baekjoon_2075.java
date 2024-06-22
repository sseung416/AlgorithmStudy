package codingtest.boj.silver2;

import java.io.*;
import java.util.*;

// N번째 큰 수: https://www.acmicpc.net/problem/2075
// 정렬
public class Baekjoon_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[n * n - n]);
    }
}
