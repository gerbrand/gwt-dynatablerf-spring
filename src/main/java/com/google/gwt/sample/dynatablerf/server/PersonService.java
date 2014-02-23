package com.google.gwt.sample.dynatablerf.server;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.sample.dynatablerf.domain.Person;

@Component
@Transactional
public class PersonService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void persist(Person person) {
		entityManager.persist(person);
	}
}
