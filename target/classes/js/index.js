window.onload = () => {
	console.log("loaded");
	populateTodosTable();
}

const populateTodosTable = () => {
	console.log("Inside populate todos table");
	const xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			let todos = JSON.parse(xhr.responseText);
			console.log(todos);
			addTodosToTable(todos);
		}
	}
	
	xhr.open("GET", "http://localhost:8088/Proj1/api/todos");
	xhr.send();
}

function addTodosToTable(todos) {
	for (let todo of todos) {
		let tdTitle = document.createElement("td");
		let tdDescription = document.createElement("td");
		
		tdTitle.textContent = todo.title;
		tdDescription.textContent = todo.description;
		
		let row = document.createElement("tr");
		
		row.appendChild(tdTitle);
		row.appendChild(tdDescription);
		
		document.getElementById("todoTable").appendChild(row);
	}
}