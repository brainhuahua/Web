<%--
  Created by IntelliJ IDEA.
  User: 25322
  Date: 2024/12/4
  Time: 上午12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>我的简历</title>
    <style>
      .home{
        width: 100%;
        height: 100vh;
        display: flex;
        align-content: center;
        justify-content: center;
        font-size: large;
        color: #001aff;
        background: #ffffff;
      }
    </style>
    <script>
      location.href = "/resume"
    </script>
  </head>
  <body>
    <div class="home" onclick="jump()">
      <div>欢迎来到我的简历系统</div>
      <div>随意点击桌面可以登陆</div>
    </div>
  </body>
  <script>
    function jump(){
      document.location="/resume";
    }


  </script>
</html>
