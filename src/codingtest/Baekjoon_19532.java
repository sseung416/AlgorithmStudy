package codingtest;

import java.util.*;
import java.io.*;

// 수학은 비대면강의입니다: https://www.acmicpc.net/problem/19532
public class Baekjoon_19532 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] num = new int[6];
            for (int i = 0; i < 6; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            // 가감법 적용
            // x = e(c+f)/b(a+d)
            // y = (c-ax)/b or (f-dx)/e
            int x = (num[2] * num[4] - num[1] * num[5]) / (num[0] * num[4] - num[1] * num[3]);
            // b가 0일 때 예외 처리
            int y = num[1] != 0 ? (num[2] - num[0] * x) / num[1] : (num[5] - num[3] * x) / num[4];
            System.out.println(x + " " + y);
        } catch (IOException ignore) {}
    }
}