package codingtest.boj.silver3;

import java.io.*;
import java.util.*;

// 수강신청: https://www.acmicpc.net/problem/13414
// 해시
public class Baekjoon_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Set<String> set = new LinkedHashSet<>(); // 순서 저장
        for (int i = 0; i < l; i++) {
            String num = br.readLine();
            set.remove(num);
            set.add(num);
        }

        int count = 0;
        for (String value : set) {
            // 순서가 저장되어 있으므로, 앞에서부터 최대 인원까지만 저장 후 반복문 탈출
            if (count >= k) break;
            sb.append(value).append("\n");
            count++;
        }
        System.out.println(sb);
    }
}