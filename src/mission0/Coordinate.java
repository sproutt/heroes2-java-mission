public class Coordinate {
    private String[] extractValue(String input) {
        return input.split(",");
    }

    private boolean isTwoValues(String[] splitInput) {
        return splitInput.length != 2;
    }

    private boolean isValidNumber(int number) {
        return number >= 1 && number <= 24;
    }

    public String getCoordinate(String input) {
        String[] splitInput = extractValue(input);
        if (isTwoValues(extractValue(input))) {
            return "Enter TWO Coordinates.";
        }

        String X = splitInput[0].replaceAll("[^0-9]", "");
        String Y = splitInput[1].replaceAll("[^0-9]", "");

        if (X.isEmpty() || Y.isEmpty()) {
            return "Blank is not valid.";
        }

        int numberX = Integer.parseInt(X);
        int numberY = Integer.parseInt(Y);

        if (isValidNumber(numberX) && isValidNumber(numberY)) {
            return "x = " + numberX + ", " + "y = " + numberY;
        } else {
            return "Valid number ranges from 1 to 24.";
        }
    }
}