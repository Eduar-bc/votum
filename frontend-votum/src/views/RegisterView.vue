<template>
  <div class="auth-container">
    <div class="auth-card">
      <h1 class="auth-title">Crear Cuenta</h1>
      <p class="auth-subtitle">Únete a Votum</p>

      <!-- Mensaje de éxito -->
      <div v-if="successMessage" class="success-message">
        {{ successMessage }}
      </div>

      <!-- Mensaje de error -->
      <div v-if="errorMessage" class="error-message">
        {{ errorMessage }}
      </div>

      <!-- Formulario -->
      <form @submit.prevent="handleRegister">
        <div class="form-group">
          <label for="email">Correo Electrónico</label>
          <input
            id="email"
            v-model="email"
            type="email"
            placeholder="tu@email.com"
            required
          />
        </div>

        <div class="form-group">
          <label for="password">Contraseña</label>
          <input
            id="password"
            v-model="password"
            type="password"
            placeholder="Mínimo 6 caracteres"
            minlength="6"
            required
          />
        </div>

        <div class="form-group">
          <label for="confirmPassword">Confirmar Contraseña</label>
          <input
            id="confirmPassword"
            v-model="confirmPassword"
            type="password"
            placeholder="Repite tu contraseña"
            required
          />
        </div>

        <button type="submit" class="btn-primary" :disabled="loading">
          {{ loading ? 'Creando cuenta...' : 'Registrarse' }}
        </button>
      </form>

      <p class="auth-footer">
        ¿Ya tienes cuenta?
        <router-link to="/login" class="link">Inicia sesión aquí</router-link>
      </p>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import api from '../api/axios';

export default {
  name: 'RegisterView',
  setup() {
    const router = useRouter();
    const email = ref('');
    const password = ref('');
    const confirmPassword = ref('');
    const errorMessage = ref('');
    const successMessage = ref('');
    const loading = ref(false);

    const handleRegister = async () => {
      errorMessage.value = '';
      successMessage.value = '';

      // Validar que las contraseñas coincidan
      if (password.value !== confirmPassword.value) {
        errorMessage.value = 'Las contraseñas no coinciden';
        return;
      }

      // Validar longitud de contraseña
      if (password.value.length < 6) {
        errorMessage.value = 'La contraseña debe tener al menos 6 caracteres';
        return;
      }

      loading.value = true;

      try {
        const response = await api.post('/auth/register', {
          email: email.value,
          password: password.value,
        });

        console.log('✅ Registro exitoso:', response.data);

        successMessage.value = '¡Cuenta creada exitosamente! Redirigiendo al login...';

        // Redirigir al login después de 2 segundos
        setTimeout(() => {
          router.push('/login');
        }, 2000);
      } catch (error) {
        console.error('❌ Error en registro:', error);

        if (error.response) {
          // El servidor respondió con un error
          errorMessage.value = error.response.data || 'Error al crear la cuenta';
        } else if (error.request) {
          // No hubo respuesta del servidor
          errorMessage.value = 'No se pudo conectar con el servidor';
        } else {
          errorMessage.value = 'Error inesperado';
        }
      } finally {
        loading.value = false;
      }
    };

    return {
      email,
      password,
      confirmPassword,
      errorMessage,
      successMessage,
      loading,
      handleRegister,
    };
  },
};
</script>

<style scoped>
.auth-container {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  padding: 1rem;
}

.auth-card {
  background: white;
  border-radius: 1rem;
  padding: 2.5rem;
  width: 100%;
  max-width: 420px;
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.1);
}

.auth-title {
  font-size: 1.875rem;
  font-weight: bold;
  color: #1a202c;
  margin-bottom: 0.5rem;
  text-align: center;
}

.auth-subtitle {
  color: #718096;
  text-align: center;
  margin-bottom: 2rem;
}

.error-message {
  background-color: #fed7d7;
  color: #c53030;
  padding: 0.75rem;
  border-radius: 0.5rem;
  margin-bottom: 1.5rem;
  font-size: 0.875rem;
}

.success-message {
  background-color: #c6f6d5;
  color: #22543d;
  padding: 0.75rem;
  border-radius: 0.5rem;
  margin-bottom: 1.5rem;
  font-size: 0.875rem;
}

.form-group {
  margin-bottom: 1.5rem;
}

.form-group label {
  display: block;
  color: #2d3748;
  font-weight: 500;
  margin-bottom: 0.5rem;
  font-size: 0.875rem;
}

.form-group input {
  width: 100%;
  padding: 0.75rem;
  border: 1px solid #e2e8f0;
  border-radius: 0.5rem;
  font-size: 1rem;
  transition: all 0.2s;
}

.form-group input:focus {
  outline: none;
  border-color: #667eea;
  box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
}

.btn-primary {
  width: 100%;
  padding: 0.875rem;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  border: none;
  border-radius: 0.5rem;
  font-weight: 600;
  font-size: 1rem;
  cursor: pointer;
  transition: transform 0.2s;
}

.btn-primary:hover:not(:disabled) {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(102, 126, 234, 0.4);
}

.btn-primary:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.auth-footer {
  text-align: center;
  margin-top: 1.5rem;
  color: #718096;
  font-size: 0.875rem;
}

.link {
  color: #667eea;
  text-decoration: none;
  font-weight: 600;
}

.link:hover {
  text-decoration: underline;
}
</style>
