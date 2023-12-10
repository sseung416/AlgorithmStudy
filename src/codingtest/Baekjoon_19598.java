package codingtest;

import java.io.*;
import java.util.*;

// 최소 회의실 개수: https://www.acmicpc.net/problem/19598
// 우선순위 큐, 자료구조
public class Baekjoon_19598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 시간, 종료 시간 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(arr[0][1]); // 첫 번째 값 초기화 (가장 빠른 회의 시작 시간의 종료 시간)

        for (int i = 1; i < n; i++) {
            // 다음 회의 시작 시간이 종료 시간보다 느리다면.. 새 회의실 예약 (큐의 개수가 곧 회의실 개수!)
            if (queue.peek() <= arr[i][0]) queue.poll();
            queue.offer(arr[i][1]);
        }
        System.out.println(queue.size());
    }
}
