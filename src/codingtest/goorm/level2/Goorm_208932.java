package codingtest.goorm.level2;

import java.io.*;
import java.util.*;

// 개발자 지망생 구름이의 취업 뽀개기: https://level.goorm.io/exam/208932/개발자-지망생-구름이의-취업-뽀개기/quiz/1
// 우선순위 큐, 자료구조
public class Goorm_208932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] problems = new int[5];
        final PriorityQueue[] queuesByLevel = new PriorityQueue[5];
        for (int i = 0; i < 5; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
            queuesByLevel[i] = new PriorityQueue<Integer>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            final int k = Integer.parseInt(st.nextToken()) - 1;
            final int t = Integer.parseInt(st.nextToken());

            queuesByLevel[k].offer(t);
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            final int solvingCount = problems[i];
            int before = 0;
            for (int j = 0; j < solvingCount; j++) {
                final int cur = (int) queuesByLevel[i].poll();
                sum += cur;
                if (before != 0) {
                    sum += cur - before;
                }
                before = cur;
            }
            sum += 60;
        }
        System.out.print(sum - 60);
    }
}
