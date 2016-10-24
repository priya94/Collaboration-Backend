package com.niit.collaborationwebsite.DAO;

import java.util.List;


import com.niit.collaborationwebsite.model.Event;

public interface EventDAO {

	public boolean saveEvent(Event event);

	public boolean updateEvent(Event event);

	void deleteEvent(String Id);

	Event getEvent(String Id);

	List<Event> listEvent();

}
