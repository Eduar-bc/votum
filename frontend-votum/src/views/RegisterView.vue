<template>
  <div class="auth-page">
    <div class="auth-container">
      <!-- Left side - Branding -->
      <div class="auth-brand">
        <div class="brand-content">
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
          <h2 class="brand-title">Únete a la revolución de la votación digital</h2>
          <p class="brand-description">
            Crea tu cuenta y accede a un sistema de votación transparente, seguro e inmutable
            respaldado por tecnología blockchain.
          </p>
          <div class="brand-stats">
            <div class="stat-item">
              <div class="stat-value">100%</div>
              <div class="stat-label">Transparente</div>
            </div>
            <div class="stat-item">
              <div class="stat-value">256-bit</div>
              <div class="stat-label">Encriptación</div>
            </div>
            <div class="stat-item">
              <div class="stat-value">24/7</div>
              <div class="stat-label">Disponibilidad</div>
            </div>
          </div>
        </div>
      </div>

      <!-- Right side - Register Form -->
      <div class="auth-form-section">
        <div class="form-wrapper">
          <div class="form-header">
            <h2 class="form-title">Crear Cuenta</h2>
            <p class="form-subtitle">Comienza a votar de forma segura</p>
          </div>

          <!-- Alert Messages -->
          <div v-if="successMessage" class="alert alert-success">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M9 12L11 14L15 10M21 12C21 16.9706 16.9706 21 12 21C7.02944 21 3 16.9706 3 12C3 7.02944 7.02944 3 12 3C16.9706 3 21 7.02944 21 12Z"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
            <span>{{ successMessage }}</span>
          </div>

          <div v-if="errorMessage" class="alert alert-error">
            <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M12 8V12M12 16H12.01M21 12C21 16.9706 16.9706 21 12 21C7.02944 21 3 16.9706 3 12C3 7.02944 7.02944 3 12 3C16.9706 3 21 7.02944 21 12Z"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
            <span>{{ errorMessage }}</span>
          </div>

          <!-- Register Form -->
          <form @submit.prevent="handleRegister" class="auth-form">
            <div class="form-field">
              <label for="email" class="field-label">Correo Electrónico</label>
              <div class="input-wrapper">
                <svg
                  class="input-icon"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M3 8L10.89 13.26C11.5417 13.6728 12.4583 13.6728 13.11 13.26L21 8M5 19H19C20.1046 19 21 18.1046 21 17V7C21 5.89543 20.1046 5 19 5H5C3.89543 5 3 5.89543 3 7V17C3 18.1046 3.89543 19 5 19Z"
                    stroke="currentColor"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
                <input
                  id="email"
                  v-model="email"
                  type="email"
                  placeholder="correo@ejemplo.com"
                  class="field-input"
                  required
                />
              </div>
            </div>

            <div class="form-field">
              <label for="password" class="field-label">Contraseña</label>
              <div class="input-wrapper">
                <svg
                  class="input-icon"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M12 15V17M6 21H18C19.1046 21 20 20.1046 20 19V13C20 11.8954 19.1046 11 18 11H6C4.89543 11 4 11.8954 4 13V19C4 20.1046 4.89543 21 6 21ZM16 11V7C16 4.79086 14.2091 3 12 3C9.79086 3 8 4.79086 8 7V11H16Z"
                    stroke="currentColor"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
                <input
                  id="password"
                  v-model="password"
                  type="password"
                  placeholder="Mínimo 6 caracteres"
                  minlength="6"
                  class="field-input"
                  required
                />
              </div>
              <div class="password-strength">
                <div class="strength-bar" :class="passwordStrengthClass"></div>
              </div>
            </div>

            <div class="form-field">
              <label for="confirmPassword" class="field-label">Confirmar Contraseña</label>
              <div class="input-wrapper">
                <svg
                  class="input-icon"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M9 12L11 14L15 10M12 15V17M6 21H18C19.1046 21 20 20.1046 20 19V13C20 11.8954 19.1046 11 18 11H6C4.89543 11 4 11.8954 4 13V19C4 20.1046 4.89543 21 6 21ZM16 11V7C16 4.79086 14.2091 3 12 3C9.79086 3 8 4.79086 8 7V11H16Z"
                    stroke="currentColor"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
                <input
                  id="confirmPassword"
                  v-model="confirmPassword"
                  type="password"
                  placeholder="Repite tu contraseña"
                  class="field-input"
                  required
                />
              </div>
            </div>

            <button type="submit" class="btn-primary" :disabled="loading">
              <span v-if="!loading">Crear Cuenta</span>
              <span v-else class="btn-loading">
                <svg
                  class="spinner"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M12 2V6M12 18V22M6 12H2M22 12H18M19.07 19.07L16.24 16.24M19.07 4.93L16.24 7.76M4.93 19.07L7.76 16.24M4.93 4.93L7.76 7.76"
                    stroke="currentColor"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
                Creando cuenta...
              </span>
            </button>
          </form>

          <div class="form-footer">
            <p class="footer-text">
              ¿Ya tienes una cuenta?
              <router-link to="/login" class="footer-link">Iniciar sesión</router-link>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import api from '../api/axios'

