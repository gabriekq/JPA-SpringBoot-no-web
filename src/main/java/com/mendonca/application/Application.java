package com.mendonca.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.provider.HibernateUtils;

import com.mendonca.conf.JPAConfiguration;
import com.mendonca.model.Pessoa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;


@SpringBootApplication
@ComponentScan(basePackageClasses = {JPAConfiguration.class})
@EntityScan("com.mendonca.model")
@Transactional
public class Application   implements CommandLineRunner {

	@PersistenceContext
	private	EntityManager entityManager;
	
	public void run(String... args) throws Exception {

		 Pessoa pessoa = new Pessoa();
		 pessoa.setIdPessoa(1);
		 pessoa.setNome("Gabriel Mendonca");
		
		 Pessoa pessoa2 = new Pessoa();
		 pessoa2.setIdPessoa(2);
		 pessoa2.setNome("Angela Mendonca");
		 
		 entityManager.persist(pessoa2);
		 entityManager.persist(pessoa);
		// Criteria
		 
		 try{
		  
		  CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		  CriteriaQuery<Pessoa>	createQuery = builder.createQuery(Pessoa.class);
		  Root<Pessoa> root = createQuery.from(Pessoa.class);
		  createQuery.select(root);
		  
		Query<Pessoa> query = (Query<Pessoa>) entityManager.createQuery(createQuery);
		List<Pessoa> empList = query.list();
		System.out.println("Nunber of rows: "+empList.size());
		 }catch(HibernateException e){
			 e.printStackTrace();
		 }
		
		 
		 
         System.out.println("END OF EXECUTION");
		
	}
	
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		

	}

	

}
