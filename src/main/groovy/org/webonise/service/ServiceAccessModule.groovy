package org.webonise.service

import com.google.inject.AbstractModule
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.service.impl.UserServiceImpl
import org.webonise.service.interfaces.UserService

@Slf4j
@CompileStatic
class ServiceAccessModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(UserService).to(UserServiceImpl)
    }
}
