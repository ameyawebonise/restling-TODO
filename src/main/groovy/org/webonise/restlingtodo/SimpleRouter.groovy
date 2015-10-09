package org.webonise.restlingtodo

import com.google.inject.Inject
import groovy.transform.CompileStatic
import org.restlet.Context
import restling.restlet.RestlingRouter

@CompileStatic
class SimpleRouter extends RestlingRouter{

    @Inject
    SimpleRouter(Context context){
        super(context)
    }
    @Override
    void init() {}
}
