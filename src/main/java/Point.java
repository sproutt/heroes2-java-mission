public class Point {
    String removeParenthesis(String input) {
        if (input.charAt(0) == '(')
            input = input.substring(1);
        if (input.charAt(input.length() - 1) == ')')
            input = input.substring(0, input.length() - 1);
        return input;
    }

    int[] getNumberArray(String input) {
        String[] stringNumberArray = input.split(",");
        int[] numberArray = new int[stringNumberArray.length];
        int i = 0;
        while (i < stringNumberArray.length) {
            numberArray[i] = Integer.parseInt(stringNumberArray[i].trim());
            i++;
        }
        return numberArray;
    }

    String validateNumberArray(int[] arr) {
        if (arr.length < 2)
            return "Please enter both X and Y";
        if (arr.length > 2)
            return "Please enter only X and Y";
        int i = 0;
        while (i < 2) {
            if (!(1 <= arr[i] && arr[i] <= 24))
                return "Not a valid number: "+ arr[i];
            i++;
        }
        return "SUCCESS";
    }

    String getXY (String input) {
        String validation;
        input = removeParenthesis(input);
        int[] pointArr = getNumberArray(input);
        if ((validation = validateNumberArray(pointArr)) != "SUCCESS")
            return validation;
        return "x=" + pointArr[0] + ", y=" + pointArr[1];
    }
}
