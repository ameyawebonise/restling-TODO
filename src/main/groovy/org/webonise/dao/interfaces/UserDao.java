package org.webonise.dao.interfaces;


import org.webonise.sql.tables.pojos.Users;

public interface UserDao {
    String getUserList();
    String saveUserDetails(Users signupRequest);
}

