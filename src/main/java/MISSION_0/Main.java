package MISSION_0;

public class Main {

    public static void main(String[] args) {
        String[] test_case = {
                "(-1,12)",
                "(12, 12)",
                "(9,14)",
                "(7, 8)",
                "(24,1)",
                "(0)",
                "(5,)",
                "(,7)",
                "(12,413,45)"
        };

        Coordinate test = new Coordinate();
        for(int i=0; i< test_case.length;i++){
            test.extractCoord(test_case[i]);
            test.printXY();
        }
    }
}
