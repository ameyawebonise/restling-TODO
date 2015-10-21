package org.webonise.dao.Interfaces;


import org.webonise.pojos.CreateTaskRequest;
import org.webonise.pojos.TodoTaskResponse;
import org.webonise.sql.tables.pojos.Tasks;

import java.util.List;

public interface TodoTaskDao {
    TodoTaskResponse createNewTask(CreateTaskRequest createTaskRequest);
    List<Tasks> getAllTasks();
    int getTaskById(Tasks tasks);
    String deleteTaskById(int taskId);
}
