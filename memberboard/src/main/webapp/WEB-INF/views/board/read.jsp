<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<main>
<div class="vbox w1200">
	<div class="w1200 fs"><p><b>${dto.title }</b></p></div>
	<div class="w1200 hbox sb">
			<div>${dto.writer } (${dto.ipaddr }) | ${dto.datetime }</div>
			<div>조회 ${dto.viewCount }</div>
	</div>
	
	
	<div class="w1200 h500 boda">
<%-- 	<img src="${cpath }/uploadFile/${dto.uploadfile}" height="300px"> --%>
	<c:if test="${dto.uploadfile != null}">
	<div style="float:right;">
		<strong>파일</strong> :
		<a href="${cpath }/uploadFile/${dto.uploadfile}">${dto.uploadfile}</a>
	</div>
</c:if>
		<pre><font size="5em">${dto.context }</font></pre>
	</div>
</div>
<div class="hbox sb w1200">
	<div>
		<a href="${cpath }/board/"><button class="btn">목록</button></a>
	</div>
	<div>
		<c:if test="${login.username == dto.writer }">
		<a href="${cpath }/board/update/${dto.idx}"><button class="btn">수정</button></a>
		<button class="btn" id="deleteBtn">삭제</button>
		</c:if>
	</div>
</div>

<div class="w1200 vbox reply" id="replyBox">
	<div>
		<c:forEach var="reply" items="${replyList }">
		<div class="vbox replyBox">
			<div class="hbox sb">
				<div>
					<span class="username">${reply.writer }</span>님 [${reply.credate }]
				</div>
				<div>
				<c:if test="${(reply.writer == login.username or login.userid == 'admin') and reply.deleted == 0 }">
					<a href="${cpath }/board/deleteReply/${reply.idx}">삭제</a>	
					</c:if>	
				</div>
			</div>
				<div>
				<c:if test="${reply.deleted != 0 }">
					<pre><b style="color: grey">${reply.deleted == 2 ? '관리자' : '작성자' }에 의해 삭제된 게시물입니다</b></pre>
				</c:if>
				<c:if test="${reply.deleted == 0 }">
					<pre><b>${reply.context }</b></pre>
				</c:if>
			</div>
		</div>
		</c:forEach>
	</div>
	<form method="POST">
		<input type="hidden" name="boardidx" value="${dto.idx }">
		<input type="hidden" name="writer" value="${login.username }">
		<div class="hbox fe">
			<div>
			<textarea name="context" placeholder="내용을 입력하세요"></textarea></div>
			<div><input type="submit" class="btn" value="댓글 작성"></div>
		</div>
	</form>
</div>

</main>

<script>
const deleteBtn = document.getElementById('deleteBtn');
deleteBtn.onclick = () => {
	const select = confirm('정말 게시글을 삭제하시겠습니까?');
	if(select) {
		location.replace('${cpath }/board/delete/${dto.idx}');
	}
};
</script>
</body>
</html>