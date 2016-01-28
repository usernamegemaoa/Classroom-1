function register() {
    var username = $("#usr")[0].value;
    var password = $("#pwd")[0].value;
    var confirmPassword = $("#pwd_confirm")[0].value;
    if (password == "" || confirmPassword == "") {
        alert("Please fill both fields for password and try again.");
        validUser = false;
    }
    if (password != confirmPassword) {
        alert("Two passwords do not match. Please correct the values and try again.");
        return;
    }
    
   

    $.post( "http://localhost:14037/Classroom/AddUser", { name: username, pwd: password } )
	.fail(function(data) {
		window.location.replace("index.html");
	    alert("Error");
	});
}