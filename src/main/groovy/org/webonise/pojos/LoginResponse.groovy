package org.webonise.pojos

import groovy.transform.Canonical
import groovy.transform.CompileStatic

@Canonical
@CompileStatic
class LoginResponse {
    String message
    String authToken
}
