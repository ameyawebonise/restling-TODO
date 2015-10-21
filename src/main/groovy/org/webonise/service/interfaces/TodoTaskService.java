package org.webonise.service.interfaces;


import org.webonise.pojos.TaskResponse;
import org.webonise.pojos.TodoTaskRequest;

public interface TodoTaskService {
    TaskResponse deleteTodoTask(TodoTaskRequest todoTaskRequest);
}
