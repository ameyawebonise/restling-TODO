package org.webonise.resources

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.Post
import org.restlet.resource.ServerResource
import org.webonise.dao.Interfaces.UserDao
import org.webonise.pojos.AuthenticationData
import org.webonise.pojos.LoginResponse
import org.webonise.service.interfaces.LoginService

@Slf4j
@CompileStatic
class LoginResource extends ServerResource {

    @Inject
    UserDao userDao

    @Inject
    LoginService loginService

    @Post
    LoginResponse doLogin(AuthenticationData authenticationData) {
       return loginService.doLogin(authenticationData)

    }

}
