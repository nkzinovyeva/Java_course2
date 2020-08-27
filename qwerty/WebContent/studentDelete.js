function deleteStudent() {
	var url = "http://localhost:8080/qwerty/deleteStudent";

	var form = document.forms["formStudent"];
	var parameterData = "id=" + form["txtId"].value;

	postDataToServer(url, parameterData, processDeleteResponse)
}

function processDeleteResponse(status) {
	if (status === 0) {
		alert("Student data deleted!");
	} else if (status === 1) {
		alert("Student data not deleted. Unknown student id!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.");
	}
}