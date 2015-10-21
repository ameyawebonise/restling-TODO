package org.webonise.exceptions

import org.restlet.resource.Status

@Status(value = 403)
class TaskException extends Exception{

    TaskException(String message){
        super(message)
    }
}
