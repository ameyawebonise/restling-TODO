package org.webonise.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Log
import org.jooq.DSLContext
import org.restlet.Request
import org.restlet.Response
import org.restlet.data.MediaType
import org.restlet.data.Method
import org.restlet.data.Reference
import org.restlet.data.Status
import org.webonise.dataaccess.DSLContextProvider
import org.webonise.pojos.TaskResponse
import org.webonise.restlingtodo.RoutingSpec
import org.webonise.restlingtodo.ServiceModule
import org.webonise.routers.TodoTaskRouter
import spock.lang.Shared
import spock.lang.Specification
import static org.webonise.sql.tables.Tasks.TASKS


@Log
class TodoTaskResourceSpec extends Specification implements RoutingSpec {

    @Shared
    Injector injector
    TodoTaskRouter fixture
    @Shared
    DSLContext  dslContext
    @Shared
    DSLContextProvider dslContextProvider

    def setupSpec() {
        injector = Guice.createInjector(new ServiceModule())
        dslContext = injector.getInstance(DSLContext)
        dslContextProvider = injector.getInstance(DSLContextProvider)
        dslContext = dslContextProvider.get()
        dslContext.insertInto(TASKS,TASKS.TASK_ID,TASKS.TASK_NAME,TASKS.IS_DONE).values(1,"reading",1).execute()
    }


    def setup() {
        def context = new org.restlet.Context(log)
        fixture = injector.getInstance(TodoTaskRouter)
        fixture.context = context
        fixture.init()
        fixture.start()
    }

    def teardown() {
        fixture.stop()
    }


     def "delete task"() {
         when: "POST /deletetask"
         def restlet = retrieveRoute(Method.POST, "/deletetask")
         Request request = new Request(Method.POST, new Reference("/deletetask"));
         request.setEntity(deleteTask(), MediaType.APPLICATION_JSON)
         Response response = restlet.handle(request)
         then:
         restlet != null
         restlet.targetClass == TodoTaskResource
         response.status == Status.SUCCESS_OK
         Object mapper = new ObjectMapper()
         TaskResponse todoTaskResponse =
                 mapper.readValue(response.getEntityAsText(), TaskResponse)
         todoTaskResponse != null
         todoTaskResponse.getMessage() == "SUCCESS"
     }

    def "try to delete invalid task"() {
        when: "POST /deletetask"
        def restlet = retrieveRoute(Method.POST, "/deletetask")
        Request request = new Request(Method.POST, new Reference("/deletetask"));
        request.setEntity(deleteInvalidTask(), MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet != null
        restlet.targetClass == TodoTaskResource
        response.status == Status.SUCCESS_OK
        Object mapper = new ObjectMapper()
        TaskResponse todoTaskResponse =
                mapper.readValue(response.getEntityAsText(), TaskResponse)
        todoTaskResponse != null
        todoTaskResponse.getMessage() == "INVALID"
    }


    String deleteTask() {
        return "{\"taskId\":1,\"status\":1}"
    }

    String deleteInvalidTask() {
        return "{\"taskId\":-11,\"status\":1}"
    }
}

