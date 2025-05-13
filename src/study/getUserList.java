
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import com.mysql.jdbc.Driver;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "getUserList",urlPatterns = "/studyServer/getUserList")
public class getUserList extends HttpServlet{
	private Connection connection;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();



		String driverName="com.mysql.jdbc.Driver";
		
		String userName="csu";
		String userPasswd="Csu@88876525";
		System.out.println(userPasswd);
		
		String dbName="demo";
		
		String url="jdbc:mysql://localhost:3306/"+dbName+"?user="+userName+"&password="+userPasswd;

		String tableName="tab_userlist";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection=DriverManager.getConnection(url);		
	         String sql="";
	      
			Statement statement = connection.createStatement();


		    sql="SELECT id,login_name,username,department,last_login_ip FROM tab_userlist ";
			
			ResultSet rs = statement.executeQuery(sql); 
			ResultSetMetaData rmeta = rs.getMetaData();
			int numColumns=rmeta.getColumnCount();
  
			JSONObject userList=new JSONObject();
			JSONObject userInfo=new JSONObject();
			JSONArray  userArray=new JSONArray();

			while(rs.next()) {
				userInfo.put("id",rs.getInt("id"));
				userInfo.put("login_name",rs.getString("login_name"));
				userInfo.put("username",rs.getString("username"));
				userInfo.put("department",rs.getString("department"));
				userInfo.put("last_login_ip",rs.getString("last_login_ip"));
				userArray.put(userInfo);
			} 
			userList.put("userList",userArray);

			out.print(userList.toString());
			
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