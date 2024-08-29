document.getElementById("form").addEventListener("submit", (event)=>{
	event.preventDefault();
	
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	data = {
		username, password
	}
	
	$.ajax({
		url:"/register",
		data: JSON.stringify(data),
	    contentType: "application/json",
	    type: "post",
	    dataType: "json",
	    success: function (response) {
	        console.log(response);
	        window.location.href= "/customerDetail";
	      },
	      error: function (error) {
			  console.log(error);
	        alert("failed");
	      }
	});
})