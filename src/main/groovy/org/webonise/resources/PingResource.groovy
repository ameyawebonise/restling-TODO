package org.webonise.resources

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.restlet.resource.Get
import org.restlet.resource.ServerResource
import org.webonise.dao.interfaces.UserDao

@Slf4j
@CompileStatic
class PingResource  extends ServerResource{

    private String message;

    @Inject
    UserDao userDao

    @Get
    String pinged(){
        log.info("pinged")
        message = "PONG"
        return message
    }
}
