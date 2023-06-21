package codingtest;

import java.util.*;
import java.io.*;

// 미로 탐색: https://www.acmicpc.net/problem/2178
public class Baekjoon_2178 {

    // 인접점 좌표 값
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        try {
            Baekjoon_2178 main = new Baekjoon_2178();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n + 1][m + 1];

            // 데이터 초기화
            for (int i = 1; i <= n; i++) {
                String line = br.readLine();
                for (int j = 1; j <= m; j++) {
                    map[i][j] = line.charAt(j - 1) - '0';
                }
            }

            int count = main.bfs(map, n, m);
            System.out.println(count);
        } catch (IOException ignore) {}
    }

    private int bfs(int[][] map, int n, int m) {
        Queue<Point> needVisit = new LinkedList<>(); // 방문해야 하는 노드
        needVisit.offer(new Point(1, 1));
        while (!needVisit.isEmpty()) {
            Point current = needVisit.poll();
            for (int i = 0; i < 4; i++) {
                int ax = dx[i] + current.x;
                int ay = dy[i] + current.y;
                if (ax <= n && ay <= m) { // 배열 크기를 넘어가지 않는다면..
                    if (map[ax][ay] == 1) { // 인접 노드가 길이라면..
                        needVisit.offer(new Point(ax, ay));
                        map[ax][ay] = map[current.x][current.y] + 1;
                    }
                }
            }
        }

        return map[n][m];
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
