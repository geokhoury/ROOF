package jo.edu.gju.roof.entities;

//import com.googlecode.objectify.annotation.Container;
import java.util.Calendar;

import jo.edu.gju.roof.StaticSchedule;
import jo.edu.gju.roof.enumurations.RoomType;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Room {

	@Id
	private Long Id;
	private String roomNumber;
	private String roomBuilding;
	private RoomType roomType;
	
	private StaticSchedule saturdayStaticSchedule;
	private StaticSchedule sundayStaticSchedule;
	private StaticSchedule mondayStaticSchedule;
	private StaticSchedule tuesdayStaticSchedule;
	private StaticSchedule wednesdayStaticSchedule;
	private StaticSchedule thursdayStaticSchedule;
	private StaticSchedule fridayStaticSchedule;
	
	public Room(){
		
	}
	
	public Room(String roomNumber, String roomBuilding, RoomType roomType){
		this.roomBuilding = roomBuilding;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		createAndInitialiseStaticSchedules();
	}
	public void createAndInitialiseStaticSchedules(){
		saturdayStaticSchedule = new StaticSchedule(Calendar.SATURDAY);
		sundayStaticSchedule = new StaticSchedule(Calendar.SUNDAY);
		mondayStaticSchedule = new StaticSchedule(Calendar.MONDAY);
		tuesdayStaticSchedule = new StaticSchedule(Calendar.TUESDAY);
		wednesdayStaticSchedule = new StaticSchedule(Calendar.WEDNESDAY);
		thursdayStaticSchedule = new StaticSchedule(Calendar.THURSDAY);
		fridayStaticSchedule = new StaticSchedule(Calendar.FRIDAY);
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
	
	public StaticSchedule getStaticScheduleOfDay(int day){
		switch(day){
			case Calendar.SATURDAY:
				
				return saturdayStaticSchedule;
				
			case Calendar.SUNDAY:
				
				return sundayStaticSchedule;
				
			case Calendar.MONDAY:
				
				return mondayStaticSchedule;
				
			case Calendar.TUESDAY:
				
				return tuesdayStaticSchedule;
				
			case Calendar.WEDNESDAY:
				
				return wednesdayStaticSchedule;
				
			case Calendar.THURSDAY:
				
				return thursdayStaticSchedule;
			default:
				
				return fridayStaticSchedule;
		}
	}

	public StaticSchedule getSaturdayStaticSchedule() {
		return saturdayStaticSchedule;
	}

	public StaticSchedule getSundayStaticSchedule() {
		return sundayStaticSchedule;
	}

	public StaticSchedule getMondayStaticSchedule() {
		return mondayStaticSchedule;
	}

	public StaticSchedule getTuesdayStaticSchedule() {
		return tuesdayStaticSchedule;
	}

	public StaticSchedule getWednesdayStaticSchedule() {
		return wednesdayStaticSchedule;
	}

	public StaticSchedule getThursdayStaticSchedule() {
		return thursdayStaticSchedule;
	}
	
	public StaticSchedule getFridayStaticSchedule() {
		return fridayStaticSchedule;
	}

}
