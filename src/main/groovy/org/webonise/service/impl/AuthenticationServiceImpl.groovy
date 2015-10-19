package org.webonise.service.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.webonise.dao.RedisDao
import org.webonise.pojos.AuthenticationData
import org.webonise.service.interfaces.AuthenticationService

@Slf4j
@CompileStatic
class AuthenticationServiceImpl implements AuthenticationService {


    @Inject
    RedisDao redisDao
    @Inject
    ObjectMapper objectMapper

    @Override
    void addAuthenticatedUser(String authToken, AuthenticationData authenticationData) {
        redisDao.add(authToken, getObjectMapper().writeValueAsString(authenticationData));
    }

}
