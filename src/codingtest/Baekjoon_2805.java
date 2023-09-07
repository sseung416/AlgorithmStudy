package codingtest;

import java.util.*;
import java.io.*;

// 나무 자르기: https://www.acmicpc.net/problem/2805
// 이분 탐색 (활용이 너무 어려워요..)
public class Baekjoon_2805 {
    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int mid;
        int start = 0;
        int end = arr[n - 1]; // 가장 큰 나무
        while (start + 1 < end) {
            // 여기서 mid 값은 나무를 자르는 height 값과 동일함
            mid = (start + end) / 2;
            if (check(mid)) {
                // 값이 넘는다면 지금보다 더 높게 잘랐을 때 만족하는 값이 있는지 확인해야 함 (높이의 최댓값을 구해야 하므로..)
                // 그러므로 start 값을 mid 값으로 초기화하여 mid 값을 올림
                start = mid;
            } else {
                // 값이 넘지 않는다면 자르는 높이를 더 작게 잘라야 함 (자른 윗 부분을 들고가니까..)
                // 그러므로 end 값을 mid 값으로 초기화해 mid 값을 작게 함
                end = mid;
            }
        }

        System.out.println(start);
    }

    // 특정 높이(height)로 나무를 잘랐을 때의 값이 m을 넘는가를 판단하는 함수
    public static boolean check(long height) {
        long sum = 0;
        for (long wood : arr) {
            if (wood <= height) continue;
            sum += wood - height;
        }
        return sum >= m;
    }
}