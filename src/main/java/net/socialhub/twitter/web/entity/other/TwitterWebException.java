package net.socialhub.twitter.web.entity.other;

public class TwitterWebException extends RuntimeException {

    public TwitterWebException(String message, Throwable th) {
        super(message, th);
    }

    public TwitterWebException(Throwable th) {
        super(th);
    }
}
