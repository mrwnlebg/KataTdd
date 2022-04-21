import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        int result = 0;
        if (!numbers.isEmpty())
            result = getResult(numbers, result);
        return result;
    }

    private int getResult(String numbers, int result) {
        String[] splitNumbers = getSplit(numbers);
        hasNegative(splitNumbers);
        for (String number : splitNumbers)
            result += Integer.parseInt(number);
        return result;
    }

    private String[] getSplit(String numbers) {
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                String delimiter = matcher.group(1);
                String numbersToSplit = matcher.group(2);
                return numbersToSplit.split(delimiter);
            }
        }
        return numbers.split(",|\n");
    }

    public void hasNegative(String[] splitedNumbers) {
        for (String number : splitedNumbers) {
            if (Integer.parseInt(number) < 0) {
                throw new RuntimeException("negatives not allowed " + Integer.parseInt(number));
            }
        }

    }

}
