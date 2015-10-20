package org.webonise.dao.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext
import org.jooq.Record1
import org.webonise.pojos.AuthenticationData
import org.webonise.dao.interfaces.UserDao
import org.webonise.dataaccess.DSLContextProvider
import org.webonise.exceptions.SignUpException
import org.webonise.sql.tables.pojos.Users

import static org.webonise.sql.tables.Users.USERS


@Slf4j
@CompileStatic
class UserDaoImpl implements UserDao {

    DSLContextProvider dslContextProvider
    DSLContext dslContext

    @Inject
    UserDaoImpl(DSLContextProvider dslContextProvider, DSLContext dslContext) {
        this.dslContext = dslContext
        this.dslContextProvider = dslContextProvider
    }

    @Override
    String authenticationUser(AuthenticationData authenticationData) {
        dslContext = dslContextProvider.get()

        Record1<Users> validUser = dslContext.selectFrom(USERS)
                .where(USERS.USER_NAME.eq(authenticationData.getUserName()))
                .and(USERS.PASSWORD.eq(authenticationData.getPassword()))
                .fetchOne() as Record1<Users>
        if (!validUser) {
            Record1<Users> userName = dslContext.select()
                    .from(USERS)
                    .where(USERS.USER_NAME.eq(authenticationData.userName))
                    .fetchOne() as Record1<Users>
            if (!userName)
                throw new NoSuchElementException("INVALID USER NAME")
            else
                throw new NoSuchElementException("INVALID PASSWORD")

        }
        return "SUCCESS"
    }

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
