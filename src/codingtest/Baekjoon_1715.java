package codingtest;

import java.io.*;
import java.util.*;

// 카드 정렬하기: https://www.acmicpc.net/problem/1715
// 우선순위 큐
public class Baekjoon_1715 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        int sum = 0;
        if (n > 1) {
            while (!q.isEmpty()) {
                int v1 = q.poll();
                int v2;
                if (q.isEmpty()) {
                    sum += v1;
                    break;
                }
                v2 = q.poll();
                if (!q.isEmpty()) q.offer(v1 + v2);
                sum += v1 + v2;
            }
        }
        System.out.println(sum);
    }
}