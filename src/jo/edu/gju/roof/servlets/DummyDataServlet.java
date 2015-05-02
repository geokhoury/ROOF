package jo.edu.gju.roof.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import jo.edu.gju.roof.connectors.DAO;
import jo.edu.gju.roof.entities.Room;
import jo.edu.gju.roof.enumurations.RoomType;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;

@SuppressWarnings("serial")
public class DummyDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Room c201 = new Room("201", "C", RoomType.Classroom);
		Room c227 = new Room("227", "C", RoomType.Lab);
		Room c105 = new Room("105", "C", RoomType.Auditourim);
		Room c223 = new Room("223", "C", RoomType.Classroom);
		
		DAO dao = DAO.getDAO();
		
		dao.addAndUpdateRoom(c201);
		dao.addAndUpdateRoom(c227);
		dao.addAndUpdateRoom(c105);
		dao.addAndUpdateRoom(c223);
		
		System.out.println("Dummy data generated.");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}