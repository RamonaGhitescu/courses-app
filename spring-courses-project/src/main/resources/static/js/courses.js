       function getCourse() {
            fetch('http://localhost:8080/courses-all')
                .then(function (res) {
                    return res.json();
                })
                .then(function (data) {
                    let result = `
                       <div>
                             <input type="text" id="title-course" placeholder="Title"></input>
                             <input type="text" id="content-course" placeholder="Content"></input>
                             <button onClick="postCourse()">Create course</button>
                    	</div>
                    `;
                    data.forEach((course) => {
                        const { id,title, content } = course
                        result +=
                            `<div>
                                <h5> Course ID: ${id} </h5>
                                <ul>
                                    <li> Title : ${title}</li>
                                    <li> Content : ${content} </li>
                                </ul>
                                <button id="update-course" onClick="expandFields(${id})">Update</button>
                                <button id="delete-course" onClick="deleteCourse(${id})">Delete</button>
                                 <div id="fields-${id}" style="display:none;">
                             <input type="text" id="title-course-${id}" placeholder="Title"></input>
                             <input type="text" id="content-course-${id}" placeholder="Content"></input>
                             <button onClick="updateCourse(${id})">Update course</button>
                        	</div>
                             </div>
                             `;
                        document.getElementById('result').innerHTML = result;
                    });
                })
        }
        function expandFields(id){
         document.getElementById("fields-"+id).style.display = "flex";
        }
        
        function postCourse() {
            let title = document.getElementById('title-course').value;
            let content = document.getElementById('content-course').value;
            title.value || content.value === "" ?
            alert('Please Enter all details') :
            fetch('http://localhost:8080/courses', {
                method: 'POST',
                headers: {
                        'Content-type': 'application/json'
                },
                body: JSON.stringify({title:title, content:content})
            }).then((res) => res.json())
                .then((data) => alert('Data Sent'))
                .catch((err) => console.log(err))
        }
        
        function deleteCourse(id) {
            fetch('http://localhost:8080/courses', {
                method: 'DELETE',
                headers: {
                        'Content-type': 'application/json'
                },
                body: JSON.stringify({id:id})
            }).then((res) => res.json())
                .then((data) => alert('Data deleted'))
                .catch((err) => console.log(err))
        }
        
        function updateCourse(id){
        	document.getElementById("fields-"+id).style.display = "none";
        	let title =  document.getElementById("title-course-"+id).value;
        	let content =  document.getElementById("content-course-"+id).value;
        	  fetch('http://localhost:8080/update-course/id', {
                  method: 'PUT',
                  headers: {
                          'Content-type': 'application/json'
                  },
                  body: JSON.stringify({title:title, content:content})
              }).then((res) => res.json())
                  .then((data) => alert('Course updated'))
                  .catch((err) => console.log(err))
          }
      