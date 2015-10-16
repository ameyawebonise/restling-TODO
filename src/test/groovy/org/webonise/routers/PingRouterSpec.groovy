package org.webonise.routers

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Log
import org.restlet.data.Method
import org.webonise.resources.PingResource
import org.webonise.restlingtodo.RoutingSpec
import org.webonise.restlingtodo.ServiceModule
import spock.lang.Shared
import spock.lang.Specification

@Log
class PingRouterSpec extends Specification implements RoutingSpec {

    @Shared
    def Injector injector

    def PingRouter fixture

    def setupSpec() {
        injector = Guice.createInjector(new ServiceModule())
    }

    def setup() {
        def context = new org.restlet.Context(log)
        fixture = injector.getInstance(PingRouter)
        fixture.context = context
        fixture.init()
    }

    def "GET /ping to PingResource"() {
        when: "GET /ping"
        def restlet = retrieveRoute(Method.GET, "/ping")

        then: "we have found the ping resource"
        restlet != null
        restlet.targetClass == PingResource
    }
}
