package org.webonise.routers

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Log
import org.restlet.data.Method
import org.restlet.resource.Finder
import org.webonise.resources.LoginResource
import org.webonise.restlingtodo.RoutingSpec
import org.webonise.restlingtodo.ServiceModule
import restling.restlet.RestlingInjectedFilter
import spock.lang.Shared
import spock.lang.Specification

@Log
class LoginRouterSpec extends Specification implements RoutingSpec {

    @Shared
    def Injector injector

    def LoginRouter fixture

    def setupSpec() {
        injector = Guice.createInjector(new ServiceModule())
    }

    def setup() {
        def context = new org.restlet.Context(log)
        fixture = injector.getInstance(LoginRouter)
        fixture.context = context
        fixture.init()
        fixture.start()
    }

    def teardown() {
        fixture.stop()
    }


    def "/login to LoginResource"() {
        when: "POST /login"
        def restlet = retrieveRoute(Method.POST, "/login")

        then: "User login"
        restlet != null
        restlet.targetClass == LoginResource
    }
}
