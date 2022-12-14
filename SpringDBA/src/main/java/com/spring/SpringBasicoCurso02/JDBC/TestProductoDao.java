package com.spring.SpringBasicoCurso02.JDBC;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.SpringBasicoCurso02.JDBC_DAO.ProductDAO;
import com.spring.SpringBasicoCurso02.JDBC_DAO.ProductDAOimpl;
import com.spring.SpringBasicoCurso02.JDBC_Model.Product;

 

public class TestProductoDao {
	
	
	
	public static void main(String[] args) {
		
	
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);

	ProductDAO product = ctx.getBean(ProductDAO.class);
	
     List<Product>  productos = product.todos();
     
     
     for(int i = 0; i< productos.size(); i++)
         System.out.println(productos.get(i).toString());  //se invoca el método toString de la clase Coche                  
	
    Product p = new Product();
    p.setIdautor(1);
    p.setNombre("NOMBRE");
    p.setApellidos("APELLIDOS");

    product.inserta(p);
    
	}
}
	