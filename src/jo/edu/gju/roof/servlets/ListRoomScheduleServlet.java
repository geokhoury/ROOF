package jo.edu.gju.roof.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jo.edu.gju.roof.StaticSchedule;
import jo.edu.gju.roof.connectors.DAO;
import jo.edu.gju.roof.entities.Room;
import jo.edu.gju.roof.entities.Schedule;
import jo.edu.gju.roof.enumurations.TimeBlock;
import jo.edu.gju.roof.handlers.Compare;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class ListRoomScheduleServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		DAO dao = DAO.getDAO();
		
		// JSON objects
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject o;
		
		// Getting the room Id.
		String roomId = req.getParameter("room-id");
		
		// Getting the room itself.
		Room r = dao.getRoomById(Long.valueOf(roomId));
		
		if(r == null){
			System.out.println("failed to get room or room doesn't exist");
			return;
		}
		
		String reservationDay = req.getParameter("day");
		String reservationMonth = req.getParameter("month");
		String reservationYear = req.getParameter("year");
		
		GregorianCalendar cal = new GregorianCalendar();
		if(reservationDay != "" && reservationMonth != "" && reservationYear != ""){
			cal.set(Integer.valueOf(reservationYear), Integer.valueOf(reservationMonth) ,Integer.valueOf(reservationDay));
		}
		
		// Getting the dynamic schedule associated to the room.
		Schedule schedule = dao.getScheduleByRoomId(Long.valueOf(roomId));
		
		if(schedule == null){
			System.out.println("Failed to get schedule or no schedule for room " + r.getRoomBuilding() + r.getRoomNumber());
			System.out.println("Creating new schedule and adding it to the datastore");
			schedule = new Schedule(Long.valueOf(roomId));
			dao.addAndUpdateSchedule(schedule);
		} else {
			System.out.println("Resetting schedule to suit " + cal.getTime());
			Compare.compareScheduleToCurrentDayAndResetValues(schedule, cal);
		}
		
		// Getting the static schedule of the current day.
		StaticSchedule staticS = r.getStaticScheduleOfDay(cal.get(Calendar.DAY_OF_WEEK));
		
		// Parsing data to JSON.
		
		try {
			json.put("scheduleId", schedule.getId().toString());
			for(TimeBlock tb: TimeBlock.values()){
				
				// Don't parse the all-day time block.
				if(tb.equals(TimeBlock.TimeBlockFull)){
					break;
				}
				
				o = new JSONObject();
				String staticVal = staticS.getTimeBlockValue(tb);
				String sVal = schedule.getTimeBlockValue(tb);
				o.put("timeBlock", tb.toString());
				
				if( staticVal.equals("FREE") ){
					o.put("reservation", sVal);
				} else{
					o.put("reservation", staticVal);
				}
				jsonArray.put(o);
			}
			json.put("timeBlocks",jsonArray);
		} catch (JSONException e) {
			System.out.println("JSONException");
		}
		
		// Sending the data back to the client.
		resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json.toString());
	    
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doGet(req, resp);
	}
}