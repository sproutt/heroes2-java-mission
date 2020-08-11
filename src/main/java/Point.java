import java.util.ArrayList;
import java.util.List;

public class Point {
    private static final int NUMBER_OF_DIMENSION = 2;
    private String removeParenthesis(String input) {
        if (input.charAt(0) == '(') {
            input = input.substring(1);
        }
        if (input.charAt(input.length() - 1) == ')') {
            input = input.substring(0, input.length() - 1);
        }
        return input;
    }

    private ArrayList<Integer> getNumberArray(String input) {
        String[] stringNumberArray = input.split(",");
        ArrayList<Integer> numberArray = new ArrayList<>();
        for (int i = 0; i < stringNumberArray.length; i++) {
            numberArray.add(Integer.parseInt(stringNumberArray[i].trim()));
        }
        return numberArray;
    }

    private String validateNumberArray(ArrayList<Integer> arr) {
        if (arr.size() < NUMBER_OF_DIMENSION)
            return "Insufficient factors";
        if (arr.size() > NUMBER_OF_DIMENSION)
            return "Too many factors";
        for (int i = 0; i < NUMBER_OF_DIMENSION; i++) {
            if (arr.get(i) < 1 || 24 < arr.get(i))
                return "Not a valid number: "+ arr.get(i);
        }
        return "SUCCESS";
    }

    public String getXY (String input) {
        input = removeParenthesis(input);
        ArrayList<Integer> pointArr = getNumberArray(input);
        String validation = validateNumberArray(pointArr);
        if (validation != "SUCCESS")
            return validation;
        return "x=" + pointArr.get(0) + ", y=" + pointArr.get(1);
    }
}
