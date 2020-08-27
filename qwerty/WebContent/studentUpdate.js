function main() {
	var updid = $_GET('id');
	var updlastname = $_GET('lastname');
	var updfirstname = $_GET('firstname');
	var upstreetaddress = $_GET('streetaddress');
	var updpostcode = $_GET('postcode');
	var updpostoffice = $_GET('postoffice');
	// alert(updid+firstname+lastname);
	document.getElementById("txtId").value = updid;
	document.getElementById("txtLastname").value = updlastname;
	document.getElementById("txtFirstname").value = updfirstname;
	document.getElementById("txtStreetaddress").value = upstreetaddress;
	document.getElementById("txtPostcode").value = updpostcode;
	document.getElementById("txtPostoffice").value = updpostoffice;
}

function $_GET(key) {
	var p = window.location.search;
	p = p.match(new RegExp(key + '=([^&=]+)'));
	return p ? p[1] : false;
}

function updateStudent(url) {
	var url = "http://localhost:8080/qwerty/updateStudent";

	var form = document.forms["formStudent"];
	var parameterData = "id=" + form["txtId"].value + "&firstname="
			+ form["txtFirstname"].value + "&lastname="
			+ form["txtLastname"].value + "&streetaddress="
			+ form["txtStreetaddress"].value + "&postcode="
			+ form["txtPostcode"].value + "&postoffice="
			+ form["txtPostoffice"].value;
	// alert(parameterData);

	postDataToServer(url, parameterData, processUpdateResponse)
}

function processUpdateResponse(status) {
	if (status === 0) {
		alert("Student's info updated.");
		location.replace("students.html");
	} else if (status === 1) {
		alert("Nothing updated");
		location.replace("students.html");
	} else {
		alert("Nothing updated. An unknown error occurred.");
		location.replace("students.html");
	}
}

main();
// updateStudent();
