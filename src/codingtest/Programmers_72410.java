package codingtest;

// 신규 아이디 추천: https://school.programmers.co.kr/learn/courses/30/lessons/72410
// 구현, 문자열
public class Programmers_72410 {
    public static void run() {
        Programmers_72410 problem = new Programmers_72410();
        String answer1 = problem.solution("...!@BaT#*..y.abcdefghijklm");
        String answer2 = problem.solution("z-+.^.");
        String answer3 = problem.solution("=.=");
        String answer4 = problem.solution(	"123_.def");
        String answer5 = problem.solution("abcdefghijklmn.p");

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
        System.out.println(answer5);
    }

    private String solution(String newId) {
        return newId.toLowerCase()
                .replaceAll("[^0-9a-z_\\-.]", "")
                .replaceAll("\\.{2,}", ".")
                .transform(s -> {
                    int length = s.length();

                    if (length == 1 && s.equals("."))
                        return "";
                    if (s.endsWith("."))
                        s = s.substring(0, s.length() - 1);
                    if (s.startsWith("."))
                        s = s.substring(1);

                    return s;
                })
                .transform(s -> s.equals("") ? "a" : s)
                .transform(s -> s.length() > 15 ? s.substring(0, 15) : s)
                .transform(s -> {
                    if (s.length() <= 2) {
                        StringBuilder builder = new StringBuilder(s);
                        String last = s.charAt(s.length() - 1) + "";
                        builder.append(last.repeat(Math.max(0, 3 - builder.length())));

                        return builder.toString();
                    }

                    return s;
                }).transform(s -> s.endsWith(".") ? s.substring(0, s.length() - 1) : s);
    }
}
