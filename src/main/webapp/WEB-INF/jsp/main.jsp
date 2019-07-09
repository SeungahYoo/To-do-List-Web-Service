<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>나의 해야할 일들</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript">
function changeStatus(data) {
	const s = document.getElementsByName('todoID');
	console.log(s);
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function() {
	  console.log(this.responseText);
	});    
	oReq.open("GET", "UpdateStatusServlet?id="+s);//parameter를 붙여서 보낼수있음. 
	oReq.send();
	}
</script>
</head>
<body>
	<div id="container">

		<header>
			<div id="title">나의 해야할 일들</div>
			<div class="new-btn" style="float: right;">
				<a href="RegisterServlet">새로운 TODO 등록</a>
			</div>
		</header>
		<section>

			<div class="list">
				<div class="status">TODO</div>

				<c:forEach var="todo" items="${todos }">
					<div class="card">
						<div class="content">${todo.title }</div>
						<div class="detail">등록날짜 ${todo.regdate }, ${todo.name },
							우선순위 ${todo.sequence }</div>
						<input id="${todo.name }" name="todoID" type="hidden" value="${todo.name }" />
						<button class="next-btn" onclick="changeStatus()">→</button>
					</div>
				</c:forEach>

			</div>

			<div class="list">
				<div class="status">DOING</div>
				<c:forEach var="doing" items="${doings }">
					<div class="card">
						<div class="content">${doing.title }</div>
						<div class="detail">등록날짜 ${doing.regdate }, ${doing.name },
							우선순위 ${doing.sequence }</div>
						<button class="next-btn">→</button>
					</div>
				</c:forEach>
			</div>

			<div class="list">
				<div class="status">DONE</div>
				<c:forEach var="done" items="${dones }">
					<div class="card">
						<div class="content">${done.title }</div>
						<div class="detail">등록날짜 ${done.regdate }, ${done.name },
							우선순위 ${done.sequence }</div>
						<button class="next-btn">→</button>
					</div>
				</c:forEach>
			</div>
		</section>
	</div>
</body>
</html>