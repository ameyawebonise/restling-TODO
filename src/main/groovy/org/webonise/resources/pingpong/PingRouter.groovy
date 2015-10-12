package org.webonise.resources.pingpong

import com.google.inject.Inject
import org.restlet.Context
import restling.restlet.RestlingRouter


class PingRouter extends RestlingRouter{

    @Override
    void init() throws Exception {
        attach("/ping", PingResource)
    }
}
