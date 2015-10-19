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
        when: "POST /user"
        def restlet = retrieveRoute(Method.POST, "/user")
        Request request = new Request(Method.POST, new Reference("/user"));
        request.setEntity(authenticatedUser(), MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == LoginResource
        response.status == Status.SUCCESS_OK
        Object mapper = new ObjectMapper()
        LoginResponse checkInLogoInResponse =
                mapper.readValue(response.getEntityAsText(), LoginResponse)
        checkInLogoInResponse.getMessage() == "SUCCESS"
    }


    def "Login with invalid password"() {
        when: "POST /user"
        def restlet = retrieveRoute(Method.POST, "/user")
        Request request = new Request(Method.POST, new Reference("/user"));
        request.setEntity(invalidPassword(), MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == LoginResource
        response.status == Status.SUCCESS_OK
        Object mapper = new ObjectMapper()
        LoginResponse checkInLogoInResponse =
                mapper.readValue(response.getEntityAsText(), LoginResponse)
        checkInLogoInResponse.getMessage() == "INVALID PASSWORD"
    }

    def "Login with invalid user name"() {
        when: "POST /user"
        def restlet = retrieveRoute(Method.POST, "/user")
        Request request = new Request(Method.POST, new Reference("/user"));
        request.setEntity(invalidUserName(), MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == LoginResource
        response.status == Status.SUCCESS_OK
        Object mapper = new ObjectMapper()
        LoginResponse checkInLogoInResponse =
                mapper.readValue(response.getEntityAsText(), LoginResponse)
        checkInLogoInResponse.getMessage() == "INVALID USER NAME"
    }

    String invalidPassword() {
        return "{\"userName\":\"goutam\",\"password\":\"goutamhg\"}"
    }

    String invalidUserName() {
        return "{\"userName\":\"goutams\",\"password\":\"goutam\"}"
    }

    String authenticatedUser() {
        return "{\"userName\":\"goutam\",\"password\":\"goutam\"}"
    }

}