export default {
  name: 'RegisterView',
  setup() {
    const router = useRouter()
    const email = ref('')
    const password = ref('')
    const confirmPassword = ref('')
    const errorMessage = ref('')
    const successMessage = ref('')
    const loading = ref(false)

    const passwordStrengthClass = computed(() => {
      const len = password.value.length
      if (len === 0) return ''
      if (len < 6) return 'weak'
      if (len < 10) return 'medium'
      return 'strong'
    })

    const handleRegister = async () => {
      errorMessage.value = ''
      successMessage.value = ''

      if (password.value !== confirmPassword.value) {
        errorMessage.value = 'Las contraseñas no coinciden'
        return
      }

      if (password.value.length < 6) {
        errorMessage.value = 'La contraseña debe tener al menos 6 caracteres'
        return
      }

      loading.value = true

      try {
        const response = await api.post('/auth/register', {
          email: email.value,
          password: password.value,
        })

        console.log('✅ Registro exitoso:', response.data)
        successMessage.value = '¡Cuenta creada exitosamente! Redirigiendo al login...'

        setTimeout(() => {
          router.push('/login')
        }, 2000)
      } catch (error) {
        console.error('❌ Error en registro:', error)

        if (error.response) {
          errorMessage.value = error.response.data || 'Error al crear la cuenta'
        } else if (error.request) {
          errorMessage.value = 'No se pudo conectar con el servidor'
        } else {
          errorMessage.value = 'Error inesperado'
        }
      } finally {
        loading.value = false
      }
    }

    return {
      email,
      password,
      confirmPassword,
      errorMessage,
      successMessage,
      loading,
      passwordStrengthClass,
      handleRegister,
    }
  },
}
</script>

<style scoped>
.auth-page {
  min-height: 100vh;
  background: #0a0a0a;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 1rem;
}

.auth-container {
  display: grid;
  grid-template-columns: 1fr;
  width: 100%;
  max-width: 1200px;
  background: #141414;
  border-radius: 1.5rem;
  overflow: hidden;
  box-shadow: 0 20px 60px rgba(0, 0, 0, 0.5);
}

@media (min-width: 1024px) {
  .auth-container {
    grid-template-columns: 1fr 1fr;
    min-height: 700px;
  }
}

