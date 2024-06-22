package codingtest.boj.silver4;

import java.io.*;
import java.util.*;

// 줄세우기: https://www.acmicpc.net/problem/10431
// 삽입 정렬
class Baekjoon_10431 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        arr = new int[p][20];
        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 0; j < 20; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p; i++) {
            sb.append(i + 1).append(" ").append(sort(arr[i])).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int sort(int[] arr) {
        int count = 0;
        for (int i = 1; i < 20; i++) {
            int tmp = arr[i];
            int j = i - 1;

            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
                count++;
            }
            arr[j + 1] = tmp;
        }
        return count;
    }
}