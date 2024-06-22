package codingtest.boj.silver1;

import java.io.*;

// 쿼드트리: https://www.acmicpc.net/problem/1992
// 분할 정복, 재귀
public class Baekjoon_1992 {

    private static StringBuilder sb = new StringBuilder();
    private static int[][] quadTree;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            quadTree = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    quadTree[i][j] = line.charAt(j) - '0';
                }
            }

            recursive(n, 0, 0);
            System.out.println(sb.toString());
        } catch (IOException ignore) {
        }
    }

    public static void recursive(int n, int r, int c) {
        if (isSameAll(n, r, c)) {
            sb.append(quadTree[r][c]);
        } else {
            int size = n / 2;
            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    recursive(size, r + i * size, c + j * size);
                }
            }
            sb.append(")");
        }
    }

    public static boolean isSameAll(int size, int r, int c) {
        int start = quadTree[r][c];
        for (int i = r; i < size + r; i++) {
            for (int j = c; j < size + c; j++) {
                if (start != quadTree[i][j])
                    return false;
            }
        }
        return true;
    }
}
