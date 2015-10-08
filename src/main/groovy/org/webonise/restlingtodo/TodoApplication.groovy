package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
@CompileStatic
class TodoApplication {
    public String greet(String message){
        return message
    }

    public static void main(String[] args) {
        String message
        TodoApplication todoApplication = new TodoApplication()
        message = todoApplication.greet("Welcome")
        log.info("{}", message)
    }
}

