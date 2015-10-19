package org.webonise.restlingtodo

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Log
import org.restlet.data.Method
import org.webonise.resources.PingResource
import org.webonise.routers.LoginRouter
import org.webonise.routers.PingRouter
import spock.lang.Shared
import spock.lang.Specification

@Log
class RootRouterSpec extends Specification implements RoutingSpec {

    RootRouter fixture
    @Shared
    Injector injector


    def setupSpec() {
        injector = Guice.createInjector(new ServiceModule())
    }

    def setup() {
        def context = new org.restlet.Context(log)
        fixture = injector.getInstance(RootRouter)
        fixture.context = context
        fixture.init()
        fixture.start()
    }

    def teardown() {
        fixture.stop()
    }

    def "GET /pingpong/ping "() {
        when: "we request GET /pingpong/ping "
        def restlet = retrieveRoute(Method.GET, "/pingpong/ping")

        then: "ping resource"
        restlet != null
        restlet.targetClass.name == PingRouter.name
    }

    def "POST /login/user "() {
        when: "we request GET /login/user  "
        def restlet = retrieveRoute(Method.GET, "/login/user ")

        then: "ping resource"
        restlet != null
        restlet.targetClass.name == LoginRouter.name
    }
}
