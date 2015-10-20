package org.webonise.pojos

import groovy.transform.CompileStatic

@CompileStatic
class TodoTaskRequest {
    int taskId
    TaskStatus status
}
