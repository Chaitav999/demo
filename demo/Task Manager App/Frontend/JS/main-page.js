/*       function updateTask(){
                    let taskHTML = '';

                    for(let i = 0; i < taskList.length; i++){
                        const task = taskList[i];
                        const html = `
                        
                            <p class="name-delete">
                                ${task} 
                                <button class="task-delete" onclick="
                                    taskList.splice(${i}, 1);
                                    updateTask();
                                ">Delete</button
                            </p>
                        `;
                        taskHTML += html;
                    }

                    document.querySelector(".js-display-task")
                      .innerHTML = taskHTML;
                } */

                loadTasks();

                // Adding tasks to the backend
                function addTask(){

                    const inputElement = document.querySelector(".js-input-task"); 
                    const value = inputElement.value;

                    //----Sending data to the backend----
                    fetch("http://localhost:8080/tasks", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        title: value,
                        completed: false
                    })
                });

                    inputElement.value = '';
                    loadTasks();
                }

                // Get the tasks from the backend
                
                function loadTasks(){
                    fetch("http://localhost:8080/tasks")
                        .then(res => res.json())
                        .then(tasks => {
                           let displayHTML = '';

                           tasks.forEach((task, index) =>  {
                              let taskHTML = `
                              <div class="css-task-row js-task-row-${index}">

                                <p class="css-task-name">${task.title}</p>

                                <div class="css-button-grp">

                                    <button class="css-green-tick-buttn js-green-tick-buttn" title="Completed">
                                        <img class="css-green-tick-img" src="Images/Green-tick/pngtree-green-check-mark-png-image_6525691.png">
                                    </button>

                                    <button class="css-delete-button" onclick="
                                        deleteTask(${index});
                                    ">Delete</button> 

                                </div>

                              </div>`;
                              displayHTML += taskHTML;
                           });

                           document.querySelector('.js-display-task')
                             .innerHTML = displayHTML;

                            // for green-tick button animation && deleting task

                            const buttons = document.querySelectorAll('.js-green-tick-buttn')

                            buttons.forEach((button, index) => {
                                button.addEventListener('click', () => {
                                    fetch(`http://localhost:8080/tasks/${index}`, {
                                        method: "PUT",
                                        headers: {
                                            "Content-Type": "application/json"
                                        } 
                                    })//fetch closing
                                      .then(res => res.json())
                                      .then(updated => console.log(updated));
                                }) //eventlistener closing
                            }) //loop closing
                            
                              animateGreenTickButton();

                           });//.then() closing
                        }//function closing

                function deleteTask(idx){
                    fetch(`http://localhost:8080/tasks/${idx}`, {
                        method: "DELETE",
                }).then(response => {loadTasks()});
                }

                function animateGreenTickButton(){
                    const buttons = document.querySelectorAll('.js-green-tick-buttn');

                               buttons.forEach((button, index) => {
                                button.addEventListener('click', () => {

                                    button.classList.add('rotate-success');

                                    const task = document.querySelector(`.js-task-row-${index}`);
                                    

                                    setTimeout(() => {

                                        button.classList.remove('rotate-success');

                                        task.classList.add('fade-out-task');

                                    }, 700);

                                    setTimeout(() => {

                                        deleteTask(index);
                                        
                                    }, 5200);


                                }); //evenlistner closing

                              }); //loop closing
                }