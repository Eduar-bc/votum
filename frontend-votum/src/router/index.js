import { createRouter, createWebHistory } from 'vue-router';
import LoginView from '../views/LoginView.vue';
import RegisterView from '../views/RegisterView.vue';
import HomeView from '../views/HomeView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: { requiresAuth: true }  // ← Requiere estar logueado
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView,
    meta: { guest: true }  // ← Solo para usuarios NO logueados
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView,
    meta: { guest: true }  // ← Solo para usuarios NO logueados
  },
  // Ruta 404 (opcional pero recomendado)
  {
    path: '/:pathMatch(.*)*',
    name: 'not-found',
    redirect: '/'
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

// 🔒 NAVIGATION GUARD - Protege las rutas
router.beforeEach((to, from, next) => {
  // Verifica si hay token en localStorage
  const token = localStorage.getItem('token');
  const isAuthenticated = !!token;

  // Si la ruta requiere autenticación y NO está logueado
  if (to.meta.requiresAuth && !isAuthenticated) {
    console.log('⛔ Acceso denegado. Redirigiendo a /login');
    next('/login');
  }
  // Si la ruta es para invitados (login/register) y YA está logueado
  else if (to.meta.guest && isAuthenticated) {
    console.log('✅ Ya estás logueado. Redirigiendo a Home');
    next('/');
  }
  // En cualquier otro caso, permite el acceso
  else {
    next();
  }
});

export default router;
