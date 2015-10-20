package org.webonise.service

import com.google.inject.Guice
import com.google.inject.Injector
import org.webonise.restlingtodo.ServiceModule
import org.webonise.service.impl.LoginServiceImpl
import spock.lang.Shared
import spock.lang.Specification


class LoginServiceImplSpec extends Specification {

    @Shared
    Injector injector

    LoginServiceImpl loginServiceImpl

    def setupSpec() {
        injector = Guice.createInjector(new ServiceModule())
    }

    def setup() {
        loginServiceImpl = injector.getInstance(LoginServiceImpl)
    }

    def "logged in user "() {

    }
}
