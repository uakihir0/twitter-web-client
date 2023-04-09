package net.socialhub.twitter.web.api;

import net.socialhub.twitter.web.utility.Cookie;
import net.socialhub.twitter.web.entity.request.LoginRequest;

public interface LoginResource {


    Cookie login(LoginRequest request);

}
