package jo.edu.gju.roof;

import java.util.HashMap;

import jo.edu.gju.roof.enumurations.TimeBlock;

public class StaticSchedule {
	
	private int day;
	private final String FREE = "FREE";
	private HashMap <String, String> schedule;
	
	public StaticSchedule(){
		
	}
	
	public StaticSchedule(int day){
		
		this.day = day;
		createAndInitialiseStaticSchedule();
		
	}
	
	public void createAndInitialiseStaticSchedule(){
		schedule = new HashMap<String, String>();
		schedule.put(TimeBlock.TimeBlock0.getTimeValue(), FREE);
		schedule.put(TimeBlock.TimeBlock1.getTimeValue(), FREE);
		schedule.put(TimeBlock.TimeBlock2.getTimeValue(), FREE);
		schedule.put(TimeBlock.TimeBlock3.getTimeValue(), FREE);
		schedule.put(TimeBlock.TimeBlock4.getTimeValue(), FREE);
		schedule.put(TimeBlock.TimeBlock5.getTimeValue(), FREE);
		schedule.put(TimeBlock.TimeBlock6.getTimeValue(), FREE);
		schedule.put(TimeBlock.TimeBlock7.getTimeValue(), FREE);
		schedule.put(TimeBlock.TimeBlock8.getTimeValue(), FREE);
	}
	
	public void setNewTimeBlockValue(TimeBlock timeBlock, String s){
		schedule.put(timeBlock.getTimeValue(), s);
	}
	
	public void setFreeTimeBlockValue(TimeBlock timeBlock){
		schedule.put(timeBlock.getTimeValue(), FREE);
	}
	
	public String getTimeBlockValue(TimeBlock timeBlock){
		return schedule.get(timeBlock.getTimeValue());
	}
	
	public int getDay() {
		return day;
	}

	public HashMap<String, String> getSchedule() {
		return schedule;
	}

}
