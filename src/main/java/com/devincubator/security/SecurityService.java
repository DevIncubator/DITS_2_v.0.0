package com.devincubator.security;
/**
 * Security service
 *
 * @author Alex V.
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
