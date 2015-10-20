package org.webonise.service.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dao.Interfaces.TodoTaskDao
import org.webonise.exceptions.TaskException
import org.webonise.pojos.TodoTaskRequest
import org.webonise.pojos.TaskResponse
import org.webonise.service.interfaces.TodoTaskService

@Slf4j
@CompileStatic
class TodoTaskServiceImpl implements TodoTaskService {


    @Inject
    TodoTaskDao todoTaskDao

    @Override
    TaskResponse deleteTodoTask(TodoTaskRequest todoTaskRequest) {
        try {
            todoTaskDao.deleteTaskById(todoTaskRequest)
            return  new TaskResponse("SUCCESS")
        } catch (TaskException ex) {
            return new TaskResponse(ex.getMessage())
        }
    }
}
