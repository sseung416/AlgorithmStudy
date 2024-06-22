package codingtest.programmers.level1;

import java.util.HashMap;

// 성격 유형 검사하기: https://school.programmers.co.kr/learn/courses/30/lessons/118666
// 구현
public class Programmers_11866 {
    public static void run() {
        Programmers_11866 problem = new Programmers_11866();
        String answer1 = problem.solution(new String[] { "AN", "CF", "MJ", "RT", "NA" }, new int[] { 5, 3, 2, 7, 5 });
        String answer2 = problem.solution(new String[] { "TR", "RT", "TR" }, new int[] { 7, 1, 3 });
        System.out.println(answer1);
        System.out.println(answer2);
    }

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        HashMap<String, Integer> hashMap = setupLinkedHashMap();
        int size = survey.length;

        // choices[0] / 4 == 0 일 때 survey[0].split(" ")[0]의 점수는 [ 원 점수 + (choices[0] - 4) * -1 ]
        // 위 조건이 아닐 때 survey[0].split(" ")[1]의 점수는 [ 원 점수 + (choices[0] - 4) ]
        for (int i = 0; i < size; i++) {
            String[] temp = survey[i].split("");
            int choice = choices[i];
            String id; // 더 높은 형
            int score; // 높은 형의 점수

            if (choice / 4 == 0) {
                id = temp[0];
                score = (choice - 4) * -1;
            } else {
                id = temp[1];
                score = choice - 4;
            }

            int currentScore = hashMap.get(id) + score;
            hashMap.put(id, currentScore);
        }

        answer.append(hashMap.get("R") >= hashMap.get("T") ? "R" : "T");
        answer.append(hashMap.get("C") >= hashMap.get("F") ? "C" : "F");
        answer.append(hashMap.get("J") >= hashMap.get("M") ? "J" : "M");
        answer.append(hashMap.get("A") >= hashMap.get("N") ? "A" : "N");

        return answer.toString();
    }

    private HashMap<String, Integer> setupLinkedHashMap() {
        return new HashMap<>() {
            {
                put("R", 0);
                put("T", 0);
                put("C", 0);
                put("F", 0);
                put("J", 0);
                put("M", 0);
                put("A", 0);
                put("N", 0);
            }
        };
    }
}
