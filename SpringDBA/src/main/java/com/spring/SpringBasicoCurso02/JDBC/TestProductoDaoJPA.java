package com.spring.SpringBasicoCurso02.JDBC;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.SpringBasicoCurso02.JDBC_DAO.ProductosDAO;
import com.spring.SpringBasicoCurso02.JPA.model.Productos;

public class TestProductoDaoJPA {

	public static void main(String[] args) {
	
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);


    	 
  //  	 ((	ProductosDAO product = ctx.getBean(ProductosDAO.class);            
     for (String bean_name : ctx.getBeanDefinitionNames()) {
         System.out.println(":: " + bean_name);
     }
     
  //try {
     // obtener bean  DAO
     ProductosDAO  productimpl    = ctx.getBean("productosDaoJpa", ProductosDAO.class);
   
     
     Productos  productos2   = productimpl.encontrar(70);
  
              if ( productos2  == null) {  
            	  System.out.println("Object is Null");  
            	          } else {  
            	  System.out.println("Object is not Null" +    productos2.getName() );
                
            	          }
              
              productos2.setId( productos2.getId()  +  productimpl.cantidad()  );
                
              productimpl.inserta(productos2);
              
              
              
          	ProductosDAO product = ctx.getBean(ProductosDAO.class);
        	
            List<Productos>  productos = product.todos();
            
            
            for(int i = 0; i< productos.size(); i++)   {
           	 
           	 Productos p = productos.get(i);
           	  System.out.println(p.getId() + "nombre " + p.getName() + " precio " + p.getPr() );
            }
           	           
              
              
              
              
              
	}
}

