package codingtest.boj.silver4;

import java.io.*;
import java.util.*;

// 좋은 단어: https://www.acmicpc.net/problem/3986
// 좋은 단어는 같은 값끼리 아치형으로 이었을 때 같은 값끼리 연결되어야 함 => 괄호와 같음
public class Baekjoon_3986 {
    public static void main(String[] args) {
        try {
            int count = 0;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                Stack<Character> stack = new Stack<>();
                stack.push(word.charAt(0)); // 첫 번째 값 추가
                for (int j = 1; j < word.length(); j++) { // 단어 사이즈만큼
                    char temp = word.charAt(j);
                    if (!stack.isEmpty() && stack.peek() == temp) { // 값이 같다면.. ex) stack[A,B], t=B -> stack[A]
                        stack.pop();
                    } else { // 값이 다르다면 스택에 추가 ex) st[A,B], t=A -> st[A,B,A]
                        stack.push(temp);
                    }
                }
                // 스택에 값이 남아있다면 좋은 단어가 아님
                if (stack.isEmpty()) count++;
            }
            br.close();

            System.out.println(count);
        } catch (IOException ignore) {
        }
    }
}