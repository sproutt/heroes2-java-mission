import java.util.ArrayList;
import java.util.List;

public class Point {
    private static final int NUMBER_OF_DIMENSION = 2;

    public String getXY (String input) {
        input = removeParenthesis(input);
        List<Integer> pointNumbers = getNumbers(input);
        String validation = validateNumbers(pointNumbers);
        if (validation != "SUCCESS")
            return validation;
        return "x=" + pointNumbers.get(0) + ", y=" + pointNumbers.get(1);
    }

    private String removeParenthesis(String input) {
        if (input.charAt(0) == '(') {
            input = input.substring(1);
        }
        if (input.charAt(input.length() - 1) == ')') {
            input = input.substring(0, input.length() - 1);
        }
        return input;
    }

    private List<Integer> getNumbers(String input) {
        String[] numberTexts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberTexts.length; i++) {
            numbers.add(Integer.parseInt(numberTexts[i].trim()));
        }
        return numbers;
    }

    private String validateNumbers(List<Integer> numbers) {
        if (numbers.size() < NUMBER_OF_DIMENSION) {
            return "Insufficient factors";
        }
        if (numbers.size() > NUMBER_OF_DIMENSION) {
            return "Too many factors";
        }
        for (int i = 0; i < NUMBER_OF_DIMENSION; i++) {
            if (numbers.get(i) < 1 || 24 < numbers.get(i)) {
                return "Not a valid number: "+ numbers.get(i);
            }
        }
        return "SUCCESS";
    }
}
