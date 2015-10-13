package org.webonise.resources

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.Get
import org.restlet.resource.ServerResource

@Slf4j
@CompileStatic
class PingResource extends ServerResource {

    private String message;
    @Get
    String pinged(){
        log.info("pinged")
        message = "PONG"
        return message
    }
}
