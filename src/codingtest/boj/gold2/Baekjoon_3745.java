package codingtest.boj.gold2;

import java.io.*;
import java.util.*;

// 오름세: https://www.acmicpc.net/problem/3745
// LIS, 이분탐색
public class Baekjoon_3745 {
    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            int[] arr = new int[n];
            lis = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            lis[0] = arr[0];
            int idx = 0;
            for (int i = 1; i < n; i++) {
                if (lis[idx] < arr[i]) {
                    lis[++idx] = arr[i];
                } else {
                    lis[binarySearch(arr[i], idx)] = arr[i];
                }
            }
            sb.append(idx + 1).append('\n');
        }
        br.close();
        System.out.print(sb);
    }

    public static int binarySearch(int target, int end) {
        int start = 0;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (lis[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}