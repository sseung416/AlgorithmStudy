package codingtest.boj.silver5;

import java.util.*;
import java.io.*;

// 단어 정렬: https://www.acmicpc.net/problem/1181
// 정렬, 문자열
public class Baekjoon_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        br.close();

        Arrays.sort(arr, (o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            if (len1 > len2) {
                return 1;
            } else if (len1 == len2) {
                return o1.compareTo(o2);
            } else {
                return -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        String distinct = null;
        for (String str : arr) {
            if (str.equals(distinct)) continue;
            sb.append(str).append("\n");
            distinct = str;
        }
        System.out.print(sb);
    }
}
