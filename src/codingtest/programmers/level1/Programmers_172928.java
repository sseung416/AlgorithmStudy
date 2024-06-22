package codingtest.programmers.level1;

// 공원 산책: https://school.programmers.co.kr/learn/courses/30/lessons/172928
// 시뮬레이션
public class Programmers_172928 {

    static String[][] map;
    static int[] dx = {0,1,0,-1}; // 동남서북 (ESWN)
    static int[] dy = {1,0,-1,0};
    static int[] current = new int[2];

    public int[] solution(String[] park, String[] routes) {
        map = new String[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            map[i] = park[i].split("");

            int currentIdx = park[i].indexOf("S");
            if (currentIdx != -1) {
                current[0] = i;
                current[1] = currentIdx;
            }
        }

        for (String operand : routes) {
            String[] opers = operand.split(" ");
            int count = Integer.parseInt(opers[1]);
            int idx;
            switch (opers[0]) {
                case "E":
                    idx = 0;
                    break;
                case "S":
                    idx = 1;
                    break;
                case "W":
                    idx = 2;
                    break;
                default:
                    idx = 3;
            }

            int[] temp = current.clone();
            for (int i = 0; i < count; i++) {
                if (!executeOperand(idx)) {
                    // 명령어 실행에 실패하면 실행 전 위치로 초기화
                    current = temp;
                    break;
                }
            }
        }
        return current;
    }

    public static boolean executeOperand(int idx) {
        int ax = current[0] + dx[idx];
        int ay = current[1] + dy[idx];
        if (ax >= 0 && ay >= 0 && ax < map.length && ay < map[0].length) {
            if (!map[ax][ay].equals("X")) {
                current[0] = ax;
                current[1] = ay;
                return true;
            }
        }
        return false;
    }
}
