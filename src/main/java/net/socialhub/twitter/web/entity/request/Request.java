package net.socialhub.twitter.web.entity.request;

import java.util.Map;

public interface Request {

    Map<String, String> params();

    default void put(Map<String, String> params, String key, Object value) {
        if (key != null && value != null) {
            if (value instanceof Boolean) {
                params.put(key, (Boolean) value ? "true" : "false");
            }
            params.put(key, value.toString());
        }
    }
}
