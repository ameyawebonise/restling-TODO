package org.webonise.restlingtodo.test

import org.webonise.restlingtodo.TodoApplication
import spock.lang.Specification

class TodoApplicationTest extends Specification{
    def "greet-test"(){
        given:
            TodoApplication todoApplication = new TodoApplication()
            String greetingMessage;

        when: "Pass the greeting message and save it in greetingMessage"
            greetingMessage = todoApplication.greet("Hello")

        then: "Expect the greeting message passed to be equal to greetingMessage"
            greetingMessage == "Hello"

    }
}
