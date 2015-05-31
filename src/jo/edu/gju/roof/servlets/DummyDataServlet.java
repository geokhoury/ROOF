package jo.edu.gju.roof.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jo.edu.gju.roof.connectors.DAO;
import jo.edu.gju.roof.entities.Room;
import jo.edu.gju.roof.entities.Schedule;
import jo.edu.gju.roof.enumurations.RoomType;
import jo.edu.gju.roof.enumurations.TimeBlock;

@SuppressWarnings("serial")
public class DummyDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Room c201 = new Room("201", "C", RoomType.Classroom);
		Room c227 = new Room("227", "C", RoomType.Lab);
		Room c105 = new Room("105", "C", RoomType.Auditourim);
		Room b223 = new Room("223", "B", RoomType.Classroom);
		Room b407 = new Room("407", "B", RoomType.Classroom);
		Room b312 = new Room("312", "B", RoomType.Classroom);
		b312.getFridayStaticSchedule().setNewTimeBlockValue(TimeBlock.TimeBlock2, "Computer Graphics");
		c227.getFridayStaticSchedule().setNewTimeBlockValue(TimeBlock.TimeBlock4, "Object Oriented Programming");
		c201.getFridayStaticSchedule().setNewTimeBlockValue(TimeBlock.TimeBlock2, "Discrete Structures");
		
		DAO dao = DAO.getDAO();
		
		dao.addAndUpdateRoom(c201);
		dao.addAndUpdateRoom(c227);
		dao.addAndUpdateRoom(c105);
		dao.addAndUpdateRoom(b223);
		dao.addAndUpdateRoom(b407);
		dao.addAndUpdateRoom(b312);
		
		Schedule c201Schedule = new Schedule (c201.getId());		
		Schedule c227Schedule = new Schedule (c227.getId());
		Schedule c105Schedule = new Schedule (c105.getId());
		Schedule b223Schedule = new Schedule (b223.getId());
		
		dao.addAndUpdateSchedule(b223Schedule);
		dao.addAndUpdateSchedule(c105Schedule);
		dao.addAndUpdateSchedule(c227Schedule);
		dao.addAndUpdateSchedule(c201Schedule);
//		
		System.out.println("Dummy data generated.");

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}