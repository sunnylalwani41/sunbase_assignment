let showData = (data) =>{
	let tbody = document.getElementsByTagName("tbody")[0];
	
	tbody.innerHtml = "";
	
	data.forEach(element =>{
		let row = document.createElement("tr");
		let firstName = document.createElement("td");
		
		firstName.innerText = element.firstName;
		
		let lastName = document.createElement("td");
		
		lastName.innerText = element.lastName;
		
		let address = document.createElement("td");
		
		address.innerText = element.address;
		
		let city = document.createElement("td");
		
		city.innerText = element.city;
		
		let state = document.createElement("td");
		
		state.innerText = element.state;
		
		let email = document.createElement("td");
		
		email.innerText = element.email;
		
		let phone = document.createElement("td");
		
		phone.innerText = element.phone;
		
		let action = document.createElement("td");
		let deleteButton = document.createElement("button");
		let updateButton = document.createElement("button");
		
		deleteButton.innerText = "Delete";
		deleteButton.setAttribute("class", "btn btn-success");
		deleteButton.addEventListener("click", ()=>{
			deleteCustomer(element.uuid);
		})
		
		updateButton.innerText = "Update";
		updateButton.setAttribute("class", "btn btn-success");
		updateButton.addEventListener("click", ()=>{
			editCustomer(element);
		})
		
		action.append(deleteButton, updateButton);
		tbody.append(firstName, lastName, address, city, state, email, phone, action);
	})
}

let deleteCustomer = (uuid) =>{
	$.ajax({
		url:`customers/deleteCustomer${uuid}`,
	    contentType: "application/json",
	    type: "delete",
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
};

let editCustomer = (data) =>{
	
}

document.getElementById("form").addEventListener("submit", (event)=>{
	event.preventDefault();
	
	let field = document.getElementById("field").value;
	let value = document.getElementById("value").value;
		
	$.ajax({
		url:`customers/getCustomerList?field=${field}&value=${value}`,
	    contentType: "application/json",
	    type: "get",
	    dataType: "json",
	    success: function (response) {
	        console.log(response);
	        showData(response);
	      },
	      error: function (error) {
			  console.log(error);
	        alert("failed");
	      }
	});
})

document.getElementById("syncButton").addEventListener("click", ()=>{
	$.ajax({
		url:`customers/getCustomerByRemoteApi`,
	    contentType: "application/json",
	    type: "post",
	    dataType: "json",
	    success: function (response) {
	        console.log(response);
	        showData(response);
	      },
	      error: function (error) {
			  console.log(error);
	        alert("failed");
	      }
	});
})

