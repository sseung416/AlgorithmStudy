package codingtest;

import java.util.*;
import java.io.*;

// 안전 영역: https://www.acmicpc.net/problem/2468
// bfs
class Baekjoon_2468 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int n;

    // 0..100(안전영역이 없을 때 까지) 침수 높이 값 올려주면서 bfs 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int max = 1;
        for (int h = 1; h <= 100; h++) { // 침수 높이
            int count = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > h && !visited[i][j]) {
                        bfs(new Point(i, j), h);
                        count++;
                    }
                }
            }
            if (count == 0) break;
            max = Math.max(count, max);
        }
        System.out.println(max);
    }

    public static void bfs(Point start, int height) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Point current = q.poll();
            for (int i = 0; i < 4; i++) {
                int ax = current.x + dx[i];
                int ay = current.y + dy[i];
                if (ax >= 0 && ay >= 0 && ax < n && ay < n) {
                    if (arr[ax][ay] > height && !visited[ax][ay]) {
                        q.offer(new Point(ax, ay));
                        visited[ax][ay] = true;
                    }
                }
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}