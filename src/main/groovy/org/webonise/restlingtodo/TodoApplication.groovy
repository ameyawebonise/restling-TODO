package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import restling.guice.modules.RestlingApplicationModule
import restling.restlet.RestlingRouter

@Slf4j
@CompileStatic
class TodoApplication extends RestlingApplicationModule{

    Class<SimpleRouter> routerClass = SimpleRouter
    public String greet(String message){
        return message
    }

    @Override
    void configureCustomBindings() {

    }

}

