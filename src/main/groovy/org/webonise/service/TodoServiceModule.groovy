package org.webonise.service

import com.google.inject.AbstractModule
import groovy.transform.CompileStatic
import org.webonise.service.impl.LoginServiceImpl
import org.webonise.service.interfaces.LoginService

@CompileStatic
class TodoServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LoginService.class).to(LoginServiceImpl)
    }
}
