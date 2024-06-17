package codingtest;

// 숫자 문자열과 영단어: https://school.programmers.co.kr/learn/courses/30/lessons/81301
// 문자열
public class Programmers_81301 {
    public int solution(String s) {
        String[] str = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String answer = s;
        for (int i = 0; i < 10; i++) {
            answer = answer.replaceAll(str[i], i + "");
        }

        return Integer.parseInt(answer);
    }
}
