package codingtest;

import java.io.*;

// 수학은 체육과목 입니다: https://www.acmicpc.net/problem/15894
public class Baekjoon_15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Long.parseLong(br.readLine()) * 4);
        br.close();
    }
}