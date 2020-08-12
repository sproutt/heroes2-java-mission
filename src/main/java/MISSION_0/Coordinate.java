package MISSION_0;

public class Coordinate {
    private final int OUT_OF_RANGE = -1;
    private int x;
    private int y;

    public Coordinate(){
        this.x = OUT_OF_RANGE;
        this.y = OUT_OF_RANGE;
    }

    private void initCoordinate(){
        this.x = OUT_OF_RANGE;
        this.y = OUT_OF_RANGE;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void extractCoord(String input) { // 좌표를 추출하는 함수
        initCoordinate();
        String[] coord_xy = input.split("\\(|,|\\)"); //정규 표현식으로 ( or , or )로 split
        if(coord_xy.length==3){
            boolean isNotNullableX = !(coord_xy[1].equals("")); //(,7) 같은 경우 x=""이 되기 때문에 검사
            boolean isNotNullableY = !(coord_xy[2].equals(""));

            if(isNotNullableX && isNotNullableY){
                int coord_x = Integer.parseInt(coord_xy[1].trim());
                int coord_y = Integer.parseInt(coord_xy[2].trim());

                addCoord(coord_x, coord_y);
            }
        }
    }

    public void printXY() { // 좌표 print func
        if(x!=OUT_OF_RANGE && y!=OUT_OF_RANGE){
            System.out.printf("x : %d, y : %d\n", this.x, this.y);
        }
    }

    private boolean isValidValue(int x, int y){ // 0 이하 25 이상인지 check func
        boolean isValidCase0 = x>0 && y>0;
        boolean isValidCase25 = x<25 && y<25;

        if (isValidCase0 && isValidCase25){
            return true;
        }
        return false;
    }

    private void addCoord(int x, int y){ // 이상 없으면 x,y에 값 할당하는 add func
        if(isValidValue(x,y)) {
            this.x = x;
            this.y = y;
        }
    }
}
