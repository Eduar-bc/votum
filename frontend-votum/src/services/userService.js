import axios from 'axios';

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080/api';

export const becomeCreator = async () => {
  try {
    const token = localStorage.getItem('token');

    if (!token) {
      throw new Error('No estás autenticado');
    }

    const response = await axios.post(
      `${API_URL}/users/become-creator`,
      {},
      {
        headers: {
          Authorization: `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      }
    );

      if (response.data.token) {
      localStorage.setItem('token', response.data.token);
    } else {
      throw new Error('El servidor no devolvió un token actualizado');
    }

    return response.data.message || '¡Ahora eres creador de elecciones!';
  } catch (error) {
    console.error('Error en becomeCreator:', error);
    throw new Error(
      error.response?.data?.message ||
      error.message ||
      'Error al procesar la solicitud'
    );
  }
};
