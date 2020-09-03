package view;

public class ViewException extends Exception {
    ViewException() {
        super("[ViewException]");
    }

    ViewException(String message) {
        super(message);
    }
}
