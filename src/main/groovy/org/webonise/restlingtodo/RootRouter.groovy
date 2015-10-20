package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import org.webonise.routers.LoginRouter
import org.webonise.routers.PingRouter
import org.webonise.routers.UserRouter
import restling.restlet.RestlingRouter

@CompileStatic
class RootRouter extends RestlingRouter{

    @Override
    void init() {
        attachSubRouter("/pingpong", PingRouter)
<<<<<<< HEAD
        attachSubRouter("/user", LoginRouter)
=======
        attachSubRouter("/user",UserRouter)
>>>>>>> 8733eeb5ce81288df30c944f4f7c274e8e19f131
    }
}
