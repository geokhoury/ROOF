package jo.edu.gju.roof.connectors;

//import static com.googlecode.objectify.ObjectifyService.ofy;
import static jo.edu.gju.roof.OfyService.OfyService.ofy;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import jo.edu.gju.roof.entities.*;

public class DAO extends Object {

	private static final DAO instance = new DAO();

	private DAO() {
	
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
	
	public List<Room> getListOfRoomsInBuilding(String building){
		List<Room> roomList =  ofy().load().type(Room.class).list();
		
		Iterator<Room> it = roomList.iterator();
		while (it.hasNext()) {
		    Room r = it.next();
		    if (!r.getRoomBuilding().equals(building)) {
		        it.remove();
		    }
		}
		
		return roomList;
	}
	
	public void addAndUpdateSchedule(Schedule schedule) {
		ofy().save().entity(schedule).now();
	}
	
	public Schedule getScheduleById(long id) {
		return ofy().load().type(Schedule.class).id(new Long(id)).now();
	}
	
	public List<Schedule> getListOfSchedulesByRoomId(Long roomId){
		return ofy().load().type(Schedule.class).filter("roomId", Long.valueOf(roomId)).list();
	}
	
	public Schedule getScheduleByRoomId(Long roomId){
		return ofy().load().type(Schedule.class).filter("roomId", Long.valueOf(roomId)).first().now();
	}
	
	public Schedule getScheduleOfCurrentDayByRoomId(Long roomId){
		List<Schedule> scheduleList = getListOfSchedulesByRoomId(roomId);
		Calendar cal = Calendar.getInstance();
		for(Schedule s : scheduleList){
			if(cal.compareTo(s.getCalendar())==0){
				return s;
			}
		}
		return null;
	}
	
	public Schedule getScheduleOfSpecificDayByRoomId(Long roomId, Calendar cal){
		List<Schedule> scheduleList = getListOfSchedulesByRoomId(roomId);
		for(Schedule s : scheduleList){
			if(cal.compareTo(s.getCalendar())==0){
				return s;
			}
		}
		return null;
	}
	
	public List<Schedule> getListOfSchedules() {
		return ofy().load().type(Schedule.class).list();
	}
	
	public void addAndUpdateReservation(Reservation reservation) {
		ofy().save().entity(reservation).now();
	}
	
	public Reservation getReservationById(long id) {
		return ofy().load().type(Reservation.class).id(new Long(id)).now();
	}

	public List<Reservation> getListOfReservation() {
		return ofy().load().type(Reservation.class).list();
	}
	
	public List<Reservation> getListOfReservationByRoomId(Long roomId) {
		return ofy().load().type(Reservation.class).filter("reservedRoomId", roomId).list();
	}
	
	public List<Reservation> getListOfReservationsAtSpecificDateByRoomId(Long roomId, int day, int month, int year){
		String date = day + " - " + month + " - " + year;
		return ofy().load().type(Reservation.class).filter("reservedRoomId", roomId).filter("reservationDateString", date).list();
	
	}

}