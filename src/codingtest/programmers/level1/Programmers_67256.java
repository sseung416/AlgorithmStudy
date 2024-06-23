package codingtest.programmers.level1;

import java.util.*;

// [카카오 인턴] 키패드 누르기: https://school.programmers.co.kr/learn/courses/30/lessons/67256
// 구현, 자료구조
public class Programmers_67256 {
    String left = "30";
    String right = "32";
    StringBuilder sb = new StringBuilder();

    public String solution(int[] numbers, String hand) {
        Map<Integer, String> keypad = new HashMap<>();
        int n = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypad.put(n++, i + "" + j);
            }
        }
        keypad.put(0, "31");

        for (int num : numbers) {
            String target = keypad.get(num);

            if (num == 1 || num == 4 || num == 7) {
                appendLeft(target);
                continue;
            }

            if (num == 3 || num == 6 || num == 9) {
                appendRight(target);
                continue;
            }

            int leftDistance = getDistance(left, target);
            int rightDistance = getDistance(right, target);
            if (leftDistance == rightDistance) {
                if (hand.equals("left")) {
                    appendLeft(target);
                } else {
                    appendRight(target);
                }
                continue;
            }

            if (leftDistance < rightDistance) {
                appendLeft(target);
            } else {
                appendRight(target);
            }
        }

        return sb.toString();
    }

    int getDistance(String cur, String target) {
        int distance = 0;
        for (int i = 0; i < 2; i++) {
            distance += Math.abs((target.charAt(i) - '0') - (cur.charAt(i) - '0'));
        }
        return distance;
    }

    void appendRight(String target) {
        sb.append("R");
        right = target;
    }

    void appendLeft(String target) {
        sb.append("L");
        left = target;
    }
}
