package codingtest.programmers.level1

// 크기가 작은 부분문자열: https://school.programmers.co.kr/learn/courses/30/lessons/147355
// 문자열
class Programmers_147355 {
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
}

private fun main() {
    val problem = Programmers_147355()
    println(problem.solution("3141592", "271"))
    println(problem.solution("500220839878", "7"))
    println(problem.solution("10203", "15"))
}