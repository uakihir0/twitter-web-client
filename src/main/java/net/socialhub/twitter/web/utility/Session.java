package net.socialhub.twitter.web.utility;

/**
 * リクエストに必要な認証情報等
 * ↑を英語に ->
 */
public class Session {

    public Session(Config config) {
        this.config = config;
        this.cookie = new Cookie(config);
    }

    private boolean isGuest = false;
    private GuestToken guestToken;
    private final Config config;
    private final Cookie cookie;


    // region
    public boolean isGuest() {
        return isGuest;
    }

    public void setGuest(boolean guest) {
        isGuest = guest;
    }

    public String getGuestToken() {
        return guestToken.get();
    }

    public void setGuestToken(GuestToken guestToken) {
        this.guestToken = guestToken;
    }

    public Config getConfig() {
        return config;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public String getCt0() {
        return cookie.getCt0();
    }
    // endregion
}
