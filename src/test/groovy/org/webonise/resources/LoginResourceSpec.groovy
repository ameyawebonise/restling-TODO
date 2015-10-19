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
import org.webonise.pojos.LoginResponse
import org.webonise.restlingtodo.RoutingSpec
import org.webonise.restlingtodo.ServiceModule
import org.webonise.routers.LoginRouter
import org.webonise.service.impl.LoginServiceImpl
import org.webonise.service.interfaces.LoginService
import spock.lang.Shared
import spock.lang.Specification

@Log
class LoginResourceSpec extends Specification implements RoutingSpec {

    @Shared
    Injector injector
    LoginRouter fixture

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

    def "Login with valid credentials"() {
        when: "POST /login"
        def restlet = retrieveRoute(Method.POST, "/login")
        Request request = new Request(Method.POST, new Reference("/login"));
        request.setEntity(authenticatedUser(), MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == LoginResource
        response.status == Status.SUCCESS_OK
        Object mapper = new ObjectMapper()
        LoginResponse checkInLogoInResponse =
                mapper.readValue(response.getEntityAsText(), LoginResponse)
        checkInLogoInResponse != null
        checkInLogoInResponse.getAuthToken() != null
        checkInLogoInResponse.getMessage() == "SUCCESS"
    }


    def "Login with invalid password"() {
        when: "POST /login"
        def restlet = retrieveRoute(Method.POST, "/login")
        Request request = new Request(Method.POST, new Reference("/login"));
        request.setEntity(invalidPassword(), MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == LoginResource
        response.status == Status.SUCCESS_OK
        Object mapper = new ObjectMapper()
        LoginResponse checkInLogoInResponse =
                mapper.readValue(response.getEntityAsText(), LoginResponse)
        checkInLogoInResponse.getAuthToken() == null
        checkInLogoInResponse.getMessage() == "INVALID PASSWORD"
    }

    def "Login with invalid user name"() {
        when: "POST /login"
        def restlet = retrieveRoute(Method.POST, "/login")
        Request request = new Request(Method.POST, new Reference("/login"));
        request.setEntity(invalidUserName(), MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == LoginResource
        response.status == Status.SUCCESS_OK
        Object mapper = new ObjectMapper()
        LoginResponse checkInLogoInResponse =
                mapper.readValue(response.getEntityAsText(), LoginResponse)
        checkInLogoInResponse.getAuthToken() == null
        checkInLogoInResponse.getMessage() == "INVALID USER NAME"
    }

    String invalidPassword() {
        return "{\"userName\":\"huma\",\"password\":\"goutamhg\"}"
    }

    String invalidUserName() {
        return "{\"userName\":\"goutams\",\"password\":\"goutam\"}"
    }

    String authenticatedUser() {
        return "{\"userName\":\"monica\",\"password\":\"monica\"}"
    }

}
