package org.webonise.resources

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.ServerResource
import org.webonise.pojos.SignupRequest
import org.webonise.pojos.SignupResponse
import org.webonise.service.interfaces.UserService

@Slf4j
@CompileStatic
class UserResource extends ServerResource{
    private String message;

    final UserService userService

    @Inject
    UserResource(UserService userService){
        this.userService = userService
    }

    @Get
    String AllUsers(){
        log.info("pinged")
        message = userService.getAllUsers()
        return message
    }

    @Post
    SignupResponse doSignUp(SignupRequest signupRequest){
       return userService.storeUserDetails(signupRequest)
    }
}