<html>
<head>
   <meta charset="UTF-8">
</head>
<html>
<%@ page language="java"  contentType="text/html;charset=UTF-8" %>
<%
   java.util.Date date=new java.util.Date();
   String date_cn ="";
   String dateStr ="";
   switch(date.getDay()){
		case 1:date_cn ="星期一"; break;
		case 2:date_cn ="星期二"; break;
		case 3:date_cn ="星期三"; break;
		case 4:date_cn ="星期四"; break;
		case 5:date_cn ="星期五"; break;
		case 6:date_cn ="星期六"; break;
		case 0:date_cn ="星期日"; break;
	}
   dateStr = (1900+date.getYear()) + "年" + (date.getMonth()+1) + "月" + date.getDate() + "日" +"("+date_cn + "xxx)";
%>
<script>
document.write("<%=dateStr%>");
</script>
</html>
