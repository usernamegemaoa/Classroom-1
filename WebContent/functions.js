/*function drawHWTable() {
	var table = $("#studentHW");
    $.ajax({
        url : 'rest/homework/getHomeworks',
        type : "GET",
        dataType : "json",
        success : function(data) {
            renderTable(data, table);
        }
    });
}*/
$(document).ready(function() {

	var table = $("#studentHW");
    $.ajax({
        url : "http://localhost:14037/Classroom/DownloadHw",
        type : "GET",
        dataType : "json",
        success : function(data) {
            renderTable(data, table);
        }
    });

function renderTable(data, table) {
    
    var tableThings = data.length;
    for (var i = 0; i < tableThings; i++) {
        renderRow(data[i], table);
    }
}
function renderRow(rowData, table) {
    var row = $("<tr />");
    table.append(row);
    var date = rowData.endDate;//change
    if (date){
    	date = date.substring(0,10);
    }
    row.append($("<td>" + rowData.name + "</td>"));
    row.append($("<td>" + rowData.endDate + "</td>")); 
    row.append($("<td>" + rowData.subject + "</td>"));
    row.append($("<td>" + rowData.info + "</td>"));
    //if (isUserAuthenticated && rowData.amount > 0) {
    //var detailsTd = $("<td />");
    //var link = $("<button>Details</button>");
   // detailsTd.append(link);
    //row.append(detailsTd);
    //link.click(function(){
    //	window.location.replace("more.html"+'?'+ rowData.id);
    	//window.location.search= rowData.id;
    //});
/*        link.click(function() {
            $.ajax({
                url: 'rest/homework/homework?homeworkId=' + rowData.id,
                type: "PUT",
                dataType: "json",
                success: alert("wooho")
            });
        });*/
    
}



});