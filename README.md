# TPSpringBoot

Gestor de Tareas - TP Programación III (UTN)
Este es un proyecto de Spring Boot desarrollado como parte del Trabajo Práctico "Fundamentos de Spring Boot" de la materia Programación III.

El objetivo es construir una API REST (aunque en este TP la probamos por consola) para gestionar una lista de tareas (To-Do List), aplicando conceptos profesionales como Inyección de Dependencias, Repositorios, Servicios y Perfiles de Entorno (dev/prod).

Tecnologías Utilizadas
Java 17+

Spring Boot 3.x

Maven

Lombok (para reducir código boilerplate)

Spring Boot DevTools (para recarga automática)

Características Principales
Gestión de Tareas: Permite agregar, listar (todas, pendientes, completadas) y marcar tareas como completadas.

Simulación de Persistencia: Utiliza un @Repository en memoria para simular una base de datos.

Lógica de Negocio: La lógica está separada en un @Service (TareaService).

Configuración Externa: Lee propiedades desde application.properties usando @Value.

Perfiles de Entorno: Utiliza @Profile para cambiar el comportamiento de la aplicación y las propiedades según el entorno (dev o prod).

Cómo Clonar y Ejecutar el Proyecto
Clonar el repositorio:

Bash

git clone https://github.com/AgusAguilera/TPSpringBoot.git
cd tareas
Ejecutar con Maven (desde la terminal):

Bash

mvn spring-boot:run
Ejecutar desde IntelliJ IDEA:

Abrí el proyecto.

Buscá la clase TareasApplication.java.

Hacé clic derecho -> Run 'TareasApplication'.

Cómo Cambiar entre Perfiles (dev/prod)
El proyecto utiliza spring.profiles.active para cambiar la configuración.

Perfil dev (Por defecto)
No es necesario hacer nada. El archivo application.properties está configurado para usar dev por defecto.

Perfil prod
Para ejecutar el proyecto en modo producción en IntelliJ IDEA:

Andá a Run -> Edit Configurations...

En la ventana de TareasApplication, buscá el campo "Active profiles".

Escribí prod en ese campo.

Hacé clic en Apply y OK.

Ejecutá la aplicación.

1. Ejecución en Perfil dev
Muestra mensajes de bienvenida detallados.

Límite de tareas: 10

Estadísticas: Habilitadas

<img width="1793" height="855" alt="image" src="https://github.com/user-attachments/assets/e58e2ea4-f87e-46a8-8006-c47519d32daf" />

2. Ejecución en Perfil prod
Muestra mensajes de bienvenida simples.

Límite de tareas: 1000 

Estadísticas: Deshabilitadas 

<img width="1823" height="926" alt="image" src="https://github.com/user-attachments/assets/ce88c172-0ad3-43f3-8e2c-241174aade4a" />

Conclusiones Personales
Este TP me ayudó a entender la importancia de la Inyección de Dependencias para desacoplar el código. El concepto de Perfiles me pareció muy útil para manejar diferentes configuraciones dentro de un mismo código y realizar distintas pruebas.

Autor
Nombre: Matías Agustín Aguilera Vega

Legajo: 50747
