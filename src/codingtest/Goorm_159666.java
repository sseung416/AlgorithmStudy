package codingtest;

import java.io.*;
import java.util.*;

// 폭탄 구현하기: https://level.goorm.io/exam/159666/폭탄-구현하기/quiz/1
// 구현
public class Goorm_159666 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());

        final int[][] map = new int[n][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            final int y = Integer.parseInt(st.nextToken()) - 1;
            final int x = Integer.parseInt(st.nextToken()) - 1;

            bomb(map, n, x, y);
        }

        final int sum = getBombSum(map, n);
        System.out.print(sum);
    }

    private static int getBombSum(int[][] map, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static void bomb(int[][] map, int n, int x, int y) {
        final int[] dx = {0,0,-1,1};
        final int[] dy = {-1,1,0,0};

        // 현재 위치의 폭탄 값 증가
        map[y][x]++;

        // 인접한 상하좌우의 폭탄 값 증가
        for (int i = 0; i < 4; i++) {
            final int ax = x + dx[i];
            final int ay = y + dy[i];

            // 인접 좌표가 배열의 범위를 넘어섰다면 다음 순회로 넘김
            if (isInvalidCoordinate(ax, ay, n)) {
                continue;
            }

            map[ax][ay]++;
        }
    }

    private static boolean isInvalidCoordinate(int x, int y, int n) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
