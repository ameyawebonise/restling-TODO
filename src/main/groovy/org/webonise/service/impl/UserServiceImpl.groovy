package org.webonise.service.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.apache.commons.codec.digest.Crypt
import org.webonise.dao.Interfaces.UserDao
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
        Crypt crypt
        try{
            Users user = new Users()
            if (signupRequest.username == null){
                signupResponse.setMessage("Please Enter Username")
                return signupResponse
            }

            else if(signupRequest.password == null){
                signupResponse.setMessage("Please Enter Password")
                return signupResponse
            }
            else{
                user.userName = signupRequest.username
                String encryptedVal = crypt.crypt(signupRequest.password,"xx")
                user.password = encryptedVal
                signupResponse.message= userDao.saveUserDetails(user)
                return signupResponse
            }
        }catch (SignUpException se){
            signupResponse.setMessage(se.getMessage())
            return signupResponse
        }
    }
}
