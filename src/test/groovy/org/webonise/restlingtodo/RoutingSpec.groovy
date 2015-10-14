package org.webonise.restlingtodo

import groovy.transform.CompileStatic
import org.restlet.Request
import org.restlet.Response
import org.restlet.Restlet
import org.restlet.data.Reference
import org.restlet.routing.Router
import org.restlet.data.Method
import org.restlet.routing.TemplateRoute

@CompileStatic
trait RoutingSpec {

    abstract Router getFixture();

    Restlet retrieveRoute(Method method, String path) {
        def request = new Request(method, new Reference(path))
        def response = new Response(request)
        Restlet nextRestlet = fixture.getNext(request, response)
        if (nextRestlet instanceof TemplateRoute) {
            nextRestlet = ((TemplateRoute) nextRestlet).getNext()
        }
        return nextRestlet
    }
}

