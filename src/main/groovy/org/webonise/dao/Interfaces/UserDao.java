package org.webonise.dao.Interfaces;


import org.webonise.pojos.AuthenticationData;
import org.webonise.sql.tables.pojos.Users;

public interface UserDao {
    String authenticationUser(AuthenticationData authenticationData);

    String getUserList();

    String saveUserDetails(Users signupRequest);
}
