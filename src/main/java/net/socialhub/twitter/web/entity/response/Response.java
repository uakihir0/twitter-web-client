package net.socialhub.twitter.web.entity.response;

public class Response<T> {

    private T value;

    public Response(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
