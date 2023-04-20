<%@page import="obs.model.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Welcome Page</title>
</head>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">


var data =${list};
function loadGrid() {
    if(!jQuery.isEmptyObject(data)){
    
        //$('.pageTable tbody tr').remove();
        var html = "";
        $.each(data, function(i,data){
        	$.each(data.students, function(i,datas){
        		 var passDigit=data.pass.toFixed(2);
        
        	html += "<tr >";
            html += "<td align='center' class='build-name'><b>"+data.name+"</b></td>";
            html += "<td class='stdid' data="+datas.studentName+" align='left'>"+datas.studentId+"</td>";
            html += "<td align='left'>"+datas.mark+"</td>";
            html += "<td align='center' class='build-pass'>"+passDigit+"</td>";
            });
        });
        $(".pageTable tbody").append(html);
    }
}


$(document).ready(function() {

		  
	loadGrid();
    var topMatchTd;
    var previousValue = "";
    var rowSpan = 1;
	var studentName;
   $('.build-name').each(function(){

        if($(this).text() == previousValue){
          rowSpan++;
          $(topMatchTd).attr('rowspan',rowSpan);
          $(this).remove();
        }else {
          topMatchTd = $(this);
          rowSpan = 1;
        }

        previousValue = $(this).text();
    });
	  
   $('.build-pass').each(function(){

       if($(this).text() == previousValue){
         rowSpan++;
         $(topMatchTd).attr('rowspan',rowSpan);
         $(this).remove();
       }else {
         topMatchTd = $(this);
         rowSpan = 1;
       }

       previousValue = $(this).text();
   });

   $('.stdid').click(function(){
	    var id = $(this).attr('data');
	    	  $(".popup-overlay, .popup-content").addClass("active");
	    	  $("#stdName").html(id);
	    });
   $('.close').click(function(){
	    	  $(".popup-overlay, .popup-content").removeClass("active");
	    });

});

</script>
<body>
	<%   
		if(session.getAttribute("username")== null){
			response.sendRedirect("login.jsp");	
		}
	%>
	Welcome
	<a >${username}</a>
	</br>
	</br>
	</br>

	<table class="pageTable" border="1">
		<thead>
			<tr>
				<th class="text-center">Department</th>
				<th class="text-center">Student ID</th>
				<th class="text-center">Mark</th>
				<th class="text-center">Pass %</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
	</br>
	</br>

<div class="popup-overlay">
 <div class="popup-content" border =1 >
    <p> Student Name : <a id="stdName"></a></p>
    <button class="close">Close</button>    
</div>
</div>


</body>
</html>