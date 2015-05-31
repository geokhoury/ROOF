package jo.edu.gju.roof.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jo.edu.gju.roof.connectors.DAO;
import jo.edu.gju.roof.entities.Room;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class ListRoomsByBuildingServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		DAO dao = DAO.getDAO();
		
		String buildingID = req.getParameter("building-id");
		
		List<Room> roomList = dao.getListOfRoomsInBuilding(buildingID);
		String json = new Gson().toJson(roomList);
		
		resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	    
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doGet(req, resp);
	}
}