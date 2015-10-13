package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import org.webonise.resources.Routers.PingRouter
import restling.restlet.RestlingRouter

@CompileStatic
class RootRouter extends RestlingRouter{

    @Override
    void init() {
        attachSubRouter("/pingpong", PingRouter)
    }
}
