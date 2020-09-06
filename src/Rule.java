import java.util.Random;

public class Rule {
    private static final int BOUNDARYNUMBER = 10;
    private static final int GOFORWARDCONDITION = 4;

    public static boolean isGoForward() {
        Random random = new Random();
        if(random.nextInt(BOUNDARYNUMBER) >= GOFORWARDCONDITION) {
            return true;
        }
        return false;
    }
}
