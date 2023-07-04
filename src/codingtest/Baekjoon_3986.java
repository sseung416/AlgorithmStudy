package codingtest;

import java.io.*;
import java.util.*;

// 좋은 단어: https://www.acmicpc.net/problem/3986
public class Baekjoon_3986 {
    public static void main(String[] args) {
        try {
            int count = 0;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                Stack<Character> stack = new Stack<>();
                stack.push(word.charAt(0));
                for (int j = 1; j < word.length(); j++) {
                    char temp = word.charAt(j);
                    if (!stack.isEmpty() && stack.peek() == temp) {
                        stack.pop();
                    } else {
                        stack.push(temp);
                    }
                }
                if (stack.isEmpty()) count++;
            }
            br.close();

            System.out.println(count);
        } catch (IOException ignore) {
        }
    }
}