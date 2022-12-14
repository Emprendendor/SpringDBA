package com.spring.SpringBasicoCurso02.JPA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTOS")

public class Productos {
	
	
	    @Id
	    @Column(name = "ID")
	    private Integer id;
	    
	    public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
 
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getPr() {
			return pr;
		}

		public void setPr(Double pr) {
			this.pr = pr;
		}

		@Column(name = "NAME")
	    private String name;
	    
	    @Column(name = "PRICE")
	    private Double pr;
}
