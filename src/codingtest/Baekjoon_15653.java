package codingtest;

import java.io.*;
import java.util.*;

// 구슬 탈출 4: https://www.acmicpc.net/problem/15653
// TODO: 2023/12/06 다시 풀기~ 
public class Baekjoon_15653 {

    static char[][] map;
    // 빨간색 구슬, 파란색 구슬 범위 체크
    // 원래는 빨간색 구슬만 체크해주었는데, 빨간색 구슬의 위치는 동일한데 파란색 구슬의 위치는 달라지는 경우가 생겨 4차원 배열로 선언
    static boolean[][][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][n][m];

        Point r = null, b = null;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char cur = map[i][j] = line.charAt(j);
                if (cur == 'B') {
                    b = new Point(i, j);
                } else if (cur == 'R') {
                    r = new Point(i, j);
                }
            }
        }
        br.close();

        System.out.println(bfs(r, b));
    }

    public static int bfs(Point startR, Point startB) {
        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(startR, startB, 1));
        visited[startR.x][startR.y][startB.x][startB.y] = true;

        while (!q.isEmpty()) {
            Location cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int redX = cur.red.x + dx[i];
                int redY = cur.red.y + dy[i];
                int blueX = cur.blue.x + dx[i];
                int blueY = cur.blue.y + dy[i];

                // 구슬이 구멍에 들어갔는지 여부
                boolean isGoalRed = false, isGoalBlue = false;

                // 빨간 구슬 이동
                while (true) {
                    if (isWall(redX, redY)) break;
                    if (isHole(redX, redY)) {
                        isGoalRed = true;
                        break;
                    }
                    redX += dx[i];
                    redY += dy[i];
                }
                redX -= dx[i];
                redY -= dy[i];

                // 파란 구슬 이동
                while (true) {
                    if (isWall(blueX, blueY)) break;
                    if (isHole(blueX, blueY)) {
                        isGoalBlue = true;
                        break;
                    }
                    blueX += dx[i];
                    blueY += dy[i];
                }
                blueX -= dx[i];
                blueY -= dy[i];

                // 파란색 구슬이 구멍에 빠지면 실패이므로, 이번 순회는 큐에 추가하지 않음
                if (isGoalBlue) continue;
                // 파란색 구슬이 구멍에 빠지지 않고 빨간색 구슬만 구멍에 빠지면, count를 반환
                if (isGoalRed) return cur.pt;

                // 위 이동 과정에서 다른 구슬의 위치와 상관없이 이동해주었으므로(앞에 구슬이 있더라도 통과함),
                // 어떤 구슬이 이동 과정의 앞에 있었는지 확인이 필요함
                // 두 구슬이 겹쳐있을 때만 나란히 이어져 있는 형태일테니, 두 구슬의 좌표가 동일할 때만 확인함
                if (redX == blueX && redY == blueY) {
                    int redDistance = getDistance(cur.red.x, cur.red.y, redX, redY);
                    int blueDistance = getDistance(cur.blue.x, cur.blue.y, blueX, blueY);

                    // 더 멀리 있는 구슬이 뒤에 있던 구슬
                    if (redDistance > blueDistance) {
                        redX -= dx[i];
                        redY -= dy[i];
                    } else {
                        blueX -= dx[i];
                        blueY -= dy[i];
                    }
                }

                if (visited[redX][redY][blueX][blueY]) continue;

                q.offer(new Location(new Point(redX, redY), new Point(blueX, blueY), cur.pt + 1));
                visited[redX][redY][blueX][blueY] = true;
            }
        }
        return -1;
    }

    public static boolean isWall(int x, int y) {
        return map[x][y] == '#';
    }

    public static boolean isHole(int x, int y) {
        return map[x][y] == 'O';
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        // 맨하탄 거리 공식...
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Location {
        Point red, blue;
        int pt;

        Location(Point red, Point blue, int point) {
            this.red = red;
            this.blue = blue;
            this.pt = point;
        }
    }
}