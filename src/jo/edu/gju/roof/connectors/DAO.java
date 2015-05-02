package jo.edu.gju.roof.connectors;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

import jo.edu.gju.roof.entities.*;

import com.googlecode.objectify.*;

public class DAO extends Object {

	private static final DAO instance = new DAO();

	private DAO() {
	}

	static {
		ObjectifyService.begin();
		ObjectifyService.register(Room.class);
	}

	public static DAO getDAO() {
		return instance;
	}
	
	public void addAndUpdateRoom(Room room) {
		ofy().save().entity(room).now();
	}
	
	public Room getRoomById(long id) {
		return ofy().load().type(Room.class).id(new Long(id)).now();
	}

	public List<Room> getListOfRooms() {
		return ofy().load().type(Room.class).list();
	}

}