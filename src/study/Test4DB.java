package study;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

import java.sql.*;

@WebServlet(name = "Test4DB",urlPatterns = "/studyServer/Test4DB")
public class Test4DB extends HttpServlet {
	private Connection connection;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();



		String driverName="com.mysql.jdbc.Driver";
		
		String userName="csu";
		String userPasswd="Csu@88876525";
		
		String dbName="demo";
		
		String url="jdbc:mysql://localhost:3306/"+dbName+"?user="+userName+"&password="+userPasswd;

		String tableName="tab_user";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection=DriverManager.getConnection(url);		
	        int  userid=-1;
	        String sql="";
	      
			Statement statement = connection.createStatement();


			try {
		    	userid = Integer.parseInt(request.getParameter("userid"));
		    } catch (NumberFormatException e) {
		    	userid=-1;
		        e.printStackTrace();
		    }

			if (userid>0){
				sql="SELECT * FROM tab_user where userid="+userid;
			}else{
				sql="SELECT * FROM tab_user";
			}
			
			ResultSet rs = statement.executeQuery(sql); 

			ResultSetMetaData rmeta = rs.getMetaData();

			int numColumns=rmeta.getColumnCount();


			out.print("id"); 

			out.print("|");

			out.print("num");

			out.print("<br>");


			while(rs.next()) {

				out.print(rs.getString(1)+" "); 

				out.print("|");

				out.print(rs.getString(2));

				out.print("<br>"); 

			} 

			out.print("<br>");
			
			rs.close(); 

			statement.close(); 

			out.close();	
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

	}
	public String getServletInfo(){
		return "MyFirstServlet";
	}
	
}