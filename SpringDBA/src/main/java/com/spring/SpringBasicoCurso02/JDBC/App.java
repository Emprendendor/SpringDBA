package com.spring.SpringBasicoCurso02.JDBC;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  throws SQLException 
    {
    	AbstractApplicationContext ctx =
    		      new AnnotationConfigApplicationContext(SpringConfiguration.class);
    	
    		
    			DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
    
    			Connection connection = dataSource.getConnection();
    			System.out.println(connection.isValid(0));
    		
    	 
    		//	  System.out.println("Could not shut down embedded database"  + ex.getMessage()
    		 
    					 
    	 
    		
    	ctx.close();
    		
    }		
    		
    		
    	
}
