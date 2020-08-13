public class PointParser {
    public static String checkXY(String input) {
        String answer = "";

        //입력한 숫자의 개수를 확인하기 위해 ,가 나오는 개수 확인
        int count = 0;
        int fromIndex = -1;
        while ((fromIndex = input.indexOf(",", fromIndex + 1)) >= 0) {
            count++;
        }


        if (count == 1) {

            String xString = input.substring(input.indexOf("(") + 1, input.indexOf(","));
            String yString = input.substring(input.indexOf(",") + 1, input.indexOf(")"));
            //String[] xy = input.split(",");
            int x = Integer.parseInt(xString);
            int y = Integer.parseInt(yString);


            if ((x >= 0 && x <= 24) && (y >= 0 && y <= 24)) {
                answer = "Success in finding x,y";
            } else {
                answer = "The number is outside the valid range";
            }

        } else if (count == 0) {
            answer = "Wrong input(only one number)";
        } else if (count >= 2) {
            answer = "Wrong input(more than 2 numbers)";
        }


        return answer;
    }


}
