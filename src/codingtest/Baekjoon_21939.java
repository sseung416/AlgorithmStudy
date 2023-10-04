package codingtest;

import java.io.*;
import java.util.*;

// 문제 추천 시스템 Version 1: https://www.acmicpc.net/problem/21939
// 자료구조, 트리
// 자료구조를 여러 개 쓸 생각도 해보자~
public class Baekjoon_21939 {
    public static void main(String[] args) throws IOException {
        TreeSet<Problem> problems = new TreeSet<>((o1, o2) -> {
            // 레벨순 -> 문제 번호순
            if (o1.level == o2.level)
                return o1.number - o2.number;
            return o1.level - o2.level;
        });
        // 위 set에서 데이터를 삭제하기 위해 정의함 (문제 번호, 문제)
        Map<Integer, Problem> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            problems.add(problem);
            map.put(problem.number, problem);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operand = st.nextToken();
            if (operand.equals("recommend")) {
                if (st.nextToken().equals("1")) {
                    // 가장 레벨 큰 값 출력, 값이 같다면 번호가 큰 것 출력
                    sb.append(problems.last().number);
                } else {
                    // 가장 레벨 작은 값 출력, 값이 같다면 번호가 작은 것 출력
                    sb.append(problems.first().number);
                }
                sb.append('\n');
            } else if (operand.equals("add")) {
                Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                map.put(problem.number, problem);
                problems.add(problem);
            } else {
                // 해당 문제 번호에 부합하는 무제 삭제
                int problem = Integer.parseInt(st.nextToken());
                problems.remove(map.get(problem));
            }
        }
        br.close();
        System.out.print(sb);
    }

    static class Problem {
        int number, level;

        Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }
    }
}