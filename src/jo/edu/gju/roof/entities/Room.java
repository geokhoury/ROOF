package jo.edu.gju.roof.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import jo.edu.gju.roof.enumurations.*;

@Entity
public class Room {

	@Id
	private Long Id;
	private String roomNumber;
	private String roomBuilding;
	private RoomType roomType;
	
	public Room(){
		
	}
	
	public Room(String roomNumber, String roomBuilding, RoomType roomType){
		
		this.roomBuilding = roomBuilding;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomBuilding() {
		return roomBuilding;
	}

	public void setRoomBuilding(String roomBuilding) {
		this.roomBuilding = roomBuilding;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
}
