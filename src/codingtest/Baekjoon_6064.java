package codingtest;

import java.util.*;
import java.io.*;

// 카잉 달력: https://www.acmicpc.net/problem/6064
// 참고 - https://mygumi.tistory.com/325
// x를 기준으로 y값을 지정함
public class Baekjoon_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = -1;
            int tempY = x;
            for (int k = x; k <= m * n; k += m) {
                tempY = tempY % n == 0 ? n : tempY % n;
                if (tempY == y) {
                    result = k;
                    break;
                }
                tempY += m;
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}

