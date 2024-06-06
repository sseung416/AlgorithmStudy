package codingtest;

public class Combination {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int n = 4;

        System.out.println("[4개 중 2개 조합]");
        combinationByRecursive(arr, new boolean[4], n, 2, 0);

        System.out.println("\n[4개 중 3개 조합]");
        combinationByBackTracking(arr, new boolean[4], 0, n, 3);
    }

    /**
     * 재귀를 사용해 조합을 출력하는 함수
     *
     * @param arr     조합을 구할 원본 배열
     * @param visited 뽑은 여부, 최종 탐색 후 뽑은 조합을 출력할 때 사용
     * @param n       원본 배열의 길이
     * @param r       뽑아야 하는 원소의 개수
     * @param depth   원본 배열에서 뽑을 원소를 정하는 인덱스
     */
    public static void combinationByRecursive(int[] arr, boolean[] visited, int n, int r, int depth) {
        // 뽑아야 하는 개수(r)가 0개라면 탐색 종료 후 값 출력
        if (r == 0) {
            print(visited, arr, n);
            return;
        }

        // 모든 원소를 탐색한 것이니 종료
        if (depth == n) {
            return;
        }

        // 특정 원소를 뽑은 경우
        visited[depth] = true;
        combinationByRecursive(arr, visited, n, r - 1, depth + 1);

        // 해당 원소를 뽑지 않은 경우
        visited[depth] = false;
        combinationByRecursive(arr, visited, n, r, depth + 1);
    }

    /**
     * 백트랙킹을 사용해 조합을 출력하는 함수
     *
     * @param start 원소를 뽑을지 말지의 기준점이 되는 인덱스, start보다 인덱스가 작으면 뽑지 않고 크면 뽑음
     * */
    public static void combinationByBackTracking(int[] arr, boolean[] visited, int start, int n, int r) {
        // 뽑아야 하는 개수(r)가 0개라면 탐색 종료 후 값 출력
        if (r == 0) {
            print(visited, arr, n);
            return;
        }

        for (int i = start; i < n; i++) {
            // 원소를 뽑음, 현재 원소를 뽑았으니 다음 조합 때 start 인덱스 값을 증가
            visited[i] = true;
            combinationByBackTracking(arr, visited, i + 1, n, r - 1);

            // 원소를 뽑지 않고 다음 순회
            visited[i] = false;
        }
    }

    public static void print(boolean[] visited, int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
