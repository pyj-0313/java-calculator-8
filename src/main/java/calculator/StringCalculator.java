package calculator;

public final class StringCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private StringCalculator() { }

    public static int add(final String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        String[] tokens = input.split(DEFAULT_DELIMITER_REGEX);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
