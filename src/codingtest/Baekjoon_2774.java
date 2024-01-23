package codingtest;

import java.io.*;
import java.util.*;

// 아름다운 수: https://www.acmicpc.net/problem/2774
// 구현
public class Baekjoon_2774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Set<Character> set = new HashSet<>();
            String number = br.readLine();
            for (int j = 0; j < number.length(); j++) {
                set.add(number.charAt(j));
            }
            sb.append(set.size()).append('\n');
        }
        br.close();
        System.out.println(sb);
    }
}
