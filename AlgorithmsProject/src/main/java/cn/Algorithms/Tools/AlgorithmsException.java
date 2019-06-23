package cn.Algorithms.Tools;

public class AlgorithmsException extends Exception {
    public AlgorithmsException() {
        super();
    }

    public AlgorithmsException(String message) {
        super(message);
    }

    public AlgorithmsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlgorithmsException(Throwable cause) {
        super(cause);
    }

    protected AlgorithmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
