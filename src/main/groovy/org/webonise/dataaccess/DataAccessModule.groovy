package org.webonise.dataaccess

import com.google.inject.AbstractModule
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
<<<<<<< HEAD
import org.jooq.DSLContext
import org.webonise.dao.Interfaces.UserDao
import org.webonise.dao.impl.UserDaoImpl
=======
import org.webonise.dao.impl.UserDaoImpl
import org.webonise.dao.interfaces.UserDao
>>>>>>> 8733eeb5ce81288df30c944f4f7c274e8e19f131

@Slf4j
@CompileStatic
class DataAccessModule extends AbstractModule{

    @Override
    protected void configure() {
<<<<<<< HEAD
        bind(DSLContext.class)toProvider(DSLContextProvider.class)
        bind(UserDao.class)to(UserDaoImpl)
=======
        bind(DSLContextProvider)
        bind(UserDao).to(UserDaoImpl)
>>>>>>> 8733eeb5ce81288df30c944f4f7c274e8e19f131
    }
}
