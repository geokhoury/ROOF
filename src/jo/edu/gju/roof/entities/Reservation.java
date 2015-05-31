package jo.edu.gju.roof.entities;

import java.util.Calendar;
import java.util.GregorianCalendar;

import jo.edu.gju.roof.StaticSchedule;
import jo.edu.gju.roof.connectors.DAO;
import jo.edu.gju.roof.enumurations.TimeBlock;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Reservation {

	@Id
	private Long id;
	private String description;
	@SuppressWarnings("unused") private String reservedBy;
	private TimeBlock timeBlock;
	@Ignore private Calendar currentTime = Calendar.getInstance();
	@SuppressWarnings("unused") private String timeStamp;
	@Index private long reservedRoomId;
	private Ref<Schedule> reservedRoomSchedule;
	@Ignore private GregorianCalendar reservationDate = new GregorianCalendar();// TODO: Implement reservationDate
	
	@Index private String reservationDateString;
	@Ignore private final String FREE = "FREE";

	public Reservation() {

	}

	// Ignore user for now
	public Reservation(long roomId, long userId, Schedule reservedRoomSchedule, String description, TimeBlock timeSlot, GregorianCalendar newReservationDate) {
		reservedRoomId = roomId;
		setReservedRoomSchedule(reservedRoomSchedule);
		reservedBy = "NONE";
		this.description = description;
		this.timeBlock = timeSlot;
		timeStamp = currentTime.toString();
		setReservedDate(newReservationDate);
		System.out.println(reservationDate.getTime());
		reservationDateString = reservationDate.get(Calendar.DAY_OF_MONTH) + " - " + reservationDate.get(Calendar.MONTH) + " - " + reservationDate.get(Calendar.YEAR);
		reserveRoomAtTimeBlock();
		
	}
	
	public void setReservedDate(GregorianCalendar newCal){
		int year = newCal.get(Calendar.YEAR);
		int month = newCal.get(Calendar.MONTH);
		int date = newCal.get(Calendar.DAY_OF_MONTH);
		reservationDate.set(year, month, date);
	}

	public Schedule getReservedRoomSchedule(){
		return reservedRoomSchedule.get();
	}
	
	public void setReservedRoomSchedule(Schedule s){
		this.reservedRoomSchedule = Ref.create(s);
	}
	
	public void reserveRoomAtTimeBlock(){
		DAO dao = DAO.getDAO();
		Schedule reservedSchedule  = getReservedRoomSchedule();
		StaticSchedule s = dao.getRoomById(reservedRoomId).getStaticScheduleOfDay(reservationDate.get(Calendar.DAY_OF_WEEK));
		if(s != null && reservationDate.compareTo(reservedSchedule.getCalendar()) == 0){
			System.out.println("tryinh to reserve!");
			String staticScheduleValue = s.getTimeBlockValue(timeBlock);
			if(staticScheduleValue.equals("FREE") && reservedSchedule.getTimeBlockValue(timeBlock).equals("FREE")){
				
				reservedSchedule.setNewTimeBlockValue(timeBlock, description);
			}
			
			dao.addAndUpdateSchedule(reservedSchedule);	
		}
	}
	
	public TimeBlock getTimeBlock() {
		return timeBlock;
	}
	
	public String getDescription() {
		return description;
	}

	public Calendar getReservationDate() {
		return reservationDate;
	}
}
