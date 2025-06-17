const todoList = document.getElementById('todos');

let todos = [];
let pageTitle = '';
let markAllComplete = true;

function init() {
  pageTitle = 'My Morning Routine';
  todos = 
  [
    { id: 1, task: 'Wake up', completed: true },
    { id: 2, task: 'Grab A Brush', completed: false },
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
  const heading = document.createElement('h1');  // <h1></h1>
  heading.textContent = pageTitle;               // <h1>My Morning Routine</h1>
  todoList.appendChild(heading);                 // <div id="todos"><h1>My Morning Routing</h1></div>
}

function addTodos() {
  const ul = document.createElement('ul');  // <ul></ul>
  todos.forEach((todo) => {
    const li = document.createElement('li'); // <li></li>
    li.textContent = todo.task;              // <li>Put on a little makeup</li>
    const checkCircle = document.createElement('i'); // <i></i>
    checkCircle.setAttribute('class', 'far fa-check-circle'); // <i class="far fa-check-circle"></i>
    li.appendChild(checkCircle); // <li> Shower <i class="far fa-check-circle"></i></li>
    ul.appendChild(li); // <ul><li> task <i></i></li></ul>
  });
  todoList.appendChild(ul); // <div><h1></h1><ul> ... 10x<li>task <i></i></li></ul></div>
}

/*
 * When the DOM is fully loaded into a browser, the browser itself will trigger an event called
 * DOMContentLoaded on the document object. What you need to do is add all of your event listeners inside
 * of an anonymous function that only runs once the DOMContentLoaded event is fired.
 */

//                    name of event    function
//document.addEventListener('string', () => {});



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
  completeAll.addEventListener('click', (event) => {

    event.preventDefault(); // prevent navigating away. USE ON A TAGS AND SUBMIT BUTTONS

    if (markAllComplete) {
      tasks.forEach((task) => {
        task.classList.add('completed');
        task.querySelector('i').classList.add('completed');
      });
      completeAll.textContent = 'MARK ALL INCOMPLETE';
      markAllComplete = false;
    } else {
      tasks.forEach((task) => {
        task.classList.remove('completed');
        task.querySelector('i').classList.remove('completed');
      });
      completeAll.textContent = 'MARK ALL COMPLETE';
      markAllComplete = true;
    }

  });


  // Tom playing around
  document.addEventListener('click', (event) => {
    console.log(`User clicked: (${event.x}, ${event.y})`);
    console.log('Clicked on document');
  });

  document.addEventListener('keyup', (event) => {
    console.log(`User typed: ${event.key}`);
  });

  // Event Propagation
  document.querySelector('i').addEventListener('click', () => {
    console.log('Clicked on i');
  });

  document.querySelector('li').addEventListener('click', () => {
    console.log('Clicked on first li');
  });

  document.getElementById('todos').addEventListener('click', (event) => {
    event.stopPropagation(); // DON'T TELL MY PARENTS!
    console.log('Clicked on div#todos');
  });

  document.querySelector('body').addEventListener('click', () => {
    console.log('Clicked on body');
  });

  document.querySelector('html').addEventListener('click', () => {
    console.log('Clicked on html');
  });


});
