package com.deloitte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.deloitte.bean.Person;
import com.deloitte.exception.PersonException;

@Transactional
@Repository
public class PersonDao implements IPersonDao {

	@PersistenceContext
	EntityManager entityManager;
	Logger logger = Logger.getLogger(PersonDao.class);
	
	@Override
	public int addPerson(Person Person) throws PersonException {
		System.out.println("DAO : "+Person);
		try{
		   entityManager.persist(Person);
		   logger.info("Saved Person : " + Person.getName());
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Error in inserting data "+e);
			throw new PersonException("Error in inserting data ");
		}
		return 1;
	}

	@Override
	public List<Person> getPersonList() throws PersonException {
		String sql = "SELECT list from Person list";
		try{
		TypedQuery<Person> query = entityManager.createQuery(sql, Person.class);
		   logger.info("Fetching Persons  ");
		return query.getResultList();
		}
		catch(Exception e){
			//e.printStackTrace();
			logger.error("Error in fetching data "+e);
			throw new PersonException("Error in fetching data ");
		}
	}

}
