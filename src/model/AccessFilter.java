package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebFilter("/UploadHw")
public class AccessFilter implements Filter {
	private ServletContext servletCtxt;

	public AccessFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String currentUserName = ((HttpServletRequest) request).getRemoteUser();
		Context ctx;
		try {
			ctx = new InitialContext();

		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/test");
		Connection con = ds.getConnection();
		if (canAddHw(ds, currentUserName, con)) {

			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendError(403, "Missing permissions");
		}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		servletCtxt = fConfig.getServletContext();
	}
	

		
		public Boolean canAddHw(DataSource ds, String userName, Connection con) {
			Boolean result = false;
			String query = "SELECT role_name FROM library.user_roles WHERE user_name=?";// TODO: *
			
			try (PreparedStatement stat = con.prepareStatement(query, ResultSet.TYPE_FORWARD_ONLY,
							ResultSet.CONCUR_READ_ONLY);) {
				stat.setString(1, userName);
				ResultSet rs = stat.executeQuery();
				if (rs.next()) {
					String roleStr = rs.getString("role_name");
					if (roleStr.equals("tomcat"))
						return true;
					

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
			return result;
		}
		
	

}
