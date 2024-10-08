document.getElementById("form").addEventListener("submit", (event)=>{
	event.preventDefault();
	
	let first_name = document.getElementById("firstName").value;
	let last_name = document.getElementById("lastName").value;
	let street = document.getElementById("street").value;
	let address = document.getElementById("address").value;
	let city = document.getElementById("city").value;
	let state = document.getElementById("state").value;
	let email = document.getElementById("email").value;
	let phone = document.getElementById("phone").value;
	
	data = {
		first_name,
		last_name,
		street,
		address,
		city,
		state,
		email,
		phone
	}
	
	$.ajax({
		url:"customers/customerAdd",
		data: JSON.stringify(data),
	    contentType: "application/json",
	    type: "post",
	    dataType: "json",
	    success: function (response) {
	        console.log(response);
	        alert("success");
	      },
	      error: function (error) {
			  console.log(error);
	        alert("failed");
	      }
	});
})