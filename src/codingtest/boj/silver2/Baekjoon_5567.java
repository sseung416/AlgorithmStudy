package codingtest.boj.silver2;

import java.io.*;
import java.util.*;

// 결혼식: https://www.acmicpc.net/problem/5567
// dfs
// 양방향 그래프를 구현하는 방법 알기
public class Baekjoon_5567 {

    static List<Integer>[] list; // 그래프
    static boolean[] checked; // 친구
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        checked = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방형 그래프를 구현하기 위해 두 값을 서로 연결해줌
            list[a].add(b);
            list[b].add(a);
        }
        br.close();

        checked[1] = true;
        dfs(1, 0);

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (checked[i]) cnt++;
        }
        System.out.println(cnt);
    }

    // 탐색 시작할 친구의 번호, 깊이(친구의 친구..)
    public static void dfs(int start, int depth) {
        // 현재 친구가 상근이의 친구의 친구의 친구라면 탐색 종료
        if (depth == 2) return;
        for (int friend : list[start]) {
            checked[friend] = true;
            dfs(friend, depth + 1);
        }
    }
}
