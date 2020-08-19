import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Integer MAX_LENGTH = 6;
    Scanner scanner = new Scanner(System.in);
    public List<Car> input() {
        String[] name = inputCarName();
        //int count = inputCount();

        List<Car> cars = new ArrayList<>();
        for(int i = 0; i<name.length; i++){
            cars.add(new Car(name[i]));
        }
        return cars;
    }

    private String[] inputCarName(){
        String inputCarName;
        String[] splittedInputCarName;
        String[] name;

        inputCarName = scanner.nextLine();
        splittedInputCarName = inputCarName.split(",");
        try{
            name = inputCarNameTrim(splittedInputCarName);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            name = inputCarName();
        }
        return name;
    }

    private String[] inputCarNameTrim(String[] name) throws IllegalArgumentException{
        String[] inputCarNameTrim;
        for(int i = 0; i<name.length; i++){
            name[i] = name[i].trim();
            checkNameLength(name[i]);
        }
        return inputCarNameTrim = name;
    }

    private void checkNameLength(String name){
        if(name.length() >= MAX_LENGTH){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public int inputCount(){
        int inputCount;
        inputCount = scanner.nextInt();
        return inputCount;
    }

}





