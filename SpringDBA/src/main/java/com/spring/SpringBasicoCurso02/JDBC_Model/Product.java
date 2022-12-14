package com.spring.SpringBasicoCurso02.JDBC_Model;

public class Product {
	private   Integer  idautor ;
	private   String  nombre ;
	private  String  apellidos ;
	
	
    public Product () {
    	
    	  this.idautor = null;
    	  this.nombre = null;
    	  this.apellidos = null;
    }

	public Integer getIdautor() {
		return idautor;
	}
	public void setIdautor(Integer idautor) {
		this.idautor = idautor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
 
	@Override
	public String toString() {
		return "Product [idautor=" + idautor + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
	
	
	
}
