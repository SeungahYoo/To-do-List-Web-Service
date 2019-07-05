<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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

#next-btn {
	float: right;
}
</style>
</head>
<body>

	<div id="container">

		<header>
			<div id="title">나의 해야할 일들</div>
			<div class="new-btn" style="float: right;">
				<a href="register.jsp">새로운 TODO 등록</a>
			</div>
		</header>
		<section>

			<div class="list">
				<div class="status">TODO</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
			</div>

			<div class="list">
				<div class="status">DOING</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
			</div>

			<div class="list">
				<div class="status">DONE</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
				<div class="card">
					<div class="content">자바스크립트 공부하기</div>
					<div class="detail">등록날짜 2018.03.10, 홍길동, 우선순위 1</div>
					<button id="next-btn">→</button>
				</div>
			</div>
		</section>
	</div>
</body>
</html>