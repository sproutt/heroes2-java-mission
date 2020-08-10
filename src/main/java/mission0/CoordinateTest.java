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
    String[] normalCoord_testCase = new String[allCase];
    int[][] normalCoord_actual = new int[allCase][2];

    String[] noCoord_testCase={"()", "(,)"}; //값이 없는 경우

    String[] oneCoord_testCase = new String[30];

    String[] overTwoCoord_testCase = new String[20];

    String[] invalidCoord_testCase = new String[20];

    @Before
    public void setUp(){
        coord = new Coordinate();
    }

    @Test
    public void normalCoord(){
        normalCoordTest();
    }

    @Test
    public void noCoord(){
        noCoordTest();
    }

    @Test
    public void oneCoord(){
        oneCoordTest();
    }

    @Test
    public void overTwoCoord(){
        overTwoCoordTest();
    }

    @Test
    public void invalidCoord(){
        InvalidCoordTest();
    }

    @After
    public void cleanUp(){
        coord = null;
    }

    private void setNormalCoord_case(){ // (1,1~24)~(1~24,1) 모든 일반적인 경우 테스트 케이스 func
        for(int x=0;x<24;x++){
            for(int y=0;y<24;y++){
                int location = x*24+y;
                normalCoord_testCase[location]="("+(x+1)+","+(y+1)+")";
                normalCoord_actual[location][0]=x+1;
                normalCoord_actual[location][1]=y+1;
            }
        }
    }

    private void setOneCoord_test(){ // 무작위 값이 하나인 테스트 케이스 func
        for(int i=0;i<10;i++){
            int x = rand.nextInt(24)+1;
            oneCoord_testCase[i]="("+x+")";
            oneCoord_testCase[i+10]="(,"+x+")";
            oneCoord_testCase[i+20]="("+x+",)";
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

            overTwoCoord_testCase[i]=str;
        }
    }

    private void setInvalidCoord_test(){
        for(int i=0;i<10;i++){
            int x = rand.nextInt(10)+25;
            int y = rand.nextInt(25)-25;
            invalidCoord_testCase[i] = "("+x+","+y+")";
            invalidCoord_testCase[i+10] = "("+y+","+x+")";
        }
    }

    private void normalCoordTest() {
        setNormalCoord_case();
        for(int i=0;i<allCase;i++){
            coord.coordExtraction(normalCoord_testCase[i]);
            assertEquals(normalCoord_actual[i][0],coord.getX());
            assertEquals(normalCoord_actual[i][1],coord.getY());
        }
    }

    private void noCoordTest() {
        for (int i = 0; i < noCoord_testCase.length; i++) {
            coord.coordExtraction(noCoord_testCase[0]);
            assertEquals(negativeCase, coord.getX());
            assertEquals(negativeCase, coord.getY());
        }
    }

    private void oneCoordTest() {
        setOneCoord_test();
        for(int i=0; i< oneCoord_testCase.length;i++){
            coord.coordExtraction(oneCoord_testCase[0]);
            assertEquals(negativeCase,coord.getX());
            assertEquals(negativeCase,coord.getY());
        }
    }

    private void overTwoCoordTest() {
        setOverTwoCoord_test();
        for(int i=0; i< overTwoCoord_testCase.length;i++){
            coord.coordExtraction(overTwoCoord_testCase[0]);
            assertEquals(negativeCase,coord.getX());
            assertEquals(negativeCase,coord.getY());
        }
    }

    private void InvalidCoordTest() {
        setInvalidCoord_test();
        for(int i=0; i< invalidCoord_testCase.length;i++){
            coord.coordExtraction(invalidCoord_testCase[0]);
            assertEquals(negativeCase,coord.getX());
            assertEquals(negativeCase,coord.getY());
        }
    }
}

