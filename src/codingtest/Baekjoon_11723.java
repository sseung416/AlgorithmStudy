package codingtest;

import java.util.*;
import java.io.*;

// 집합: https://www.acmicpc.net/problem/11723
// 자료구조, 셋
public class Baekjoon_11723 {
    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                set.add(st.nextToken());
            } else if (command.equals("remove")) {
                set.remove(st.nextToken());
            } else if (command.equals("check")) {
                if (set.contains(st.nextToken())) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("toggle")) {
                String value = st.nextToken();
                if (set.contains(value)) {
                    set.remove(value);
                } else {
                    set.add(value);
                }
            } else if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j + "");
                }
            } else {
                set = new HashSet<>();
            }
        }

        System.out.print(sb);
    }
}