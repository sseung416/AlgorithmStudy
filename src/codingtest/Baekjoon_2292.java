package codingtest;

import java.util.*;
import java.io.*;

// 블랙잭: https://www.acmicpc.net/problem/2798
public class Baekjoon_2292 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] cards = new int[n];
            int answer = 0;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }
            br.close();
            Arrays.sort(cards);

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int sum = cards[i] + cards[j] + cards[k];
                        if (m - sum >= 0 && m - sum < m - answer) {
                            answer = sum;
                        }
                    }
                }
            }
            System.out.println(answer);
        } catch (IOException ignore) {}
    }
}
