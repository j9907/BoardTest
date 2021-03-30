<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<main>
	
	<div class="vbox w1200 write">
		<form method="POST" enctype="multipart/form-data">
			<input type="hidden" name="ipaddr" value="${pageContext.request.remoteAddr }" value=${dto.ipaddr }>
			<input type="hidden" name="writer" placeholder="작성자" value="${dto.writer }">
			<div class="w1200 fs">
				<p><input type="text" name="title" placeholder="제목을 입력하세요"  required autofocus value=${dto.title }></p>
			
				<div class="w1200 h500 boda">
					<textarea name="context" placeholder="내용을 작성하세요" required >${dto.context }</textarea>
				</div>
				<p><input type="file" name="File" value="${cpath }/uploadFile/${dto.uploadfile }"></p>
			</div>
			<div class="w1200 sb hbox">
			<div>
				<input type="button" value="돌아가기" class="btn">
			</div>
			<div>
				<input type="submit" value="수정" class="btn">
			</div>
		</div>
		</form>
	</div>
	
</main>
</body>
</html>