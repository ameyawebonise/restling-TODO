package org.webonise.resources.Resources

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.Get

@Slf4j
@CompileStatic
class PingResource {

    @Get
    String pinged(){
        log.info("pinged")
        return "PONG"
    }
}
