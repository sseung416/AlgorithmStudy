package codingtest.boj.silver4;

import java.io.*;
import java.util.*;

// 괄호: https://www.acmicpc.net/problem/9012
// 스택, 문자열
public class Baekjoon_9012 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                Stack<Integer> stack = new Stack<>();
                String line = br.readLine();
                boolean isVPS = true;

                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == '(') {
                        stack.push(0);
                    } else {
                        if (stack.size() == 0) {
                            isVPS = false;
                            break;
                        }
                        stack.pop();
                    }
                }
                String answer = isVPS && stack.isEmpty() ? "YES" : "NO";
                System.out.println(answer);
            }
            br.close();
        } catch (IOException ignore) {}
    }
}
