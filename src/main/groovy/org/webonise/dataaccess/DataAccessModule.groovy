package org.webonise.dataaccess

import com.google.inject.AbstractModule
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext

@Slf4j
@CompileStatic
class DataAccessModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(DSLContext.class)toProvider(DSLContextProvider.class)
    }
}
