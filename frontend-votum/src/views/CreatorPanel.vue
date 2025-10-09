<template>
  <div class="container">
    <!-- Header -->
    <header class="header">
      <div class="header-content">
        <div class="brand">
          <div class="brand-icon">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M9 12l2 2 4-4m5.618-4.016A11.955 11.955 0 0112 2.944a11.955 11.955 0 01-8.618 3.04A12.02 12.02 0 003 9c0 5.591 3.824 10.29 9 11.622 5.176-1.332 9-6.03 9-11.622 0-1.042-.133-2.052-.382-3.016z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>
          </div>
          <h1 class="brand-name">Votum</h1>
        </div>
        <button @click="goBack" class="btn-secondary">Volver</button>
      </div>
    </header>

    <!-- Main Content -->
    <main class="main">
      <div class="content">

        <!-- Page Title -->
        <div class="page-header">
          <h2 class="page-title">Crear Nueva Elección</h2>
          <p class="page-subtitle">Configura los detalles de tu votación</p>
        </div>

        <!-- Success Message -->
        <div v-if="successMessage" class="alert alert-success">
          <svg class="alert-icon" viewBox="0 0 24 24" fill="none">
            <circle cx="12" cy="12" r="10" stroke="currentColor" stroke-width="2"/>
            <path d="M9 12l2 2 4-4" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
          </svg>
          <div>
            <p class="alert-title">¡Elección creada exitosamente!</p>
            <p class="alert-message">{{ successMessage }}</p>
          </div>
        </div>

        <!-- Error Message -->
        <div v-if="errorMessage" class="alert alert-error">
          <svg class="alert-icon" viewBox="0 0 24 24" fill="none">
            <circle cx="12" cy="12" r="10" stroke="currentColor" stroke-width="2"/>
            <path d="M12 8v4m0 4h.01" stroke="currentColor" stroke-width="2" stroke-linecap="round"/>
          </svg>
          <div>
            <p class="alert-title">Error</p>
            <p class="alert-message">{{ errorMessage }}</p>
          </div>
        </div>

        <!-- Form Card -->
        <div class="card">
          <form @submit.prevent="handleSubmit" class="form">

            <!-- Título -->
            <div class="form-group">
              <label for="titulo" class="label">
                <span>Título de la Elección</span>
                <span class="required">*</span>
              </label>
              <input
                id="titulo"
                v-model="form.titulo"
                type="text"
                class="input"
                placeholder="Ejemplo: Elección de Representante Estudiantil"
                required
              />
            </div>

            <!-- Descripción -->
            <div class="form-group">
              <label for="descripcion" class="label">
                <span>Descripción</span>
                <span class="required">*</span>
              </label>
              <textarea
                id="descripcion"
                v-model="form.descripcion"
                class="textarea"
                rows="4"
                placeholder="Describe el propósito y detalles de esta votación..."
                required
              ></textarea>
            </div>

            <!-- Fechas -->
            <div class="form-row">
              <!-- Fecha Inicio -->
              <div class="form-group">
                <label for="fechaInicio" class="label">
                  <span>Fecha de Inicio</span>
                  <span class="required">*</span>
                </label>
                <input
                  id="fechaInicio"
                  v-model="form.fechaInicio"
                  type="datetime-local"
                  class="input"
                  required
                />
              </div>

              <!-- Fecha Fin -->
              <div class="form-group">
                <label for="fechaFin" class="label">
                  <span>Fecha de Fin</span>
                  <span class="required">*</span>
                </label>
                <input
                  id="fechaFin"
                  v-model="form.fechaFin"
                  type="datetime-local"
                  class="input"
                  :class="{ 'input-error': dateError }"
                  required
                />
                <p v-if="dateError" class="error-text">
                  La fecha de fin debe ser posterior a la fecha de inicio
                </p>
              </div>
            </div>

            <!-- Submit Button -->
            <button
              type="submit"
              class="btn-primary"
              :disabled="loading || !isFormValid"
            >
              <svg v-if="loading" class="spinner" viewBox="0 0 24 24">
                <circle cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4" fill="none" opacity="0.25"/>
                <path d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" fill="currentColor"/>
              </svg>
              <span>{{ loading ? 'Creando elección...' : 'Crear Elección' }}</span>
            </button>

          </form>
        </div>

        <!-- Info Box -->
        <div class="info-box">
          <svg class="info-icon" viewBox="0 0 24 24" fill="none">
            <circle cx="12" cy="12" r="10" stroke="currentColor" stroke-width="2"/>
            <path d="M12 16v-4m0-4h.01" stroke="currentColor" stroke-width="2" stroke-linecap="round"/>
          </svg>
          <p class="info-text">
            Una vez creada la elección, podrás agregar candidatos y gestionar votantes
          </p>
        </div>

      </div>
    </main>
  </div>
