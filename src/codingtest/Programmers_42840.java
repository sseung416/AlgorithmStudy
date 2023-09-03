package codingtest;

import java.util.*;

// 모의고사: https://school.programmers.co.kr/learn/courses/30/lessons/42840
// 완전탐색
public class Programmers_42840 {
    public int[] solution(int[] answers) {
        int[] ans = new int[]{0,0,0};

        int[] secondAns = {1,3,4,5};
        int[] thirdAns = {3,1,2,4,5};

        for (int i = 0; i < answers.length; i++) {
            if ((i % 5) + 1 == answers[i]) ans[0]++;
            int currentSecondAns = i % 2 == 0 ? 2 : secondAns[i / 2 % 4];
            if (currentSecondAns == answers[i]) ans[1]++;
            if (thirdAns[i / 2 % 5] == answers[i]) ans[2]++;
        }

        int max = Math.max(ans[0], Math.max(ans[1], ans[2]));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (ans[i] == max) list.add(i + 1);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
