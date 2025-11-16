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
2. Ingrese a la dirección: `[URL del sistema]`
3. Verá la pantalla de inicio de Votum

### 2.2 Pantalla de Inicio
La pantalla principal muestra:
- **Botón "Iniciar Sesión"**: Para usuarios registrados
- **Botón "Registrarse"**: Para nuevos usuarios
- **Información del sistema**: Descripción de Votum

---

## 3. Registro y Acceso

### 3.1 Crear una Cuenta Nueva

**Paso 1:** Haga clic en **"Registrarse"**

**Paso 2:** Complete el formulario de registro:
```
┌─────────────────────────────────────┐
│  REGISTRO DE USUARIO                │
├─────────────────────────────────────┤
│  Correo electrónico:                │
│  [___________________________]      │
│                                     │
│  Contraseña:                        │
│  [___________________________]      │
│                                     │
│  Confirmar contraseña:              │
│  [___________________________]      │
│                                     │
│        [  Registrarse  ]            │
└─────────────────────────────────────┘
```

**Paso 3:** Haga clic en **"Registrarse"**

**Paso 4:** Si el registro es exitoso, verá el mensaje:
> ✅ "Usuario creado exitosamente"

**Paso 5:** Ahora puede iniciar sesión con sus credenciales

### 3.2 Iniciar Sesión

**Paso 1:** En la pantalla principal, haga clic en **"Iniciar Sesión"**

**Paso 2:** Ingrese sus credenciales:
```
┌─────────────────────────────────────┐
│  INICIAR SESIÓN                     │
├─────────────────────────────────────┤
│  Correo electrónico:                │
│  [___________________________]      │
│                                     │
│  Contraseña:                        │
│  [___________________________]      │
│                                     │
│  [ ] Recordarme                     │
│                                     │
│        [  Entrar  ]                 │
│                                     │
│  ¿Olvidó su contraseña?             │
└─────────────────────────────────────┘
```

**Paso 3:** Haga clic en **"Entrar"**

**Mensajes posibles:**
- ✅ Acceso exitoso → Redirige al panel principal
- ❌ Credenciales incorrectas → "Usuario o contraseña incorrectos"
- ❌ Usuario deshabilitado → "Contacte al administrador"

### 3.3 Recuperar Contraseña
*(Funcionalidad pendiente de implementación)*

### 3.4 Cerrar Sesión
1. Haga clic en su nombre de usuario (esquina superior derecha)
2. Seleccione **"Cerrar Sesión"**
3. Será redirigido a la pantalla de inicio

---

## 4. Perfil de Votante

### 4.1 Panel del Votante

Al iniciar sesión como votante, verá:

```
┌────────────────────────────────────────────────┐
│  👤 Bienvenido, usuario@correo.com             │
├────────────────────────────────────────────────┤
│                                                │
│  📋 MIS ELECCIONES                             │
│  ┌──────────────────────────────────────────┐ │
│  │ 🗳️ Elección de Presidente 2025           │ │
│  │ Estado: ⏳ En curso                       │ │
│  │ Finaliza: 01/12/2025 18:00               │ │
│  │                                          │ │
│  │ [  Votar  ] [ Ver Detalles ]             │ │
│  └──────────────────────────────────────────┘ │
│                                                │
│  ┌──────────────────────────────────────────┐ │
│  │ 🗳️ Votación Consejo Estudiantil         │ │
│  │ Estado: ✅ Votado                        │ │
│  │ Finaliza: 15/11/2025 17:00               │ │
│  │                                          │ │
│  │ [ Ver Resultados ]                       │ │
│  └──────────────────────────────────────────┘ │
│                                                │
│  💡 ¿Quiere crear sus propias elecciones?     │
│     [  Convertirme en Administrador  ]        │
└────────────────────────────────────────────────┘
```

### 4.2 Convertirse en Administrador de Elecciones

Si desea crear y gestionar sus propias elecciones:

**Paso 1:** En el panel principal, haga clic en:
> **"Convertirme en Administrador"**

**Paso 2:** El sistema actualizará su cuenta automáticamente

**Paso 3:** Recibirá la confirmación:
> ✅ "Ahora eres administrador de elecciones"

**Paso 4:** Su sesión se actualizará y verá las nuevas opciones de administración

### 4.3 Ver Mis Elecciones

En **"Mis Elecciones"** puede:
- Ver todas las elecciones en las que puede participar
- Conocer el estado de cada elección
- Acceder a votaciones activas
- Ver resultados de elecciones finalizadas

---

## 5. Perfil de Administrador de Elecciones

### 5.1 Panel del Administrador

