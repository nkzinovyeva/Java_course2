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

function postDataToServer(url, parameterData) {

    var operation = operation;
    var requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/x-www-form-urlencoded"},
        body: parameterData
    };

    fetch(url, requestOptions)
        .then(response => 
        {
            if (response.ok) {
                return response.json();
            } else {
                throw "HTTP status code is " + response.status;
            }
        })
        .then(status => processResponseStatus(status))
        .catch(errorText => alert("Fetch failed: " + errorText));
}

/*function postDataToServer(url, parameterData, operation) {

    var operation = operation;
    var requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/x-www-form-urlencoded"},
        body: parameterData
    };

    fetch(url, requestOptions)
        .then(response => 
        {
            if (response.ok) {
                return response.json();
            } else {
                throw "HTTP status code is " + response.status;
            }
        })
        .then(status => processResponseStatus(status, operation))
        .catch(errorText => alert("Fetch failed: " + errorText))
}

function processResponseStatus(status, operation) {
    if (operation = "to-do") {
        if (status === 0) {
            alert("Student added.");
        } else if (status === 1) {
            alert("Nothing added. The student id is already in use");
        } else {
            alert("Nothing added. An unknown error occurred.");
        }
    }
    if (operation != "to-do") {

    }
}*/