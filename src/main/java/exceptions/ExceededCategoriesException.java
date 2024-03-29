package exceptions;

public class ExceededCategoriesException extends RuntimeException {
    public ExceededCategoriesException(String message) {
        super(message);
    }
}
