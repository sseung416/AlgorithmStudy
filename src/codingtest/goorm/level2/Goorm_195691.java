package codingtest.goorm.level2;

import java.io.*;
import java.util.*;

// 폭탄 구현하기 (2): https://level.goorm.io/exam/195691/폭탄-구현하기-2/quiz/1
// 구현
public class Goorm_195691 {
    private static String[][] map; // 땅의 정보
    private static int[][] bombs; // 폭탄 값을 저장하는 배열
    private static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());
        map = new String[n][n];
        bombs = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
            }
        }

        // 폭탄 떨어트림
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            final int y = Integer.parseInt(st.nextToken()) - 1;
            final int x = Integer.parseInt(st.nextToken()) - 1;
            bomb(x, y);
        }

        // 결과 값 출력
        int max = getMaximumBombCount();
        System.out.print(max);
    }

    private static void bomb(final int x, final int y) {
        final int[] dx = {1,-1,0,0};
        final int[] dy = {0,0,1,-1};

        // 현재 좌표 폭탄 값 증가
        bombs[y][x] += getBombCountByGround(map[y][x]);

        // 인접한 좌표 폭탄 값 증가 탐색
        for (int i = 0; i < 4; i++) {
            final int ax = dx[i] + x;
            final int ay = dy[i] + y;

            if (isInvalidCoordinate(ax, ay)) {
                continue;
            }

            bombs[ay][ax] += getBombCountByGround(map[ay][ax]);
        }
    }

    // 올바르지 않은 좌표 값인지의 여부를 반환
    private static boolean isInvalidCoordinate(final int x, final int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    // 땅의 상태에 따라 폭탄 값을 반환하는 함수
    private static int getBombCountByGround(final String ground) {
        switch (ground) {
            case "@":
                return 2;
            case "#":
                return 0;
            default:
                return 1;
        }
    }

    // 가장 높은 폭탄 값을 반환하는 함수
    private static int getMaximumBombCount() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(bombs[i][j], max);
            }
        }
        return max;
    }
}
