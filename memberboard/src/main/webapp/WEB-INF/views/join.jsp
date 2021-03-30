<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<main>
	<div class="vbox w1200 h500">
		<h2>회원가입</h2>
		<form method="POST">
			<p><input type="text" name="userid" placeholder="ID" required autofocus autocomplete="off"></p>
			<p><input type="password" name="userpw" placeholder="Password" required></p>
			<p><input type="text" name="username" placeholder="사용자 이름" required autocomplete="off"></p>
			<p><input type="text" name="email" placeholder="E-Mail" required autocomplete="off"></p>
			<div class="hbox">
				<label><input type="radio" name="gender" value="남성" required>남성</label>
				<label><input type="radio" name="gender" value="여성" required>여성</label>
			</div>
			<br>
			<div class="vbox">
				<input class="btn" type="submit" value="회원가입">
			</div>
		</form>
	</div>
	</main>

</body>
</html>