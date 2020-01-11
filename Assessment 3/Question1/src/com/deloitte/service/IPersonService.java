package com.deloitte.service;

import java.util.List;

import com.deloitte.bean.Person;
import com.deloitte.exception.PersonException;

public interface IPersonService {


	int addPerson(Person Person) throws PersonException;

	List<Person> getPersonList() throws PersonException;
}
