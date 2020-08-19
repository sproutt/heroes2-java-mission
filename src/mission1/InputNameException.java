public class InputNameException extends Exception {
    public InputNameException() {
        System.out.println("공백 포함. 자동차 이름은 1~5자여야 합니다.");
    }
    public InputNameException(String name) {
        System.out.println(name + " : 자동차 이름은 1~5자여야 합니다.");
    }
}
