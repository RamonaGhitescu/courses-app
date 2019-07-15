       function getMentor() {
            fetch('http://localhost:8080/mentors-all')
                .then(function (res) {
                    return res.json();
                })
                .then(function (data) {
                    let result = `
                       <div>
                             <input type="text" id="firstName-mentor" placeholder="First Name"></input>
                             <input type="text" id="lastName-mentor" placeholder="Last Name"></input>
                             <input type="text" id="email-mentor" placeholder="Email"></input>
                             <button onClick="postMentor()">Create mentor</button>
                    	</div>
                    `;
                    data.forEach((mentor) => {
                        const { id,firstName, lastName, email } = mentor
                        result +=
                            `<div>
                                <h5> Mentor ID: ${id} </h5>
                                <ul>
                                    <li> First Name : ${firstName}</li>
                                    <li> Last Name : ${lastName} </li>
                                    <li> Email : ${email} </li>
                                </ul>
                                <button id="update-mentor" onClick="expandFields(${id})">Update</button>
                                <button id="delete-mentor" onClick="deleteMentor(${id})">Delete</button>
                                 <div id="fields-${id}" style="display:none;">
                             <input type="text" id="firstName-mentor-${id}" placeholder="First Name"></input>
                             <input type="text" id="lastName-mentor-${id}" placeholder="Last Name"></input>
                             <input type="text" id="email-mentor-${id}" placeholder="Email"></input>
                             <button onClick="updateMentor(${id})">Update mentor</button>
                        	</div>
                             </div>
                             `;
                        document.getElementById('result').innerHTML = result;
                    });
                })
        }
        
        function expandFields(id){
        	console.log("clicked " + id);
         document.getElementById("fields-"+id).style.display = "flex";
        }
        
        function postMentor() {
            let firstName = document.getElementById('firstName-mentor').value;
            let lastName = document.getElementById('lastName-mentor').value;
            firstName.value || lastName.value === "" ?
            alert('Please Enter all details') :
            fetch('http://localhost:8080/mentors', {
                method: 'POST',
                headers: {
                        'Content-type': 'application/json'
                },
                body: JSON.stringify({firstName:firstName, lastName:lastName, email:email})
            }).then((res) => res.json())
                .then((data) => alert('Data Sent'))
                .catch((err) => console.log(err))
        }
        
        function deleteMentor(id) {
            fetch('http://localhost:8080/mentors', {
                method: 'DELETE',
                headers: {
                        'Content-type': 'application/json'
                },
                body: JSON.stringify({id:id})
            }).then((res) => res.json())
                .then((data) => alert('Data deleted'))
                .catch((err) => console.log(err))
        }
        
        function updateMentor(id){
        	document.getElementById("fields-"+id).style.display = "none";
        	let firstName =  document.getElementById("firstName-mentor-"+id).value;
        	let lastName =  document.getElementById("lastName-mentor-"+id).value;
        	let email =  document.getElementById("email-mentor-"+id).value;
        	  fetch('http://localhost:8080/update-mentor/id', {
                  method: 'PUT',
                  headers: {
                          'Content-type': 'application/json'
                  },
                  body: JSON.stringify({firstName:firstName, lastName:lastName, email:email})
              }).then((res) => res.json())
                  .then((data) => alert('Mentor updated'))
                  .catch((err) => console.log(err))
          }
      