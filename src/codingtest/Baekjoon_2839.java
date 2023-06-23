package codingtest;

import java.io.*;

// 설탕 배달: https://www.acmicpc.net/problem/2839
public class Baekjoon_2839 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            br.close();

            // 55555 -> 55553 -> 55533 -> ... (반복)
            for (int i = 0; n - i >= 0; i += 3) {
                int temp = n - i; // 3 연산
                if (temp % 5 == 0) {
                    // 몫이 딱 떨어지면 결과 출력
                    System.out.println(temp / 5 + i / 3);
                    return;
                }
            }

            System.out.println(-1); // 딱 떨어지지 않을 때
        } catch (IOException ignore) {}
    }
}
