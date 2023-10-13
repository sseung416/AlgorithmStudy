package codingtest;

import java.io.*;
import java.util.*;

// 체스판 다시 칠하기 2: https://www.acmicpc.net/problem/25682
// 누적합
// 장하다 해냈다!!
public class Baekjoon_25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        int[][] sum = new int[n + 1][m + 1];

        char startColor = 'W';
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);

                // 누적합 계산 (칠해야 하는 칸 수)
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j];
                // 현재 인덱스가 홀수인지 판단하는 함수
                boolean isOddIdx = j % 2 == 1;
                // 현재 값이 체스판의 올바른 형태가 아니라면, 칠해야 하는 개수를 증가해줌
                if ((startColor == board[i][j] && !isOddIdx) || (startColor != board[i][j] && isOddIdx)) {
                    sum[i + 1][j + 1]++;
                }
            }
            startColor = startColor == 'W' ? 'B' : 'W';
        }

        br.close();

        // 계산
        int min = Integer.MAX_VALUE;
        for (int startX = 1; startX + k - 1 <= n; startX++) { // k x k 체스판으로 쪼개기
            for (int startY = 1; startY + k - 1 <= m; startY++) {
                int endX = startX + k - 1;
                int endY = startY + k - 1;

                int count = sum[endX][endY] - sum[endX][startY - 1] - sum[startX - 1][endY] + sum[startX - 1][startY - 1];
                min = Math.min(min, count);
                min = Math.min(min, k * k - count);
            }
        }
        System.out.println(min);
    }
}
