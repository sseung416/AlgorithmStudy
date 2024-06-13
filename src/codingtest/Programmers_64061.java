package codingtest;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

// 크레인 인형 뽑기: https://school.programmers.co.kr/learn/courses/30/lessons/64061
// 구현, 자료구조
public class Programmers_64061 {

    public static void run() {
        Programmers_64061 problem = new Programmers_64061();
        int answer = problem.solution(
                new int[][] { {0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1} },
                new int[] { 1,5,3,5,1,2,1,4 }
        );
        System.out.println(answer);
    }

    private int solution(int[][] board, int[] moves) {
        // 리스트 안에 스택, 값 초기화: 마지막 -> 처음, length-1
        List<Stack<Integer>> list = new ArrayList<>();
        Stack<Integer> bucket = new Stack<>(); // 뽑은 인형 바구니
        int count = 0;

        for (int i = 0; i < board[0].length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = board[0].length - 1; j >= 0; j--) {
                int data = board[j][i];
                if (data != 0) {
                    stack.push(data);
                }
            }
            list.add(stack);
        }

        // 바구니에 저장
        for (int move : moves) {
            try {
                int data = list.get(move - 1).pop();
                int bucketSize = bucket.size();

                // 뽑은 인형과 바구니의 담긴 인형이 같을 때, 바구니의 인형 터트려짐
                if (bucketSize != 0 && bucket.peek() == data) {
                    bucket.pop();
                    count++;
                } else {
                    bucket.push(data);
                }
            } catch (EmptyStackException ignored) {}
        }

        return count * 2;
    }
}
