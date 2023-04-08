package net.socialhub.twitter.web.entity.response.login;

import com.google.gson.annotations.SerializedName;
import net.socialhub.twitter.web.entity.response.User;

public class SubTask {

    @SerializedName("subtask_id")
    private String subtaskId;

    @SerializedName("open_account")
    private User openAccount;

    // region
    public String getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(String subtaskId) {
        this.subtaskId = subtaskId;
    }
    // endregion
}
