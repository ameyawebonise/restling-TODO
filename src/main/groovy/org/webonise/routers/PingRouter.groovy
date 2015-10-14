package org.webonise.routers


import groovy.transform.CompileStatic
import org.webonise.resources.PingResource
import restling.restlet.RestlingRouter

@CompileStatic
class PingRouter extends RestlingRouter{

    @Override
    void init() throws Exception {
        attach("/ping", PingResource)
    }
}
