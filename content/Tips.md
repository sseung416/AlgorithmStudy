# 코테 풀면서 알아두면 좋은 개념

## String 함수 모음

|   반환값   |            함수명            |        설명        |
|:-------:|:-------------------------:|:----------------:|
| boolean | String.startsWith(String) | 특정 문자열로 시작하는지 확인 |
| boolean |  String.endsWith(String)  | 특정 문자열로 끝나는지 확인  |
| boolean |    String.indexOf(int)    | 특정 문자열로 끝나는지 확인  |
| boolean |  String.lastIndexOf(int)  | 특정 문자열로 끝나는지 확인  |

## 배열

#### 정렬

- 오름차순 정렬: `Arrays.sort(arr);`
- 내림차순 정렬: `Arrays.sort(arr, Collections.reverseOrder())`

[//]: # (Arrays.sort의 경우 사전순으로 정렬하기 때문에 ["12", "111", "])

[//]: # (## 리스트)

[//]: # (Collections.swap&#40;Collection, T, T&#41;)

[//]: # (#### 정렬)


## Math 클래스

파라미터 값은 거의 대부분 `double`을 기준으로하니 자료형이 기억 안 날 땐 `double`로 사용하자
(abs, nax, min은 `int`도 지원함)

 |    함수명    |           설명           |
|:---------:|:----------------------:|
|  abs(a)   |         절대값 반환         |
| round(a)  | 소수점 첫째 자리에서 반올림한 정수 반환 |
|  ceil(a)  | 소수점 첫째 자리에서 올림한 정수 반환  |
| floor(a)  | 소수점 첫째 자리에서 버림한 정수 반환  |
| max(a, b) |     두 값 중 더 큰 값 반환     |
| min(a, b) |    두 값 중 더 작은 값 반환     |
| pow(a, b) |         a^b 반환         |
|  sqrt(a)  |       a의 제곱근 반환        |

## 형변환

- String to int: Integer.parseInt()
- int to String
- char to String: Character.toString()
