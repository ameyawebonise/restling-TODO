package org.webonise.service.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dao.Interfaces.TodoTaskDao
import org.webonise.pojos.CreateTaskRequest
import org.webonise.pojos.TodoTaskResponse
import org.webonise.service.interfaces.TodoTaskService
import org.webonise.sql.tables.pojos.Tasks

@Slf4j
@CompileStatic
class TodoTaskServiceImpl implements TodoTaskService {
    final TodoTaskDao todoTaskDao

    @Inject
    TodoTaskServiceImpl(TodoTaskDao todoTaskDao){
        this.todoTaskDao = todoTaskDao
    }
    @Override
    String deleteTodoTask(int taskId) {
        return null
    }

    @Override
    TodoTaskResponse addNewTask(CreateTaskRequest createTaskRequest) {
        TodoTaskResponse todoTaskResponse = new TodoTaskResponse()
        if (createTaskRequest.taskDescription.isEmpty()){
            todoTaskResponse.setMessage("Please Add a Description to the task")
            return todoTaskResponse
        }
        else{
            return todoTaskDao.createNewTask(createTaskRequest)
        }
    }

    @Override
    List<Tasks> getAllTasksLists() {
        return todoTaskDao.getAllTasks()
    }
}
