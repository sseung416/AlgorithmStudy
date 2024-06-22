package codingtest.boj.gold4;

import java.io.*;
import java.util.*;

// 이중 우선순위 큐: https://www.acmicpc.net/problem/7662
// 트리
public class Baekjoon_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            // 삽입할 정수의 값, 해당 정수가 삽입된 개수 (중복된 값을 허용하기 때문에 count를 저장함)
            TreeMap<Long, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                String[] line = br.readLine().split(" ");
                long value = Long.parseLong(line[1]);
                if (line[0].equals("I")) {
                    // 삽입 연산
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    long key;
                    if (value < 0) { // 음수인 경우, 최솟값 삭제
                        key = map.firstKey();
                    } else { // 양수인 경우, 최댓값 삭제
                        key = map.lastKey();
                    }

                    int count = map.get(key) - 1;
                    if (count == 0) {
                        // 현재 값을 삭제
                        map.remove(key);
                    } else {
                        map.put(key, count);
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
        br.close();
    }
}