package codingtest.boj.silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 그림: https://www.acmicpc.net/problem/1926
// bfs
public class Baekjoon_1926 {

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    int[][] drawing;

    public static void main(String[] args) {
        Baekjoon_1926 solution = new Baekjoon_1926();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        solution.drawing = new int[n][m];

        // 데이터 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                solution.drawing[i][j] = sc.nextInt();
            }
        }

        sc.close();

        int max = 0;
        int drawingCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (solution.drawing[i][j] == 1) {
                    drawingCount++;
                    int count = solution.bfs(i, j, n, m); // 그림 크기 계산
                    max = Math.max(max, count); // 현재 순회한 그림이 이전 그림보다 크다면 max에 삽입
                }
            }
        }

        System.out.println(drawingCount);
        System.out.println(max);
    }

    public int bfs(int x, int y, int n, int m) {
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        drawing[x][y] = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            count++; // 그림 크기 증가

            for (int i = 0; i < 4; i++) {
                int ax = current.x + dx[i];
                int ay = current.y + dy[i];
                if (ax >= 0 && ax < n && ay >= 0 && ay < m) {
                    if (drawing[ax][ay] == 1) {
                        queue.offer(new Point(ax, ay));
                        drawing[ax][ay] = 0;
                    }
                }
            }
        }
        return count;
    }
}