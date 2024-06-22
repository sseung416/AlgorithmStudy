package codingtest.boj.silver5;

import java.util.*;
import java.io.*;

// 회사에 있는 사람: https://www.acmicpc.net/problem/7785
// 해시
public class Baekjoon_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            if (!set.remove(info[0])) {
                set.add(info[0]);
            }
        }

        List<String> list = new ArrayList<>(List.copyOf(set));
        list.sort(Collections.reverseOrder());
        for (String value : list) {
            sb.append(value).append("\n");
        }
        System.out.print(sb);
    }
}