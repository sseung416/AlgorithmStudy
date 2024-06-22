package codingtest.boj.silver3;

import java.util.*;
import java.io.*;

// 파일 정리: https://www.acmicpc.net/problem/20291
// 자료구조, 문자, 정렬
// split() 사용시 정규식 체크 유의하기
// Set to List 형변환 방법 알기
public class Baekjoon_20291 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] split = line.split("\\.");
            int count = map.getOrDefault(split[1], 0) + 1;
            map.put(split[1], count);
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            sb.append(key).append(' ').append(map.get(key)).append('\n');
        }
        System.out.print(sb);
    }
}