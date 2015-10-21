package org.webonise.routers

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Log
import org.restlet.data.Method
import org.webonise.resources.LoginResource
import org.webonise.resources.TodoTaskResource
import org.webonise.restlingtodo.RoutingSpec
import org.webonise.restlingtodo.ServiceModule
import spock.lang.Shared
import spock.lang.Specification

@Log
class TodoTaskRouterSpec extends Specification implements RoutingSpec {

    @Shared
    def Injector injector

    def TodoTaskRouter fixture

    def setupSpec(){
        injector = Guice.createInjector(new ServiceModule())
    }

    def setup(){
        def context =  new org.restlet.Context(log)
        fixture = injector.getInstance(TodoTaskRouter)
        fixture.context = context
        fixture.init()
        fixture.start()
    }

    def teardown(){
        fixture.stop()
    }

    def "/newtask to TodoResource"() {
        when: "POST /newtask"
        def restlet = retrieveRoute(Method.POST, "/newtask")

        then: "create new task"
        restlet != null
        restlet.targetClass == TodoTaskResource
    }
}
