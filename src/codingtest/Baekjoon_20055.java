package codingtest;

import java.io.*;
import java.util.*;

// 컨베이어 벨트 위의 로봇: https://www.acmicpc.net/problem/20055
public class Baekjoon_20055 {
    static int n, k;
    static List<Integer> belt = new ArrayList<>(); // 각 칸의 내구도 값
    static List<Integer> robots = new ArrayList<>(); // 로봇이 위치한 벨트의 인덱스 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            belt.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        int count = 0;
        while (check()) {
            count++;
            rotate();
            moveRobot();
            putRobot();
        }
        System.out.println(count);
    }

    // 내구도 체크
    public static boolean check() {
        int count = 0;
        for (int block : belt) {
            if (block == 0) count++;
        }
        return count < k;
    }

    // 벨트 회전
    public static void rotate() {
        belt.add(0, belt.remove(n * 2 - 1));

        // 로봇 회전
        if (!robots.isEmpty()) {
            int lastIdx = robots.size() - 1;
            for (int i = 0; i <= lastIdx; i++) {
                robots.add(i, robots.remove(i) + 1);
            }

            // n번째 칸에 왔을 때 로봇을 내림
            if (robots.get(lastIdx) == n - 1) robots.remove(lastIdx);
        }
    }

    // 첫 번째 칸에 로봇 넣기
    public static void putRobot() {
        // 내구도가 0보다 크면 로봇 추가
        if (belt.get(0) > 0) {
            robots.add(0, 0);
            belt.add(0, belt.remove(0) - 1); // 내구도 줄임
        }
    }

    // 로봇 이동
    public static void moveRobot() {
        // 가장 먼저 벨트에 올라간 로봇부터 탐색
        for (int i = robots.size() - 1; i >= 0; i--) {
            int nextBeltIdx = robots.get(i) + 1;
            // 벨트 내구도가 남아있고 앞에 로봇이 없다면 로봇 이동
            if (belt.get(nextBeltIdx) > 0 && !robots.contains(nextBeltIdx)) {
                belt.add(nextBeltIdx, belt.remove(nextBeltIdx) - 1);
                robots.remove(i);

                // n번째 칸 체크
                if (nextBeltIdx != n - 1) robots.add(i, nextBeltIdx);
            }
        }
    }
}