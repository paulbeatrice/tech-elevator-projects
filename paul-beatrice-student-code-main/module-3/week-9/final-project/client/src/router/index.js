import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import LogoutView from '../views/LogoutView.vue'
import RegisterView from '../views/RegisterView.vue'
import AdminDashboard from '../views/AdminDashboard.vue'
import ContactLeadsView from '../views/ContactLeadsView.vue'


/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      meta: {
        requiresAuth: false //set this to false to allow public access to Home Page
      }
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: LogoutView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: RegisterView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/admindashboard",
      name: 'AdminDashboard',
      component: AdminDashboard,
      meta: {
        requiresAuth: true,
        requiredRole: 'ROLE_ADMIN'
      },
      children: [
        {
          path: 'users',
          name: 'ManageUsers',
          component: () => import('../views/ManageUsersView.vue'),
          meta: { requiresAuth: true, requiredRole: 'ROLE_ADMIN' }
        },
        {
          path: 'orders',
          name: 'ManageOrders',
          component: () => import('../views/ManageOrdersView.vue'),
          meta: { requiresAuth: true, requiredRole: 'ROLE_ADMIN' }
        },
        {
          path: 'packages',
          name: 'SeoPackages',
          component: () => import('../views/SeoPackagesView.vue'),
          meta: { requiresAuth: true, requiredRole: 'ROLE_ADMIN' }
        },
        {
          path: 'contact-submissions',
          name: 'ContactLeads',
          component: () => import('../views/ContactLeadsView.vue'),
          meta: { requiresAuth: true, requiredRole: 'ROLE_ADMIN' }
        },
        {
          path: 'report',
          name: 'GenerateReport',
          component: () => import('../views/GenerateReportView.vue'),
          meta: { requiresAuth: true, requiredRole: 'ROLE_ADMIN' }
        }
      ]
    },
  ];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const requiredRole = to.matched.find(x => x.meta.requiredRole)?.meta.requiredRole;

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }

  if (requiredRole && store.state.user?.role !== requiredRole) {
    return { name: 'login'};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
