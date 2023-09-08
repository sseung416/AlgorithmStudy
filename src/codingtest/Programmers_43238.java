package codingtest;

import java.util.*;

// 입국 심사: https://school.programmers.co.kr/learn/courses/30/lessons/43238
// 이분 탐색
public class Programmers_43238 {
    static int[] arr;

    public long solution(int n, int[] times) {
        arr = times;
        Arrays.sort(arr);

        long start = 0;
        long end = Long.MAX_VALUE;
        long mid; // 모든 심사를 받는데 걸리는 시간을 기준
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (check(mid, n)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }

    // 최대 심사 시간을 기준으로 각 심사원마다 최대로 심사를 마칠 수 있는 사람의 합을 구해,
    // 그 값이 줄 선 사람의 수(n)를 넘는지 판별함
    public static boolean check(long mid, int n) {
        long cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += (mid / arr[i]);
            if (cnt >= n) return true;
        }
        return false;
    }
}
