package codingtest.programmers.level1;

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

    // 가장 많이 받은 선물: https://school.programmers.co.kr/learn/courses/30/lessons/258712
    // 구현, 자료구조
    public static class Programmers_258712 {
        public int solution(String[] friends, String[] gifts) {
            // 선물 지수를 저장하는 해시
            Map<String, Integer> scores = new HashMap<>();
            // 주고받은 선물의 수를 저장하는 해시
            Map<String, Integer> gives = new HashMap<>();

            for (int i = 0; i < gifts.length; i++) {
                // 주고받은 선물의 수를 기록
                String gift = gifts[i];
                gives.put(gift, gives.getOrDefault(gift, 0) + 1);

                // 선물 지수 계산
                String[] friend = gifts[i].split(" ");
                String giver = friend[0];
                String taker = friend[1];
                scores.put(giver, scores.getOrDefault(giver, 0) + 1);
                scores.put(taker, scores.getOrDefault(taker, 0) - 1);
            }

            Set<String> check = new HashSet<String>();
            Map<String, Integer> result = new HashMap<>();
            for (int i = 0; i < friends.length; i++) {
                for (int j = 0; j < friends.length; j++) {
                    if (i == j) continue;

                    String giver = friends[i];
                    String taker = friends[j];
                    if (check.contains(giver + " " + taker)) continue;
                    check.add(taker + " " + giver);

                    // 서로 주고 받은 선물의 수를 조회
                    int cnt1 = gives.getOrDefault(giver + " " + taker, 0);
                    int cnt2 = gives.getOrDefault(taker + " " + giver, 0);
                    String k;
                    if (cnt1 == cnt2) {
                        // 선물 주고 받은 개수가 같거나 주고받지 않았다면..
                        int t1 = scores.getOrDefault(giver, 0);
                        int t2 = scores.getOrDefault(taker, 0);

                        // 선물 지수도 같다면 선물 안 주고 받음
                        if (t1 == t2) continue;

                        // 선물 지수가 큰 사람이 작은 사람한테 선물 받음
                        k = t1 > t2 ? giver : taker;
                    } else {
                        // 준 선물이 많은 사람이 선물을 받음
                        k = cnt1 > cnt2 ? giver : taker;
                    }
                    result.put(k, result.getOrDefault(k, 0) + 1);
                }
            }

            int max = 0;
            for (String friend : result.keySet()) {
                System.out.println(friend + ": " + result.get(friend));
                max = Math.max(result.get(friend), max);
            }
            return max;
        }
    }
}
