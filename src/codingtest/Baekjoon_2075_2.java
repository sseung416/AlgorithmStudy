package codingtest;

import java.io.*;
import java.util.*;

// N번째 큰 수: https://www.acmicpc.net/problem/2075
// 트리, 자료구조
public class Baekjoon_2075_2 {
    public static void main(String[] args) throws IOException {
        TreeSet<Integer> s = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (s.size() > n) s.pollFirst();
                s.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            s.pollLast();
        }
        System.out.println(s.pollLast());
    }
}
