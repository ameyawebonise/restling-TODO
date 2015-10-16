package org.webonise.resources

import com.fasterxml.jackson.databind.ObjectMapper
import org.webonise.pojos.SignupRequest
import org.webonise.pojos.SignupResponse
import spock.lang.Specification

class UserResourceSpec extends Specification{

    def userResource = new UserResource()

    SignupRequest request = new SignupRequest()

    def "method call to doSignUp User"(){
        when: "doSignUp method is called"
        def jsonString
        then: "Success message should be returned"
        ObjectMapper mapper = new ObjectMapper()
        SignupResponse signupResponse = mapper.readValue(jsonString,SignupResponse)
        assert  signupResponse : "SignUp Successful"
    }

}
