function addStudent() {
	var url = "http://localhost:8080/qwerty/addStudent";

	var form = document.forms["formStudent"];
	var parameterData = "id=" + form["txtId"].value + "&firstname="
			+ form["txtFirstname"].value + "&lastname="
			+ form["txtLastname"].value + "&streetaddress="
			+ form["txtStreetaddress"].value + "&postcode="
			+ form["txtPostcode"].value + "&postoffice="
			+ form["txtPostoffice"].value;
	
	postDataToServer(url, parameterData, processAddResponse)
}

function processAddResponse(status) {
	if (status === 0) {
		alert("Student added.");
		location.replace("students.html");
	} else if (status === 1) {
		alert("Nothing added. The student id is already in use");
		location.replace("students.html");
	} else {
		alert("Nothing added. An unknown error occurred.");
		location.replace("students.html");
	}
}

//addStudent();