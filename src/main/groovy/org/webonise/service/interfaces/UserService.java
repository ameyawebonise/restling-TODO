package org.webonise.service.interfaces;

import org.webonise.pojos.SignupRequest;
import org.webonise.pojos.SignupResponse;

public interface UserService {
    String getAllUsers();
    SignupResponse storeUserDetails(SignupRequest signupRequest);
}
