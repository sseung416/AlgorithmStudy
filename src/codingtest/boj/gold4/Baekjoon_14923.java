package codingtest.boj.gold4;

import java.io.*;
import java.util.*;

// 미로 탈출: https://www.acmicpc.net/problem/14923
// bfs
public class Baekjoon_14923 {

    static int[][] arr;
    static int[][][] visited; // 미로 (지팡이 사용 X, 지팡이 사용 O)
    static int hx, hy, ex, ey, n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        hx = Integer.parseInt(st.nextToken()) - 1;
        hy = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[n][m];
        visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        System.out.println(bfs() - 1);
    }

    public static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(hx, hy, false));
        visited[hx][hy][0] = 1; // 시작점 방문 표시
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int z = cur.isBroken ? 1 : 0;
            for (int i = 0; i < 4; i++) {
                int ax = dx[i] + cur.x;
                int ay = dy[i] + cur.y;

                // 인덱스를 넘어가거나 이미 방문했다면 다음 순회
                if (ax < 0 || ay < 0 || ax >= n || ay >= m) continue;
                if (visited[ax][ay][z] != 0) continue;

                int point = visited[cur.x][cur.y][z] + 1;
                // 도착하면 포인트 반환
                if (ax == ex && ay == ey) return point;

                if (arr[ax][ay] == 1) {
                    // 벽인데 지팡이를 사용하지 않았다면, 지팡이 사용 (벽 무시하고 이동)
                    if (cur.isBroken) continue;
                    q.offer(new Point(ax, ay, true));
                    visited[ax][ay][1] = point;
                } else {
                    // 벽이 아닐 때, 걍 이동
                    q.offer(new Point(ax, ay, cur.isBroken));
                    visited[ax][ay][z] = point;
                }
            }
        }
        return 0;
    }

    static class Point {
        int x, y;
        boolean isBroken;

        Point(int x, int y, boolean isBroken) {
            this.x = x;
            this.y = y;
            this.isBroken = isBroken;
        }
    }
}
