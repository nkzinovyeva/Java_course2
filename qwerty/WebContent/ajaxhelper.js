function getDataFromServer(url, printStudents) {

    fetch(url)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw "HTTP status code is " + response.status;
            }
        })
        .then(StudentListServlet => printStudents(StudentListServlet))
        .catch(errorText => alert("getDataFromServer failed: " + errorText));
}

function postDataToServer(url, parameterData, processResponseStatus) {

	 //var myJSON = JSON.stringify(parameterData);
	 //alert(myJSON);
	
    var requestOptions = {
        method:"POST",
        headers: {"Content-Type":"application/x-www-form-urlencoded"},
        body: parameterData
    };

    //var myJSON2 = JSON.stringify(requestOptions);
	 //alert(myJSON2);
    
    fetch(url, requestOptions)
        .then(response => {
        	if (response.ok) {
        		return response.json();
        		} else {
        		throw "HTTP status code is " + response.status;
        		}
        	})
        .then(status => processResponseStatus(status))
        .catch(errorText => alert("postDataToServer failed: " + errorText))
}
