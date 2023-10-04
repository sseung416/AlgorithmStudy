package codingtest;

import java.util.*;
import java.io.*;

// 절댓값 힙: https://www.acmicpc.net/problem/11286
// 우선순위 큐
public class Baekjoon_11286 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            // 절댓값 기준으로 비교
            int value = Math.abs(o1) - Math.abs(o2);
            if (value == 0) {
                // 절댓값이 같다면, 더 작은 값 기준으로 비교
                return o1 - o2;
            } else {
                return value;
            }
        });
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (q.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(q.poll());
                }
                sb.append('\n');
            } else {
                q.offer(value);
            }
        }
        br.close();
        System.out.print(sb);
    }
}
