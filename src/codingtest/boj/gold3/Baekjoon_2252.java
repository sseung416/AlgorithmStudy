package codingtest.boj.gold3;

import java.io.*;
import java.util.*;

// 줄 세우기: https://www.acmicpc.net/problem/2252
// 위상 정렬
public class Baekjoon_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수 (노드)
        int m = Integer.parseInt(st.nextToken()); // 키 비교 횟수

        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 노드 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
        }
        br.close();

        // 진입 차수 계산
        int[] inDegree = new int[n];
        for (List<Integer> neighbors : graph) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        // 진입 차수가 0인 학생(노드)를 큐에 추가
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 위상 정렬 시작~
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + 1).append(' ');

            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        System.out.print(sb);
    }
}
