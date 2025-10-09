<template>
  <div class="dashboard">
    <!-- Sidebar -->
    <aside class="sidebar" :class="{ 'sidebar-open': sidebarOpen }">
      <div class="sidebar-header">
        <div class="logo-section">
          <div class="logo-icon">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M12 2L2 7L12 12L22 7L12 2Z"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M2 17L12 22L22 17"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M2 12L12 17L22 12"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <h1 class="brand-name">Votum</h1>
        </div>
      </div>

      <nav class="sidebar-nav">
        <a href="#" class="nav-item active">
          <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M3 9L12 2L21 9V20C21 20.5304 20.7893 21.0391 20.4142 21.4142C20.0391 21.7893 19.5304 22 19 22H5C4.46957 22 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H16"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          <span>Dashboard</span>
        </a>
        <a href="#" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M9 11L12 14L22 4M21 12V19C21 19.5304 20.7893 20.0391 20.4142 20.4142C20.0391 20.7893 19.5304 21 19 21H5C4.46957 21 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H16"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          <span>Votaciones</span>
        </a>
        <a href="#" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M12 8V12L15 15M21 12C21 16.9706 16.9706 21 12 21C7.02944 21 3 16.9706 3 12C3 7.02944 7.02944 3 12 3C16.9706 3 21 7.02944 21 12Z"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          <span>Historial</span>
        </a>
        <a href="#" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M12 2L2 7L12 12L22 7L12 2Z"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M2 17L12 22L22 17"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M2 12L12 17L22 12"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          <span>Blockchain</span>
        </a>
        <a href="#" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M12 15C15.866 15 19 11.866 19 8C19 4.13401 15.866 1 12 1C8.13401 1 5 4.13401 5 8C5 11.866 8.13401 15 12 15Z"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
            <path
              d="M8.21 13.89L7 23L12 20L17 23L15.79 13.88"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          <span>Perfil</span>
        </a>
      </nav>

      <div class="sidebar-footer">
        <div v-if="!isCreator()" class="creator-section">
          <button @click="handleBecomeCreator" :disabled="loading" class="creator-btn">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M12 5V19M5 12H19"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
            <span>{{ loading ? 'Procesando...' : 'Ser creador' }}</span>
          </button>
        </div>
        <div v-else class="creator-section">
          <button @click="goToCreatorPanel" class="creator-active-btn">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M22 11.08V12C21.9988 14.1564 21.3005 16.2547 20.0093 17.9818C18.7182 19.7088 16.9033 20.9725 14.8354 21.5839C12.7674 22.1953 10.5573 22.1219 8.53447 21.3746C6.51168 20.6273 4.78465 19.2461 3.61096 17.4371C2.43727 15.628 1.87979 13.4881 2.02168 11.3363C2.16356 9.18455 2.99721 7.13631 4.39828 5.49706C5.79935 3.85781 7.69279 2.71537 9.79619 2.24013C11.8996 1.7649 14.1003 1.98232 16.07 2.85999"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M22 4L12 14.01L9 11.01"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
            <span>Panel creador</span>
          </button>
        </div>

        <button @click="handleLogout" class="logout-btn">
          <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M9 21H5C4.46957 21 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H9M16 17L21 12M21 12L16 7M21 12H9"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          <span>Cerrar Sesión</span>
        </button>
      </div>
    </aside>

    <!-- Main Content -->
    <main class="main-content">
      <!-- Header -->
      <header class="header">
        <button @click="toggleSidebar" class="menu-btn">
          <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M3 12H21M3 6H21M3 18H21"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
        </button>
        <div class="header-content">
          <div>
            <h2 class="header-title">Bienvenido, {{ userName }}</h2>
            <p class="header-subtitle">Gestiona tus votaciones de forma segura</p>
          </div>
          <div class="header-actions">
            <button class="icon-btn">
              <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M18 8C18 6.4087 17.3679 4.88258 16.2426 3.75736C15.1174 2.63214 13.5913 2 12 2C10.4087 2 8.88258 2.63214 7.75736 3.75736C6.63214 4.88258 6 6.4087 6 8C6 15 3 17 3 17H21C21 17 18 15 18 8Z"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
                <path
                  d="M13.73 21C13.5542 21.3031 13.3019 21.5547 12.9982 21.7295C12.6946 21.9044 12.3504 21.9965 12 21.9965C11.6496 21.9965 11.3054 21.9044 11.0018 21.7295C10.6982 21.5547 10.4458 21.3031 10.27 21"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
              <span class="notification-badge">3</span>
            </button>
            <div class="user-avatar">
              <span>{{ userInitials }}</span>
            </div>
          </div>
        </div>
      </header>

      <!-- Stats Grid -->
      <div class="stats-grid">
        <div class="stat-card">
          <div class="stat-icon stat-icon-blue">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M9 11L12 14L22 4M21 12V19C21 19.5304 20.7893 20.0391 20.4142 20.4142C20.0391 20.7893 19.5304 21 19 21H5C4.46957 21 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H16"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <div class="stat-content">
            <p class="stat-label">Votaciones Activas</p>
            <p class="stat-value">{{ stats.activeVotes }}</p>
            <p class="stat-change positive">+2 esta semana</p>
          </div>
        </div>

        <div class="stat-card">
          <div class="stat-icon stat-icon-green">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M22 11.08V12C21.9988 14.1564 21.3005 16.2547 20.0093 17.9818C18.7182 19.7088 16.9033 20.9725 14.8354 21.5839C12.7674 22.1953 10.5573 22.1219 8.53447 21.3746C6.51168 20.6273 4.78465 19.2461 3.61096 17.4371C2.43727 15.628 1.87979 13.4881 2.02168 11.3363C2.16356 9.18455 2.99721 7.13631 4.39828 5.49706C5.79935 3.85781 7.69279 2.71537 9.79619 2.24013C11.8996 1.7649 14.1003 1.98232 16.07 2.85999"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M22 4L12 14.01L9 11.01"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <div class="stat-content">
            <p class="stat-label">Votos Emitidos</p>
            <p class="stat-value">{{ stats.totalVotes }}</p>
            <p class="stat-change positive">+12 hoy</p>
          </div>
        </div>

        <div class="stat-card">
          <div class="stat-icon stat-icon-purple">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M12 2L2 7L12 12L22 7L12 2Z"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M2 17L12 22L22 17"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M2 12L12 17L22 12"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <div class="stat-content">
            <p class="stat-label">Bloques Verificados</p>
            <p class="stat-value">{{ stats.blocksVerified }}</p>
            <p class="stat-change neutral">Actualizado hace 2m</p>
          </div>
        </div>

        <div class="stat-card">
          <div class="stat-icon stat-icon-orange">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M17 21V19C17 17.9391 16.5786 16.9217 15.8284 16.1716C15.0783 15.4214 14.0609 15 13 15H5C3.93913 15 2.92172 15.4214 2.17157 16.1716C1.42143 16.9217 1 17.9391 1 19V21M23 21V19C22.9993 18.1137 22.7044 17.2528 22.1614 16.5523C21.6184 15.8519 20.8581 15.3516 20 15.13M16 3.13C16.8604 3.3503 17.623 3.8507 18.1676 4.55231C18.7122 5.25392 19.0078 6.11683 19.0078 7.005C19.0078 7.89317 18.7122 8.75608 18.1676 9.45769C17.623 10.1593 16.8604 10.6597 16 10.88M13 7C13 9.20914 11.2091 11 9 11C6.79086 11 5 9.20914 5 7C5 4.79086 6.79086 3 9 3C11.2091 3 13 4.79086 13 7Z"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
          <div class="stat-content">
            <p class="stat-label">Participantes</p>
            <p class="stat-value">{{ stats.participants }}</p>
            <p class="stat-change positive">+8% vs mes anterior</p>
          </div>
        </div>
      </div>

      <!-- Active Votes Section -->
      <section class="section">
        <div class="section-header">
          <h3 class="section-title">Votaciones Activas</h3>
          <button class="btn-secondary">Ver todas</button>
        </div>
        <div class="votes-grid">
          <div v-for="vote in activeVotes" :key="vote.id" class="vote-card">
            <div class="vote-header">
              <div class="vote-badge" :class="`badge-${vote.status}`">{{ vote.status }}</div>
              <span class="vote-time">{{ vote.timeLeft }}</span>
            </div>
            <h4 class="vote-title">{{ vote.title }}</h4>
            <p class="vote-description">{{ vote.description }}</p>
            <div class="vote-stats">
              <div class="vote-stat">
                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M17 21V19C17 17.9391 16.5786 16.9217 15.8284 16.1716C15.0783 15.4214 14.0609 15 13 15H5C3.93913 15 2.92172 15.4214 2.17157 16.1716C1.42143 16.9217 1 17.9391 1 19V21M23 21V19C22.9993 18.1137 22.7044 17.2528 22.1614 16.5523C21.6184 15.8519 20.8581 15.3516 20 15.13M16 3.13C16.8604 3.3503 17.623 3.8507 18.1676 4.55231C18.7122 5.25392 19.0078 6.11683 19.0078 7.005C19.0078 7.89317 18.7122 8.75608 18.1676 9.45769C17.623 10.1593 16.8604 10.6597 16 10.88M13 7C13 9.20914 11.2091 11 9 11C6.79086 11 5 9.20914 5 7C5 4.79086 6.79086 3 9 3C11.2091 3 13 4.79086 13 7Z"
                    stroke="currentColor"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
                <span>{{ vote.voters }} votantes</span>
              </div>
              <div class="vote-stat">
                <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M9 11L12 14L22 4M21 12V19C21 19.5304 20.7893 20.0391 20.4142 20.4142C20.0391 20.7893 19.5304 21 19 21H5C4.46957 21 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H16"
                    stroke="currentColor"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
                <span>{{ vote.options }} opciones</span>
              </div>
            </div>
            <button @click="handleVote(vote.id)" class="btn-vote">Votar Ahora</button>
          </div>
        </div>
      </section>

      <!-- Recent Activity -->
      <section class="section">
        <div class="section-header">
          <h3 class="section-title">Actividad Reciente</h3>
        </div>
        <div class="activity-list">
          <div v-for="activity in recentActivity" :key="activity.id" class="activity-item">
            <div class="activity-icon" :class="`activity-${activity.type}`">
              <svg
                v-if="activity.type === 'vote'"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M9 11L12 14L22 4M21 12V19C21 19.5304 20.7893 20.0391 20.4142 20.4142C20.0391 20.7893 19.5304 21 19 21H5C4.46957 21 3.96086 20.7893 3.58579 20.4142C3.21071 20.0391 3 19.5304 3 19V5C3 4.46957 3.21071 3.96086 3.58579 3.58579C3.96086 3.21071 4.46957 3 5 3H16"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
              <svg
                v-else-if="activity.type === 'block'"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M12 2L2 7L12 12L22 7L12 2Z"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
                <path
                  d="M2 17L12 22L22 17"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
              <svg v-else viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M12 8V12L15 15M21 12C21 16.9706 16.9706 21 12 21C7.02944 21 3 16.9706 3 12C3 7.02944 7.02944 3 12 3C16.9706 3 21 7.02944 21 12Z"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
            </div>
            <div class="activity-content">
              <p class="activity-title">{{ activity.title }}</p>
              <p class="activity-time">{{ activity.time }}</p>
            </div>
            <div class="activity-badge" :class="`badge-${activity.status}`">
              {{ activity.status }}
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import { isCreator } from '@/utils/auth'
import { becomeCreator } from '@/services/userService'

