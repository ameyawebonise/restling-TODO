package org.webonise.service.interfaces;

import org.webonise.pojos.SignupRequest;
import org.webonise.pojos.SignupResponse;
import org.webonise.sql.tables.pojos.Users;

public interface UserService {
    String getAllUsers();
    SignupResponse storeUserDetails(SignupRequest signupRequest);
}
