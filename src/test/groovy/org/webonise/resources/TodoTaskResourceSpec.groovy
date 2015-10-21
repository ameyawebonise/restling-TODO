package org.webonise.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Log
import org.restlet.Request
import org.restlet.Response
import org.restlet.data.MediaType
import org.restlet.data.Method
import org.restlet.data.Reference
import org.restlet.data.Status
import org.webonise.pojos.TodoTaskResponse
import org.webonise.restlingtodo.RoutingSpec
import org.webonise.restlingtodo.ServiceModule
import org.webonise.routers.TodoTaskRouter
import spock.lang.Shared
import spock.lang.Specification

@Log
class TodoTaskResourceSpec extends Specification implements RoutingSpec {

    @Shared
    Injector injector
    TodoTaskRouter fixture

    def setupSpec(){
        injector = Guice.createInjector(new ServiceModule())
    }

    def setup(){
        def context =  new org.restlet.Context(log)
        fixture = injector.getInstance(TodoTaskRouter)
        fixture.context = context
        fixture.init()
        fixture.start()
    }

    def teardown(){
        fixture.stop()
    }

    def "Create Task with Valid task Description"(){
        when:"POST /newtask"
        def restlet = retrieveRoute(Method.POST,"/newtask")
        Request request = new Request(Method.POST, new Reference("/newtask"))
        request.setEntity(validTaskDesc(),MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then:
        restlet!= null
        restlet.targetClass == TodoTaskResource
        response.status == Status.SUCCESS_OK
        ObjectMapper objectMapper = new ObjectMapper()
        TodoTaskResponse todoTaskResponse = objectMapper.readValue(response.getEntityAsText(),TodoTaskResponse)
        todoTaskResponse.getMessage() == "Task Successfully Added"
    }

    def "Task Not created if task description is null"(){
        when :"POST /newtask"
        def restlet = retrieveRoute(Method.POST,"/newtask")
        Request request = new Request(Method.POST,new Reference("/newtask"))
        request.setEntity(taskDescNull(),MediaType.APPLICATION_JSON)
        Response response = restlet.handle(request)
        then :
        restlet!= null
        restlet.targetClass == TodoTaskResource
        response.status == Status.SUCCESS_OK
        ObjectMapper mapper = new ObjectMapper()
        TodoTaskResponse taskResponse = mapper.readValue(response.getEntityAsText(),TodoTaskResponse)
        taskResponse.getMessage() == "Please Add a Description to the task"
    }
    String validTaskDesc(){
        return "{\"taskDescription\":\"New Task\"}"
    }
    String taskDescNull(){
        return "{\"taskDescription\":\"\"}"
    }
}
