package jo.edu.gju.roof.entities;

import java.util.GregorianCalendar;
import java.util.HashMap;

import jo.edu.gju.roof.connectors.DAO;
import jo.edu.gju.roof.enumurations.TimeBlock;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Schedule {

	@Id
	private Long id;
	private HashMap <String, String> map;
	@Ignore private GregorianCalendar cal = new GregorianCalendar();
	@Index private long roomId;
	@SuppressWarnings("unused")
	private String time = cal.toString();
	@Ignore private final String FREE = "FREE";
	@Ignore private DAO dao = DAO.getDAO();
	
	public Schedule() {

	}

	public Schedule(long roomId) {
		this.roomId = roomId;
		createAndInitalizeMap();
		
	}
	
	public void createAndInitalizeMap(){
		map = new HashMap<String, String>();
		setMapToDefaultState();
	}
	
	public void setMapToDefaultState(){
		map.put(TimeBlock.TimeBlock0.getTimeValue(), FREE);
		map.put(TimeBlock.TimeBlock1.getTimeValue(), FREE);
		map.put(TimeBlock.TimeBlock2.getTimeValue(), FREE);
		map.put(TimeBlock.TimeBlock3.getTimeValue(), FREE);
		map.put(TimeBlock.TimeBlock4.getTimeValue(), FREE);
		map.put(TimeBlock.TimeBlock5.getTimeValue(), FREE);
		map.put(TimeBlock.TimeBlock6.getTimeValue(), FREE);
		map.put(TimeBlock.TimeBlock7.getTimeValue(), FREE);
		map.put(TimeBlock.TimeBlock8.getTimeValue(), FREE);
	}
	
	public GregorianCalendar getCalendar(){
		return cal;
	}

	public void setCalendar(GregorianCalendar cal) {
		this.cal = cal;
	}

	public void setNewTimeBlockValue(TimeBlock timeBlock, String s){
		System.out.println(timeBlock.getTimeValue() + " " + s);
		map.put(timeBlock.getTimeValue(), s);
	}
	
	public void setFreeTimeBlock(TimeBlock timeBlock){
		map.put(timeBlock.getTimeValue(), FREE);
	}
	
	public String getTimeBlockValue(TimeBlock timeBlock){
		return map.get(timeBlock.getTimeValue());
	}

	public Long getId() {
		return id;
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMap(HashMap<String, String > map) {
		this.map = map;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

}
