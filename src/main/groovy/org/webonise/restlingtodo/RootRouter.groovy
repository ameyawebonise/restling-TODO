package org.webonise.restlingtodo

import com.google.inject.Inject
import groovy.transform.CompileStatic
import org.restlet.Context
import restling.restlet.RestlingRouter

@CompileStatic
class RootRouter extends RestlingRouter{

    @Inject
    RootRouter(Context context){
        super(context)
    }
    @Override
    void init() {}
}
