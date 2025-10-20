package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String input) {
        // ★ 테스트가 "\n"을 문자 그대로 줄 수도 있으니, 실제 개행으로 치환
        if (input != null) {
            input = input.replace("\\n", "\n");
        }

        // 0) 빈 문자열이면 0
        if (input == null || input.isBlank()) {
            return 0;
        }

        // 기본 구분자: 쉼표(,) 또는 콜론(:)
        String delimiterRegex = ",|:";
        String numbers = input;

        // 1) 커스텀 구분자 형식: //구분자\n숫자들
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex < 0) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String custom = input.substring(2, newlineIndex);  // //와 \n 사이
            numbers = input.substring(newlineIndex + 1);       // \n 뒤부터 숫자들

            // 특수문자 구분자도 안전하게 쓰기 위해 Pattern.quote 사용
            delimiterRegex = Pattern.quote(custom) + "|,|:";
        }

        // 2) 분리
        String[] tokens = numbers.split(delimiterRegex);

        int sum = 0;
        for (String token : tokens) {
            if (token.isBlank()) {
                throw new IllegalArgumentException("비어있는 숫자 항목이 있습니다.");
            }
            boolean allDigits = token.chars().allMatch(Character::isDigit);
            if (!allDigits) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
            int n = Integer.parseInt(token);
            if (n <= 0) {
                throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
            }
            sum += n;
        }
        return sum;
    }
}
