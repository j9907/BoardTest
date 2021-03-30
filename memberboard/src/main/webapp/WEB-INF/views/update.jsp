<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<main>
<div class="vbox w1200 h500">
	<h2>회원 정보 수정</h2>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" value="${login.userid }" readonly></p>
		<p><input type="password" name="userpw" placeholder="현재 비밀번호" autofocus required></p>
		<p><input type="password" name="newpw1" placeholder="새 비밀번호" required></p>
		<p><input type="password" name="newpw2" placeholder="새 비밀번호 확인" required></p>
		<p><input type="text" name="username" placeholder="사용자 이름" value="${login.username }" required autocomplete="off"></p>
		<p><input type="submit" value="수정" class="btn"></p>
	</form>
	</div>
	
</main>
</body>
</html>