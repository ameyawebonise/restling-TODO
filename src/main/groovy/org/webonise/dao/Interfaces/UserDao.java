package org.webonise.dao.Interfaces;


import org.webonise.pojos.AuthenticationData;

public interface UserDao {
    String authenticationUser(AuthenticationData authenticationData);
}
