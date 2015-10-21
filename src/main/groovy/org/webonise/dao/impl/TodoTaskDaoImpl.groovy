package org.webonise.dao.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext
import org.jooq.Record1
import org.webonise.dao.Interfaces.TodoTaskDao
import org.webonise.dataaccess.DSLContextProvider
import org.webonise.exceptions.TaskException
import org.webonise.pojos.TodoTaskRequest
import org.webonise.sql.tables.pojos.Users

import static org.webonise.sql.tables.Tasks.TASKS

@Slf4j
@CompileStatic
class TodoTaskDaoImpl implements TodoTaskDao {

    DSLContextProvider dslContextProvider
    DSLContext dslContext

    @Inject
    TodoTaskDaoImpl(DSLContextProvider dslContextProvider, DSLContext dslContext) {
        this.dslContext = dslContext
        this.dslContextProvider = dslContextProvider
    }

    @Override
    void deleteTaskById(TodoTaskRequest todoTaskRequest) {
        dslContext = dslContextProvider.get()

        Record1<Users> task = dslContext.selectFrom(TASKS)
                .where(TASKS.TASK_ID.eq(todoTaskRequest.getTaskId()))
                .fetchOne() as Record1<Users>
        if(!task){
            throw new TaskException("INVALID")
        }else {
            dslContext.delete(TASKS).where(TASKS.TASK_ID.eq(todoTaskRequest.getTaskId())).execute()
        }

    }


}
