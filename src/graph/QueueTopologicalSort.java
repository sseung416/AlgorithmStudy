package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Queue로 위상 정렬 구현
public class QueueTopologicalSort {

    // 노드의 개수
    private final int vertices;

    // 방향성 그래프
    private final List<List<Integer>> list;

    public QueueTopologicalSort(int vertices) {
        this.vertices = vertices;
        list = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            list.add(new ArrayList<>());
        }
    }

    // 노드 추가
    public void addEdge(int source, int destination) {
        list.get(source).add(destination);
    }

    // 위상 정렬
    public void sort() {
        // 진입 차수를 저장하는 배열 (노드의 값이 인덱스가 됨)
        int[] inDegree = new int[vertices];

        // 진입 차수 계산
        for (List<Integer> neighbors : list) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // 진입 차수가 0인 노드를 큐에 삽입
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 탐색 결과를 저장하는 리스트
        List<Integer> results = new ArrayList<>();

        // 큐가 빌 때까지 다음의 과정을 반복
        while (!queue.isEmpty()) {
            // 큐에서 노드를 꺼내고 탐색 결과 리스트에 해당 노드를 추가
            int node = queue.poll();
            results.add(node);

            // 해당 노드의 진출 차선을 제거
            for (int neighbor : list.get(node)) {
                inDegree[neighbor]--;

                // 새롭게 진입 차수가 0이 되었다면, 해당 노드를 큐에 삽입
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // 사이클 여부 확인 (결과 리스트의 크기가 정점의 개수가 동일하다면 사이클이 없음)
        if (results.size() == vertices) {
            System.out.println("위상 정렬 결과: " + results);
        } else {
            System.out.println("순환 그래프입니다. 위상 정렬을 수행할 수 없습니다.");
        }
    }

    public static void main(String[] args) {
        QueueTopologicalSort graph = new QueueTopologicalSort(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.sort();
    }
}