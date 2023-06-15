package codingtest;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class Programmers_161990 {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = -1;
        int rdy = -1;

        for (int x = 0; x < wallpaper.length; x++) {
            int firstY = wallpaper[x].indexOf("#");
            int lastY = wallpaper[x].lastIndexOf("#");

            // Math 클래스를 잘 활용해보자
            if (firstY != -1) {
                if (luy > firstY) {
                    luy = firstY;
                }
                if (lux > x) {
                    lux = x;
                }
                if (lastY > rdy) {
                    rdy = lastY;
                }
                if (rdx < x) {
                    rdx = x;
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    public static void run() {
        Programmers_161990 problem = new Programmers_161990();
        assert Arrays.equals(problem.solution(new String[]{".#...", "..#..", "...#."}), new int[]{0, 1, 3, 4});
        assert Arrays.equals(problem.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}), new int[]{0, 0, 7, 9});
    }
}