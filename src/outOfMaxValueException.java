public class outOfMaxValueException extends RuntimeException{
    public outOfMaxValueException() {
        System.out.println("Выход за 1024");
    }

    public outOfMaxValueException(String message) {
        super(message);
    }

    public outOfMaxValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public outOfMaxValueException(Throwable cause) {
        super(cause);
    }

    public outOfMaxValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
