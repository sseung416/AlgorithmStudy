package codingtest;

import java.io.*;
import java.util.*;

// 스택: https://www.acmicpc.net/problem/10828
public class Baekjoon_10828 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                int num;
                switch (line) {
                    case "pop":
                        num = stack.size() == 0 ? -1 : stack.pop();
                        System.out.println(num);
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        num = stack.size() == 0 ? 1 : 0;
                        System.out.println(num);
                        break;
                    case "top":
                        num = stack.size() == 0 ? -1 : stack.peek();
                        System.out.println(num);
                        break;
                    default:
                        num = Integer.parseInt(line.split(" ")[1]);
                        stack.push(num);
                }
            }
            br.close();
        } catch (IOException ignore) {}
    }
}