```
┌────────────────────────────────────────────────┐
│  👤 usuario@correo.com (Administrador)          │
├────────────────────────────────────────────────┤
│  [➕ Nueva Elección] [📊 Mis Elecciones]        │
│                                                │
│  📊 MIS ELECCIONES CREADAS                     │
│  ┌──────────────────────────────────────────┐ │
│  │ 🗳️ Elección de Presidente 2025           │ │
│  │ Estado: ⏳ Activa                         │ │
│  │ Votantes: 45/100                         │ │
│  │                                          │ │
│  │ [ Editar ] [ Ver ] [ Resultados ]        │ │
│  └──────────────────────────────────────────┘ │
│                                                │
│  ┌──────────────────────────────────────────┐ │
│  │ 🗳️ Votación Delegado de Curso           │ │
│  │ Estado: 📝 Creada                        │ │
│  │ Votantes: 0/30                           │ │
│  │                                          │ │
│  │ [ Editar ] [ Agregar Votantes ]          │ │
│  └──────────────────────────────────────────┘ │
└────────────────────────────────────────────────┘
```

### 5.2 Funciones Disponibles
- ✅ Crear nuevas elecciones
- ✅ Configurar fechas y horarios
- ✅ Agregar votantes autorizados
- ✅ Monitorear el progreso de votación
- ✅ Ver resultados

---

## 6. Gestión de Elecciones

### 6.1 Crear una Nueva Elección

**Paso 1:** Haga clic en **"➕ Nueva Elección"**

**Paso 2:** Complete el formulario:

```
┌─────────────────────────────────────────────┐
│  CREAR NUEVA ELECCIÓN                       │
├─────────────────────────────────────────────┤
│  Título de la elección: *                   │
│  [_________________________________]        │
│                                             │
│  Descripción:                               │
│  [_________________________________]        │
│  [_________________________________]        │
│  [_________________________________]        │
│                                             │
│  Fecha de inicio: *                         │
│  [__/__/____] [__:__]                       │
│                                             │
│  Fecha de finalización: *                   │
│  [__/__/____] [__:__]                       │
│                                             │
│  * Campos obligatorios                      │
│                                             │
│  [  Cancelar  ]  [  Crear Elección  ]       │
└─────────────────────────────────────────────┘
```

**Campos:**
- **Título**: Nombre descriptivo de la elección
- **Descripción**: Información adicional sobre la votación
- **Fecha de inicio**: Cuándo se abrirá la votación
- **Fecha de finalización**: Cuándo se cerrará la votación

**Paso 3:** Haga clic en **"Crear Elección"**

**Paso 4:** La elección se crea en estado **"CREADA"**

### 6.2 Agregar Votantes a una Elección

**Importante:** Solo puede agregar votantes ANTES de que inicie la elección.

**Paso 1:** En la lista de elecciones, seleccione la elección

**Paso 2:** Haga clic en **"Agregar Votantes"**

**Paso 3:** Ingrese los correos electrónicos:

```
┌─────────────────────────────────────────────┐
│  AGREGAR VOTANTES                           │
├─────────────────────────────────────────────┤
│  Elección: Votación de Presidente 2025      │
│                                             │
│  Ingrese los correos de los votantes:       │
│  (uno por línea)                            │
│                                             │
│  [_________________________________]        │
│  │ votante1@correo.com                     │
│  │ votante2@correo.com                     │
│  │ votante3@correo.com                     │
│  │                                         │
│  [_________________________________]        │
│                                             │
│  O cargar archivo CSV:                      │
│  [ Seleccionar archivo ]                    │
│                                             │
│  [  Cancelar  ]  [  Agregar Votantes  ]     │
└─────────────────────────────────────────────┘
```

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

Durante la votación, puede ver:

```
┌────────────────────────────────────────────┐
│  MONITOREO: Elección Presidente 2025       │
├────────────────────────────────────────────┤
│  Estado: ⏳ ACTIVA                          │
│  Tiempo restante: 4h 32m                   │
│                                            │
│  📊 ESTADÍSTICAS                           │
│  ├─ Votantes registrados: 100              │
│  ├─ Han votado: 67                         │
│  ├─ Pendientes: 33                         │
│  └─ Participación: 67%                     │
│                                            │
│  📈 Progreso:                              │
│  ████████████████░░░░ 67%                  │
│                                            │
│  🕐 Última actualización: Hace 2 minutos   │
│                                            │
│  [ Actualizar ] [ Enviar Recordatorio ]    │
└────────────────────────────────────────────┘
```

### 6.6 Ver Resultados

Una vez finalizada la elección:

**Paso 1:** Seleccione la elección finalizada

**Paso 2:** Haga clic en **"Ver Resultados"**

**Paso 3:** Visualice los resultados completos

---

## 7. Participación en Votaciones

### 7.1 Acceder a una Votación

**Paso 1:** En su panel, vea las elecciones disponibles

**Paso 2:** Identifique elecciones con estado **"⏳ En curso"**

**Paso 3:** Haga clic en **"Votar"**

### 7.2 Proceso de Votación

```
┌────────────────────────────────────────────┐
│  🗳️ VOTACIÓN                                │
│  Elección de Presidente 2025               │
├────────────────────────────────────────────┤
│  Seleccione su opción:                     │
│                                            │
│  ○ Candidato A - Partido X                 │
│  ○ Candidato B - Partido Y                 │
│  ○ Candidato C - Independiente             │
│  ○ Voto en blanco                          │
│                                            │
│  ⚠️ IMPORTANTE:                            │
│  • Su voto es secreto y anónimo            │
│  • No podrá cambiar su voto después        │
│  • Verifique su selección antes de enviar │
│                                            │
│  [  Cancelar  ]  [  Confirmar Voto  ]      │
└────────────────────────────────────────────┘
```

