package org.webonise.service.interfaces;

import org.webonise.pojos.AuthenticationData;

public interface AuthenticationService {
    void addAuthenticatedUser(String authToken, AuthenticationData authenticationData);
}
