package codingtest;

// 카펫: https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class Programmers_42842 {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int j = yellow / i;
                if (brown == i * 2 + j * 2 + 4) {
                    return new int[]{j + 2, i + 2};
                }
            }
        }
        return null;
    }
}