package net.socialhub.twitter.web.entity;

import java.util.Map;

public interface GraphRequest {

    Map<String, Object> params();

    default void put(Map<String, Object> params, String key, Object value) {
        if (key != null && value != null) {
            params.put(key, value);
        }
    }
}
