package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Cursor {

    @SerializedName("value")
    private String value;
    @SerializedName("cursorType")
    private String cursorType;
    @SerializedName("stopOnEmptyResponse")
    private Boolean stopOnEmptyResponse;

    // region // Getter
    public String getValue() {
        return value;
    }

    public String getCursorType() {
        return cursorType;
    }

    public Boolean getStopOnEmptyResponse() {
        return stopOnEmptyResponse;
    }
    // endregion
}
