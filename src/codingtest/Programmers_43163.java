package codingtest;

import java.util.*;

// 단어 변환: https://school.programmers.co.kr/learn/courses/30/lessons/43163
// DFS/BFS
public class Programmers_43163 {
    static String[] arr;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        arr = words;
        visited = new boolean[words.length];
        return bfs(begin, target);
    }

    public static int bfs(String begin, String target) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(begin, 0));
        while (!q.isEmpty()) {
            Point current = q.poll();
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i] && canTransform(current.word, arr[i])) {
                    if (arr[i].equals(target)) {
                        return current.pt + 1;
                    }
                    visited[i] = true;
                    q.offer(new Point(arr[i], current.pt + 1));
                }
            }
        }
        return 0;
    }

    public static boolean canTransform(String target, String transform) {
        boolean checked = false;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != transform.charAt(i)) {
                if (checked) return false;
                checked = true;
            }
        }
        return true;
    }

    static class Point {
        String word;
        int pt;

        Point(String word, int pt) {
            this.word = word;
            this.pt = pt;
        }
    }
}