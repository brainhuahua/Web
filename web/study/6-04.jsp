<%@ page language="java"  contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>login</title>
</head>
<body>
<%
String userName=request.getParameter("userName");
if(userName!=null){
	if(userName.equals("guest"))
	     response.sendRedirect("http://www.csu.edu.cn");
    else
	    response.sendRedirect("http://vlab.csu.edu.cn");
}
%>
<table border="0" width="300" height="60" background="#FFFF00">
<form action="6-04.jsp" method="GET">
<tr>
 <td width="100%" height="53">用户名：<input type=text name=userName /> </td> 
</tr>
<tr>
 <td width="100%" height="53">密码：<input type=password name=userName /> </td> 
</tr>
<tr>
 <td width="100%" height="53"><input type="submit" value=登录 /> </td> 
</tr>
</form>

</table>
</body>
</html>