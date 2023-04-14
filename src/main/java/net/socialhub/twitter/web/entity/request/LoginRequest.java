package net.socialhub.twitter.web.entity.request;

public class LoginRequest {

    private String username;
    private String password;


    // region
    public static LoginRequestBuilder builder() {
        return new LoginRequestBuilder();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static final class LoginRequestBuilder {
        private String username;
        private String password;

        private LoginRequestBuilder() {
        }

        public LoginRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public LoginRequest build() {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.username = this.username;
            loginRequest.password = this.password;
            return loginRequest;
        }
    }
    // endregion
}
