import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//データベース追加用サーブレット　

@WebServlet("/tuika")

public class Tuika extends HttpServlet {
	
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
		) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup(
					"java:/comp/env/jdbc/webapp");
			Connection con = ds.getConnection();
			String name = request.getParameter("name");
			String comm = request.getParameter("comm");
			String count = request.getParameter("count");
			
			
			PreparedStatement st = con.prepareStatement(
					"insert into comm_table values(null,1,?,?,?,?)");
			
			if(comm.equals("niti")) {
				st.setInt(1,  1);	
			}else {
				st.setInt(1,  2);	
			}
			st.setString(2,  name);
			st.setInt(3, 1);
			st.setString(4,count);
			
			
			
			int line = st.executeUpdate();
			
			if (line > 0) {
				
				out.println("追加しました。");
			}
			
			st.close();
			con.close();
			} catch (Exception e) {
				out.println("<pre>");
				e.printStackTrace(out);
			}
	}
	
}