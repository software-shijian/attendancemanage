<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<form id="loginForm" action="/login/submit.jhtml" method="post">
<table >
					<tr>
						<th>
							username:
						</th>
						<td>
							<input type="text" id="username" name="username" class="text" maxlength="20" />
						</td>
					</tr>
					<tr>
						<th>
							password:
						</th>
						<td>
							<input type="password" id="password" class="text" maxlength="20" autocomplete="off" />
						</td>
					</tr>
					
					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
						<input type="submit" class="loginButton" value="login" />
						</td>
					</tr>
				</table>
</form>
  </body>
</html>
