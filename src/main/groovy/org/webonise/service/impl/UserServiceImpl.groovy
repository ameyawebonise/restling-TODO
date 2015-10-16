package org.webonise.service.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dao.interfaces.UserDao
import org.webonise.exceptions.SignUpException
import org.webonise.pojos.SignupRequest
import org.webonise.pojos.SignupResponse
import org.webonise.service.interfaces.UserService
import org.webonise.sql.tables.pojos.Users

@Slf4j
@CompileStatic
class UserServiceImpl implements UserService {

    @Inject
    UserDao userDao

    @Override
    String getAllUsers() {
        return userDao.getUserList()
    }

    @Override
    SignupResponse storeUserDetails(SignupRequest signupRequest) {
        SignupResponse signupResponse = new SignupResponse()
        try{
            Users user = new Users()
            if (signupRequest.username != null)
                user.userName = signupRequest.username
            else{
                signupResponse.setMessage("Please Enter Username")
                return signupResponse
            }
            if(signupRequest.password != null)
                user.password = signupRequest.password
            else{
                signupResponse.setMessage("Please Enter Password")
                return signupResponse
            }
            signupResponse.message= userDao.saveUserDetails(user)
            return signupResponse
        }catch (SignUpException se){
            signupResponse.setMessage(se.getMessage())
            return signupResponse
        }
    }
}
