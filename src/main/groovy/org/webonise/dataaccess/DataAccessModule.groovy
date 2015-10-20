package org.webonise.dataaccess

import com.google.inject.AbstractModule
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext
import org.webonise.dao.Interfaces.UserDao
import org.webonise.dao.impl.UserDaoImpl

@Slf4j
@CompileStatic
class DataAccessModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(DSLContext.class)toProvider(DSLContextProvider.class)
        bind(UserDao.class)to(UserDaoImpl)
    }
}
