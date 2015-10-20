package org.webonise.dao.Interfaces;


import org.webonise.sql.tables.pojos.Tasks;

public interface TodoTaskDao {
    int getTaskById(Tasks tasks);
    String deleteTaskById(int taskId);
}
