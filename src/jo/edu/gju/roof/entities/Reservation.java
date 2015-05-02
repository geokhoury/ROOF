package jo.edu.gju.roof.entities;

import java.util.Date;

import jo.edu.gju.roof.connectors.DAO;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Reservation {

	@Id
	private Long id;
	private String description;
	private String reservedBy;
	private int timeSlot;
	private Date timestamp = new Date();
	private Room reservedRoom;

	private DAO dao = DAO.getDAO();
	
	public Reservation() {

	}

	public Reservation(long roomId, long userId, String description, int timeSlot) {
		Room currentRoom = dao.getRoomById(roomId);
		
	}
}
