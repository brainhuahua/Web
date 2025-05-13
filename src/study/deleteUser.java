
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import com.mysql.jdbc.Driver;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "deleteUser",urlPatterns = "/studyServer/deleteUser")
public class deleteUser extends HttpServlet{
	private Connection connection;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String  user_id;
		user_id=request.getParameter("user_id");
		if(user_id==null) user_id="";
		



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


		    sql="delete from tab_userlist where id="+user_id;

			System.out.println(sql);
			int rows= statement.executeUpdate(sql); 
			
			
			JSONObject result=new JSONObject();
			JSONObject rtn=new JSONObject();
			
			if(rows>0){
				result.put("result","OK");
			}else{
				result.put("result","Failed");	
			}		
			rtn.put("rtn",result);

			out.print(rtn.toString());
			
			
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