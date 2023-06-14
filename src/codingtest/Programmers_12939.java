package codingtest;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class Programmers_12939 {
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();

        for (String value : s.split(" ")) {
            list.add(Integer.parseInt(value));
        }
        Collections.sort(list);

        return list.get(0) + " " + list.get(list.size() - 1);
    }

    public static void run() {
        Programmers_12939 problem = new Programmers_12939();
        assert problem.solution("1 2 3 4").equals("1 4");
        assert problem.solution("-1 -2 -3 -4").equals("-4 -1");
        assert problem.solution("-1 -1").equals("-1 -1");
    }
}
