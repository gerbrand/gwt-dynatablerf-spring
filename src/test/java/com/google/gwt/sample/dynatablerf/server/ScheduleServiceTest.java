package com.google.gwt.sample.dynatablerf.server;

import static org.junit.Assert.*;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gwt.sample.dynatablerf.domain.TimeSlot;
import com.google.gwt.sample.dynatablerf.server.spring.RootApplicationConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootApplicationConfig.class)
public class ScheduleServiceTest {

	@Autowired
	private ScheduleService scheduleService;
	@Test
	public void testCreateTimeSlot() {
		TimeSlot result = scheduleService.createTimeSlot(0, 3, 23);
		assertEquals(0, result.getDayOfWeek());
		assertEquals(23, result.getEndMinutes());
	}

}
