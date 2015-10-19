package org.webonise.routers

import org.webonise.resources.UserResource
import restling.restlet.RestlingRouter

class UserRouter extends RestlingRouter{
    @Override
    void init() throws Exception {
        attach("/signup",UserResource)
    }
}
