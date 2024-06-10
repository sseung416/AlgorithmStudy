package codingtest;

import java.util.*;
import java.io.*;

// 로봇 청소기: https://www.acmicpc.net/problem/14503
// 구현
public class Baekjoon_14503 {
    static int n, m, r, c, d;
    static int[][] room; // 0은 청소 X, 1은 벽, 2는 청소 O
    static int[] dx = {-1,0,1,0}; // 북, 동, 남, 서
    static int[] dy = {0,1,0,-1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                // 0은 청소 X, 1은 벽
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        while (true) {
            cleanIfNot();
            if (isNotCleanNear()) {
                // 주변에 청소되지 않은 칸이 있는 경우 (3)
                rotate();
                goIfNotClean();
            } else {
                // 청소되지 않은 칸이 없는 경우 (2)
                if (isFinish()) break;
                goBack();
            }
        }
        System.out.print(count);
    }

    public static void cleanIfNot() {
        if (room[r][c] == 0) {
            count++;
            room[r][c] = 2;
        }
    }

    public static void goIfNotClean() {
        int ax = r + dx[d];
        int ay = c + dy[d];
        if (room[ax][ay] == 0) {
            r = ax;
            c = ay;
        }
    }

    public static void goBack() {
        int dIdx = (d + 2) % 4;
        r += dx[dIdx];
        c += dy[dIdx];
    }

    public static boolean isNotCleanNear() {
        for (int i = 0; i < 4; i++) {
            int ax = r + dx[i];
            int ay = c + dy[i];
            if (room[ax][ay] == 0) return true;
        }
        return false;
    }

    public static void rotate() {
        d--;
        d = d < 0 ? d + 4 : d;
    }

    public static boolean isFinish() {
        // 바라보는 방향의 뒤쪽이 벽이라 후진할 수 없다면 true 반환
        int dIdx = (d + 2) % 4;
        int ax = r + dx[dIdx];
        int ay = c + dy[dIdx];
        return room[ax][ay] == 1;
    }
}