package com.spring.SpringBasicoCurso02.JDBC_DAO;
import com.spring.SpringBasicoCurso02.JPA.model.Productos;
import java.util.List;
 

	public interface ProductosDAO {

		
		   List<Productos>   todos();
		   
		   void    inserta( Productos  p);

		Productos encontrar(Integer i);

		void eliminar(Integer id);

		Integer cantidad();
	}

	
	
 