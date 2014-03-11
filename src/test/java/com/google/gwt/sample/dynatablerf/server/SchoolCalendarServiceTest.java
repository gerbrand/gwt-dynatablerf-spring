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
import com.google.gwt.sample.dynatablerf.spring.config.RootApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootApplicationConfig.class)
public class SchoolCalendarServiceTest {

	@Autowired
	private SchoolCalendarService schoolCalendarService;
	@Test
	public void testGetPeople() {
		List<Boolean> dayFilter=new ArrayList<Boolean>();
		List<Person> result = schoolCalendarService.getPeople(0, 3, dayFilter);
		assertNotNull(result);
	}

}
