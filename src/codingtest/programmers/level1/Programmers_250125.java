package codingtest.programmers.level1;

// [PCCE 기출문제] 9번 / 이웃한 칸: https://school.programmers.co.kr/learn/courses/30/lessons/250125
// 구현
public class Programmers_250125 {
    public int solution(String[][] board, int h, int w) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int len = board[0].length;

        int count = 0;
        String key = board[h][w];
        for (int i = 0; i < 4; i++) {
            int ax = h + dx[i];
            int ay = w + dy[i];

            if (ax < 0 || ay < 0 || ax >= len || ay >= len) continue;
            if (!key.equals(board[ax][ay])) continue;

            count++;
        }

        return count;
    }
}
