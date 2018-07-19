/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdp.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author DELL
 */
public class DBUtils implements Serializable{
    public static Connection getMyConnection() throws SQLException, NamingException{
       Context context = new InitialContext();
       Context tomcatCxt = (Context)context.lookup("java:comp/env");
       DataSource ds = (DataSource)tomcatCxt.lookup("DataSource");
       Connection con = ds.getConnection();
       return con;
    }
}
