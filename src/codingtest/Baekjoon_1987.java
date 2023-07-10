package codingtest;

import java.io.*;
import java.util.*;

// 알파벳: https://www.acmicpc.net/problem/1987
public class Baekjoon_1987 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n, m, count;
    static char[][] map;
    static HashSet<Character> visited = new HashSet<>();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][m];
            for (int i = 0; i < n; i++) { // 데이터 초기화
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j);
                }
            }
            br.close();
            dfs(0, 0);
            System.out.println(count);
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int x, int y) {
        char current = map[x][y];
        if (!visited.contains(current)) {
            visited.add(current);
            for (int i = 0; i < 4; i++) {
                int ax = x + dx[i];
                int ay = y + dy[i];
                if (ax >= 0 && ay >= 0 && ax < n && ay < m) {
                    dfs(ax, ay);
                }
            }
            count = Math.max(count, visited.size());
            visited.remove(current);
        }
    }
}
