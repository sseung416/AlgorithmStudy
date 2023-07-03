package codingtest;

import java.io.*;
import java.math.BigInteger;

// 하노이 탑: https://www.acmicpc.net/problem/1914
public class Baekjoon_1914 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            br.close();

            BigInteger cnt = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
            System.out.println(cnt);
            if (n <= 20) {
                hanoi(n, 1, 3, 2);
                System.out.println(sb.toString());
            }
        } catch (IOException ignore) {}
    }

    public static void hanoi(int n, int start, int to, int via) {
        if (n == 1) {
            sb.append(start).append(" ").append(to).append("\n");
        } else {
            hanoi(n - 1, start, via, to);
            sb.append(start).append(" ").append(to).append("\n");
            hanoi(n - 1, via, to, start);
        }
    }
}
