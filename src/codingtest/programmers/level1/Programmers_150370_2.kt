package codingtest.programmers.level1

// 개인정보 수집 유효기간: https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=kotlin
// 시뮬레이션
// 조건 처리가 참....
class Programmers_150370_2  {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val result = mutableListOf<Int>()
        val expiredByType = terms.associate {
            val (type, expired) = it.split(" ")
            type to expired
        }

        privacies.forEachIndexed { index, privacie ->
            val (date, type) = privacie.split(" ")
            var (year, month, day) = date.split(".").map { it.toInt() }
            val expired = expiredByType[type]!!.toInt()

            year += expired / 12
            month += expired % 12
            if (month > 12) {
                year++
                month -= 12
            }

            if (String.format("%d%02d%02d", year, month, day).toInt() <= today.replace(".", "").toInt()) {
                result.add(index + 1)
            }
        }

        return result.toIntArray()
    }
}

private fun main() {
    val problem = Programmers_150370_2()

    val result = problem.solution(
        "2022.05.19",
        arrayOf("A 100", "B 12", "C 3"),
        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C", "2022.10.01 C")
    )
    println(result.contentToString())

    val result2 = problem.solution("2022.05.01", arrayOf("B 15"), arrayOf("2021.02.01 B"))
    println(result2.contentToString())
}