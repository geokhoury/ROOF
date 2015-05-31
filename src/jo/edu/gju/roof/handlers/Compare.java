package jo.edu.gju.roof.handlers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import jo.edu.gju.roof.connectors.DAO;
import jo.edu.gju.roof.entities.*;

public class Compare {
	
	public static void compareScheduleToCurrentDayAndResetValues(Schedule s, GregorianCalendar newCal){
		
		if(s == null || newCal == null) return;
		
		DAO dao = DAO.getDAO();
		
		GregorianCalendar sCal = s.getCalendar();
		
		if(sCal == null) return;
		
		if(sCal.compareTo(newCal) != 0){
			
			s.setCalendar(newCal);
			s.setMapToDefaultState();
			
			int day = newCal.get(Calendar.DAY_OF_MONTH);
			int month = newCal.get(Calendar.MONTH);
			int year = newCal.get(Calendar.YEAR);
			
			List<Reservation> reservations = dao.getListOfReservationsAtSpecificDateByRoomId(s.getRoomId(), day, month, year);
			
			if (reservations.isEmpty()) {
				return;
			}
			
			
			Iterator<Reservation> r = reservations.iterator();
			while(r.hasNext()){
				Reservation o = r.next();
				s.setNewTimeBlockValue(o.getTimeBlock(), o.getDescription());
			}
			
		}
		
	}
	
}
