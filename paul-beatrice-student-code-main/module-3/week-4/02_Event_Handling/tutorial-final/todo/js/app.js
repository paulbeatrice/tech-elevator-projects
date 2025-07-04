const todoList = document.getElementById('todos');

let todos = [];
let pageTitle = '';

function init() {
  pageTitle = 'My Morning Routine';
  todos = [
    { id: 1, task: 'Wake up', completed: false },
    { id: 2, task: 'Brush Teeth', completed: false },
    { id: 3, task: 'Shower', completed: false },
    { id: 4, task: 'Get Dressed', completed: false },
    { id: 5, task: 'Drive to work', completed: false },
    { id: 6, task: 'Work', completed: false },
    { id: 7, task: 'Drive home from work', completed: false },
    { id: 8, task: 'Dinner', completed: false },
    { id: 9, task: 'Brush Teeth', completed: false },
    { id: 10, task: 'Go to bed', completed: false }
  ];
}

function addPageTitle() {
  const heading = document.createElement('h1');     // <h1></h1>
  heading.textContent = pageTitle;                  // <h1>My-Mourning-Routine</h1>
  todoList.appendChild(heading);                    // <div id = "todos"><h1>My-Morning-Routine</h1>
}

function addTodos() {
  const ul = document.createElement('ul');  // <ul></ul>
  todos.forEach((todo) => {
    const li = document.createElement('li');  // <li></li>
    li.textContent = todo.task;               //<li>Put on a little makeup</li>
    const checkCircle = document.createElement('i'); // <i></i>
    checkCircle.setAttribute('class', 'far fa-check-circle');  // <i class =" far fa-check-circle"></li>
    li.appendChild(checkCircle);          // <li> Shower <i class =" far fa-check-circle"></li>
    ul.appendChild(li);                 //<ul><li> task <i></i></li></ul>
  });
  todoList.appendChild(ul);    //<div><h1></h1><ul> ... 10x<li>task <i></i></li></ul></div>
}

/*
 * When the DOM is fully loaded into a browser, the browser itself will trigger an event called
 * DOMContentLoaded on the document object. What you need to do is add all of your event listeners inside
 * of an anonymous function that only runs once the DOMContentLoaded event is fired.
 * 
 */
//                                 name of event  function        
//          document.addEventListener('String', () => {});

//          document.addEventListener('');


document.addEventListener('DOMContentLoaded', () => {
  init();
  addPageTitle();
  addTodos();

  const tasks = document.querySelectorAll('li');

  tasks.forEach((task) => {
    // when you click on a task mark it completed
    task.addEventListener('click', () => {
      if (!task.classList.contains('completed')) {
        task.classList.add('completed');
        task.querySelector('i').classList.add('completed');
      }
    });

    // when you double click a task remove the completed class
    task.addEventListener('dblclick', () => {
      if (task.classList.contains('completed')) {
        task.classList.remove('completed');
        task.querySelector('i').classList.remove('completed');
      }
    });
  });

  // mark all tasks as completed
  const completeAll = document.getElementById('btnCompleteAll');
  completeAll.addEventListener('click', () => {
    tasks.forEach((task) => {
      task.classList.add('completed');
      task.querySelector('i').classList.add('completed');
    });
  });
});
