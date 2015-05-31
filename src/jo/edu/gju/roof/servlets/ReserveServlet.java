package jo.edu.gju.roof.servlets;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jo.edu.gju.roof.connectors.DAO;
import jo.edu.gju.roof.entities.Reservation;
import jo.edu.gju.roof.entities.Schedule;
import jo.edu.gju.roof.enumurations.TimeBlock;

@SuppressWarnings("serial")
public class ReserveServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		DAO dao = DAO.getDAO();
		
		Long scheduleId = Long.valueOf(req.getParameter("schedule-id"));
		
		Long roomId = Long.valueOf(req.getParameter("room-id"));
		
		String tb = req.getParameter("time-block");
		Integer t = Integer.valueOf(tb) - 1;
		TimeBlock timeBlock = TimeBlock.getTimeBlockByTimeValue(t.toString());
		
		String reservationDescription = req.getParameter("reservation-title");
		
		String reservationDay = req.getParameter("day");
		
		String reservationMonth = req.getParameter("month");
		
		String reservationYear = req.getParameter("year");
		
		System.out.println(reservationDay + " " + reservationDescription + " "+ reservationMonth + " " + reservationYear);
		GregorianCalendar cal = new GregorianCalendar(); 
		if(reservationDay != "" && reservationMonth != "" && reservationYear != ""){
			cal.set(Integer.valueOf(reservationYear), Integer.valueOf(reservationMonth), Integer.valueOf(reservationDay));
		}
		
		System.out.println("Creating rR");
		
		Schedule s = dao.getScheduleById(scheduleId);
		
		Reservation reservation = new Reservation (roomId, 0, s, reservationDescription, timeBlock, cal);
		dao.addAndUpdateReservation(reservation);
	    
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doGet(req, resp);
	}
}