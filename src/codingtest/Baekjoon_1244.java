package codingtest;

import java.io.*;
import java.util.*;

// 스위치 켜고 끄기: https://www.acmicpc.net/problem/1244
// 구현
public class Baekjoon_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switchNumber = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                int j = 0;
                while (++j <= n) {
                    if (j % switchNumber == 0) {
                        int index = j - 1;
                        switches[index] = (switches[index] + 1) % 2;
                    }
                }
            } else {
                int j = 1;
                int index = switchNumber - 1;
                switches[index] = (switches[index] + 1) % 2;
                while (true) {
                    int left = index - j;
                    int right = index + j;

                    if (left < 0 || right >= switches.length) break;
                    if (switches[left] != switches[right]) break;

                    switches[left] = switches[right] = (switches[left] + 1) % 2;
                    j++;
                }
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(switches[i]);
            if ((i + 1) % 20 == 0) {
                sb.append('\n');
            } else {
                sb.append(' ');
            }
        }
        System.out.print(sb);
    }
}