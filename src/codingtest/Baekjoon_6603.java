package codingtest;

import java.io.*;
import java.util.*;

// 로또: https://www.acmicpc.net/problem/6603
// 백트랙킹
public class Baekjoon_6603 {
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            result = new int[6];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            search(0, 0);
            sb.append('\n');
        }
        br.close();
        System.out.print(sb);
    }

    public static void search(int depth, int idx) {
        if (depth == 6) {
            for (int value : result) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = idx; i < k; i++) {
            result[depth] = arr[i];
            search(depth + 1, i + 1);
        }
    }
}