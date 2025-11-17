# Manual de Usuario - Sistema de Votación Electrónica Votum

## Índice
1. [Introducción](#1-introducción)
2. [Primeros Pasos](#2-primeros-pasos)
3. [Registro y Acceso](#3-registro-y-acceso)
4. [Perfil de Votante](#4-perfil-de-votante)
5. [Perfil de Administrador de Elecciones](#5-perfil-de-administrador-de-elecciones)
6. [Gestión de Elecciones](#6-gestión-de-elecciones)
7. [Participación en Votaciones](#7-participación-en-votaciones)
8. [Preguntas Frecuentes](#8-preguntas-frecuentes)
9. [Solución de Problemas](#9-solución-de-problemas)
10. [Soporte y Contacto](#10-soporte-y-contacto)

---

## 1. Introducción

### 1.1 ¿Qué es Votum?
Votum es un sistema de votación electrónica seguro y fácil de usar que permite:
- **Crear y gestionar elecciones digitales**
- **Participar en votaciones de forma remota**
- **Garantizar la seguridad y transparencia del proceso electoral**

### 1.2 Requisitos del Sistema
- **Navegador web** actualizado (Chrome, Firefox, Safari, Edge)
- **Conexión a Internet** estable
- **Correo electrónico** válido para registro

### 1.3 Roles de Usuario

El sistema cuenta con tres tipos de usuarios:

| Rol | Descripción | Permisos |
|-----|-------------|----------|
| **Votante** | Usuario estándar | • Participar en elecciones asignadas<br>• Ver resultados |
| **Administrador de Elecciones** | Creador de elecciones | • Todo lo de Votante<br>• Crear elecciones<br>• Gestionar votantes<br>• Configurar opciones |
| **Administrador del Sistema** | Administrador general | • Control total del sistema |

---

## 2. Primeros Pasos

### 2.1 Acceso al Sistema
1. Abra su navegador web
2. Ingrese a la dirección: `[null]`
3. Verá la pantalla de inicio de Votum

### 2.2 Pantalla de Inicio
La pantalla principal muestra:
- **Botón "Iniciar Sesión"**: Para usuarios registrados
- **Botón "Registrarse"**: Para nuevos usuarios
- **Información del sistema**: Descripción de Votum

---

## 3. Registro y Acceso

### 3.1 Crear una Cuenta Nueva

**Paso 1:** Haga clic en **"Crear Cuenta"**

**Paso 2:** Complete el formulario de registro:

<img width="1211" height="711" alt="registro" src="https://github.com/user-attachments/assets/2eea9392-6eb7-4381-9612-a79383dbc99e" />

**Paso 3:** Haga clic en **"Registrarse"**

**Paso 4:** Si el registro es exitoso, verá el mensaje:
> ✅ "Usuario creado exitosamente"

**Paso 5:** Ahora puede iniciar sesión con sus credenciales

### 3.2 Iniciar Sesión

**Paso 1:** En la pantalla principal, haga clic en **"Iniciar Sesión"**

**Paso 2:** Ingrese sus credenciales:

<img width="1215" height="714" alt="Iniciar Sesión" src="https://github.com/user-attachments/assets/4437f3e6-9144-4161-852a-28f88dedea38" />

**Paso 3:** Haga clic en **"Iniciar Sesión"**

**Mensajes posibles:**
- ✅ Acceso exitoso → Redirige al panel principal
- ❌ Credenciales incorrectas → "Usuario o contraseña incorrectos"
- ❌ Usuario deshabilitado → "Contacte al administrador"

### 3.3 Recuperar Contraseña
*(Funcionalidad pendiente de implementación)*

### 3.4 Cerrar Sesión
1. Haga clic en su nombre de usuario (esquina inferior izquierda)
2. Seleccione **"Cerrar Sesión"**
<img width="1366" height="768" alt="salir" src="https://github.com/user-attachments/assets/902d7fa2-4fc2-4b61-8ad3-e9b7bc95712f" />

3. Será redirigido a la pantalla de inicio

---

## 4. Perfil de Votante

### 4.1 Panel del Votante

Al iniciar sesión como votante, verá:

<img width="1366" height="768" alt="Home" src="https://github.com/user-attachments/assets/9f6a4cec-4fb3-4ab7-ade0-fa79873b9e1d" />

### 4.2 Convertirse en Administrador de Elecciones

Si desea crear y gestionar sus propias elecciones:

**Paso 1:** En el panel principal, haga clic en:
> **"Ser Creador"**

<img width="1366" height="768" alt="ser creador" src="https://github.com/user-attachments/assets/c1eb6e55-5891-4dbf-b80b-3c77e1e58c28" />

**Paso 2:** El sistema actualizará su cuenta automáticamente

**Paso 3:** Recibirá la confirmación:
> ✅ "Ahora eres administrador de elecciones"

**Paso 4:** Su sesión se actualizará y verá las nuevas opciones de administración

### 4.3 Ver Mis Elecciones

*(Funcionalidad pendiente de implementación)*

---

## 5. Perfil de Administrador de Elecciones

### 5.1 Panel del Administrador

*(Funcionalidad pendiente de implementación)*

### 5.2 Funciones Disponibles

*(Funcionalidad pendiente de implementación)*

---

## 6. Gestión de Elecciones

### 6.1 Crear una Nueva Elección

**Paso 1:** Haga clic en **"➕ Nueva Elección"**

**Paso 2:** Complete el formulario:

<img width="1005" height="768" alt="Crear una Nueva Elección" src="https://github.com/user-attachments/assets/f0c1cd49-2c11-4c8c-9999-2963f0ab161d" />

**Campos:**
- **Título**: Nombre descriptivo de la elección
- **Descripción**: Información adicional sobre la votación
- **Fecha de inicio**: Cuándo se abrirá la votación
- **Fecha de finalización**: Cuándo se cerrará la votación

**Paso 3:** Haga clic en **"Crear Elección"**

**Paso 4:** La elección se crea en estado **"CREADA"**

### 6.2 Agregar Votantes a una Elección

*(Funcionalidad pendiente de frontend)*

**Paso 4:** Haga clic en **"Agregar Votantes"**

**Resultado:**
- ✅ Votantes agregados correctamente
- Los usuarios recibirán notificación (si está configurado)
- Los votantes podrán ver la elección en su panel

### 6.3 Estados de una Elección

| Estado | Descripción | Acciones Disponibles |
|--------|-------------|---------------------|
| 📝 **CREADA** | Recién creada, no iniciada | Editar, Agregar votantes |
| ⏳ **ACTIVA** | En proceso de votación | Ver progreso, Monitorear |
| ⏸️ **INACTIVA** | Pausada temporalmente | Reactivar |
| ✅ **FINALIZADA** | Votación cerrada | Ver resultados finales |

### 6.4 Editar una Elección

**Restricciones:**
- ⚠️ Solo puede editar elecciones que NO han iniciado
- ⚠️ Una vez iniciada, no se puede modificar

**Paso 1:** Seleccione la elección en estado "CREADA"

**Paso 2:** Haga clic en **"Editar"**

**Paso 3:** Modifique los campos necesarios

**Paso 4:** Guarde los cambios

### 6.5 Monitorear una Elección Activa

*(Funcionalidad pendiente de implementación)*

### 6.6 Ver Resultados

*(Funcionalidad pendiente de implementación)*

---

## 7. Participación en Votaciones

### 7.1 Acceder a una Votación

*(Funcionalidad pendiente de implementación)*

### 7.2 Proceso de Votación

*(Funcionalidad pendiente de implementación)*

### 7.3 Verificar que Voté

*(Funcionalidad pendiente de implementación)*

### 7.4 Ver Resultados (después de finalizar)

*(Funcionalidad pendiente de implementación)*
---

## 8. Preguntas Frecuentes

### 8.1 Sobre el Registro y Acceso

**P: ¿Puedo usar cualquier correo electrónico?**
R: Sí, puede usar cualquier correo válido. Se recomienda usar un correo institucional si está disponible.

**P: ¿Qué hago si olvidé mi contraseña?**
R: Contacte al administrador del sistema para restablecer su contraseña.

**P: ¿Puedo cambiar mi correo electrónico después de registrarme?**
R: Actualmente no. Debe contactar al administrador.

### 8.2 Sobre las Votaciones

**P: ¿Puedo cambiar mi voto después de enviarlo?**
R: No, una vez confirmado el voto, no puede modificarse para garantizar la integridad de la elección.

**P: ¿Mi voto es anónimo?**
R: Sí, el sistema registra que usted votó pero no registra por quién votó.

**P: ¿Hasta cuándo puedo votar?**
R: Puede votar hasta la fecha y hora de finalización indicada en cada elección.

**P: ¿Qué pasa si intento votar después de la hora límite?**
R: El sistema no le permitirá acceder a la votación una vez finalizada.

### 8.3 Sobre Creación de Elecciones

**P: ¿Necesito permisos especiales para crear elecciones?**
R: Sí, debe convertirse en "Administrador de Elecciones" desde su panel.

**P: ¿Puedo modificar una elección después de iniciada?**
R: No, por seguridad no se pueden modificar elecciones activas.

**P: ¿Cuántos votantes puedo agregar?**
R: No hay límite técnico, pero considere la capacidad del sistema.

**P: ¿Qué pasa si agrego un correo que no está registrado?**
R: El sistema solo agregará usuarios que ya estén registrados en la plataforma.

### 8.4 Sobre Seguridad

**P: ¿Es seguro votar por Internet?**
R: Sí, el sistema usa encriptación y medidas de seguridad para proteger su información.

**P: ¿Alguien puede ver por quién voté?**
R: No, ni siquiera los administradores pueden ver el voto individual de cada persona.

**P: ¿Puedo votar desde mi teléfono?**
R: Sí, el sistema es compatible con navegadores móviles.

---

## 9. Solución de Problemas

### 9.1 No puedo iniciar sesión

**Problema:** Mensaje de "Credenciales incorrectas"

**Soluciones:**
1. ✅ Verifique que el correo esté escrito correctamente
2. ✅ Verifique que la contraseña sea correcta (distingue mayúsculas)
3. ✅ Asegúrese de que su cuenta esté activada
4. ✅ Contacte al administrador si el problema persiste

### 9.2 No veo ninguna elección disponible

**Problema:** El panel aparece vacío

**Soluciones:**
1. ✅ Verifique que haya sido agregado como votante
2. ✅ Consulte las fechas de las elecciones
3. ✅ Contacte al administrador de la elección

### 9.3 Error al votar

**Problema:** El voto no se registra

**Soluciones:**
1. ✅ Verifique su conexión a Internet
2. ✅ Actualice la página (F5)
3. ✅ Intente desde otro navegador
4. ✅ Contacte a soporte técnico

### 9.4 No puedo agregar votantes a mi elección

**Problema:** Mensaje de error al agregar votantes

**Posibles causas y soluciones:**
- ⚠️ **La elección ya inició**: No se pueden agregar votantes después del inicio
- ⚠️ **Correos incorrectos**: Verifique que los correos estén bien escritos
- ⚠️ **Usuarios no registrados**: Solo se pueden agregar usuarios que ya tengan cuenta

### 9.5 Problemas de visualización

**Problema:** La página no se ve correctamente

**Soluciones:**
1. ✅ Actualice su navegador a la última versión
2. ✅ Limpie el caché del navegador
3. ✅ Intente desde otro navegador
4. ✅ Verifique su conexión a Internet

---

**Versión:** 1.0  
**Última actualización:** Noviembre 2025  
**Sistema Votum** - Votación Electrónica Segura

---

## Notas Finales

Este manual está diseñado para ayudarle a utilizar todas las funciones del Sistema Votum. Si tiene sugerencias para mejorar este documento, por favor contacte al equipo de soporte.

¡Gracias por usar Votum! 🗳️✨
