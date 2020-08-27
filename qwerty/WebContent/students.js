
function main() {
	getDataFromServer("http://localhost:8080/qwerty/students", printStudents);
}


var data = "";

function printStudents(studentListServlet) {
	for (var student of studentListServlet) { 
		console.log(student);
 
 data += "<tr><td>" + student.id + "</td><td>" + student.lastname + "</td><td>" + student.firstname + "</td><td>" + student.streetaddress + "</td><td>" + student.postcode + "</td><td>" + student.postoffice + "</td>"
 + "<td>" + createUpdateDeleteLinks(student.id,student.lastname, student.firstname,student.streetaddress,student.postcode, student.postoffice ) + "</td>" +"</tr>";
 
 document.getElementById("tableData").innerHTML = data;
 
	}
}

function addStudent() {
	location.replace("studentAdd.html");
}

function updateStudent(studentId,lastname,firstname,streetaddress,postcode, postoffice ) {
	var confirmed = confirm("Update student " + studentId + " ?");

	if(confirmed){
		location.replace("StudentUpdate.html?id=" + studentId + "&lastname=" + lastname + "&firstname=" + firstname +
				"&streetaddress=" + streetaddress + "&postcode=" + postcode + "&postoffice=" + postoffice );
	} else {
	  //close or do smth else
	}
}

function deleteStudent(studentId) {
	var confirmed = confirm("Delete student " + studentId + " ?");

	if(confirmed){
		//deleteStudent(studentId);
		var url = "http://localhost:8080/qwerty/deleteStudent";

		var parameterData = "id=" + studentId;

		postDataToServer(url, parameterData, processDeleteResponse)
		
	} else {
	  //close or do smth else
	}
}

function createUpdateDeleteLinks(studentId,lastname,firstname,streetaddress,postcode,postoffice) {
	return "<span class='link' onclick='updateStudent(" + studentId + ",&apos;" + lastname + "&apos;" +	",&apos;" + firstname + "&apos;" 
	+ ",&apos;" + streetaddress + "&apos;" +",&apos;" + postcode + "&apos;" + ",&apos;" + postoffice + "&apos;" +
	");'>Update</span>" + "&nbsp;&nbsp;" +
	"<span class='link' onclick='deleteStudent(" + studentId + ");'>Delete</span>";
	}

function processDeleteResponse(status) {
	if (status === 0) {
		alert("Student data deleted!");
		location.reload();
	} else if (status === 1) {
		alert("Student data not deleted. Unknown student id!");
		location.reload();
	} else {
		alert("The database is temporarily unavailable. Please try again later.");
		location.reload();
	}
	
}

main();