package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {


    private final List<Tarea> tareas = new ArrayList<>();

    private final AtomicLong contadorId = new AtomicLong(1);

    public TareaRepository() {
        // Inicializa la lista con tareas de ejemplo [cite: 121]
        tareas.add(new Tarea(contadorId.getAndIncrement(), "Comprar leche", false, Prioridad.MEDIA));
        tareas.add(new Tarea(contadorId.getAndIncrement(), "Terminar TP de Spring Boot", false, Prioridad.ALTA));
        tareas.add(new Tarea(contadorId.getAndIncrement(), "Llamar al dentista", true, Prioridad.BAJA));
    }


    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas); // Devuelve una copia para no modificar la original
    }


    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }


    public Tarea guardar(Tarea tarea) {
        // Asigna un nuevo ID automático
        tarea.setId(contadorId.getAndIncrement());
        tareas.add(tarea);
        return tarea;
    }


    public Tarea actualizar(Tarea tarea) {
        buscarPorId(tarea.getId()).ifPresent(t -> {
            t.setDescripcion(tarea.getDescripcion());
            t.setCompletada(tarea.isCompletada());
            t.setPrioridad(tarea.getPrioridad());
        });
        return tarea;
    }


    public void eliminarPorId(Long id) {
        tareas.removeIf(t -> t.getId().equals(id));
    }
}