<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>할일 등록</title>
<style type="text/css">
body {
	background-color: #d9d9d9;
}

section {
	background-color: white;
	padding: 40px 150px;
	width: 900px;
	height: 400px;
	margin: 50px auto;
}

div.question {
	margin: 25px 0px;
	height: 50px;
	line-height: 30px;
}

div.btn {
	width: 100px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	cursor: pointer;
	display: inline-block;
}

div.blue {
	color: white;
	background: #619eff;
	float: right;
	margin-left: 20px;
}

div.back {
	border: 0.3px solid black;
}

div.buttons {
	margin-top: 50px;
}

form {
	width: 450px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<section>
		<center>
			<h1>할일 등록</h1>
		</center>

		<form action="">
			<div class="question">
				어떤일인가요?<br> <input name="what" maxlength="24" size="50"
					placeholder="swift공부하기(24자까지)" />
			</div>
			<div class="question">
				누가 할 일인가요?<br> <input name="who" size="50" placeholder="홍길동" />
			</div>
			<div class="question">
				우선 순위를 선택하세요<br> <input type="radio" name="chk_info" value="1">1순위
				<input type="radio" name="chk_info" value="2">2순위 <input
					type="radio" name="chk_info" value="3">3순위
			</div>

			<div class="buttons">
				<div class="btn back">
					<a href="main.jsp "> &lt; 이전</a>
				</div>
				<div class="btn blue">
					<a>제출</a>
				</div>
				<div class="btn blue">
					<a>내용지우기</a>
				</div>
			</div>
		</form>
	</section>
</body>
</html>