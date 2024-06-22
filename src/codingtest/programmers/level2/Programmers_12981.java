package codingtest.programmers.level2;

import java.util.*;

// 영어 끝말잇기: https://school.programmers.co.kr/learn/courses/30/lessons/12981
// 해시
public class Programmers_12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();
        String before = null;
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            // 이전에 말한 단어이거나 잘못된 단어일 때(끝나는 단어로 시작하는 단어가 아닐 때)
            if (set.contains(words[i]) || (before != null && before.charAt(before.length() - 1) != current.charAt(0))) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else {
                set.add(current);
                before = current;
            }
        }
        return answer;
    }
}
