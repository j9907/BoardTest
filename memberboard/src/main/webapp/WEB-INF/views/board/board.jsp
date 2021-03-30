<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%> 
<main>
<table id="boardList">
	<thead>
		<tr>
			<th class="idx">번호</th>
			<th class="title">제목</th>
			<th class="writer">작성자</th>
			<th class="viewCount">조회수</th>
			<th class="creationDate">작성날짜</th>
			<th class="ipaddr">IP Address</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${list }">
			<tr class="current">
				<td class="idx">${board.idx }</td>
				<td class="title"><a href="${cpath }/board/read/${board.idx }/">${board.title }</a></td>
				<td class="writer">${board.writer }</td>
				<td class="viewCount">${board.viewCount }</td>
				<td class="creationDate">${board.datetime }</td>
				<td class="ipaddr">${board.ipaddr }</td>
			</tr>
		</c:forEach>
		</tbody>
</table>
<div class="paging">
		<c:if test="${prev }">
			<a href="${cpath }/board/${begin - 1}/"
			   style="display: inline;">◀</a>
		</c:if>
		<c:forEach var="page" begin="${begin }" end="${end }">
			<c:if test="${nowPage == page }">
				<b>[${page }]</b>
			</c:if>
			<c:if test="${not (nowPage == page) }">
				<a style="display: inline;" href="${cpath }/board/${page}/">
					[${page }] </a>
			</c:if>
		</c:forEach>
		
		<c:if test="${next }">
			<a href="${cpath }/board/${end + 1}/"
			   style="display: inline;">▶</a>
		</c:if>
	</div>
<div class="hbox sb w1200">
	<div>
		<a href="${cpath }/board/write/"><button class="btn">새 글 작성</button></a>
	</div>
</div>
</main>
</body>
</html>