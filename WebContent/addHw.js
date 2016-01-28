function createHomework() {

    var title = $("#homework")[0].value;
    var description = $("#description")[0].value;
    var endDate = $("#dueDate")[0].value;
    var subjectt = $("#subject")[0].value;

    $.post( "http://localhost:14037/Classroom/UploadHw", { name: title, info: description, subject: subjectt } )
	.fail(function(data) {
		window.location.replace("createHomework.html");
	    alert("Error");
	});
}