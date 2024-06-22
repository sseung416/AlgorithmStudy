package codingtest.boj.silver4;

import java.io.*;
import java.util.*;

// 빙고: https://www.acmicpc.net/problem/2578
// 구현
public class Baekjoon_2578 {
    public static void main(String[] args) throws IOException {
        int[][][] board = new int[2][5][5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        br.close();

        BingoGame game = new BingoGame(board[0], board[1]);
        System.out.print(game.getResult());
    }
}

class BingoGame {
    private int[][] user, moderator;
    private boolean[][] checker = new boolean[5][5];

    BingoGame(int[][] user, int[][] moderator) {
        this.user = user;
        this.moderator = moderator;
    }

    public int getResult() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                int[] pos = find(moderator[i][j]);
                if (pos == null) return -1;

                checker[pos[0]][pos[1]] = true;

                if (isBingo()) return count;
            }
        }
        return -1;
    }

    private int[] find(int target) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (user[i][j] == target) return new int[]{i, j};
            }
        }
        return null;
    }

    private boolean isBingo() {
        int rowCount = checkRow();
        int columnCount = checkColumn();
        int diagonalCount = checkDiagonal();
        return rowCount + columnCount + diagonalCount >= 3;
    }

    private int checkRow() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int check = 0;
            for (int j = 0; j < 5; j++) {
                if (checker[i][j]) check++;
            }
            if (check == 5) count++;
        }
        return count;
    }

    private int checkColumn() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int check = 0;
            for (int j = 0; j < 5; j++) {
                if (checker[j][i]) check++;
            }
            if (check == 5) count++;
        }
        return count;
    }

    private int checkDiagonal() {
        int count = 0;
        int check1 = 0, check2 = 0;
        for (int i = 0; i < 5; i++) {
            if (checker[i][i]) check1++;
            if (checker[i][4 - i]) check2++;
        }
        if (check1 == 5) count++;
        if (check2 == 5) count++;
        return count;
    }
}