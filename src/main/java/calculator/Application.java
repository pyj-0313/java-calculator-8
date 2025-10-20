package calculator;

import camp.nextstep.edu.missionutils.Console;

public final class Application {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    private Application() { }

    public static void main(final String[] args) {
        System.out.println(INPUT_MESSAGE);
        final String input = Console.readLine();
        final int result = StringCalculator.add(input);
        System.out.println(RESULT_MESSAGE + result);
    }
}
