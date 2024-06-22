package codingtest.boj.silver2;

import java.io.*;
import java.util.*;

// 마인크래프트: https://www.acmicpc.net/problem/18111
// 시뮬레이션, 브루트포스
public class Baekjoon_18111 {

    static int[][] arr;
    static int n, m, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;
        // 모든 높이를 탐색함 (256*500*500 범위므로 1억 번 내이니 1초 안에 통과 가능)
        for (int h = 0; h <= 256; h++) {
            int result = search(h);
            if (result == -1) continue;

            if (minTime >= result) {
                minTime = result;
                maxHeight = Math.max(h, maxHeight); // 시간이 동일하다면, 높이가 더 높은 것을 저장
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }

    // 해당 높이가 될 때까지 블럭을 놓거나 제거함
    public static int search(int h) {
        int currentBlock = b;
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = arr[i][j];
                if (value > h) {
                    // 현재 블럭의 위치가 기준 높이보다 높을 때 -> 기준 높이가 될 때까지 블럭 제거
                    int temp = value - h; // 제거할 블럭 개수
                    currentTime += 2 * temp;
                    currentBlock += temp;
                } else if (value < h) {
                    // 현재 블럭 위치가 기준 높이보다 낮을 때 -> 기준 높이가 될 때까지 블럭을 설치
                    int temp = h - value; // 설치할 블럭 개수
                    currentBlock -= temp;
                    currentTime += temp;
                }
            }
        }
        // 모든 연산 후 남은 블럭의 개수가 0보다 작다면, 블럭이 없는데 블럭을 쌓으려고 한거니 성립 불가능! 따라서 -1 반환
        return currentBlock < 0 ? -1 : currentTime;
    }
}