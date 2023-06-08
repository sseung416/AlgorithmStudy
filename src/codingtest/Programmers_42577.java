package codingtest;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class Programmers_42577 {

    public static void run() {
        Programmers_42577 problem = new Programmers_42577();
        assert !problem.solution(new String[]{"119", "97674223", "1195524421"});
        assert problem.solution(new String[]{"123", "456", "789"});
        assert !problem.solution(new String[]{"12", "123", "1235", "567", "88"});
        assert !problem.solution(new String[]{"934793", "34", "44", "9347"});
        assert problem.solution(new String[]{"123", "1005", "1006", "1007"});
    }

    private boolean solution(String[] phone_book) {
        Map<String, String> map = new HashMap<>();
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        int minimumLength = phone_book[0].length();
        for (String number : phone_book) {
            String key = number.substring(0, minimumLength);
            String value = map.get(key);
            if (value != null) {
                if (number.startsWith(value)) {
                    return false;
                }
            } else {
                map.put(key, number);
            }
        }
        return true;
    }
}