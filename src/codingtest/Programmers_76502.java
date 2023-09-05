package codingtest;

import java.util.*;

// 괄호 회전하기:  https://school.programmers.co.kr/learn/courses/30/lessons/76502#
// 스택
public class Programmers_76502 {
    static List<String> list = new ArrayList<>();

    public int solution(String s) {
        int answer = 0;
        list.addAll(Arrays.asList(s.split("")));
        for (int i = 0; i < s.length(); i++) {
            // 왼쪽으로 회전하는 부분
            list.add(list.size() - 1, list.remove(0));
            // 올바른 괄호라면 count를 증가
            if (isAvailable()) answer++;
        }
        return answer;
    }

    // 올바른 괄호인지 판별
    public static boolean isAvailable() {
        Stack<String> stack = new Stack<>();
        stack.push(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (stack.isEmpty()) {
                stack.push(list.get(i));
                continue;
            }

            String before = stack.peek();
            String current = list.get(i);
            // 현재 값이 닫는 괄호가 아니라면 stack에 값 추가
            switch (current) {
                case ")":
                    current = "(";
                    break;
                case "]":
                    current = "[";
                    break;
                case "}":
                    current = "{";
                    break;
                default:
                    stack.push(current);
                    continue;
            }

            if (before.equals(current))
                stack.pop();
        }
        return stack.isEmpty();
    }
}
