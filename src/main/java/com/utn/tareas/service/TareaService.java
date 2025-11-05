package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;


    @Value("${app.nombre}") // [cite: 77]
    private String appNombre;

    @Value("${app.max-tareas}") // [cite: 77]
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}") // [cite: 77]
    private boolean mostrarEstadisticas;


    public TareaService(TareaRepository tareaRepository) { // [cite: 63]
        this.tareaRepository = tareaRepository;
    }



    public Tarea agregarTarea(String descripcion, Prioridad prioridad) { // [cite: 64]

        if (tareaRepository.obtenerTodas().size() >= maxTareas) { // [cite: 78]
            System.out.println("Error: No se pueden agregar más tareas. Límite (" + maxTareas + ") alcanzado.");
            return null;
        }

        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setDescripcion(descripcion);
        nuevaTarea.setPrioridad(prioridad);
        nuevaTarea.setCompletada(false);

        return tareaRepository.guardar(nuevaTarea);
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public Tarea marcarComoCompletada(Long id) {
        Optional<Tarea> tareaOpt = tareaRepository.buscarPorId(id);
        if (tareaOpt.isPresent()) {
            Tarea tarea = tareaOpt.get();
            tarea.setCompletada(true);
            return tareaRepository.actualizar(tarea);
        }
        System.out.println("Error: No se encontró la tarea con ID " + id);
        return null;
    }

    public String obtenerEstadisticas() {

        if (!mostrarEstadisticas) {
            return "Las estadísticas están desactivadas.";
        }

        long total = tareaRepository.obtenerTodas().size();
        long completadas = listarCompletadas().size();
        long pendientes = total - completadas;

        return String.format("Estadísticas: Total=%d, Completadas=%d, Pendientes=%d",
                total, completadas, pendientes);
    }



    public void mostrarConfiguracion() { // [cite: 78]
        System.out.println("--- Configuración de la App ---");
        System.out.println("Nombre: " + appNombre);
        System.out.println("Límite de tareas: " + maxTareas);
        System.out.println("Mostrar estadísticas: " + mostrarEstadisticas);
        System.out.println("---------------------------------");
    }
}