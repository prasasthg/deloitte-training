package com.deloitte.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.bean.Person;
import com.deloitte.dao.IPersonDao;
import com.deloitte.exception.PersonException;

@Transactional
@Service
public class PersonServiceImpl implements IPersonService{

	@Autowired
	IPersonDao PersonDao;
	
	@Override
	public int addPerson(Person Person) throws PersonException {
		//System.out.println("addPerson : " + Person);
		return PersonDao.addPerson(Person);
	}

	@Override
	public List<Person> getPersonList() throws PersonException {
		//System.out.println("getPersonList");
		return PersonDao.getPersonList();
	}

}
