package mission0;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class CoordinateTest {
    Coordinate coord;
    Random rand = new Random();
    private final int negativeCase = -1;

    int allCase = 24*24;
    String[] normalCoord_test = new String[allCase];
    int[][] normalCoord_actual = new int[allCase][2];

    String[] noCoord_test={"()", "(,)"}; //값이 없는 경우

    String[] oneCoord_test = new String[30];

    String[] overTwoCoord_test = new String[20];

    String[] invalidCoord_test = new String[20];

    @Before
    public void setUp(){
        coord = new Coordinate();
    }

    @Test
    public void normalCoord(){
        setNormalCoord_case();
        for(int i=0;i<allCase;i++){
            coord.coordExtraction(normalCoord_test[i]);
            assertEquals(normalCoord_actual[i][0],coord.getX());
            assertEquals(normalCoord_actual[i][1],coord.getY());
        }
    }

    @Test
    public void noCoord(){
        for(int i=0; i< noCoord_test.length;i++){
            coord.coordExtraction(noCoord_test[0]);
            assertEquals(negativeCase,coord.getX());
            assertEquals(negativeCase,coord.getY());
        }
    }
    @Test
    public void oneCoord(){
        setOneCoord_test();
        for(int i=0; i< oneCoord_test.length;i++){
            coord.coordExtraction(oneCoord_test[0]);
            assertEquals(negativeCase,coord.getX());
            assertEquals(negativeCase,coord.getY());
        }
    }
    @Test
    public void overTwoCoord(){
        setOverTwoCoord_test();
        for(int i=0; i< overTwoCoord_test.length;i++){
            coord.coordExtraction(overTwoCoord_test[0]);
            assertEquals(negativeCase,coord.getX());
            assertEquals(negativeCase,coord.getY());
        }
    }
    @Test
    public void invalidCoord(){
        setInvalidCoord_test();
        for(int i=0; i< invalidCoord_test.length;i++){
            coord.coordExtraction(invalidCoord_test[0]);
            assertEquals(negativeCase,coord.getX());
            assertEquals(negativeCase,coord.getY());
        }
    }
    @After
    public void cleanUp(){
        coord = null;
    }


    private void setNormalCoord_case(){ // (1,1~24)~(1~24,1) 모든 일반적인 경우 테스트 케이스 func
        for(int x=0;x<24;x++){
            for(int y=0;y<24;y++){
                int location = x*24+y;
                normalCoord_test[location]="("+(x+1)+","+(y+1)+")";
                normalCoord_actual[location][0]=x+1;
                normalCoord_actual[location][1]=y+1;
            }
        }
    }

    private void setOneCoord_test(){ // 무작위 값이 하나인 테스트 케이스 func
        for(int i=0;i<10;i++){
            int x = rand.nextInt(24)+1;
            oneCoord_test[i]="("+x+")";
        }
        for(int i=10;i<20;i++){
            int x = rand.nextInt(24)+1;
            oneCoord_test[i]="(,"+x+")";
        }
        for(int i=20;i<30;i++){
            int x = rand.nextInt(24)+1;
            oneCoord_test[i]="("+x+",)";
        }
    }

    private void setOverTwoCoord_test(){ // 무작위 값이 2개 초과인 테스트 케이스 func
        for(int i=0;i<20;i++){
            int length = rand.nextInt(6)+2;
            String str = "(";
            for(int j=0;j<length;j++){
                int x=rand.nextInt(24)+1;
                str+= x + ",";
            }
            int x=rand.nextInt(24)+1;
            str+=x+")";

            overTwoCoord_test[i]=str;
        }
    }

    private void setInvalidCoord_test(){
        for(int i=0;i<10;i++){
            int x = rand.nextInt(10)+25;
            int y = rand.nextInt(25)-25;
            invalidCoord_test[i] = "("+x+","+y+")";
        }
        for(int i=10;i<20;i++){
            int x = rand.nextInt(10)+25;
            int y = rand.nextInt(25)-25;
            invalidCoord_test[i] = "("+y+","+x+")";
        }
    }
}
