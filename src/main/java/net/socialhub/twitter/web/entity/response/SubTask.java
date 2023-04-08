package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class SubTask {

    @SerializedName("subtask_id")
    private String subtaskId;

    // region
    public String getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(String subtaskId) {
        this.subtaskId = subtaskId;
    }
    // endregion
}
