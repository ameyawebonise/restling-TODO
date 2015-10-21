package org.webonise.service.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dao.Interfaces.UserDao
import org.webonise.pojos.AuthenticationData
import org.webonise.pojos.LoginResponse
import org.webonise.service.interfaces.AuthenticationService
import org.webonise.service.interfaces.LoginService
import org.webonise.sql.tables.pojos.Users

@Slf4j
@CompileStatic
class LoginServiceImpl implements LoginService {

    @Inject
    UserDao userDao

    @Inject
    AuthenticationService authenticationService

    @Override
    LoginResponse doLogin(AuthenticationData authenticationData) {
        try {
            userDao.authenticationUser(authenticationData)
            String authToken = UUID.randomUUID().toString()
            authenticationService.addAuthenticatedUser(authToken,authenticationData)
            return new LoginResponse("SUCCESS",authToken)
        } catch (NoSuchElementException ex) {
            return new LoginResponse(ex.getMessage())
        }
    }
}
