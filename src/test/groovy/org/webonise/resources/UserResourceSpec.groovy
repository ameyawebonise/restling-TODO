package org.webonise.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Log
import org.restlet.Request
import org.restlet.Response
import org.restlet.data.MediaType
import org.restlet.data.Method
import org.restlet.data.Reference
import org.restlet.data.Status
import org.webonise.pojos.SignupResponse
import org.webonise.restlingtodo.RoutingSpec
import org.webonise.restlingtodo.ServiceModule
import org.webonise.routers.UserRouter
import spock.lang.Shared
import spock.lang.Specification

@Log
class UserResourceSpec extends Specification implements RoutingSpec{

    @Shared
    Injector injector
    UserRouter fixture

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

    def "SignUp with valid field entries"(){
        when: "POST /signup"
        def restlet = retrieveRoute(Method.POST,"/signup")
        Request request = new Request(Method.POST, new Reference("/signup"))
        request.setEntity(validEntryField(),MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == UserResource
        response.status == Status.SUCCESS_OK
        ObjectMapper mapper = new ObjectMapper()
        SignupResponse signupResponse = mapper.readValue(response.getEntityAsText(),SignupResponse)
        signupResponse.getMessage() == "SignUp Successful"
    }

    def "SignUp with username field empty"(){
        when: "POST /signup"
        def restlet = retrieveRoute(Method.POST,"/signup")
        Request request = new Request(Method.POST, new Reference("/signup"))
        request.setEntity(emptyUserNameField(),MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == UserResource
        response.status == Status.SUCCESS_OK
        ObjectMapper mapper = new ObjectMapper()
        SignupResponse signupResponse = mapper.readValue(response.getEntityAsText(),SignupResponse)
        signupResponse.getMessage() == "Please Enter Username"
    }

    def "SignUp with password field empty"(){
        when: "POST /signup"
        def restlet = retrieveRoute(Method.POST,"/signup")
        Request request = new Request(Method.POST, new Reference("/signup"))
        request.setEntity(emptyPasswordField(),MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == UserResource
        response.status == Status.SUCCESS_OK
        ObjectMapper mapper = new ObjectMapper()
        SignupResponse signupResponse = mapper.readValue(response.getEntityAsText(),SignupResponse)
        signupResponse.getMessage() == "Please Enter Password"
    }

    String validEntryField(){
        return "{\"username\":\"Rohan\",\"password\":\"rohan123\"}"
    }
    String emptyUserNameField(){
        return "{\"password\":\"rohan123\"}"
    }
    String emptyPasswordField(){
        return "{\"username\":\"Rohan\"}"
    }
}
