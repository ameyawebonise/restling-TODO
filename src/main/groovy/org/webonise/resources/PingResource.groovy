package org.webonise.resources

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.Get

@Slf4j
@CompileStatic
class PingResource {

    private String message;
    @Get
    String pinged(){
        log.info("pinged")
        message = "PONG"
        return message
    }
}
