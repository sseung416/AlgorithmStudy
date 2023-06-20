package codingtest;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1012
public class Baekjoon_1012 {

    int t, m, n, k;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int[][] map;

    public static void main(String[] args) {
        Baekjoon_1012 main = new Baekjoon_1012();
        main.run();
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            List<Integer> result = new ArrayList<>();
            t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                // 데이터 초기화
                map = new int[m][n];
                for (int j = 0; j < k; j++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    map[x][y] = 1;
                }

                int count = 0;
                for (int a = 0; a < m; a++) {
                    for (int b = 0; b < n; b++) {
                        if (map[a][b] == 1) {
                            bfs(a, b);
                            count++;
                        }
                    }
                }
                result.add(count);
            }

            for (int count : result) {
                System.out.println(count);
            }
        } catch (IOException ignore) {
        }
    }

    public void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ax = current.x + dx[i];
                int ay = current.y + dy[i];
                if (ax >= 0 && ay >= 0 && ax < m && ay < n) {
                    if (map[ax][ay] == 1) {
                        map[ax][ay] = 0;
                        queue.offer(new Point(ax, ay));
                    }
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}