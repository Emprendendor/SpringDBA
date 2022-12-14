package com.spring.SpringBasicoCurso02.JDBC_DAO;

import java.util.List;

import com.spring.SpringBasicoCurso02.JDBC_Model.Product;

public interface ProductDAO {

	
	   List<Product>   todos();
	   
	   void    inserta( Product p);
}
