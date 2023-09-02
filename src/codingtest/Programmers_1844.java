package codingtest;

import java.util.*;

// 게임 맵 최단거리: https://school.programmers.co.kr/learn/courses/30/lessons/1844
// bfs
public class Programmers_1844 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n, m;
    static int[][] map;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        map = maps;
        return bfs(0, 0);
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 1));
        map[x][y] = 0;
        while (!q.isEmpty()) {
            Point current = q.poll();

            for (int i = 0; i < 4; i++) {
                int ax = current.x + dx[i];
                int ay = current.y + dy[i];
                if (ax >= 0 && ay >= 0 && ax < n && ay < m) {
                    if (map[ax][ay] == 1) {
                        if (ax == n - 1 && ay == m - 1)
                            return current.point + 1;

                        map[ax][ay] = 0;
                        q.offer(new Point(ax, ay, current.point + 1));
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int x, y, point;

        Point(int x, int y, int point) {
            this.x = x;
            this.y = y;
            this.point = point;
        }
    }
}
