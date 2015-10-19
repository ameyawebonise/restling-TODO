package org.webonise.restlingtodo

import com.google.inject.Guice
import com.google.inject.Injector
import spock.lang.Specification


class ServiceModuleSpec extends Specification{

    Injector injector
    ServiceModule fixture

    def setup(){
        injector = Guice.createInjector(new ServiceModule())
    }

    def"calssws should route to router"(){
        when: fixture = injector.getInstance(ServiceModule)
        then: fixture.routerClass == RootRouter
    }

    def "configuration"(){
        expect: "not explode anything"
        true
    }
}
