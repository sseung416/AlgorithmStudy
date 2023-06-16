package graph;

import java.util.*;

public class BFSSearch {

    public Queue<String> bfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        Queue<String> visited = new LinkedList<>(); // 방문한 노드
        Queue<String> needVisit = new LinkedList<>(); // 방문해야 하는 노드

        needVisit.add(startNode); // 첫 번째 시작 노드 추가

        while (!needVisit.isEmpty()) {
            String node = needVisit.poll();

            if (!visited.contains(node)){
                needVisit.addAll(graph.get(node));
                visited.add(node);
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));

        BFSSearch search = new BFSSearch();
        System.out.print(search.bfs(graph, "A"));
    }
}