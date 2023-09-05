package codingtest;

import java.util.*;

// 최솟값 만들기: https://school.programmers.co.kr/learn/courses/30/lessons/12941
// 정렬
public class Programmers_12941 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int length = A.length;
        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length - 1 - i];
        }

        return answer;
    }
}