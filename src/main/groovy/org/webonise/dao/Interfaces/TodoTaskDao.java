package org.webonise.dao.Interfaces;


import org.webonise.pojos.TodoTaskRequest;

public interface TodoTaskDao {
    void deleteTaskById(TodoTaskRequest todoTaskRequest);
}
