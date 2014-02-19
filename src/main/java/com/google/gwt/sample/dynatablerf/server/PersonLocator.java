package com.google.gwt.sample.dynatablerf.server;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.sample.dynatablerf.domain.Person;

@Component
@Transactional
public class PersonLocator extends JpaEntityLocator<Person, Long> {

	public PersonLocator() {
		super(Person.class, Long.class);
	}

	@Override
	public Long getId(Person entity) {
		return entity.getId();
	}

	@Override
	public Object getVersion(Person domainObject) {
		return domainObject.getVersion();
	}

}
