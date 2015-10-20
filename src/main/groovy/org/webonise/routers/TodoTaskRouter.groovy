package org.webonise.routers

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.resources.TodoTaskResource
import restling.restlet.RestlingRouter

@Slf4j
@CompileStatic
class TodoTaskRouter extends RestlingRouter {
    @Override
    void init() throws Exception {
        attach("/tasks", TodoTaskResource)
    }
}
