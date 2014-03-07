/*
 * Copyright 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.sample.dynatablerf.server;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.sample.dynatablerf.domain.TimeSlot;

/**
 * Service object for Schedule entities, used to demonstrate the use of non-static
 * service objects with RequestFactory. Unlike the original version of the
 * DynaTableRf, no ScheduleServiceLocator is needed. The Service class only
 * has to be made available via Spring.
 *
 * @author Gerbrand van Dieijen <gerbrand@vandieijen.nl>
 */
@Component
@Transactional
public class ScheduleService {

  public TimeSlot createTimeSlot(int zeroBasedDayOfWeek, int startMinutes, int endMinutes) {
    return new TimeSlot(zeroBasedDayOfWeek, startMinutes, endMinutes);
  }
  
}
