package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import restling.guice.modules.RestlingApplicationModule

@Slf4j
@CompileStatic
class ServiceModule extends RestlingApplicationModule{

    Class<RootRouter> routerClass = RootRouter

    @Override
    void configureCustomBindings() {

    }

}

