       function getStudent() {
            fetch('http://localhost:8080/students-all')
                .then(function (res) {
                    return res.json();
                })
                .then(function (data) {
                    let result = `
                       <div>
                             <input type="text" id="firstName-student" placeholder="First Name"></input>
                             <input type="text" id="lastName-student" placeholder="Last Name"></input>
                             <input type="text" id="email-student" placeholder="Email"></input>
                             <button onClick="postStudent()">Create student</button>
                    	</div>
                    `;
                    data.forEach((student) => {
                        const { id,firstName, lastName, email } = student
                        result +=
                            `<div>
                                <h5> Student ID: ${id} </h5>
                                <ul>
                                    <li> First Name : ${firstName}</li>
                                    <li> Last Name : ${lastName} </li>
                                    <li> Email : ${email} </li>
                                </ul>
                                <button id="update-student" onClick="expandFields(${id})">Update</button>
                                <button id="delete-student" onClick="deleteStudent(${id})">Delete</button>
                                 <div id="fields-${id}" style="display:none;">
                             <input type="text" id="firstName-student-${id}" placeholder="First Name"></input>
                             <input type="text" id="lastName-student-${id}" placeholder="Last Name"></input>
                             <input type="text" id="email-student-${id}" placeholder="Email"></input>
                             <button onClick="updateStudent(${id})">Update student</button>
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
        
        function postStudent() {
            let firstName = document.getElementById('firstName-student').value;
            let lastName = document.getElementById('lastName-student').value;
            firstName.value || lastName.value === "" ?
            alert('Please Enter all details') :
            fetch('http://localhost:8080/students', {
                method: 'POST',
                headers: {
                        'Content-type': 'application/json'
                },
                body: JSON.stringify({firstName:firstName, lastName:lastName, email:email})
            }).then((res) => res.json())
                .then((data) => alert('Data Sent'))
                .catch((err) => console.log(err))
        }
        
        function deleteStudent(id) {
            fetch('http://localhost:8080/students', {
                method: 'DELETE',
                headers: {
                        'Content-type': 'application/json'
                },
                body: JSON.stringify({id:id})
            }).then((res) => res.json())
                .then((data) => alert('Data deleted'))
                .catch((err) => console.log(err))
        }
        
        function updateStudent(id){
        	document.getElementById("fields-"+id).style.display = "none";
        	let firstName =  document.getElementById("firstName-student-"+id).value;
        	let lastName =  document.getElementById("lastName-student-"+id).value;
        	let email =  document.getElementById("email-student-"+id).value;
        	  fetch('http://localhost:8080/update-student/id', {
                  method: 'PUT',
                  headers: {
                          'Content-type': 'application/json'
                  },
                  body: JSON.stringify({firstName:firstName, lastName:lastName, email:email})
              }).then((res) => res.json())
                  .then((data) => alert('Student updated'))
                  .catch((err) => console.log(err))
          }
      