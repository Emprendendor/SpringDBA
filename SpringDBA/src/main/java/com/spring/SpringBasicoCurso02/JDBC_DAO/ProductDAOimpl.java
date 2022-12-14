package com.spring.SpringBasicoCurso02.JDBC_DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.SpringBasicoCurso02.JDBC_Model.Product;
/**
 * DAOimplementacion
 * Anotacion @repository
 * @author ProductDAOimpl
 *
 */
@Repository
public class ProductDAOimpl implements ProductDAO {
   private DataSource dataSource;
	
	  
   @Autowired
   public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
  	 
	 @Override
	    public List<Product> todos() {

	        List<Product> products = new ArrayList<>();
	        Connection conn = null;

	        try {
	            conn = dataSource.getConnection();
	            
	            Statement stmt = conn.createStatement();
	            ResultSet rs =   stmt.executeQuery("select * from  autor" );

	            while(rs.next()) {
	                Product p = new Product();
	                p.setIdautor(rs.getInt("IDAUTOR"));
	                p.setNombre(rs.getString("NOMBRE"));
	                p.setApellidos(rs.getString("APELLIDOS"));

	                products.add(p);
	 //               System.out.println( p.toString());
	            }
	            /*
	             * Pendientee de cierrre
	             */
	            rs.close();
	            stmt.close();
	            
	            
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                }
	            }
	        }

	        return products;
	    }
	    
	 public void inserta(Product p) {
       //  p.setIdautor(rs.getInt("IDAUTOR"));
		//   p.setNombre(rs.getString("NOMBRE"));
		//   p.setApellidos(rs.getString("APELLIDOS"));

		 
		 String consultaSQL = "insert into  autor (idautor, nombre, apellidos) values ";
		 consultaSQL += "('" + p.getIdautor() + "','" + p.getNombre() + "','" + p.getApellidos() + "')";

		 //4
	//     filas = sentencia.executeUpdate(consultaSQL);
 
		 System.out.println("Saltar a listado");
		 
	        Connection conn = null;

	        try {
	            conn = dataSource.getConnection();
	            
	            Statement stmt = conn.createStatement();
	            
	            stmt.executeUpdate(consultaSQL );

	          
	            
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                }
	            }
	        }

	       
	    }
	    
	 
	 
	 
		 

}
