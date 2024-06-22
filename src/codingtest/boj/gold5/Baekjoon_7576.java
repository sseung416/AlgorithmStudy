package codingtest.boj.gold5;

import java.util.*;

// 토마토: https://www.acmicpc.net/problem/7576
// bfs
public class Baekjoon_7576 {

    static class Point {
        int x, y;
        int count = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] box;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Baekjoon_7576 main = new Baekjoon_7576();
        List<Point> starts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        main.box = new int[n][m];
        // 데이터 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = sc.nextInt();
                main.box[i][j] = value;
                if (value == 1) {
                    starts.add(new Point(i, j));
                }
            }
        }
        sc.close();

        int count = main.bfs(starts, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (main.box[i][j] == 0) {
                    System.out.print("-1");
                    return;
                }
            }
        }
        System.out.print(count);
    }

    public int bfs(List<Point> starts, int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        for (Point point : starts) {
            queue.offer(point);
            box[point.x][point.y] = 1;
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            count = current.count;
            for (int i = 0; i < 4; i++) {
                int ax = current.x + dx[i];
                int ay = current.y + dy[i];
                if (ax >= 0 && ay >= 0 && ax < n && ay < m) {
                    if (box[ax][ay] == 0) {
                        box[ax][ay] = 1;
                        Point next = new Point(ax, ay);
                        next.count = current.count + 1;
                        queue.offer(next);
                    }
                }
            }
        }
        return count;
    }
}