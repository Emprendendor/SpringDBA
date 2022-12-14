package com.spring.SpringBasicoCurso02.SpringDBA;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.SpringBasicoCurso02.JDBC.SpringConfiguration;

public class PruebaDataSource {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDataSource() {
		Boolean r1 ; 
    	AbstractApplicationContext ctx =
  		      new AnnotationConfigApplicationContext(SpringConfiguration.class);
  	//Olas
    	 System.out.println( "testDataSource  +   point01 "); 
    	try { 
  			DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
  	
  			Connection connection = dataSource.getConnection();
  			  r1  = connection.isValid(0);
  			 assertTrue( r1);
  			
  		}catch(SQLException e ) {
  			 System.out.println( "testDataSource  +  Exception " + e.getMessage()  ); 
  			assertTrue( false );
  		}	
  		
    	assertTrue( false );
  		 
  		 System.out.println( "testDataSource  +   point02 "); 
	}

}
