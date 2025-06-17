import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import AboutVue from '../views/AboutView.vue';
import DisplaySingleItem from '../views/SingleItemView.vue';

const routes = 
[
  {
    path: '/',
    name: 'homepage',
    component: HomeView
  },
  {
    path: '/about',
    name: 'cantCodeWithoutChatGPT',
    component: AboutVue
  },
  {
    path: '/items/:id',
    name: 'singleItem',
    component: DisplaySingleItem
  }

];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
