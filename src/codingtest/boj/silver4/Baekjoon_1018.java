package codingtest.boj.silver4;

import java.io.*;
import java.util.*;

// 체스판 다시 칠하기: https://www.acmicpc.net/problem/1018
// 완전탐기
public class Baekjoon_1018 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] board = new char[n][m];
            int answer = 1000;

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
            br.close();

            for (int i = 0; n - (i + 8) >= 0; i++) { // 8x8 배열로 쪼갬
                for (int j = 0; m - (j + 8) >= 0; j++) {
                    int count = 0;
                    char startPoint = board[i][j];
                    for (int k = i; k < 8 + i; k++) { // 배열 순회
                        boolean isOddIndex = true;
                        for (int l = j; l < 8 + j; l++) {
                            if ((isOddIndex && startPoint != board[k][l]) || (!isOddIndex && startPoint == board[k][l])) {
                                count++;
                            }
                            isOddIndex = !isOddIndex;
                        }
                        startPoint = startPoint == 'W' ? 'B' : 'W';
                    }

                    count = Math.min(count, 64 - count); // BW 기준 비교와 WB 기준 비교의 count 값의 최소값 구함
                    answer = Math.min(answer, count);
                }
            }

            System.out.println(answer);
        } catch (IOException ignore) {
        }
    }
}