package com.google.gwt.sample.dynatablerf.server;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gwt.sample.dynatablerf.domain.Person;
import com.google.gwt.sample.dynatablerf.domain.TimeSlot;
import com.google.gwt.sample.dynatablerf.spring.config.RootApplicationConfig;
import com.google.gwt.thirdparty.guava.common.base.Predicate;
import com.google.gwt.thirdparty.guava.common.collect.Iterables;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootApplicationConfig.class)
public class PersonServiceTest {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private SchoolCalendarService schoolCalendarService;
	
	@Test
	public void testPersist() {
		Person person = new Person();
		person.setName("Tester");
		person.setDescription("Some student");
		person.getAddress().setCity("Test");
		person.getAddress().setState("na");
		person.getAddress().setStreet("Teststreet");
		person.getAddress().setZip("33333");
		TimeSlot timeslot = new TimeSlot(3,5,22);
		person.getClassSchedule().getTimeSlots().add(timeslot);
		personService.persist(person);
		
		List<Boolean> dayfilter=new ArrayList<Boolean>();
		List<Person> people = schoolCalendarService.getPeople(0, 3, dayfilter);
		Predicate<? super Person> predicate = new Predicate<Person>() {

			@Override
			public boolean apply(Person p) {
				return p.getName().equals("Tester");
			}
		};
		assertTrue(Iterables.any(people, predicate));
	}

}
