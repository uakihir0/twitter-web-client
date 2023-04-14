package net.socialhub.twitter.web.entity.request;

import com.google.gson.Gson;
import net.socialhub.twitter.web.internal.AbstractResource;

import java.util.Map;

public interface GraphRequest {

    Map<String, Object> params();

    default void put(Map<String, Object> params, String key, Object value) {
        if (key != null && value != null) {
            params.put(key, value);
        }
    }

    default Gson getGson() {
        return AbstractResource.gson;
    }
}