export default {
  name: 'DashboardView',
  setup() {
    const router = useRouter()
    const sidebarOpen = ref(false)
    const userName = ref('Usuario')
    const loading = ref(false)

    const stats = ref({
      activeVotes: 5,
      totalVotes: 1247,
      blocksVerified: 8934,
      participants: 3521,
    })

    const activeVotes = ref([
      {
        id: 1,
        title: 'Elección de Representante Estudiantil 2025',
        description:
          'Vota por el candidato que mejor represente tus intereses en el consejo estudiantil.',
        status: 'activa',
        timeLeft: 'Termina en 2 días',
        voters: 342,
        options: 4,
      },
      {
        id: 2,
        title: 'Presupuesto Anual de Actividades',
        description:
          'Decide cómo se distribuirá el presupuesto para las actividades del próximo año.',
        status: 'activa',
        timeLeft: 'Termina en 5 días',
        voters: 189,
        options: 3,
      },
      {
        id: 3,
        title: 'Reforma del Reglamento Interno',
        description: 'Aprueba o rechaza las modificaciones propuestas al reglamento interno.',
        status: 'activa',
        timeLeft: 'Termina en 1 semana',
        voters: 256,
        options: 2,
      },
    ])

    const recentActivity = ref([
      {
        id: 1,
        type: 'vote',
        title: 'Has votado en "Elección de Delegado de Curso"',
        time: 'Hace 2 horas',
        status: 'verificado',
      },
      {
        id: 2,
        type: 'block',
        title: 'Nuevo bloque verificado #8934',
        time: 'Hace 3 horas',
        status: 'confirmado',
      },
      {
        id: 3,
        type: 'vote',
        title: 'Nueva votación disponible: "Presupuesto Anual"',
        time: 'Hace 5 horas',
        status: 'pendiente',
      },
      {
        id: 4,
        type: 'block',
        title: 'Tu voto fue incluido en el bloque #8932',
        time: 'Hace 1 día',
        status: 'verificado',
      },
    ])

    const userInitials = computed(() => {
      return userName.value
        .split(' ')
        .map((n) => n[0])
        .join('')
        .toUpperCase()
    })

    const toggleSidebar = () => {
      sidebarOpen.value = !sidebarOpen.value
    }

    const handleLogout = () => {
      localStorage.clear()
      console.log('[v0] Sesión cerrada')
      router.push('/login')
    }

    const handleBecomeCreator = async () => {
      loading.value = true
      try {
        const message = await becomeCreator()
        alert(message)
        router.push('/creator-panel')
      } catch (err) {
        console.error('[v0] Error al convertirse en creador:', err)
        alert(err.message || 'Error al procesar la solicitud')
      } finally {
        loading.value = false
      }
    }

    const goToCreatorPanel = () => {
      router.push('/creator-panel')
    }

    const handleVote = (voteId) => {
      console.log('[v0] Navegando a votación:', voteId)
      router.push(`/votacion/${voteId}`)
    }

    return {
      sidebarOpen,
      userName,
      userInitials,
      stats,
      activeVotes,
      recentActivity,
      loading,
      toggleSidebar,
      handleLogout,
      handleBecomeCreator,
      goToCreatorPanel,
      handleVote,
      isCreator,
    }
  },
}
</script>

