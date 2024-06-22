package codingtest.programmers.level2;

// JadenCase 문자열 만들기: https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Programmers_12951 {
    public String solution(String s) {
        String answer = "";

        for (String value : s.split(" ")) {
            // 공백이 여러 개인 경우를 위한 예외 처리
            if (value.isBlank()) {
                answer += " ";
                continue;
            }

            String lower = value.toLowerCase();
            answer += Character.toString(lower.charAt(0)).toUpperCase() + lower.substring(1) + " ";
        }

        // 마지막 글자에 공백이 들어가는지 체크, 들어가지 않는다면 trim()
        if (s.charAt(s.length() - 1) != ' ') {
            answer = answer.trim();
        }

        return answer;
    }

    public static void run() {
        Programmers_12939 problem = new Programmers_12939();
        assert problem.solution("3people unFollowed me").equals("3people Unfollowed Me");
        assert problem.solution("for the last week").equals("For The Last Week");
    }
}