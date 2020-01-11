package com.deloitte.dao;

import java.util.List;

import com.deloitte.bean.Person;
import com.deloitte.exception.PersonException;

public interface IPersonDao {

	int addPerson(Person Person) throws PersonException;

	List<Person> getPersonList() throws PersonException;

}
