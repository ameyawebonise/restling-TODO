package org.webonise.service

import com.google.inject.AbstractModule
import groovy.transform.CompileStatic
import org.webonise.dao.Interfaces.TodoTaskDao
import org.webonise.dao.impl.TodoTaskDaoImpl
import org.webonise.service.impl.AuthenticationServiceImpl
import org.webonise.service.impl.LoginServiceImpl
import org.webonise.service.impl.TodoTaskServiceImpl
import org.webonise.service.interfaces.AuthenticationService
import org.webonise.service.interfaces.LoginService
import org.webonise.service.interfaces.TodoTaskService

@CompileStatic
class TodoServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LoginService.class).to(LoginServiceImpl)
        bind(AuthenticationService).to(AuthenticationServiceImpl.class)
        bind(TodoTaskDao.class).to(TodoTaskDaoImpl.class)
        bind(TodoTaskService).to(TodoTaskServiceImpl.class)
    }
}