<style scoped>
.dashboard {
  display: flex;
  min-height: 100vh;
  background: #0a0a0a;
}

/* Sidebar */
.sidebar {
  width: 280px;
  background: #141414;
  border-right: 1px solid #262626;
  display: flex;
  flex-direction: column;
  position: fixed;
  height: 100vh;
  left: 0;
  top: 0;
  z-index: 100;
  transition: transform 0.3s ease;
}

.sidebar-header {
  padding: 2rem 1.5rem;
  border-bottom: 1px solid #262626;
}

.logo-section {
  display: flex;
  align-items: center;
  gap: 0.75rem;
}

.logo-icon {
  width: 40px;
  height: 40px;
  background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
}

.logo-icon svg {
  width: 24px;
  height: 24px;
}

.brand-name {
  font-size: 1.5rem;
  font-weight: 700;
  color: #ffffff;
  margin: 0;
}

.sidebar-nav {
  flex: 1;
  padding: 1.5rem 1rem;
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  overflow-y: auto;
}

.nav-item {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  padding: 0.875rem 1rem;
  color: #a3a3a3;
  text-decoration: none;
  border-radius: 0.75rem;
  font-size: 0.9375rem;
  font-weight: 500;
  transition: all 0.2s;
}

.nav-item svg {
  width: 20px;
  height: 20px;
  flex-shrink: 0;
}

