package org.webonise.dataaccess

import com.google.inject.AbstractModule
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dao.impl.UserDaoImpl
import org.webonise.dao.interfaces.UserDao

@Slf4j
@CompileStatic
class DataAccessModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(DSLContextProvider)
        bind(UserDao).to(UserDaoImpl)
    }
}
