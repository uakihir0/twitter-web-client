package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Operation {

    @SerializedName("cursor")
    private Cursor cursor;

    // region // Getter
    public Cursor getCursor() {
        return cursor;
    }
    // endregion

}
