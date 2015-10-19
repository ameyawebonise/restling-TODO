package org.webonise.dao.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext
import org.webonise.dao.interfaces.UserDao
import org.webonise.dataaccess.DSLContextProvider
import org.webonise.exceptions.SignUpException
import org.webonise.sql.tables.pojos.Users
import static org.webonise.sql.tables.Users.USERS

@Slf4j
@CompileStatic
class UserDaoImpl implements UserDao{
    @Inject
    DSLContextProvider dslContextProvider

    DSLContext dslContext

    @Override
    public String getUserList(){
        dslContext = dslContextProvider.get()
        List<Users> usersList =  dslContext.select().from(USERS).fetch().into(Users) as List<Users>
        for(Users user: usersList){
            log.info("UserID : "+"${user.getUserId()}"+" UserName : "+"${user.getUserName()}"+" Password : "+"${user.getPassword()}")
        }
        return true
    }

    @Override
    String saveUserDetails(Users signupRequest) {
        dslContext = dslContextProvider.get()
        if (dslContext.newRecord(USERS, signupRequest).store())
            return "SignUp Successful"
        else
            throw new SignUpException("SignUp Unsuccessful")
    }
}
