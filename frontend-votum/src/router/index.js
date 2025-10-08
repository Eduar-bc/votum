import { createRouter, createWebHistory } from 'vue-router';
import { isCreator } from '@/utils/auth';
import LoginView from '../views/LoginView.vue';
import RegisterView from '../views/RegisterView.vue';
import HomeView from '../views/HomeView.vue';
import CreatorPanel from '../views/CreatorPanel.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: { requiresAuth: true }
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView,
    meta: { guest: true }
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView,
    meta: { guest: true }
  },
  {
    path: '/panel-creador',
    name: 'creator-panel',
    component: CreatorPanel,
    meta: { requiresAuth: true, requiresCreator: true }
  },
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
  const token = localStorage.getItem('token');
  const isAuthenticated = !!token;

  // 1. Verificar autenticación básica
  if (to.meta.requiresAuth && !isAuthenticated) {
    console.log('⛔ Acceso denegado. Redirigiendo a /login');
    return next('/login');
  }

  // 2. Redirigir usuarios autenticados fuera de login/register
  if (to.meta.guest && isAuthenticated) {
    console.log('✅ Ya estás logueado. Redirigiendo a Home');
    return next('/');
  }

  // 3. Verificar si requiere ser creador
  if (to.meta.requiresCreator && !isCreator()) {
    console.log('⛔ No tienes permisos de creador');
    alert('No tienes permisos para acceder a esta sección.');
    return next('/');
  }

  // 4. Permitir acceso
  next();
});

export default router;
