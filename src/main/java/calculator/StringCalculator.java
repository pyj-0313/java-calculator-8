package calculator;

import java.util.regex.Pattern;

public final class StringCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String NEWLINE_LITERAL = "\\n";

    private StringCalculator() { }

    public static int add(final String rawInput) {
        if (rawInput == null || rawInput.isBlank()) {
            return 0;
        }

        // "\n"이 문자 그대로 들어올 때를 실제 줄바꿈으로 정규화
        final String input = rawInput.replace(NEWLINE_LITERAL, "\n");

        String numbers = input;
        String delimiterRegex = DEFAULT_DELIMITER_REGEX;

        if (input.startsWith("//")) {
            final int newlineIndex = input.indexOf('\n');
            if (newlineIndex < 0) {
                throw new IllegalArgumentException("커스텀 구분자 형식 오류");
            }
            final String custom = input.substring(2, newlineIndex);
            numbers = input.substring(newlineIndex + 1);
            delimiterRegex = Pattern.quote(custom) + "|" + DEFAULT_DELIMITER_REGEX;
        }

        String[] tokens = numbers.split(delimiterRegex);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
