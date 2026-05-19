

     loadTasks();

                // Adding tasks to the backend
        function addTask(){

            const inputElement = document.querySelector(".js-input-task"); 
            const value = inputElement.value.trim();

            if(value === ''){
                alert("ENTER A VALID INPUT");
                return;
            }

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
        }).then(res => res.json())
            .then(data => {loadTasks()});

            inputElement.value = '';
            
        }

        // Get the tasks from the backend
        
        function loadTasks(){
            fetch("http://localhost:8080/tasks")
                .then(res => res.json())
                .then(tasks => {
                    let displayHTML = '';

                    tasks.forEach((task) =>  {
                        
                        let rowClass = "";
                        if(task.completed === true){
                        rowClass = "completed-task";
                        } 
                        
                        let taskHTML = `
                        <div class="css-task-row ${rowClass} js-task-row-${task.id}">

                        <p class="css-task-name">${task.title}</p>

                        <div class="css-button-grp">

                            <button class="css-green-tick-buttn js-green-tick-buttn" title="Completed" onclick="
                                completeTask(${task.id}, this);
                            ">
                                <img class="css-green-tick-img" src="Images/Green-tick/pngtree-green-check-mark-png-image_6525691.png">
                            </button>

                            <button class="css-delete-button" onclick="
                                deleteTask(${task.id});
                            ">Delete</button> 

                        </div>

                        </div>`;
                        displayHTML += taskHTML;
                    });

                    document.querySelector('.js-display-task')
                        .innerHTML = displayHTML;

                    // for green-tick button animation && deleting task

                    });//.then() closing
                }//function closing

        function deleteTask(id){
            fetch(`http://localhost:8080/tasks/${id}`, {
                method: "DELETE",
        }).then(response => {loadTasks()});
        }

        function completeTask(id, button){
            button.classList.add("rotate-success");

            fetch(`http://localhost:8080/tasks/${id}`,{
                method: "PUT"
            }).then(res => res.json())
              .then(data => {
                    setTimeout(() => {
                    button.classList.remove("rotate-success");
                    loadTasks();
                }, 700);
              })
        }