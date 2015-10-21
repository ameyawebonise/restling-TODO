package org.webonise.service.interfaces;


import org.webonise.pojos.CreateTaskRequest;
import org.webonise.pojos.TodoTaskResponse;
import org.webonise.sql.tables.pojos.Tasks;

import java.util.List;

public interface TodoTaskService {
    String deleteTodoTask(int taskId);
    TodoTaskResponse addNewTask(CreateTaskRequest createTaskRequest);
    List<Tasks> getAllTasksLists();
}
