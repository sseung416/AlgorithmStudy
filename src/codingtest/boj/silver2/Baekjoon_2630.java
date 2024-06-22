package codingtest.boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 만들기: https://www.acmicpc.net/problem/2630
// 재귀, 분할정복
public class Baekjoon_2630 {

    private static int[] count = new int[2];
    private static int[][] paper;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            paper = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            divide(n, 0, 0);
            System.out.println(count[0]);
            System.out.println(count[1]);
        } catch (IOException ignore) {}
    }

    public static void divide(int n, int r, int c) {
        if (isAllNumbersSame(r, c, n)) {
            count[paper[r][c]]++;
        } else {
            int length = n / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    divide(length, r + i * length, c + j * length);
                }
            }
        }
    }

    public static boolean isAllNumbersSame(int r, int c, int length) {
        int start = paper[r][c];
        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (paper[i][j] != start)
                    return false;
            }
        }
        return true;
    }
}
