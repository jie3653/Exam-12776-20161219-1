<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>
${pageContext.request.contextPath}
	<div style="margin:0 auto;width:320px;height:300px;position:absolute;left:400px;top:100px;">
		<form action="CustomerServlet">
			<input type="hidden" name="command" value="login">
			name: <input name="first_name"/><br/><br/>
			${info}<br/><br/>
			<input type="submit" value="登录">      <input type="reset" value="取消">
		</form>
	</div>
	
</body>
</html>