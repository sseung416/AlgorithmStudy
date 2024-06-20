package codingtest

// 크기가 작은 부분문자열: https://school.programmers.co.kr/learn/courses/30/lessons/147355
// 문자열
fun solution(t: String, p: String): Int {
    var count = 0

    val target = p.toInt()
    val subLength = p.length

    for (i in 0..t.length - subLength) {
        val compare = t.substring(i, i + subLength).toInt()
        if (compare <= target) {
            count++
        }
    }
    return count
}

fun main() {
    println(solution("3141592", "271"))
    println(solution("500220839878", "7"))
    println(solution("10203", "15"))
}