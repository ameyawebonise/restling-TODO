package org.webonise.resources

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.ServerResource
import org.webonise.service.interfaces.TodoTaskService

@Slf4j
@CompileStatic
class TodoTaskResource extends ServerResource{

    @Inject
    TodoTaskService todoTaskService


}
