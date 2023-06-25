package codingtest;

import java.io.*;
import java.util.*;

// 직각삼각형: https://www.acmicpc.net/problem/4153
public class Baekjoon_4153 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String[] split = br.readLine().split(" ");
                int[] num = new int[3];
                for (int i = 0; i < 3; i++) {
                    num[i] = Integer.parseInt(split[i]);
                }

                if (num[0] == 0 && num[1] == 0 && num[2] == 0) break;

                Arrays.sort(num);
                String answer = Math.pow(num[0], 2) + Math.pow(num[1], 2) == Math.pow(num[2], 2) ? "right" : "wrong";
                System.out.println(answer);
            }
            br.close();
        } catch (IOException ignored) {}
    }
}