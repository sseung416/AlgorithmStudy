package codingtest.boj.bronze5;

import java.io.*;

// 대소문자 바꾸기: https://www.acmicpc.net/problem/2744
// 문자열, 구현
public class Baekjoon_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (char c : br.readLine().toCharArray()) {
            if (c < 97) {
                sb.append(Character.toString(c + 32));
            } else {
                sb.append(Character.toString(c - 32));
            }
        }
        br.close();
        System.out.print(sb);
    }
}
