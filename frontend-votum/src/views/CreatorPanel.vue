<template>
  <div class="creator-panel">
    <h1>Panel de Creador</h1>
    <p>Bienvenido al panel de creación de elecciones</p>
    <button @click="$router.push('/')">Volver al Home</button>
  </div>
</template>

<script>
export default {
  name: 'CreatorPanel'
}
</script>

<style scoped>
.creator-panel {
  padding: 2rem;
  text-align: center;
}
</style>
