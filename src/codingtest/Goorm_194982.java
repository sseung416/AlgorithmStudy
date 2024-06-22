package codingtest;

import java.io.*;
import java.util.*;

// 장마: https://level.goorm.io/exam/194982/장마/quiz/1
// 구현
public class Goorm_194982 {
    private static int[] waters;
    private static int[][] rains;

    public static void main(String[] args) throws Exception {
        // 데이터 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());

        final int[] heights = new int[n];
        waters = new int[n];
        rains = new int[m][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            rains[i][0] = Integer.parseInt(st.nextToken());
            rains[i][1] = Integer.parseInt(st.nextToken());
        }

        // 높이 계산
        for (int i = 0; i < m; i++) {
            int start = rains[i][0];
            int end = rains[i][1];

            for (int j = start - 1; j < end; j++) {
                waters[j]++;
            }

            // 배수 시스템을 작동해야 한다면 작동
            if (shouldRunSystem(i)) {
                runSystem(i, n);
            }
        }

        // 결과 값 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(heights[i] + waters[i]).append(' ');
        }
        System.out.print(sb);
    }

    // 배수 시스템 동작 여부를 반환
    private static boolean shouldRunSystem(int index) {
        return (index + 1) % 3 == 0;
    }

    private static void runSystem(int index, int n) {
        // 배수 시스템을 동작시킬 집 위치를 구함
        boolean[] isRain = new boolean[n];
        for (int i = index - 2; i <= index; i++) {
            int start = rains[i][0];
            int end = rains[i][1];
            for (int j = start - 1; j < end; j++) {
                isRain[j] = true;
            }
        }

        // 배수 시스템 동작
        for (int i = 0; i < n; i++) {
            if (isRain[i] && waters[i] > 0) {
                waters[i]--;
            }
        }
    }
}
