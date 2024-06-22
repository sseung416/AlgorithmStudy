package codingtest.boj.silver4;

import java.util.*;
import java.io.*;

// 비밀번호 찾기: https://www.acmicpc.net/problem/17219
// 해시
public class Baekjoon_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            map.put(split[0], split[1]);
        }
        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}