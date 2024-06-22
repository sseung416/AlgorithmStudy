package codingtest.programmers.level2;

import java.util.*;

// 주차 요금 계산: https://school.programmers.co.kr/learn/courses/30/lessons/92341
// 구현
public class Programmers_92341 {
    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>(); // 주차하고 있는 자동차 정보
        Map<String, Integer> timeMap = new HashMap<>(); // 누적한 주차 시간 정보

        for (String record : records) {
            String[] split = record.split(" ");
            String car = split[1];
            String time = split[0];

            if (map.containsKey(car)) {
                int usingTime = calculateTimeByMin(map.remove(car), time);
                timeMap.put(car, timeMap.getOrDefault(car, 0) + usingTime);
            } else {
                map.put(car, time);
            }
        }

        // 아직 출차되지 않은 차량 요금 계산
        for (String car : map.keySet()) {
            int usingTime = calculateTimeByMin(map.get(car), "23:59");
            timeMap.put(car, timeMap.getOrDefault(car, 0) + usingTime);
        }

        int[] answer = new int[timeMap.size()];
        List<String> cars = new ArrayList<>(timeMap.keySet());
        Collections.sort(cars);
        for (int i = 0; i < cars.size(); i++) {
            answer[i] = calculateFee(fees, timeMap.get(cars.get(i)));
        }
        return answer;
    }

    // 시간을 분으로 변환 후 그 값을 반환하는 함수
    private static int calculateTimeByMin(String startTime, String endTime) {
        int sum = 0;

        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        int startHour = Integer.parseInt(start[0]);
        int startMin = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]);
        int endMin = Integer.parseInt(end[1]);

        if (endMin < startMin) {
            // 1:50 -> 2:10인 경우
            endHour--;
            sum = (60 + endMin) - startMin;
        } else {
            sum = endMin - startMin;
        }
        sum += (endHour - startHour) * 60;
        return sum;
    }

    // 요금 계산
    private static int calculateFee(int[] fees, int usingTime) {
        if (usingTime <= fees[0]) {
            return fees[1];
        } else {
            usingTime -= fees[0];
            return (int) (fees[1] + Math.ceil((float) usingTime / fees[2]) * fees[3]);
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil((float) 3 / 2));
        int[] result1 = solution(
                new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
        );
        System.out.println(Arrays.toString(result1));
    }
}
