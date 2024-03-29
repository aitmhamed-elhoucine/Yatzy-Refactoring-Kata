package exceptions;

public class AlreadyPlayedCategoryException extends RuntimeException {
    public AlreadyPlayedCategoryException(String message) {
        super(message);
    }
}
