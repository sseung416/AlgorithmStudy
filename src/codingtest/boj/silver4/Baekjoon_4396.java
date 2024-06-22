package codingtest.boj.silver4;

import java.io.*;

// 지뢰찾기: https://www.acmicpc.net/problem/4396
// 구현
// 문제를 읽자,"지뢰가 있는 칸이 열렸다면 지뢰가 있는 모든 칸이 별표(*)로 표시되어야 한다. " 이 한 문단 놓쳐서 별 짓 다함
class Baekjoon_4396 {
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][][] arr = new char[2][n][n];
        for (int i = 0; i < 2; i++) {
            // 지뢰 부분, 체크한 부분
            for (int j = 0; j < n; j++) {
                String line = br.readLine();
                for (int k = 0; k < n; k++) {
                    arr[i][j][k] = line.charAt(k);
                }
            }
        }
        br.close();

        char[][] result = new char[n][n];
        boolean isGameOver = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char curBomb = arr[0][i][j]; // 지뢰
                char curChecker = arr[1][i][j]; // 체크한 부분

                if (curBomb == '*') {
                    result[i][j] = '*';
                    // 지뢰를 밟았을 경우
                    if (curChecker == 'x') {
                        isGameOver = true;
                    }
                    continue;
                }

                // 체크하지 않은 경우 다음 루프로
                if (curChecker == '.') {
                    result[i][j] = '.';
                    continue;
                }

                // 체크한 경우 근처의 지뢰 개수를 카운트
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int ax = i + dx[k];
                    int ay = j + dy[k];

                    if (ax < 0 || ay < 0 || ax >= n || ay >= n) continue;

                    if (arr[0][ax][ay] == '*') count++;
                }
                result[i][j] = Integer.toString(count).charAt(0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = result[i][j];
                if (c == '*' && !isGameOver) {
                    // 지뢰를 밟지 않았다면 .으로 표시
                    sb.append('.');
                } else {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}