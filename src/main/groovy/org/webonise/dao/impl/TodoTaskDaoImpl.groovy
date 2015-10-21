package org.webonise.dao.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext
import org.webonise.dao.Interfaces.TodoTaskDao
import org.webonise.dataaccess.DSLContextProvider
import org.webonise.pojos.CreateTaskRequest
import org.webonise.pojos.TodoTaskResponse
import org.webonise.sql.tables.pojos.Tasks

import static org.webonise.sql.tables.Tasks.TASKS

@Slf4j
@CompileStatic
class TodoTaskDaoImpl implements TodoTaskDao {

    DSLContextProvider dslContextProvider
    DSLContext dslContext

    @Inject
    UserDaoImpl(DSLContextProvider dslContextProvider, DSLContext dslContext) {
        this.dslContext = dslContext
        this.dslContextProvider = dslContextProvider
    }

    @Override
    TodoTaskResponse createNewTask(CreateTaskRequest createTaskRequest){
        TodoTaskResponse todoTaskResponse = new TodoTaskResponse()
        dslContext = dslContextProvider.get()
        if (dslContext.insertInto(TASKS,TASKS.TASK_NAME,TASKS.IS_DONE).values(createTaskRequest.getTaskDescription(), false).execute()){

            todoTaskResponse.setMessage("Task Successfully Added")
        }
        else{
            todoTaskResponse.setMessage("Task Not Created")
        }
        return todoTaskResponse
    }

    @Override
    List<Tasks> getAllTasks() {
        dslContext = dslContextProvider.get()
        def tasks = dslContext.select().from(TASKS)
                .fetch()
        if(!tasks){
            Collections.emptyList()
        }
        List<Tasks> tasksList = tasks.into(Tasks)
        return tasksList
    }

    @Override
    int getTaskById(Tasks tasks) {
        return 0
    }

    @Override
    String deleteTaskById(int taskId) {
        return null
    }
}
