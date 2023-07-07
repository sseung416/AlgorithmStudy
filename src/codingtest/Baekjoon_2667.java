package codingtest;

import java.io.*;
import java.util.*;

// 단지 번호 붙이기: https://www.acmicpc.net/problem/2667
public class Baekjoon_2667 {

    static int[][] map;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static int n;
    static int count = 0;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            br.close();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        count = 0;
                        dfs(i, j);
                        answer.add(count);
                    }
                }
            }

            Collections.sort(answer);
            System.out.println(answer.size());
            for (int size : answer) {
                System.out.println(size);
            }
        } catch (IOException ignore) {}
    }

    public static void dfs(int x, int y) {
        count++;
        map[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if (ax >= 0 && ay >= 0 && ax < n && ay < n) {
                if (map[ax][ay] == 1) {
                    dfs(ax, ay);
                }
            }
        }
    }
}
