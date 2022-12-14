package com.spring.SpringBasicoCurso02.JDBC;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement; 

@Configuration
@ComponentScan(basePackages = "com.spring.SpringBasicoCurso02.JPA")
@EnableTransactionManagement


public class SpringConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
      //  dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");    
    //  dataSource.setUrl("jdbc:mysql://localhost:3306/negocio?autoReconnect=true&useSSL=false");
        dataSource.setUrl("jdbc:mysql://localhost:3306/negocio?serverTimezone=UTC");
       //   dataSource.setUrl(" ");

        dataSource.setUsername("root");
       dataSource.setPassword("point2020");
   
     //    dataSource.setPassword("dsdse");
        
        return dataSource;
    //    jdbc:mysql://localhost:3306/negocio?autoReconnect=true&useSSL=false
    }
    /**
    Configurar Hibernate JPA
    Para acceder a la base de datos JPA utiliza la interface EntityManager, esta puede ser creada de varias maneras, en este tutorial usaremos la clase LocalContainerEntityManagerFactoryBean otra opción, por ejemplo, sería crearla a partir de JDNI para ello usaríamos JndiObjectFactoryBean.

    Para finalizar debemos crear un bean de tipo JpaVendorAdapter que nos sirve para definir cual es el proveedor que utilizaremos, nosotros estamos usando Hibernate por lo que creamos este bean con la clase HibernateJpaVendorAdapter para otros proveedores tenemos las correspondientes clases: EclipseLinkJpaVendorAdapter y OpenJpaVendorAdapter.
    
    */
    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        
    	LocalContainerEntityManagerFactoryBean factoryBean
                = new LocalContainerEntityManagerFactoryBean();
        
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setPackagesToScan("com.spring.SpringBasicoCurso02.JPA.model");
        factoryBean.setPersistenceUnitName("pun-hibernate-jpa");
        
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.format_sql", "true");
        props.put("hibernate.use_sql_comments", "true");
        props.put("hibernate.hbm2ddl.auto", "validate");
    //   props.put("hibernate.hbm2ddl.auto", "create-drop");
        
        factoryBean.setJpaPropertyMap(props);
        
        return factoryBean;
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        return jpaVendorAdapter;
    }
    
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}