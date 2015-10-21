package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import org.webonise.routers.LoginRouter
import org.webonise.routers.PingRouter
import org.webonise.routers.TodoTaskRouter
import restling.restlet.RestlingRouter

@CompileStatic
class RootRouter extends RestlingRouter{

    @Override
    void init() {
        attachSubRouter("/pingpong", PingRouter)
        attachSubRouter("/user", LoginRouter)
        attachSubRouter("/tasks",TodoTaskRouter)
    }
}
