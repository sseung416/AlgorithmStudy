package codingtest

// 가장 가까운 문자: https://school.programmers.co.kr/learn/courses/30/lessons/142086
// 문자열
fun solution(s: String): IntArray {
    val answer = IntArray(s.length)
    val indexByChar = hashMapOf<Char, Int>()

    s.forEachIndexed { index, c ->
        answer[index] = if (indexByChar.containsKey(c)) {
            index - indexByChar[c]!!
        } else {
            -1
        }
        indexByChar[c] = index
    }

    return answer
}

fun main() {
    println(solution("banana").contentToString())
}