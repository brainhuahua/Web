<%@ page language="java"  contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>次数</title>
</head>

<body>
<%int accessCount=0;%>
<table border="0" width="100%" height="60" background="#FFFF00">
<tr>
 <td width="20%" height="53">主机名：<%=request.getRemoteHost()%></td>
 <td width="20%" height="53">访问次数：<%=++accessCount%></td>
 <td width="60%" height="53">当前时间：<%=new Date()%></td>
</tr>
</table>
</body>
</html>