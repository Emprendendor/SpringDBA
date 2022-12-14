package com.spring.SpringBasicoCurso02.JPA.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.SpringBasicoCurso02.JDBC_DAO.ProductosDAO;
import com.spring.SpringBasicoCurso02.JPA.model.Productos;



@Repository("productosDaoJpa")
@Transactional
public class ProductosDaoJpaImpl implements ProductosDAO {
	 
	private EntityManager entityManager;
	 
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
	@Override
	public Productos encontrar (Integer id) {
		// TODO Auto-generated method stub
     
		 return entityManager.find(Productos.class, id);
	}

	
	public void actualizar(Productos product) {
	    entityManager.merge(product);
	}
	
	@Override
	public List<Productos> todos() {
		// TODO Auto-generated method stub
        String query = "from Productos";
        return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void inserta(Productos product) {
	    entityManager.persist(product);
	}
	
	@Override
	public void eliminar(Integer id) {
	    String jpql = "select p from Product p where p.id = :id";
	    Query query = entityManager.createQuery(jpql);
	    query.setParameter("id", id);
	    Productos  p = (Productos) query.getSingleResult();
	    
	    entityManager.remove(p);
	}
	@Override
	public Integer cantidad() {
	     return entityManager
	             .createQuery("select count(p) from Productos  p", Long.class)
	             .getSingleResult().intValue();
	 }
}
