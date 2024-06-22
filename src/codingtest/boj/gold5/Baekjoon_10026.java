package codingtest.boj.gold5;

import java.io.*;

// 적록색약: https://www.acmicpc.net/problem/10026
// dfs
public class Baekjoon_10026 {

    static char[][] rgb;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count, n;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            rgb = new char[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) { // 값 초기화
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    rgb[i][j] = line.charAt(j);
                }
            }
            br.close();

            for (int i = 0; i < n; i++) { // 색약이 아닐 때
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j, rgb[i][j], false);
                        count++;
                    }
                }
            }
            System.out.print(count + " ");
            visited = new boolean[n][n];
            count = 0;
            for (int i = 0; i < n; i++) { // 색약일 때
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j, rgb[i][j], true);
                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int x, int y, char color, boolean isColorBlind) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if (ax >= 0 && ay >= 0 && ax < n && ay < n) {
                if (isSameColor(isColorBlind, color, ax, ay)) {
                    dfs(ax, ay, color, isColorBlind);
                }
            }
        }
    }

    public static boolean isSameColor(boolean isColorBlind, char currentColor, int ax, int ay) {
        if (!visited[ax][ay]) {
            if (isColorBlind) {
                // 현재 컬러가 같거나 현재 컬러와 근처 값이 R 또는 G일 때
                return rgb[ax][ay] == currentColor || (rgb[ax][ay] != 'B' && currentColor != 'B');
            } else {
                return rgb[ax][ay] == currentColor;
            }
        } else {
            return false;
        }
    }
}