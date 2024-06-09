package codingtest;

import java.io.*;
import java.util.*;

// 단축키 지정: https://www.acmicpc.net/problem/1283
// 구현, 문자열
public class Baekjoon_1283 {

    static StringBuilder sb = new StringBuilder();
    static Set<Character> options = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (checkFirstChar(word)) continue;
            if (checkAllChar(word)) continue;
            sb.append(word).append('\n');
        }
        br.close();

        System.out.print(sb);
    }

    public static boolean checkFirstChar(String word) {
        StringBuilder temp = new StringBuilder();
        boolean useOption = false;

        for (String s : word.split(" ")) {
            temp.append(' ');
            char option = s.toUpperCase().charAt(0);
            if (!useOption && !options.contains(option)) {
                temp.append('[').append(s.charAt(0)).append(']').append(s.substring(1));
                options.add(option);
                useOption = true;
                continue;
            }
            temp.append(s);
        }

        if (useOption) sb.append(temp.toString().trim()).append('\n');
        return useOption;
    }

    public static boolean checkAllChar(String word) {
        StringBuilder temp = new StringBuilder();
        boolean useOption = false;
        String upperWord = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            char option = upperWord.charAt(i);
            if (!useOption && option != ' ' && !options.contains(option)) {
                temp.append('[').append(word.charAt(i)).append(']');
                options.add(option);
                useOption = true;
                continue;
            }
            temp.append(word.charAt(i));
        }
        if (useOption) sb.append(temp.toString().trim()).append('\n');
        return useOption;
    }
}