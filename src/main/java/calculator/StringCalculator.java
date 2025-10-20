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

        final String input = rawInput.replace(NEWLINE_LITERAL, "\n");

        String numbers = input;
        String delimiterRegex = DEFAULT_DELIMITER_REGEX;

        if (input.startsWith("//")) {
            final int newlineIndex = input.indexOf('\n');
            if (newlineIndex < 0) throw new IllegalArgumentException("커스텀 구분자 형식 오류");
            final String custom = input.substring(2, newlineIndex);
            numbers = input.substring(newlineIndex + 1);
            delimiterRegex = Pattern.quote(custom) + "|" + DEFAULT_DELIMITER_REGEX;
        }

        final String[] tokens = numbers.split(delimiterRegex);

        int sum = 0;
        for (final String token : tokens) {
            validateToken(token);
            final int n = Integer.parseInt(token);
            if (n <= 0) {
                throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
            }
            sum += n;
        }
        return sum;
    }

    private static void validateToken(final String token) {
        if (token.isBlank()) {
            throw new IllegalArgumentException("비어있는 숫자 항목이 있습니다.");
        }
        if (!token.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
