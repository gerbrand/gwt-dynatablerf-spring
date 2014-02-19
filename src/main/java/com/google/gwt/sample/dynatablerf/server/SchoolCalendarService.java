package com.google.gwt.sample.dynatablerf.server;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.sample.dynatablerf.domain.Person;

@Component
@Transactional
public class SchoolCalendarService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Person> getPeople(int startIndex, int maxCount, List<Boolean> dayFilter) {
		TypedQuery<Person> q = entityManager.createQuery("SELECT p FROM Person p WHERE ORDER BY p.name", Person.class);
		q.setFirstResult(startIndex);
		q.setMaxResults(maxCount);
		return q.getResultList();
	}

	public Person getRandomPerson() {
		return new Person();
	}
}
