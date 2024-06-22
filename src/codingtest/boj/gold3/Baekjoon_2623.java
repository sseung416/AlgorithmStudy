package codingtest.boj.gold3;

import java.io.*;
import java.util.*;

// 음악프로그램: https://www.acmicpc.net/problem/2623
// 위상 정렬
public class Baekjoon_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 가수
        int m = Integer.parseInt(st.nextToken()); // PD

        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 노드 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 1; j < size; j++) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph.get(a).add(b);
                a = b; // 부모 노드 갱신
            }
        }
        br.close();

        // 진입 차선 계산
        int[] inDegree = new int[n];
        for (List<Integer> neighbors : graph) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        // 진입 차선이 0인 노드 큐에 삽입
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 위상 정렬~
        StringBuilder sb = new StringBuilder();
        int size = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + 1).append('\n');
            size++;

            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        System.out.print(size == n ? sb : 0);
    }
}
