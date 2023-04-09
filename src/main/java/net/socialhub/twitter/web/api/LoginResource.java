package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.entity.request.LoginRequest;
import net.socialhub.twitter.web.utility.Cookie;

public interface LoginResource {

    Cookie login(LoginRequest request);
}
