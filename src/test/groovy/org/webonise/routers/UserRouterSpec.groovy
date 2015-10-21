package org.webonise.routers

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Log
import org.restlet.data.Method
import org.webonise.resources.UserResource
import org.webonise.restlingtodo.RoutingSpec
import org.webonise.restlingtodo.ServiceModule
import spock.lang.Shared
import spock.lang.Specification

@Log
class UserRouterSpec extends Specification implements RoutingSpec{

    @Shared
    def Injector injector

    def UserRouter fixture

    def setupSpec(){
        injector = Guice.createInjector(new ServiceModule())
    }

    def setup(){
        def context =  new org.restlet.Context(log)
        fixture = injector.getInstance(UserRouter)
        fixture.context = context
        fixture.init()
        fixture.start()
    }

    def teardown(){
        fixture.stop()
    }

    def " POST /signup goes to UserResource "(){

        when: "POST /signup"
        def restlet = retrieveRoute(Method.POST,"/signup")

        then: "UserResource found"
        restlet != null
        restlet.targetClass == UserResource
    }
}