/* Brand Section */
.auth-brand {
  background: linear-gradient(135deg, #1a1a1a 0%, #0a0a0a 100%);
  padding: 3rem 2rem;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  overflow: hidden;
}

.auth-brand::before {
  content: '';
  position: absolute;
  top: -50%;
  left: -50%;
  width: 100%;
  height: 100%;
  background: radial-gradient(circle, rgba(34, 197, 94, 0.08) 0%, transparent 70%);
  pointer-events: none;
}

.brand-content {
  position: relative;
  z-index: 1;
  max-width: 480px;
}

.logo-section {
  display: flex;
  align-items: center;
  gap: 1rem;
  margin-bottom: 2rem;
}

.logo-icon {
  width: 48px;
  height: 48px;
  background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
}

.logo-icon svg {
  width: 28px;
  height: 28px;
}

.brand-name {
  font-size: 2rem;
  font-weight: 700;
  color: #ffffff;
  margin: 0;
}

.brand-title {
  font-size: 1.875rem;
  font-weight: 700;
  color: #ffffff;
  margin-bottom: 1rem;
  line-height: 1.2;
}

.brand-description {
  font-size: 1rem;
  color: #a3a3a3;
  line-height: 1.6;
  margin-bottom: 2.5rem;
}

.brand-stats {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 1.5rem;
}

.stat-item {
  text-align: center;
}

.stat-value {
  font-size: 1.5rem;
  font-weight: 700;
  color: #3b82f6;
  margin-bottom: 0.25rem;
}

.stat-label {
  font-size: 0.8125rem;
  color: #737373;
}

/* Form Section */
.auth-form-section {
  background: #1a1a1a;
  padding: 3rem 2rem;
  display: flex;
  align-items: center;
  justify-content: center;
}

.form-wrapper {
  width: 100%;
  max-width: 420px;
}

.form-header {
  margin-bottom: 2rem;
}

.form-title {
  font-size: 1.875rem;
  font-weight: 700;
  color: #ffffff;
  margin-bottom: 0.5rem;
}

.form-subtitle {
  font-size: 0.9375rem;
  color: #a3a3a3;
}

/* Alert */
.alert {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  padding: 1rem;
  border-radius: 0.75rem;
  margin-bottom: 1.5rem;
  font-size: 0.875rem;
}

.alert svg {
  width: 20px;
  height: 20px;
  flex-shrink: 0;
}

.alert-error {
  background: rgba(239, 68, 68, 0.1);
  border: 1px solid rgba(239, 68, 68, 0.2);
  color: #fca5a5;
}

.alert-success {
  background: rgba(34, 197, 94, 0.1);
  border: 1px solid rgba(34, 197, 94, 0.2);
  color: #86efac;
}

/* Form */
.auth-form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.form-field {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.field-label {
  font-size: 0.875rem;
  font-weight: 600;
  color: #d4d4d4;
}

.input-wrapper {
  position: relative;
  display: flex;
  align-items: center;
}

.input-icon {
  position: absolute;
  left: 1rem;
  width: 20px;
  height: 20px;
  color: #737373;
  pointer-events: none;
}

.field-input {
  width: 100%;
  padding: 0.875rem 1rem 0.875rem 3rem;
  background: #0a0a0a;
  border: 1px solid #262626;
  border-radius: 0.75rem;
  color: #ffffff;
  font-size: 0.9375rem;
  transition: all 0.2s;
}

.field-input::placeholder {
  color: #525252;
}

.field-input:focus {
  outline: none;
  border-color: #3b82f6;
  box-shadow: 0 0 0 3px rgba(59, 130, 246, 0.1);
}

/* Password Strength */
.password-strength {
  height: 4px;
  background: #262626;
  border-radius: 2px;
  overflow: hidden;
  margin-top: 0.25rem;
}

.strength-bar {
  height: 100%;
  transition: all 0.3s;
  width: 0;
}

.strength-bar.weak {
  width: 33.33%;
  background: #ef4444;
}

.strength-bar.medium {
  width: 66.66%;
  background: #f59e0b;
}

.strength-bar.strong {
  width: 100%;
  background: #22c55e;
}

/* Button */
.btn-primary {
  width: 100%;
  padding: 1rem;
  background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
  color: #ffffff;
  border: none;
  border-radius: 0.75rem;
  font-size: 0.9375rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;
  margin-top: 0.5rem;
}

.btn-primary:hover:not(:disabled) {
  transform: translateY(-2px);
  box-shadow: 0 8px 24px rgba(59, 130, 246, 0.3);
}

.btn-primary:disabled {
  opacity: 0.6;
  cursor: not-allowed;
  transform: none;
}

.btn-loading {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
}

.spinner {
  width: 18px;
  height: 18px;
  animation: spin 1s linear infinite;
}

@keyframes spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}

/* Footer */
.form-footer {
  margin-top: 2rem;
  text-align: center;
}

.footer-text {
  font-size: 0.875rem;
  color: #a3a3a3;
}

.footer-link {
  color: #3b82f6;
  text-decoration: none;
  font-weight: 600;
  transition: color 0.2s;
}

.footer-link:hover {
  color: #60a5fa;
}

/* Responsive */
@media (max-width: 1023px) {
  .auth-brand {
    display: none;
  }

  .auth-form-section {
    padding: 2rem 1.5rem;
  }
}

@media (max-width: 640px) {
  .form-title {
    font-size: 1.5rem;
  }

  .auth-form-section {
    padding: 2rem 1rem;
  }
}
</style>
