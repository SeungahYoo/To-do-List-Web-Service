<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>나의 해야할 일들</title>
<style type="text/css">
#container {
	width: 1200px;
	margin: 50px auto;
}

header {
	width: 1200px;
	height: 110px;
}

section {
	padding-left: 80px;
}

#title {
	width: 300px;
	height: 40px;
	transform: rotate(330deg);
	color: #007396;
	font-size: 28px;
	font-weight: bold;
	margin-top: 30px;
	height: 40px;
	transform: rotate(330deg);
	color: #007396;
}

.status {
	width: 320px;
	height: 45px;
	background-color: #007396;
	color: white;
	background-color: #007396;
	margin: 10px;
	padding: 15px;
	font-size: 23px;
	font-weight: bold;
	line-height: 45px;
}

.card {
	width: 320px;
	height: 60px;
	background-color: #bfdfe3;
	margin: 10px;
	padding: 15px;
}

.content {
	font-size: 17px;
	font-weight: bold;
}

.detail {
	margin-top: 9px;
	font-size: 15px;
	display: inline-block;
}

.list {
	width: 370px;
	display: table-cell;
	vertical-align: top;
}

div.new-btn {
	width: 170px;
	height: 40px;
	text-align: center;
	line-height: 40px;
	cursor: pointer;
	display: inline-block;
	color: white;
	background: #619eff;
	float: right;
	margin-right: 20px;
}

.next-btn {
	float: right;
}
</style>
</head>
<body>
	<div id="container">

		<header>
			<div id="title">나의 해야할 일들</div>
			<div class="new-btn" style="float: right;">
				<a href="./register.jsp">새로운 TODO 등록</a>
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
						<button class="next-btn">→</button>
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