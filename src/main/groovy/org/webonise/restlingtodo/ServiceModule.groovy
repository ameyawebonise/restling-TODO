package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dataaccess.DataAccessModule
<<<<<<< HEAD
import org.webonise.service.TodoServiceModule
=======
import org.webonise.service.ServiceAccessModule
>>>>>>> 8733eeb5ce81288df30c944f4f7c274e8e19f131
import restling.guice.modules.RestlingApplicationModule

@Slf4j
@CompileStatic
class ServiceModule extends RestlingApplicationModule{

    Class<RootRouter> routerClass = RootRouter

    @Override
    void configureCustomBindings() {
        this.install(new DataAccessModule())
<<<<<<< HEAD
        this.install(new TodoServiceModule())
=======
        this.install(new ServiceAccessModule())
>>>>>>> 8733eeb5ce81288df30c944f4f7c274e8e19f131
    }

}

