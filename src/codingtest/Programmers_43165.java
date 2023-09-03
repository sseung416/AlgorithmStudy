package codingtest;

// 타겟 넘버: https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
// DFS
public class Programmers_43165 {
    static int[] arr;
    static boolean[][] visited;
    static int target;
    static int cnt = 0;

    public int solution(int[] numbers, int target) {
        arr = numbers;
        visited = new boolean[numbers.length][2];
        this.target = target;
        dfs(0, 0, 0);
        return cnt;
    }

    public static void dfs(int n, int sign, int sum) {
        if (n == arr.length) {
            if (sum == target) cnt++;
            return;
        }

        visited[n][sign] = true;
        dfs(n + 1, 0, sum + arr[n] * -1);
        dfs(n + 1, 1, sum + arr[n]);
    }
}
