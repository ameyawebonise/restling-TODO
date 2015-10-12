package org.webonise.restlingtodo.test

import ServiceModule
import spock.lang.Specification

class ToDoApplicationTest extends Specification{
    def "greet-test"(){

        given:
            ServiceModule todoApplication = new ServiceModule()
            String greetingMessage;

        when: "Pass the greeting message and save it in greetingMessage"
            greetingMessage = todoApplication.greet("Hello")

        then: "Expect the greeting message passed to be equal to greetingMessage"
            greetingMessage == "Hello"
    }
}
