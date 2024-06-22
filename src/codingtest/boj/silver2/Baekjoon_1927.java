package codingtest.boj.silver2;

import java.io.*;
import java.util.*;

// 최소 힙: https://www.acmicpc.net/problem/1927
// 자료구조, 우선순위 큐
public class Baekjoon_1927 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            if (x == 0) {
                long value;
                if (q.isEmpty()) {
                    value = 0;
                } else {
                    value = q.poll();
                }
                sb.append(value).append('\n');
            } else {
                q.offer(x);
            }
        }
        System.out.print(sb);
    }
}
