package ichiran;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Ichiran
 */
@WebServlet("/Ichiran")
public class Ichiran extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Ichiran() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			/*
			 * conn = DriverManager.getConnection(url, user, password); // データベースに対する処理
			 * java.sql.Statement stmt = conn.createStatement(); 
			 */

			InitialContext ic = new InitialContext();
			DataSource ds =(DataSource) ic.lookup("java:/comp/env/jdbc/webapp");
			java.sql.Connection con = ds.getConnection();

			/*PreparedStatement st = ((java.sql.Connection) con)
					.prepareStatement("select comm_id,comm_name,sort_id,count from comm_table ");
			ResultSet rs = st.executeQuery();*/
			
			/* Statement stmt = (Statement) con.createStatement();
			  String sql = "select comm_id,comm_name,sort_id,count from comm_table ";
			  ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);*/
			  
			
			 PreparedStatement st = 
						con.prepareStatement(
								"select comm_id,comm_name,sort_id,count from comm_table "
								);
				ResultSet rs = st.executeQuery();
				

			java.util.List<String[]> list = new ArrayList<>();
			while (rs.next()) {
				String[] s = new String[4]; 
				
				s[0] = rs.getString("comm_id");
				s[1] = String.valueOf(rs.getInt("comm_name"));
				s[2] = String.valueOf(rs.getInt("sort_id"));
				s[3] = String.valueOf(rs.getInt("count"));
				
				list.add(s);
			}
			for (String[] s : list) {
				System.out.println(s[0]);
			}
			request.setAttribute("list", list);
			
		} catch (SQLException e) {
			out.println("SQLException:" + e.getMessage());
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ichiran.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
