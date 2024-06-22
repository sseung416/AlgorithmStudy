package codingtest.boj.silver3;

import java.io.*;
import java.util.*;

// N과 M (4): https://www.acmicpc.net/problem/15652
// 백트랙킹
public class Baekjoon_15652 {
    static int[] result;
    static boolean[] checked;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            result = new int[m];
            checked = new boolean[n];
            br.close();
            dfs(0);
            System.out.print(sb.toString());
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int index) {
        if (index == m) {
            for (int value : result) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (index > 0 && result[index - 1] > i +1)
                continue;
            result[index] = i + 1;
            dfs(index + 1);
        }
    }
}
