package org.webonise.routers

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.resources.LoginResource
import restling.restlet.RestlingRouter

@Slf4j
@CompileStatic
class LoginRouter extends RestlingRouter {
    @Override
    void init() throws Exception {
        attach("/login",LoginResource)
    }
}
