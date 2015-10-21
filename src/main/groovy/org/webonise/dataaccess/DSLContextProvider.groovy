package org.webonise.dataaccess

import com.google.inject.Provider
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.DSLContext
import org.jooq.impl.DSL

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

@Slf4j
@CompileStatic
class DSLContextProvider implements Provider<DSLContext>{

    private static final String USER_NAME = 'root'
    private static final String PASSWORD = 'root'
    private static final String URL = "jdbc:mysql://localhost:3306/todo_task"

    DSLContext get(){
        DSLContext dslContext
        try{
            Connection connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD)
            dslContext = DSL.using(connection)
        } catch (SQLException sqlException){
            log.info(sqlException.getMessage())
        }
        return dslContext
    }

}
