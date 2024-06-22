package codingtest.boj.silver3;

import java.io.*;
import java.util.*;

// 바이러스: https://www.acmicpc.net/problem/2606
// dfs
public class Baekjoon_2606 {

    private static HashMap<Integer, ArrayList<Integer>> computers = new HashMap<>();
    private static boolean[] visited;
    private static int count = 0;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                String[] split = br.readLine().split(" ");
                setupList(split[0], split[1]);
                setupList(split[1], split[0]);
            }
            br.close();
            dfs(1);
            System.out.println(count);
        } catch (IOException ignore) {
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int node : computers.getOrDefault(start, new ArrayList<>())) {
            if (!visited[node]) {
                count++;
                dfs(node);
            }
        }
    }

    private static void setupList(String keyStr, String valueStr) {
        int key = Integer.parseInt(keyStr);
        ArrayList<Integer> list = computers.getOrDefault(key, new ArrayList<>());
        list.add(Integer.parseInt(valueStr));
        Collections.sort(list);
        computers.put(key, list);
    }
}