.nav-item:hover {
  background: #1a1a1a;
  color: #ffffff;
}

.nav-item.active {
  background: linear-gradient(135deg, rgba(59, 130, 246, 0.15) 0%, rgba(37, 99, 235, 0.15) 100%);
  color: #3b82f6;
}

.sidebar-footer {
  padding: 1.5rem 1rem;
  border-top: 1px solid #262626;
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.logout-btn {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  width: 100%;
  padding: 0.875rem 1rem;
  background: transparent;
  border: 1px solid #262626;
  border-radius: 0.75rem;
  color: #a3a3a3;
  font-size: 0.9375rem;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;
}

.logout-btn svg {
  width: 20px;
  height: 20px;
}

.logout-btn:hover {
  background: #1a1a1a;
  border-color: #ef4444;
  color: #ef4444;
}

/* Main Content */
.main-content {
  flex: 1;
  margin-left: 280px;
  background: #0a0a0a;
}

/* Header */
.header {
  background: #141414;
  border-bottom: 1px solid #262626;
  padding: 1.5rem 2rem;
  position: sticky;
  top: 0;
  z-index: 50;
}

.menu-btn {
  display: none;
  padding: 0.5rem;
  background: transparent;
  border: none;
  color: #a3a3a3;
  cursor: pointer;
  margin-right: 1rem;
}

.menu-btn svg {
  width: 24px;
  height: 24px;
}

.header-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.header-title {
  font-size: 1.5rem;
  font-weight: 700;
  color: #ffffff;
  margin: 0 0 0.25rem 0;
}

.header-subtitle {
  font-size: 0.875rem;
  color: #a3a3a3;
  margin: 0;
}

.header-actions {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.icon-btn {
  position: relative;
  padding: 0.625rem;
  background: #1a1a1a;
  border: 1px solid #262626;
  border-radius: 0.75rem;
  color: #a3a3a3;
  cursor: pointer;
  transition: all 0.2s;
}

.icon-btn svg {
  width: 20px;
  height: 20px;
  display: block;
}

.icon-btn:hover {
  background: #262626;
  color: #ffffff;
}

.notification-badge {
  position: absolute;
  top: -4px;
  right: -4px;
  width: 18px;
  height: 18px;
  background: #ef4444;
  color: #ffffff;
  font-size: 0.625rem;
  font-weight: 700;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.user-avatar {
  width: 40px;
  height: 40px;
  background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #ffffff;
  font-weight: 600;
  font-size: 0.875rem;
}

/* Stats Grid */
.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 1.5rem;
  padding: 2rem;
}

.stat-card {
  background: #141414;
  border: 1px solid #262626;
  border-radius: 1rem;
  padding: 1.5rem;
  display: flex;
  gap: 1rem;
  transition: all 0.2s;
}

.stat-card:hover {
  border-color: #3b82f6;
  transform: translateY(-2px);
}

.stat-icon {
  width: 48px;
  height: 48px;
  border-radius: 0.75rem;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
}

.stat-icon svg {
  width: 24px;
  height: 24px;
}

.stat-icon-blue {
  background: rgba(59, 130, 246, 0.15);
  color: #3b82f6;
}

.stat-icon-green {
  background: rgba(34, 197, 94, 0.15);
  color: #22c55e;
}

.stat-icon-purple {
  background: rgba(168, 85, 247, 0.15);
  color: #a855f7;
}

.stat-icon-orange {
  background: rgba(249, 115, 22, 0.15);
  color: #f97316;
}

.stat-content {
  flex: 1;
}

.stat-label {
  font-size: 0.875rem;
  color: #a3a3a3;
  margin: 0 0 0.5rem 0;
}

.stat-value {
  font-size: 1.875rem;
  font-weight: 700;
  color: #ffffff;
  margin: 0 0 0.5rem 0;
}

.stat-change {
  font-size: 0.8125rem;
  margin: 0;
}

.stat-change.positive {
  color: #22c55e;
}

.stat-change.neutral {
  color: #a3a3a3;
}

/* Section */
.section {
  padding: 2rem;
}

.section-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 1.5rem;
}

.section-title {
  font-size: 1.25rem;
  font-weight: 700;
  color: #ffffff;
  margin: 0;
}

.btn-secondary {
  padding: 0.625rem 1.25rem;
  background: #1a1a1a;
  border: 1px solid #262626;
  border-radius: 0.75rem;
  color: #a3a3a3;
  font-size: 0.875rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;
}

.btn-secondary:hover {
  background: #262626;
  color: #ffffff;
}

/* Votes Grid */
.votes-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(340px, 1fr));
  gap: 1.5rem;
}

