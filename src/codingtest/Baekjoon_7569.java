package codingtest;

import java.util.*;
import java.io.*;

// 토마토: https://www.acmicpc.net/problem/7569
// bfs
public class Baekjoon_7569 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dz = {-1, 1};
    static int[][][] box;
    static int n, m, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[h][n][m];
        List<Point> starts = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int temp = box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (temp == 1) starts.add(new Point(i, j, k));
                }
            }
        }
        br.close();

        int cnt = bfs(starts);
        if (isAllChecked()) {
            if (cnt > 0) cnt--;
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }

    public static int bfs(List<Point> starts) {
        Queue<Point> q = new LinkedList<>(starts);
        int max = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int nextCnt = box[cur.z][cur.x][cur.y] + 1;
            for (int i = 0; i < 4; i++) {
                int ax = cur.x + dx[i];
                int ay = cur.y + dy[i];
                if (ax >= 0 && ay >= 0 && ax < n && ay < m) {
                    if (box[cur.z][ax][ay] == 0) {
                        box[cur.z][ax][ay] = nextCnt;
                        max = Math.max(max, nextCnt);
                        q.offer(new Point(cur.z, ax, ay));
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                int az = cur.z + dz[i];
                if (az >= 0 && az < h) {
                    if (box[az][cur.x][cur.y] == 0) {
                        box[az][cur.x][cur.y] = nextCnt;
                        max = Math.max(max, nextCnt);
                        q.offer(new Point(az, cur.x, cur.y));
                    }
                }
            }
        }
        return max;
    }

    public static boolean isAllChecked() {
        for (int[][] arr1 : box) {
            for (int[] arr2 : arr1) {
                for (int value : arr2) {
                    if (value == 0) return false;
                }
            }
        }
        return true;
    }

    static class Point {
        int x, y, z;

        Point(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
