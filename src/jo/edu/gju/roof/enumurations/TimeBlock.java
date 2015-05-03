package jo.edu.gju.roof.enumurations;

public enum TimeBlock {
	TimeBlockFree ("Free"  , "Free"  , 0),
	TimeBlock1 	  ("8:00"  , "9:30"  , 1), 
	TimeBlock2    ("9:30"  , "11:00" , 2),
	TimeBlock3    ("11:00" , "12:30" , 3),
	TimeBlock4    ("12:00" , "2:00"  , 4),
	TimeBlock5    ("2:00"  , "3:30"  , 5),
	TimeBlock6    ("3:30"  , "5:00"  , 6),
	TimeBlock7    ("5:00"  , "6:30"  , 7),
	TimeBlock8    ("6:30"  , "8:00"  , 8),
	TimeBlockFull ("Full"  , "Full"  , 9);


	private int timeValue;
	private String start;
	private String end;


	TimeBlock (String start, String end, int timeValue ){
	this.start = start;
	this.end = end;
	this.timeValue = timeValue;
	}

	public int getTimeValue (){
		return timeValue;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}
	
}