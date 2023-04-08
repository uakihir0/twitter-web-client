package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Onboarding {

    @SerializedName("flow_token")
    private String flowToken;
    @SerializedName("status")
    private String status;
    @SerializedName("subtasks")
    private SubTask[] subtasks;

    // region
    public String getFlowToken() {
        return flowToken;
    }

    public void setFlowToken(String flowToken) {
        this.flowToken = flowToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SubTask[] getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(SubTask[] subtasks) {
        this.subtasks = subtasks;
    }
    // endregion
}
