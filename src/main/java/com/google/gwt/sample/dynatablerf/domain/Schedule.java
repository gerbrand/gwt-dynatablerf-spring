/*
 * Copyright 2008 Google Inc.
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
package com.google.gwt.sample.dynatablerf.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Holds the relevant data for a Schedule entity.
 * This entity does not follow the usual pattern of providing getId(), getVersion()
 * and findSchedule() methods for RequestFactory's use. 
 * {@link com.google.gwt.sample.dynatablerf.server.ScheduleLocator} handles
 * those responsibilities instead.
 */
@Entity
public class Schedule implements Serializable {
	private static final long serialVersionUID = -1058962925354763216L;

	@ElementCollection
  private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
  
	@Id
  private Integer key;
  
	@Id
  private Integer revision;

  public Schedule() {
  }

  public void addTimeSlot(TimeSlot timeSlot) {
    timeSlots.add(timeSlot);
  }

  public String getDescription(List<Boolean> daysFilter) {
    String s = null;
    ArrayList<TimeSlot> sortedSlots = new ArrayList<TimeSlot>(timeSlots);
    Collections.sort(sortedSlots);
    for (TimeSlot timeSlot : sortedSlots) {
      if (daysFilter.get(timeSlot.getDayOfWeek())) {
        if (s == null) {
          s = timeSlot.getDescription();
        } else {
          s += ", " + timeSlot.getDescription();
        }
      }
    }

    if (s != null) {
      return s;
    } else {
      return "";
    }
  }

  public Integer getKey() {
    return key;
  }

  public Integer getRevision() {
    return revision;
  }

  public List<TimeSlot> getTimeSlots() {
    return timeSlots;
  }

  public void setKey(Integer key) {
    this.key = key;
  }

  public void setRevision(Integer revision) {
    this.revision = revision;
  }

  public void setTimeSlots(List<TimeSlot> timeSlots) {
    this.timeSlots = new ArrayList<TimeSlot>(timeSlots);
  }

  @Override
  public String toString() {
    return getDescription(null);
  }

}
