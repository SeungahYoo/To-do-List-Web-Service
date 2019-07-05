<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
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
			<h1>���� ���</h1>
		</center>

		<form action="">
			<div class="question">
				����ΰ���?<br> <input name="what" maxlength="24" size="50"
					placeholder="swift�����ϱ�(24�ڱ���)" />
			</div>
			<div class="question">
				���� �� ���ΰ���?<br> <input name="who" size="50" placeholder="ȫ�浿" />
			</div>
			<div class="question">
				�켱 ������ �����ϼ���<br> <input type="radio" name="chk_info" value="1">1����
				<input type="radio" name="chk_info" value="2">2���� <input
					type="radio" name="chk_info" value="3">3����
			</div>

			<div class="buttons">
				<div class="btn back">
					<a href="main.jsp "> &lt; ����</a>
				</div>
				<div class="btn blue">
					<a>����</a>
				</div>
				<div class="btn blue">
					<a>���������</a>
				</div>
			</div>
		</form>
	</section>
</body>
</html>