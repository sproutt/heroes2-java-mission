public class check {
   static boolean checkXY(String m){
       boolean a;
       //입력받은 문자열을 , 를 중심으로 나누어서 x와 y를 추출한다.
        String[] xy= m.split(",");
        int x= Integer.parseInt(xy[0]);
        int y= Integer.parseInt(xy[1]);;

        //x와 y가 유효한 범위 안의 값이면 true, 그렇지 않으면 false 값을 준다.
        if((x>=0 && x<=24) && (y>=0 && y<=24)){
            a=true;
        }else{a=false;}

        //x,y 좌표 값을 하나만 입력했거나 두 개 이상 입력한 경우 false 값을 준다.
       if(m.length()<=2 || m.length()>=5){a=false;}

       return a;
   }

}
