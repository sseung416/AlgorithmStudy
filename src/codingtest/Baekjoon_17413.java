package codingtest;

import java.io.*;

// 단어 뒤집기: https://www.acmicpc.net/problem/17413
// 구현, 문자열
public class Baekjoon_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        StringBuilder result = new StringBuilder(); // 결과 저장
        StringBuilder temp = new StringBuilder();
        boolean isTag = false; // 태그 여부
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                result.append(temp.reverse());
                temp = new StringBuilder();
                isTag = true;
            } else if (c == '>') {
                temp.append(c);
                result.append(temp);

                temp = new StringBuilder();
                isTag = false;
                continue;
            } else if (!isTag && c == ' ') {
                result.append(temp.reverse());
                result.append(' ');

                temp = new StringBuilder();
                continue;
            }
            temp.append(c);
        }
        result.append(temp.reverse());

        System.out.print(result);
    }
}
