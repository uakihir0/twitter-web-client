package net.socialhub.twitter.web.model;

import com.google.gson.annotations.SerializedName;

public class Secrets {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    // region
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // endregion
}
