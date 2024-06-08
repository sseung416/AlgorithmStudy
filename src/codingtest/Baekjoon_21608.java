package codingtest;

import java.util.*;
import java.io.*;

// 상어 초등학교: https://www.acmicpc.net/problem/21608
// 구현
public class Baekjoon_21608 {

    public static int[] order;
    public static int[][] likes;
    public static int[][] result;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = n * n;
        order = new int[cnt];
        likes = new int[cnt][4];
        result = new int[n][n];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = order[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                likes[student - 1][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = 0; i < cnt; i++) {
            getResult(n, order[i]);
        }

        System.out.println(getSatisfy(n));
    }

    public static void getResult(int n, int student) {
        int x = 0, y = 0;

        // 인접한 좋아하는 학생 수, 인접한 빈칸 수
        // https://www.acmicpc.net/board/view/110982 이슈 때문에 -1로 초기화
        int likeStuCnt = -1, blankCnt = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 빈 칸이 아니라면 다음 순회
                if (result[i][j] != 0) continue;

                int curLikeStuCnt = 0;
                int curBlankCnt = 0;
                for (int k = 0; k < 4; k++) {
                    int ax = i + dx[k];
                    int ay = j + dy[k];

                    // 배열 범위 넘어가는지 체크
                    if (ax < 0 || ay < 0 || ax >= n || ay >= n) continue;

                    int nearStudent = result[ax][ay];
                    if (nearStudent == 0) curBlankCnt++;
                    if (isLikeStudent(student, nearStudent)) curLikeStuCnt++;
                }

                if (check(i, j, x, y, blankCnt, likeStuCnt, curBlankCnt, curLikeStuCnt)) {
                    likeStuCnt = curLikeStuCnt;
                    blankCnt = curBlankCnt;
                    x = i;
                    y = j;
                }
            }
        }

        result[x][y] = student;

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        System.out.println();
    }

    // 착석할지 말지를 결정
    public static boolean check(int i, int j, int x, int y, int blankCnt, int likeStuCnt, int curBlankCnt, int curLikeStuCnt) {
        if (likeStuCnt < curLikeStuCnt) return true;

        if (likeStuCnt == curLikeStuCnt) {
            if (blankCnt < curBlankCnt) return true;

            if (blankCnt == curBlankCnt) {
                if (x > i) return true;
                if (x == i) return y > j;
            }
        }
        return false;
    }

    // target 학생이 student 학생의 좋아하는 학생인지 확인
    public static boolean isLikeStudent(int student, int target) {
        for (int i : likes[student - 1]) {
            if (i == target) return true;
        }
        return false;
    }

    // 만족도 결과 계산
    public static int getSatisfy(int n) {
        int satisfy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int like = 0;
                int student = result[i][j];
                for (int k = 0; k < 4; k++) {
                    int ax = i + dx[k];
                    int ay = j + dy[k];
                    if (ax < 0 || ay < 0 || ax >= n || ay >= n) continue;

                    if (isLikeStudent(student, result[ax][ay])) like++;
                }
                satisfy += like == 0 ? 0 : (int) Math.pow(10, like - 1);
            }
        }
        return satisfy;
    }
}
