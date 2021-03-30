<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="${cpath }/resources/css/site.css">
<link rel="stylesheet" href="${cpath }/resources/css/board.css">
</head>
<body>
<header>
	<h1><a href="${cpath }/">HOME</a></h1>
	<div class="loginInfo">
		<strong>
		${login.username } 
		${not empty login ? '(' : '' }
		${login.userid }
		${not empty login ? ')' : '' }
		</strong>
	</div>
</header>
<nav>
	<ul>
		<c:if test="${empty login }">
		<li><a href="${cpath }/join/">회원 가입</a>
			</li>
		</c:if>
		<li>
			<a href="${cpath }/${not empty login ? 'logout' : 'login' }">
			${not empty login ? '로그아웃' : '로그인' }
			</a>
		</li>
		<c:if test="${not empty login }">
			<li><a href="${cpath }/update/">회원 수정</a></li>
		<li><a href="${cpath }/board/">게시판</a></li>
		</c:if>
	</ul>
</nav>






