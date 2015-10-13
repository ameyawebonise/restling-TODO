package org.webonise.resources.Routers

import org.webonise.resources.Resources.PingResource
import restling.restlet.RestlingRouter


class PingRouter extends RestlingRouter{

    @Override
    void init() throws Exception {
        attach("/ping", PingResource)
    }
}
