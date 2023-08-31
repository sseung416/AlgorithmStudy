package codingtest;

// k진수에서 소수 개수 구하기: https://school.programmers.co.kr/learn/courses/30/lessons/92335
public class Programmers_92335 {
    public static int solution(int n, int k) {
        int count = 0;
        String numStr = k != 0 ? calculateNumber(n, k) : Integer.toString(n);
        String[] split = numStr.split("0");
        for (String value : split) {
            if (!value.isBlank() && isPrime(Long.parseLong(value))) {
                count++;
            }
        }
        return count;
    }

    // 소수 판별
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 진수 계산
    private static String calculateNumber(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n >= k) {
            sb.insert(0, n % k);
            n /= k;
        }
        sb.insert(0, n);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
        System.out.println(solution(885733, 3));
    }
}
