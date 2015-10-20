package org.webonise.pojos

import groovy.transform.Canonical
import groovy.transform.CompileStatic

@Canonical
@CompileStatic
class TodoTaskResponse {
    int taskId
    String taskDesc
    TaskStatus status
}
