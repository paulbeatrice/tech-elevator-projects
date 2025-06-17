const todoList = document.getElementById('todos');

let todos = [];
let pageTitle = '';

function init() {
  pageTitle = 'My Morning Routine';
  todos = [{
      id: 1,
      task: 'Wake up',
      completed: false
    },
    {
      id: 2,
      task: 'Brush Teeth',
      completed: false
    },
    {
      id: 3,
      task: 'Shower',
      completed: false
    },
    {
      id: 4,
      task: 'Get Dressed',
      completed: false
    },
    {
      id: 5,
      task: 'Drive to work',
      completed: false
    },
    {
      id: 6,
      task: 'Work',
      completed: false
    },
    {
      id: 7,
      task: 'Drive home from work',
      completed: false
    },
    {
      id: 8,
      task: 'Dinner',
      completed: false
    },
    {
      id: 9,
      task: 'Brush Teeth',
      completed: false
    },
    {
      id: 10,
      task: 'Go to bed',
      completed: false
    }
  ];
}

function addPageTitle() {
  const heading = document.createElement('h1');  // <h1></h1>
  heading.textContent = pageTitle;               // <h1>My Morning Jacket</h1>
  todoList.appendChild(heading);                 // put it on stage! it's now a child of the div#todos element!
}

function addTodos() {
  const ul = document.createElement('ul');       // ul:  <ul></ul>
  ul.setAttribute('id', 'unorderedListOfStuff'); //      <ul id="unorderedListOfStuff"></ul>
  todos.forEach((todo) => {                      // 
    const li = document.createElement('li');     // li:  <li></li>
    li.textContent = todo.task;                  //      <li>Go to bed</li>
    ul.appendChild(li);                          // <ul><li>Go to bed</li></ul>
  });
  todoList.appendChild(ul);                      // FINALLY add the ul (with 10 li children) to the DOM
}

// setup our page title and tasks
init();
// add page title to the DOM
addPageTitle();
// add the task to the DOM
addTodos();

function addLater() {
  const ul = document.getElementById('unorderedListOfStuff');
  const newItem = document.createElement('li');
  newItem.textContent = 'Make a To-Do List!';
  ul.prepend(newItem);
}

setTimeout(addLater, 5000);
