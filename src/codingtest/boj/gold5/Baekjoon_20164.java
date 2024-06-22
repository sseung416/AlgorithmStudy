package codingtest.boj.gold5;

import java.io.*;

// 홀수 홀릭 호석: https://www.acmicpc.net/problem/20164
// 구현, 브루트포스, 재귀
public class Baekjoon_20164 {
    static int min = Integer.MAX_VALUE, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        br.close();
        rec(n, 0);
        System.out.print(min + " " + max);
    }

    public static void rec(String n, int count) {
        int len = n.length();
        count += countOdd(n);

        if (len == 1) {
            min = Math.min(count, min);
            max = Math.max(count, max);
            return;
        }

        if (len == 2) {
            int sum = n.charAt(0) - '0' + n.charAt(1) - '0';
            rec(Integer.toString(sum), count);
            return;
        }

        for (int i = 1; i < len - 1; i++) {
            int cut1 = Integer.parseInt(n.substring(0, i));
            for (int j = i + 1; j < len; j++) {
                int cut2 = Integer.parseInt(n.substring(i, j));
                int cut3 = Integer.parseInt(n.substring(j));
                rec(Integer.toString(cut1 + cut2 + cut3), count);
            }
        }
    }

    public static int countOdd(String n) {
        int count = 0;
        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if (num % 2 == 1) count++;
        }
        return count;
    }
}
