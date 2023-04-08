package net.socialhub.twitter.web.utility;

/**
 * リクエストに必要な認証情報等
 * ↑を英語に ->
 */
public class Session {

    private boolean isGuest = false;
    private GuestToken guestToken;
    private final Cookie cookie = new Cookie();

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

    public Cookie getCookie() {
        return cookie;
    }

    public String getCt0() {
        return cookie.getCt0();
    }
    // endregion
}
