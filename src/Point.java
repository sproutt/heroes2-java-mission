import java.util.ArrayList;
import java.util.List;

public class Point {

    public String removeBracket(String coordinates) {
        if (coordinates.charAt(0) == '(') {
            coordinates = coordinates.substring(1);
        }
        if (coordinates.charAt(coordinates.length() - 1) ==')') {
            coordinates = coordinates.substring(0, coordinates.length() - 2);
        }
        return coordinates;
    }

    public List<Integer> getXandY(String coordinates) {
        coordinates = removeBracket(coordinates);
        String[] pointContainer = coordinates.split(",");;
        List<Integer> number = new ArrayList<>();
        for(int i = 0; i < pointContainer.length; i++) {
            number.add(Integer.parseInt(pointContainer[i]));
        }
        return number;
    }

    public String Test(String coordinates) {
        List<Integer> number = getXandY(coordinates);

        if (number.size() == 1) {
            return "좌표 값 하나만 입력됨.";
        }else if (number.size() > 2) {
            return "좌표 두 개이상 입력됨.";
        }else if (number.get(0) < 1 || number.get(1) > 24) {
            return "유효하지 않은 값 입력됨.";
        }else
            return "UnexpectedTestCase";
    }
}


