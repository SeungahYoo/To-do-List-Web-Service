function init() {
	const Buttons = document.querySelectorAll("button");
	
	request.onreadystatechange = () => {
		if (request.status >= 400) {
			alert("오류가 발생했습니다. 다시 시도하세요");
			return;
		}
	};
	
	Buttons.forEach((event) => {
		event.addEventListener("click", changeStatus)
	});
}

function changeStatus() {
	const button = this;
	const request = new XMLHttpRequest();
	const information = `id=${button.dataset.id}&type=${button.dataset.type}`;

	request.open("POST", "update-status");
	request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	request.send(information);

	const clickedCard = button.parentNode;
	let doList;

	if (button.dataset.type === "TODO") {// todo->doing
		doList = document.querySelector("#doing-list");
		button.dataset.type = "DOING";
	} else if (button.dataset.type === "DOING") {// doing->done
		button.remove();
		doList = document.querySelector("#done-list");
	}

	doList.appendChild(clickedCard);
}

document.addEventListener("DOMContentLoaded", function () {
	init();
})