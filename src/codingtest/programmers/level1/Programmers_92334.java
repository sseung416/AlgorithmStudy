package codingtest.programmers.level1;

import java.util.*;

// 신고 결과 받기: https://school.programmers.co.kr/learn/courses/30/lessons/92334
// 구현, 자료구조
public class Programmers_92334 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 신고 결과, 어떤 유저가 몇 번 신고 당했는지를 나타냄
        Map<String, Integer> reportResult = new HashMap<>();
        // 누가 누구를 신고했는지, 중복 제거를 위해 Set으로 선언
        Map<String, Set<String>> whoReport = new HashMap<>();

        // 신고 결과 계산
        for (String value : report) {
            String[] split = value.split(" ");
            String user = split[0];
            String reportedUser = split[1];

            // 현재 유저가 신고한 유저 목록 조회
            Set<String> reportedListByCurrentUser = whoReport.getOrDefault(user, new HashSet<>());
            if (!reportedListByCurrentUser.contains(reportedUser)) {
                // 이미 신고한 유저라면 넘어가고, 처음 신고했다면 count 값 추가
                reportResult.put(reportedUser, reportResult.getOrDefault(reportedUser, 0) + 1);
                reportedListByCurrentUser.add(reportedUser);
                whoReport.put(user, reportedListByCurrentUser);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            Set<String> reported = whoReport.get(id_list[i]);
            if (reported == null) continue;

            int count = 0;
            for (String key : reported) {
                if (reportResult.getOrDefault(key, 0) >= k) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] ids = new String[] {"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println(Arrays.toString(solution(ids, report, 2)));
    }

    // 바탕화면 정리: https://school.programmers.co.kr/learn/courses/30/lessons/161990
    // 수학
    public static class Programmers_161990 {
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
}