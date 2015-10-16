package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dataaccess.DataAccessModule
import org.webonise.service.ServiceAccessModule
import restling.guice.modules.RestlingApplicationModule

@Slf4j
@CompileStatic
class ServiceModule extends RestlingApplicationModule{

    Class<RootRouter> routerClass = RootRouter

    @Override
    void configureCustomBindings() {
        this.install(new DataAccessModule())
        this.install(new ServiceAccessModule())
    }

}

