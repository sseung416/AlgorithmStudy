# k진수에서 소수 개수 구하기

### 문제 설명
[[ 문제 바로가기 ]](https://school.programmers.co.kr/learn/courses/30/lessons/92335)

숫자 n을 k진수로 변환한 문자열에서 조건에 맞는 소수의 개수를 찾는 문제
소수의 기준은 `0P0`, `P0`, `0P`, `P`의 형태 중 하나이어야 하며, `P`의 값이 소수이면서 0을 포함하지 않아야 함

### 풀이

원래는 매우 단순하게 풀었음  
하지만 아래 코드를 실행하니 테스트 케이스 1번에서 시간 초과가 나는 것...

```java
public class Solution {
    public static int solution(int n, int k) {
        int count = 0;
        String numStr = k != 0 ? calculateNumber(n, k) : Integer.toString(n);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '0') continue;
            for (int j = i + 1; j <= numStr.length(); j++) {
                if (numStr.charAt(j - 1) == '0') {
                    i = j - 1;
                    break;
                }
                long splitNum = Long.parseLong(numStr.substring(i, j));

                if (isPrime(splitNum) && checkSideNumber(i, j, numStr)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean checkSideNumber(int i, int j, String numStr) {
        if (i == 0) {
            if (j == numStr.length()) {
                // 소수 양쪽에 아무 것도 없는 경우 (P)
                return true;
            } else {
                // 다음 값이 0인지 판별 (P0)
                return numStr.charAt(j) == '0';
            }
        } else {
            if (j == numStr.length()) {
                // 이전 값이 0인지 판별 (0P)
                return numStr.charAt(i - 1) == '0';
            } else {
                // 이전 값과 다음 값이 0인지 판별 (0P0)
                return numStr.charAt(i - 1) == '0' && numStr.charAt(j) == '0';
            }
        }
    }

    private static String calculateNumber(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
```

그래서 완전탐색이라 그런가 했는데.. 소수를 탐색하는 부분이 문제였음 
`isPrime` 함수의 `for`문을 보면 `i` 변수가 `int` 값으로 선언되어 있는 것을 볼 수 있음..  
`n`은 long 값인데 `i`는 int 값이니 당연히 오버플로우가 발생함  
그러니 무한 반복으로 시간 초과가 날 수 밖에 없다~

아래와 같이 코드를 수정하니 잘 돌아감 ㅎ
```java
for (long i = 2; i * i <= n; i++)
```

### 개선
위 코드 자체가 워낙 길다보니까 피드백을 얻어서 더 짧게 개선함  

아래 코드는 `split()`을 사용해 0이 나올 때마다 숫자를 나누고 값이 비어있지 않을 때 소수인지 판별하도록 구현함

조건을 보면 소수에는 0을 포함하지 않으므로 0을 기준으로 문자열을 잘랐음  
예를 들어, 첫 번째 입력 예시인 `211020101011`은 0을 기준으로 잘랐을 때 `[211, 2, 1, 1, 11]`로 나뉨   
이제 저 나뉜 값을 기준으로 소수인지만 판별하면 끝~!
```java
public class Solution {
    public int solution(int n, int k) {
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

    private static String calculateNumber(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
```