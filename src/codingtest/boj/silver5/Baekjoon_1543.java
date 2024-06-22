package codingtest.boj.silver5;

import java.io.*;

// 문서 검색: https://www.acmicpc.net/problem/1543
// 문자열, 브루트포스 알고리즘
// replace 까먹지 않기..
public class Baekjoon_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        br.close();

        int count = 0;
        while (true) {
            int idx = doc.indexOf(word);
            if (idx == -1) break;
            count++;
            // 삭제한 단어가 이어지지 않도로 * 처리함
            doc = doc.substring(0, idx) + "*" + doc.substring(idx + word.length());
        }

        System.out.print(count);
    }
}