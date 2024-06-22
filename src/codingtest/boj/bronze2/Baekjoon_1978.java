package codingtest.boj.bronze2;

import java.io.*;
import java.util.*;

// 소수 찾기: https://www.acmicpc.net/problem/1978
// 수학
public class Baekjoon_1978 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;

            for (int i = 0; i < input; i++) {
                int num = Integer.parseInt(st.nextToken());
                boolean isPrime = true;
                for (int j = 2; j < num; j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (num != 1 && isPrime) count++;
            }

            System.out.println(count);
        } catch (IOException ignore) {
        }
    }
}