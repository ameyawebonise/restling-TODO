package org.webonise.dao.impl

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dao.Interfaces.TodoTaskDao
import org.webonise.sql.tables.pojos.Tasks

@Slf4j
@CompileStatic
class TodoTaskDaoImpl implements TodoTaskDao {
    @Override
    int getTaskById(Tasks tasks) {
        return 0
    }

    @Override
    String deleteTaskById(int taskId) {
        return null
    }
}
