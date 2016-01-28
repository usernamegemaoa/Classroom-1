package model;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;


/**
 * Servlet implementation class DownloadHw
 */
@WebServlet("/DownloadHw")
public class DownloadHw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadHw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    List<Homework> list = new ArrayList<Homework>();

		try {

			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/test");
			Connection con = ds.getConnection();
			Statement s = con.createStatement();
			ResultSet rsRep = s.executeQuery("SELECT * FROM library.homeworks ");
			HomeworkDescriptor hwDesc = new HomeworkDescriptor();
			hwDesc.generateData(rsRep);
			list = hwDesc.getHomeworks();
			con.close();
			rsRep.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	    String json = new Gson().toJson(list);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
		response.setHeader("Content-Disposition", "attachment; filename=\"homeworks.json\"");
	}


}
