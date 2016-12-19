<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>film表</title>
</head>
<body>
	<div>
    	<table border="1px" cellspacing="0">
    	 <tbody>
    		<tr>
    			<th>film_id</th>
    			<th>title</th>
    			<th>description</th>
    			<th>language</th>
    			<th>操作</th>
    		</tr>
	    	<c:forEach items="${films}" var="film">
	    		<tr>
	    			<td>${film.film_id}</td>
	    			<td>${film.title}</td>
	    			<td>${film.description}</td>
	    		<c:forEach items="${languages}" var="l">
	    			<c:when test="${film.language_id == l.language_id}">
	    					<td>${l.name}</td>
	    			</c:when>
	    		</c:forEach>			
	    		</tr>
	    	</c:forEach>
    	</tbody>
    </table>
    </div>
</body>
</html>