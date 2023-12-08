package codingtest;

import java.io.*;
import java.util.*;

// N과 M (6): https://www.acmicpc.net/problem/15655
// 백트랙킹
public class Baekjoon_15655 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] result;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);
        search(0, 0);
        System.out.print(sb);
    }

    public static void search(int depth, int idx) {
        if (depth == m) {
            for (int value : result) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = idx; i < n; i++) {
            result[depth] = arr[i];
            search(depth + 1, i + 1);
        }
    }
}