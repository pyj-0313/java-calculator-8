package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // ✅ 테스트 환경을 맞추기 위해 '한 줄만' 읽는다.
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}
