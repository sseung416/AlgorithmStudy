package codingtest;

// 이진 변환 반복하기: https://school.programmers.co.kr/learn/courses/30/lessons/70129
// 문자열
public class Programmers_70129 {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        while (!s.equals("1")) {
            answer[0]++;
            String after = s.replace("0", "");
            answer[1] += s.length() - after.length();
            s = getBinaryNumber(after.length()); // toBinaryString()이라는 메서드가 있었다...
        }
        return answer;
    }

    public static String getBinaryNumber(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        return sb.toString();
    }
}
