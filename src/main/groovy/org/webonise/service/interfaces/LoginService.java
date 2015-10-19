package org.webonise.service.interfaces;

import org.webonise.pojos.AuthenticationData;
import org.webonise.pojos.LoginResponse;

public interface LoginService {
    LoginResponse login(AuthenticationData authenticationData);
}
