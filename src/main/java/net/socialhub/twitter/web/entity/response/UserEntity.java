package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class UserEntity {

    @SerializedName("url")
    private Entity url;
    @SerializedName("description")
    private Entity description;
}
