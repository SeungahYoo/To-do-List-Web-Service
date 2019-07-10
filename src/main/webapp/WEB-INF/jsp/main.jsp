<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 해야할 일들</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />

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
			<div class="list" id="todo-list">
				<div class="status">TODO</div>
				<c:forEach var="todo" items="${todos }">
					<div class="card">
						<div class="content">${todo.title }</div>
						<div class="detail">등록날짜 ${todo.regdate }, ${todo.name },
							우선순위 ${todo.sequence }</div>
						<button class="next-btn"
							onclick="changeStatus(${todo.id},'${todo.type}')">→</button>
					</div>
				</c:forEach>

			</div>

			<div class="list" id="doing-list">
				<div class="status">DOING</div>
				<c:forEach var="doing" items="${doings }">
					<div class="card">
						<div class="content">${doing.title }</div>
						<div class="detail">등록날짜 ${doing.regdate }, ${doing.name },
							우선순위 ${doing.sequence }</div>
						<button class="next-btn"
							onclick="changeStatus(${doing.id},'${doing.type}')">→</button>
					</div>
				</c:forEach>
			</div>

			<div class="list" id="done-list">
				<div class="status">DONE</div>
				<c:forEach var="done" items="${dones }">
					<div class="card">
						<div class="content">${done.title }</div>
						<div class="detail">등록날짜 ${done.regdate }, ${done.name },
							우선순위 ${done.sequence }</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</div>

	<script type="text/javascript">
	function changeStatus(id, status) {
		const request = new XMLHttpRequest();
		const button = event.target;
		const information = 'id='+id+'&type='+status;
	
		request.addEventListener("load", function() {
		  console.log(this.responseText);
		});    
		
		request.open("POST", "UpdateStatusServlet");//parameter를 붙여서 보낼수있음. 
		request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		request.send(information);
		
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				const clickedCard = button.parentNode;
				let doList;
				if(status === "TODO"){//todo->doing
					button.setAttribute("onClick","changeStatus("+id+",'DOING')")
					doList = document.querySelector("#doing-list");
				}else if(status === "DOING"){//doing->done
					button.remove();
					doList = document.querySelector("#done-list");
				}
				doList.appendChild(clickedCard);
			}
		};
	}
</script>

</body>
</html>