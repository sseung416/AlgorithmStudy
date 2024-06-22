package codingtest.boj.bronze1;

import java.io.*;
import java.util.*;

// 단어 공부: https://www.acmicpc.net/problem/1157
// 문자열, 구현
public class Baekjoon_1157 {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        br.close();
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        char result = '?';
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (value == count) {
                result = '?';
            } else if (value > count) {
                result = key;
                count = value;
            }
        }
        System.out.println(result);
    }
}
