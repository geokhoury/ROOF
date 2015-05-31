package jo.edu.gju.roof.enumurations;

public enum TimeBlock {
	TimeBlock0	  ("06:30"     	, "08:00"   , "0"),
	TimeBlock1 	  ("08:00"     	, "09:30"   , "1"), 
	TimeBlock2    ("09:30"     	, "11:00"  	, "2"),
	TimeBlock3    ("11:00"    	, "12:30"	, "3"),
	TimeBlock4    ("12:30"    	, "14:00"   , "4"),
	TimeBlock5    ("14:00"     	, "15:30"   , "5"),
	TimeBlock6    ("15:30"     	, "17:00"   , "6"),
	TimeBlock7    ("17:00"     	, "18:30"   , "7"),
	TimeBlock8    ("18:30"  	, "20:00"   , "8"),
	TimeBlockFull ("All Day"  	, "All Day" , "9");


	private String timeValue;
	private String start;
	private String end;


	TimeBlock (String start, String end, String timeValue ){
	this.start = start;
	this.end = end;
	this.timeValue = timeValue;
	}

	public String getTimeValue (){
		return timeValue;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}
	
	public String toString(){
		return start + " - " + end;
	}
	
	static public TimeBlock getTimeBlockByTimeValue(String timeValue){
		for(TimeBlock tb: TimeBlock.values()){
			if(tb.getTimeValue().equals(timeValue)){
				return tb;
			}
		}
		return null;
	}
	
}