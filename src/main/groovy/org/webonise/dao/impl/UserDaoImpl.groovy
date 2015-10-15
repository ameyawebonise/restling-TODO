package org.webonise.dao.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext
import org.jooq.InsertValuesStep2
import org.jooq.impl.DSL
import org.restlet.resource.Post
import org.webonise.dao.Interfaces.UserDao
import org.webonise.sql.tables.pojos.Users

@Slf4j
@CompileStatic
class UserDaoImpl implements UserDao{

    @Inject
    DSLContext dslContext

    @Post
    public String doSignup(Users users){
        InsertValuesStep2<?,Object,Object> step2 = dslContext.insertInto(DSL.table("Users"),DSL.field("userName"),DSL.field("password")).values(users.getUserName(),users.getPassword()).execute()
    }
}