.vote-card {
  background: #141414;
  border: 1px solid #262626;
  border-radius: 1rem;
  padding: 1.5rem;
  transition: all 0.2s;
}

.vote-card:hover {
  border-color: #3b82f6;
  transform: translateY(-4px);
  box-shadow: 0 8px 24px rgba(59, 130, 246, 0.15);
}

.vote-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 1rem;
}

.vote-badge {
  padding: 0.375rem 0.75rem;
  border-radius: 0.5rem;
  font-size: 0.75rem;
  font-weight: 600;
  text-transform: uppercase;
}

.badge-activa {
  background: rgba(34, 197, 94, 0.15);
  color: #22c55e;
}

.vote-time {
  font-size: 0.8125rem;
  color: #a3a3a3;
}

.vote-title {
  font-size: 1.125rem;
  font-weight: 700;
  color: #ffffff;
  margin: 0 0 0.75rem 0;
  line-height: 1.4;
}

.vote-description {
  font-size: 0.875rem;
  color: #a3a3a3;
  line-height: 1.6;
  margin: 0 0 1.25rem 0;
}

.vote-stats {
  display: flex;
  gap: 1.5rem;
  margin-bottom: 1.25rem;
  padding-top: 1rem;
  border-top: 1px solid #262626;
}

.vote-stat {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  font-size: 0.8125rem;
  color: #a3a3a3;
}

