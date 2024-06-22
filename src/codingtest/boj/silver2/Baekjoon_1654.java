package codingtest.boj.silver2;

import java.util.*;
import java.io.*;

// 랜선 자르기: https://www.acmicpc.net/problem/1654
// 이분 탐색
// 참고: https://st-lab.tistory.com/269
public class Baekjoon_1654 {
    static long[] arr;
    static int n, k; // 필요한 랜선의 개수, 이미 가지고 있는 랜선의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long mid; // 자르려고 하는 길이
        long start = 1;
        long end = arr[k - 1] + 1; // 가지고 있는 랜선 중 가장 긴 랜선의 길이
        // 가장 긴 랜선으로 가지려면 mid 값이 커야함
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (check(mid)) {
                // n개가 넘으므로, 최댓값을 찾기위해 mid 값을 증가시킴
                start = mid;
            } else {
                // n개가 넘지 못하므로, mid 값을 감소시킴
                end = mid;
            }
        }

        System.out.println(end - 1);
    }

    // 랜선을 특정 길이만큼 잘랐을 때 나오는 개수가 n개를 넘는지 확인하는 함수
    public static boolean check(long length) {
        long count = 0;
        for (long line : arr) {
            count += (line / length);
            if (count >= n) return true;
        }
        return false;
    }
}