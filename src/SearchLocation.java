public class SearchLocation {

    String result;

    public String oneInput(int x) {
        result = "oneInput";
        return result;
    }

    public String overTwoInput(int ... x) {
        if (x.length > 2) {
            result = "overTwoInput";
        }
        return result;
    }

    public String invalidInput(int x, int y){
        if(x<1||x>24||y<1||y>24) {
            result = "invalidInput";
        }
        return result;
    }

}