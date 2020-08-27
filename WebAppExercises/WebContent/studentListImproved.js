
function main() {
	getDataFromServer("http://localhost:8080/WebAppExercises/students", printStudents);
}


var data = "";

function printStudents(studentListServlet) {
	for (var student of studentListServlet) { 
		console.log(student);
 
 data += "<tr><td>" + student.id + "</td><td>" + student.lastname + "</td><td>" + student.firstname + "</td><td>" + student.streetaddress + "</td><td>" + student.postcode + "</td><td>" + student.postoffice + "</td></tr>";
 
 document.getElementById("tableData").innerHTML = data;
 
	}
}

main();

