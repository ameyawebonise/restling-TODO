package org.webonise.resources

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.ServerResource
import org.webonise.pojos.CreateTaskRequest
import org.webonise.pojos.TodoTaskResponse
import org.webonise.service.interfaces.TodoTaskService
import org.webonise.sql.tables.pojos.Tasks

@Slf4j
@CompileStatic
class TodoTaskResource extends ServerResource{
    final TodoTaskService todoTaskService

    @Inject
    TodoTaskResource(TodoTaskService todoTaskService){
        this.todoTaskService = todoTaskService
    }

    @Post
    TodoTaskResponse doCreateTask(CreateTaskRequest createTaskRequest){
        return todoTaskService.addNewTask(createTaskRequest)
    }

    @Get
    List<Tasks> getTasksList(){
        return todoTaskService.getAllTasksLists()
    }
}
