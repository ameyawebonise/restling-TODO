package org.webonise.resources

import spock.lang.Specification


class PingResourceTest extends Specification{

    PingResource pingResource = new PingResource();

    def "pinged method returns PONG" (){
        when: "call to a method pinged"
        def result = pingResource.pinged()

        then:"result is PONG"
        result == "PONG"
    }
}
