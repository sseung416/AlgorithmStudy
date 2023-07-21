package codingtest;

import java.io.*;
import java.util.*;

// 듣보잡: https://www.acmicpc.net/problem/1764
public class Baekjoon_1764 {
    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if (set.contains(line))
                list.add(line);
            set.add(line);
        }
        br.close();
        Collections.sort(list);
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(list.size());
        System.out.print(sb);
    }
}