.vote-stat svg {
  width: 16px;
  height: 16px;
}

.btn-vote {
  width: 100%;
  padding: 0.875rem;
  background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
  border: none;
  border-radius: 0.75rem;
  color: #ffffff;
  font-size: 0.9375rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;
}

.btn-vote:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 24px rgba(59, 130, 246, 0.3);
}

/* Activity List */
.activity-list {
  background: #141414;
  border: 1px solid #262626;
  border-radius: 1rem;
  overflow: hidden;
}

.activity-item {
  display: flex;
  align-items: center;
  gap: 1rem;
  padding: 1.25rem 1.5rem;
  border-bottom: 1px solid #262626;
  transition: background 0.2s;
}

.activity-item:last-child {
  border-bottom: none;
}

.activity-item:hover {
  background: #1a1a1a;
}

.activity-icon {
  width: 40px;
  height: 40px;
  border-radius: 0.75rem;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
}

.activity-icon svg {
  width: 20px;
  height: 20px;
}

.activity-vote {
  background: rgba(59, 130, 246, 0.15);
  color: #3b82f6;
}

.activity-block {
  background: rgba(168, 85, 247, 0.15);
  color: #a855f7;
}

.activity-content {
  flex: 1;
}

.activity-title {
  font-size: 0.9375rem;
  color: #ffffff;
  margin: 0 0 0.25rem 0;
}

.activity-time {
  font-size: 0.8125rem;
  color: #a3a3a3;
  margin: 0;
}

.activity-badge {
  padding: 0.375rem 0.75rem;
  border-radius: 0.5rem;
  font-size: 0.75rem;
  font-weight: 600;
  text-transform: uppercase;
}

.badge-verificado {
  background: rgba(34, 197, 94, 0.15);
  color: #22c55e;
}

.badge-confirmado {
  background: rgba(59, 130, 246, 0.15);
  color: #3b82f6;
}

.badge-pendiente {
  background: rgba(249, 115, 22, 0.15);
  color: #f97316;
}

/* Responsive */
@media (max-width: 1024px) {
  .sidebar {
    transform: translateX(-100%);
  }

  .sidebar-open {
    transform: translateX(0);
  }

  .main-content {
    margin-left: 0;
  }

  .menu-btn {
    display: block;
  }

  .header {
    display: flex;
    align-items: center;
  }
}

@media (max-width: 768px) {
  .stats-grid {
    grid-template-columns: 1fr;
    padding: 1.5rem;
  }

  .section {
    padding: 1.5rem;
  }

  .votes-grid {
    grid-template-columns: 1fr;
  }

  .header-content {
    flex-direction: column;
    align-items: flex-start;
    gap: 1rem;
  }

  .header-actions {
    width: 100%;
    justify-content: flex-end;
  }
}

/* Creator Section Styles */
.creator-section {
  width: 100%;
}

.creator-btn {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  width: 100%;
  padding: 0.75rem 1rem;
  background: transparent;
  border: 1px solid #262626;
  border-radius: 0.75rem;
  color: #737373;
  font-size: 0.8125rem;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;
}

.creator-btn svg {
  width: 16px;
  height: 16px;
}

.creator-btn:hover:not(:disabled) {
  background: #1a1a1a;
  border-color: #3b82f6;
  color: #3b82f6;
}

.creator-btn:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.creator-active-btn {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  width: 100%;
  padding: 0.75rem 1rem;
  background: rgba(59, 130, 246, 0.1);
  border: 1px solid rgba(59, 130, 246, 0.3);
  border-radius: 0.75rem;
  color: #3b82f6;
  font-size: 0.8125rem;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;
}

.creator-active-btn svg {
  width: 16px;
  height: 16px;
}

.creator-active-btn:hover {
  background: rgba(59, 130, 246, 0.15);
  border-color: #3b82f6;
}
</style>
