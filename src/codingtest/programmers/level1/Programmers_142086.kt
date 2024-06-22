package codingtest.programmers.level1

// 가장 가까운 문자: https://school.programmers.co.kr/learn/courses/30/lessons/142086
// 문자열
class Programmers_142086 {
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
}

private fun main() {
    val problem = Programmers_142086()
    println(problem.solution("banana").contentToString())
}