</template>

<script>
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import api from '@/api/axios';

export default {
  name: 'CreateElectionView',
  setup() {
    const router = useRouter();

    const form = ref({
      titulo: '',
      descripcion: '',
      fechaInicio: '',
      fechaFin: ''
    });

    const loading = ref(false);
    const errorMessage = ref('');
    const successMessage = ref('');

    const isFormValid = computed(() => {
      return form.value.titulo.trim() !== '' &&
        form.value.descripcion.trim() !== '' &&
        form.value.fechaInicio !== '' &&
        form.value.fechaFin !== '' &&
        new Date(form.value.fechaFin) > new Date(form.value.fechaInicio);
    });

    const dateError = computed(() => {
      if (form.value.fechaInicio && form.value.fechaFin) {
        return new Date(form.value.fechaFin) <= new Date(form.value.fechaInicio);
      }
      return false;
    });

    const handleSubmit = async () => {
      if (!isFormValid.value) {
        errorMessage.value = 'Por favor completa todos los campos correctamente';
        return;
      }

      loading.value = true;
      errorMessage.value = '';
      successMessage.value = '';

      try {
        const response = await api.post('/elections', {
          titulo: form.value.titulo,
          descripcion: form.value.descripcion,
          fechaInicio: form.value.fechaInicio,
          fechaFin: form.value.fechaFin
        });

        console.log('✅ Elección creada:', response.data);

        successMessage.value = `Elección "${response.data.titulo}" creada con ID: ${response.data.id}`;

        // Limpiar formulario
        form.value = {
          titulo: '',
          descripcion: '',
          fechaInicio: '',
          fechaFin: ''
        };

        // Opcional: redirigir después de 2 segundos
        setTimeout(() => {
          router.push('/');
        }, 2000);

      } catch (error) {
        console.error('❌ Error al crear elección:', error);
        errorMessage.value = error.response?.data?.message || 'Error al crear la elección';
      } finally {
        loading.value = false;
      }
    };

    const goBack = () => {
      router.push('/');
    };

    return {
      form,
      loading,
      errorMessage,
      successMessage,
      isFormValid,
      dateError,
      handleSubmit,
      goBack
    };
  }
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.container {
  min-height: 100vh;
  background: #0d0d0d;
  color: #e5e5e5;
}

/* Header */
.header {
  background: #1a1a1a;
  border-bottom: 1px solid #2a2a2a;
  position: sticky;
  top: 0;
  z-index: 50;
}

.header-content {
  max-width: 1000px;
  margin: 0 auto;
  padding: 1.25rem 1.5rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.brand {
  display: flex;
  align-items: center;
  gap: 0.75rem;
}

.brand-icon {
  width: 40px;
  height: 40px;
  background: linear-gradient(135deg, #6366f1 0%, #8b5cf6 100%);
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.brand-icon svg {
  width: 24px;
  height: 24px;
  color: #ffffff;
}

.brand-name {
  font-size: 1.5rem;
  font-weight: 700;
  color: #ffffff;
}

.btn-secondary {
  padding: 0.625rem 1.25rem;
  background: #2a2a2a;
  border: 1px solid #3a3a3a;
  border-radius: 8px;
  color: #e5e5e5;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;
}

.btn-secondary:hover {
  background: #333333;
  border-color: #444444;
}

/* Main Content */
.main {
  max-width: 800px;
  margin: 0 auto;
  padding: 2.5rem 1.5rem;
}

.content {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.page-header {
  text-align: center;
  margin-bottom: 1rem;
}

.page-title {
  font-size: 2rem;
  font-weight: 700;
  color: #ffffff;
  margin-bottom: 0.5rem;
}

.page-subtitle {
  font-size: 1rem;
  color: #888888;
}

/* Alerts */
.alert {
  display: flex;
  align-items: flex-start;
  gap: 1rem;
  padding: 1rem 1.25rem;
  border-radius: 12px;
  border: 1px solid;
}

.alert-success {
  background: rgba(34, 197, 94, 0.1);
  border-color: rgba(34, 197, 94, 0.3);
}

.alert-error {
  background: rgba(239, 68, 68, 0.1);
  border-color: rgba(239, 68, 68, 0.3);
}

.alert-icon {
  width: 24px;
  height: 24px;
  flex-shrink: 0;
  margin-top: 2px;
}

.alert-success .alert-icon {
  color: #22c55e;
}

.alert-error .alert-icon {
  color: #ef4444;
}

.alert-title {
  font-weight: 600;
  margin-bottom: 0.25rem;
}

.alert-success .alert-title {
  color: #22c55e;
}

.alert-error .alert-title {
  color: #ef4444;
}

.alert-message {
  font-size: 0.875rem;
  color: #b0b0b0;
}

/* Card */
.card {
  background: #1a1a1a;
  border: 1px solid #2a2a2a;
  border-radius: 16px;
  padding: 2rem;
}

/* Form */
.form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.form-row {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 1.5rem;
}

.label {
  font-size: 0.875rem;
  font-weight: 600;
  color: #b0b0b0;
  display: flex;
  gap: 0.25rem;
}

.required {
  color: #ef4444;
}

.input,
.textarea {
  width: 100%;
  padding: 0.875rem 1rem;
  background: #0d0d0d;
  border: 1px solid #2a2a2a;
  border-radius: 10px;
  color: #e5e5e5;
  font-size: 1rem;
  font-family: inherit;
  transition: all 0.2s;
}

.input::placeholder,
.textarea::placeholder {
  color: #555555;
}

.input:focus,
.textarea:focus {
  outline: none;
  border-color: #6366f1;
  background: #151515;
}

.input-error {
  border-color: #ef4444 !important;
}

.textarea {
  resize: vertical;
  min-height: 100px;
}

.error-text {
  font-size: 0.75rem;
  color: #ef4444;
  margin-top: -0.25rem;
}

/* Datetime input styling */
input[type="datetime-local"]::-webkit-calendar-picker-indicator {
  filter: invert(0.7);
  cursor: pointer;
}

/* Button */
.btn-primary {
  width: 100%;
  padding: 1rem;
  background: linear-gradient(135deg, #6366f1 0%, #8b5cf6 100%);
  border: none;
  border-radius: 10px;
  color: #ffffff;
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
  margin-top: 0.5rem;
}

.btn-primary:hover:not(:disabled) {
  transform: translateY(-2px);
  box-shadow: 0 10px 30px rgba(99, 102, 241, 0.3);
}

.btn-primary:disabled {
  opacity: 0.5;
  cursor: not-allowed;
  transform: none;
}

.spinner {
  width: 20px;
  height: 20px;
  animation: spin 1s linear infinite;
}

@keyframes spin {
  to { transform: rotate(360deg); }
}

/* Info Box */
.info-box {
  display: flex;
  align-items: flex-start;
  gap: 0.75rem;
  padding: 1rem;
  background: #1a1a1a;
  border: 1px solid #2a2a2a;
  border-radius: 12px;
}

.info-icon {
  width: 20px;
  height: 20px;
  color: #6366f1;
  flex-shrink: 0;
  margin-top: 2px;
}

.info-text {
  font-size: 0.875rem;
  color: #888888;
  line-height: 1.5;
}

/* Responsive */
@media (max-width: 768px) {
  .form-row {
    grid-template-columns: 1fr;
  }

  .card {
    padding: 1.5rem;
  }

  .page-title {
    font-size: 1.5rem;
  }
}
</style>
