<template>
  <div class="home-container">
    <nav class="navbar">
      <div class="navbar-content">
        <h2 class="logo">Votum</h2>
        <button @click="handleLogout" class="btn-logout">
          Cerrar Sesión
        </button>
      </div>
    </nav>

    <main class="main-content">
      <div class="welcome-card">
        <h1 class="welcome-title">¡Bienvenido a Votum! 🎉</h1>
        <p class="welcome-text">
          Has iniciado sesión exitosamente en el sistema de votación electrónica.
        </p>

        <div class="info-grid">
          <div class="info-card">
            <div class="info-icon">📊</div>
            <h3>Votaciones Activas</h3>
            <p class="info-number">0</p>
          </div>

          <div class="info-card">
            <div class="info-icon">✅</div>
            <h3>Votos Realizados</h3>
            <p class="info-number">0</p>
          </div>

          <div class="info-card">
            <div class="info-icon">📅</div>
            <h3>Próximas Votaciones</h3>
            <p class="info-number">0</p>
          </div>
        </div>

        <!-- Sección de Creador -->
        <div class="creator-section">
          <div v-if="!isCreator()" class="creator-card">
            <div class="creator-icon">🎯</div>
            <h3>¿Quieres crear elecciones?</h3>
            <p>Conviértete en creador y gestiona tus propias votaciones</p>
            <button
              @click="handleBecomeCreator"
              :disabled="loading"
              class="btn-creator"
            >
              {{ loading ? "Procesando..." : "Convertirme en creador" }}
            </button>
          </div>
          <div v-else class="creator-active">
            <p class="creator-status">✅ Ya eres creador de elecciones</p>
            <button @click="goToCreatorPanel" class="btn-panel">
              Ir al panel de creador
            </button>
          </div>
        </div>

        <p class="coming-soon">
          Próximamente: Módulos de votación, resultados en tiempo real y más...
        </p>
      </div>
    </main>
  </div>
</template>

<script>
import { useRouter } from 'vue-router';
import { ref } from 'vue';
import { isCreator } from '@/utils/auth';
import { becomeCreator } from '@/services/userService';

export default {
  name: 'HomeView',
  setup() {
    const router = useRouter();
    const loading = ref(false);
    const message = ref('');

    const handleLogout = () => {
      // Limpiar TODOS los datos de localStorage
      localStorage.clear();
      console.log('🔓 Sesión cerrada');
      // Redirigir al login
      router.push('/login');
    };

    const handleBecomeCreator = async () => {
      loading.value = true;
      try {
        message.value = await becomeCreator();
        alert(message.value);
        router.push('/panel-creador');
      } catch (err) {
        console.error('Error al convertirse en creador:', err);
        alert(err.message || 'Error al procesar la solicitud');
      } finally {
        loading.value = false;
      }
    };

    const goToCreatorPanel = () => {
      router.push('/panel-creador');
    };

    return {
      handleLogout,
      handleBecomeCreator,
      goToCreatorPanel,
      isCreator,
      loading,
    };
  },
};
</script>

<style scoped>
.home-container {
  min-height: 100vh;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

.navbar {
  background: rgba(255, 255, 255, 0.95);
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  padding: 1rem 0;
}

.navbar-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 1.5rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  font-size: 1.5rem;
  font-weight: bold;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.btn-logout {
  padding: 0.625rem 1.25rem;
  background: #f56565;
  color: white;
  border: none;
  border-radius: 0.5rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;
}

.btn-logout:hover {
  background: #e53e3e;
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(245, 101, 101, 0.4);
}

.main-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 3rem 1.5rem;
}

.welcome-card {
  background: white;
  border-radius: 1rem;
  padding: 3rem;
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.1);
}

.welcome-title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #1a202c;
  margin-bottom: 1rem;
  text-align: center;
}

.welcome-text {
  color: #718096;
  text-align: center;
  font-size: 1.125rem;
  margin-bottom: 3rem;
}

.info-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1.5rem;
  margin-bottom: 3rem;
}

.info-card {
  background: linear-gradient(135deg, #667eea15 0%, #764ba215 100%);
  border-radius: 0.75rem;
  padding: 2rem;
  text-align: center;
  transition: transform 0.2s;
}

.info-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 20px rgba(102, 126, 234, 0.2);
}

.info-icon {
  font-size: 3rem;
  margin-bottom: 1rem;
}

.info-card h3 {
  color: #2d3748;
  font-size: 1rem;
  margin-bottom: 0.5rem;
  font-weight: 600;
}

.info-number {
  font-size: 2.5rem;
  font-weight: bold;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

/* Estilos para la sección de creador */
.creator-section {
  margin-bottom: 3rem;
}

.creator-card {
  background: linear-gradient(135deg, #48bb78 0%, #38a169 100%);
  border-radius: 0.75rem;
  padding: 2rem;
  text-align: center;
  color: white;
}

.creator-icon {
  font-size: 3rem;
  margin-bottom: 1rem;
}

.creator-card h3 {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
  font-weight: 600;
}

.creator-card p {
  margin-bottom: 1.5rem;
  opacity: 0.9;
}

.btn-creator {
  padding: 0.75rem 2rem;
  background: white;
  color: #38a169;
  border: none;
  border-radius: 0.5rem;
  font-weight: 600;
  font-size: 1rem;
  cursor: pointer;
  transition: all 0.2s;
}

.btn-creator:hover:not(:disabled) {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
}

.btn-creator:disabled {
  opacity: 0.7;
  cursor: not-allowed;
}

.creator-active {
  background: linear-gradient(135deg, #667eea15 0%, #764ba215 100%);
  border: 2px solid #48bb78;
  border-radius: 0.75rem;
  padding: 2rem;
  text-align: center;
}

.creator-status {
  color: #38a169;
  font-size: 1.125rem;
  font-weight: 600;
  margin-bottom: 1rem;
}

.btn-panel {
  padding: 0.75rem 2rem;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  border: none;
  border-radius: 0.5rem;
  font-weight: 600;
  font-size: 1rem;
  cursor: pointer;
  transition: all 0.2s;
}

.btn-panel:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(102, 126, 234, 0.4);
}

.coming-soon {
  text-align: center;
  color: #a0aec0;
  font-style: italic;
  padding: 1.5rem;
  background: #f7fafc;
  border-radius: 0.5rem;
}

@media (max-width: 768px) {
  .welcome-card {
    padding: 2rem 1.5rem;
  }

  .welcome-title {
    font-size: 1.875rem;
  }

  .info-grid {
    grid-template-columns: 1fr;
  }

  .creator-card, .creator-active {
    padding: 1.5rem;
  }
}
</style>
