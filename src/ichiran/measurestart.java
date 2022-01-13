package ichiran;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class measurestart 
 */
@WebServlet("/measurestart")
public class measurestart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public measurestart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		
		//ボタンを押してaaaをもってくる
		String keisoku = request.getParameter("s[2]");
		// aaaに何か入っていたらOK
		if (keisoku != null) {
			// 日付表示
			out.println("Today is " + DateFormat.getDateInstance().format(new Date()));
			keisoku = DateFormat.getDateInstance().format(new Date());
			//後はこれをSQL文にぶち込む
			out.close();
		}
		
		java.sql.Connection conn = null;
		String url = "jdbc:mysql://192.168.54.194:3306/icemint";
		String user = "webapp";
		String password = "webapp";

		try{
		  conn = DriverManager.getConnection(url, user, password);

		  // データベースに対する処理
		  java.sql.Statement stmt = conn.createStatement();
		  String sql = "update meas_time set measure_start = keisoku where comm_id = s[2] and user_id='?' ";
		  int num = stmt.executeUpdate(sql);
		  
		}catch (SQLException e){
			out.println("SQLException:" + e.getMessage());
		}finally{
		  try{
		    if (conn != null){
		      conn.close();
		    }
		  }catch (SQLException e){
			  out.println("SQLException:" + e.getMessage());
		  }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
