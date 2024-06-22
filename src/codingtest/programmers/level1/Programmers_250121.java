package codingtest.programmers.level1;

import java.util.*;

// [PCCE 기출문제] 10번 / 데이터 분석: https://school.programmers.co.kr/learn/courses/30/lessons/250121
// 구현, 정렬
public class Programmers_250121 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int compareIdx = getIndex(ext);
        List<int[]> list = new ArrayList<>();
        for (int[] value : data) {
            if (value[compareIdx] < val_ext) {
                list.add(value);
            }
        }

        int sortIdx = getIndex(sort_by);
        Comparator<int[]> comparator = (o1, o2) -> o1[sortIdx] - o2[sortIdx];
        Collections.sort(list, comparator);

        int[][] result = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int getIndex(String operator) {
        switch (operator) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            default:
                return 3;
        }
    }
}
