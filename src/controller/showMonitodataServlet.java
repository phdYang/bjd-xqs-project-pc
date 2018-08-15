package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MonitorDataService;

/**
 * Servlet implementation class showMonitodataServlet
 */
@WebServlet("/showMonitodataServlet")
public class showMonitodataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showMonitodataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        System.out.println(1);
        int sensorId = Integer.parseInt(request.getParameter("sensorId"));
        String starDate = request.getParameter("starDate");
        String endDate = request.getParameter("endDate");
        System.out.println(sensorId+","+starDate+","+endDate);
        String json_data = new MonitorDataService().getMonitorDataVo(starDate, endDate, sensorId);
        System.out.println(json_data);
        response.getWriter().write(json_data);
	}

}
