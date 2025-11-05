package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
        this.tareaService = tareaService;
        this.mensajeService = mensajeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mensajeService.mostrarBienvenida();

        tareaService.mostrarConfiguracion();

        System.out.println("\n--- 3. Tareas Iniciales ---");
        tareaService.listarTodas().forEach(System.out::println);

        System.out.println("\n--- 4. Agregando nueva tarea ---");
        Tarea nueva = tareaService.agregarTarea("Estudiar @Value y @Profile", Prioridad.ALTA);
        if (nueva != null) {
            System.out.println("Agregada: " + nueva);
        }

        System.out.println("\n--- 5. Tareas Pendientes ---");
        tareaService.listarPendientes().forEach(System.out::println);

        System.out.println("\n--- 6. Marcando tarea ID 1 como completada ---");
        tareaService.marcarComoCompletada(1L);

        System.out.println("\n--- 7. Estadísticas ---");
        System.out.println(tareaService.obtenerEstadisticas());

        System.out.println("\n--- 8. Tareas Completadas ---");
        tareaService.listarCompletadas().forEach(System.out::println);

        System.out.println();
        mensajeService.mostrarDespedida();
    }
}