**Paso 4:** Seleccione su opción

**Paso 5:** Haga clic en **"Confirmar Voto"**

**Paso 6:** Confirme su decisión:

```
┌────────────────────────────────────────────┐
│  ⚠️ CONFIRMACIÓN DE VOTO                    │
├────────────────────────────────────────────┤
│  Ha seleccionado:                          │
│  ➤ Candidato B - Partido Y                 │
│                                            │
│  ¿Está seguro de confirmar su voto?        │
│                                            │
│  Esta acción NO se puede deshacer.         │
│                                            │
│  [  Volver  ]  [  Sí, Confirmar  ]         │
└────────────────────────────────────────────┘
```

**Paso 7:** Recibirá la confirmación:

```
┌────────────────────────────────────────────┐
│  ✅ VOTO REGISTRADO                         │
├────────────────────────────────────────────┤
│  Su voto ha sido registrado exitosamente   │
│                                            │
│  Número de comprobante:                    │
│  #VO-2025-001234                           │
│                                            │
│  Gracias por participar en esta elección   │
│                                            │
│  [  Volver al Panel  ]                     │
└────────────────────────────────────────────┘
```

### 7.3 Verificar que Voté

En su panel verá:
- ✅ Estado: **"Votado"**
- 📅 Fecha y hora del voto registrado
- 🔒 Su voto es confidencial

### 7.4 Ver Resultados (después de finalizar)

**Paso 1:** Espere a que finalice la elección

**Paso 2:** En su panel, haga clic en **"Ver Resultados"**

**Paso 3:** Visualice los resultados:

```
┌────────────────────────────────────────────┐
│  📊 RESULTADOS FINALES                      │
│  Elección de Presidente 2025               │
├────────────────────────────────────────────┤
│  Total de votantes: 100                    │
│  Votos emitidos: 95                        │
│  Participación: 95%                        │
│                                            │
│  RESULTADOS:                               │
│                                            │
│  1️⃣ Candidato B - Partido Y                │
│     ████████████████░░░░ 48 votos (50.5%)  │
│                                            │
│  2️⃣ Candidato A - Partido X                │
│     ████████████░░░░░░░░ 35 votos (36.8%)  │
│                                            │
│  3️⃣ Candidato C - Independiente            │
│     ████░░░░░░░░░░░░░░░░ 10 votos (10.5%)  │
│                                            │
│  4️⃣ Voto en blanco                         │
│     █░░░░░░░░░░░░░░░░░░░ 2 votos (2.1%)    │
│                                            │
│  [ Descargar PDF ] [ Compartir ]           │
└────────────────────────────────────────────┘
```

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

## 10. Soporte y Contacto

### 10.1 Canales de Soporte

**Correo Electrónico:**
soporte@votum.com

**Teléfono:**
(+57) 123-456-7890

**Horario de Atención:**
Lunes a Viernes: 8:00 AM - 6:00 PM
Sábados: 9:00 AM - 1:00 PM

### 10.2 Información a Proporcionar al Contactar Soporte

Para una atención más rápida, proporcione:
- 📧 Su correo electrónico registrado
- 📝 Descripción detallada del problema
- 🖥️ Navegador y sistema operativo que usa
- 📸 Captura de pantalla del error (si aplica)
- 🕐 Hora y fecha en que ocurrió el problema

### 10.3 Recursos Adicionales

**Tutoriales en Video:**
[URL de videos tutoriales]

**Guía Rápida (PDF):**
[URL de guía rápida descargable]

**Centro de Ayuda:**
[URL del centro de ayuda]

---

## 11. Términos y Condiciones

Al usar el sistema Votum, usted acepta:
- Proporcionar información veraz y actualizada
- Mantener la confidencialidad de su contraseña
- Usar el sistema de manera responsable y ética
- No intentar vulnerar la seguridad del sistema
- Respetar la privacidad de otros usuarios

---

## 12. Política de Privacidad

### Datos que Recopilamos:
- Correo electrónico
- Registros de participación en elecciones (NO el contenido del voto)
- Fecha y hora de acceso

### Uso de los Datos:
- Gestión de la cuenta de usuario
- Administración de procesos electorales
- Mejora del servicio

### Seguridad:
Sus datos están protegidos mediante encriptación y medidas de seguridad estándar de la industria.

---

**Versión:** 1.0  
**Última actualización:** Noviembre 2025  
**Sistema Votum** - Votación Electrónica Segura

---

## Notas Finales

Este manual está diseñado para ayudarle a utilizar todas las funciones del Sistema Votum. Si tiene sugerencias para mejorar este documento, por favor contacte al equipo de soporte.

¡Gracias por usar Votum! 🗳️✨
