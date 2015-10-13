package org.webonise.routers

import org.webonise.resources.PingResource
import restling.restlet.RestlingRouter


class PingRouter extends RestlingRouter{

    @Override
    void init() throws Exception {
        attach("/ping", PingResource)
    }
}
