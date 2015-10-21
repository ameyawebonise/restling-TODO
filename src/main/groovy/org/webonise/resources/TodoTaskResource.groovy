package org.webonise.resources

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.Post
import org.restlet.resource.ServerResource
import org.webonise.pojos.TodoTaskRequest
import org.webonise.pojos.TaskResponse
import org.webonise.service.interfaces.TodoTaskService

@Slf4j
@CompileStatic
class TodoTaskResource extends ServerResource{

    @Inject
    TodoTaskService todoTaskService

    @Post
    TaskResponse deleteTask(TodoTaskRequest todoTaskRequest){
            return todoTaskService.deleteTodoTask(todoTaskRequest)
    }


}
