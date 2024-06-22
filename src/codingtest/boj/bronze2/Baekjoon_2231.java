package codingtest.boj.bronze2;

import java.io.*;

// 분해합: https://www.acmicpc.net/problem/2231
// 완전탐색
public class Baekjoon_2231 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            br.close();

            for (int i = 1; i < n; i++) {
                int sum = i;
                int temp = i;
                for (; temp / 10 != 0; temp /= 10) {
                    sum += (temp % 10);
                }
                sum += temp;

                if (sum == n) {
                    System.out.println(i);
                    return;
                }
            }

            System.out.println(0);
        } catch (IOException ignore) {}
    }
}
