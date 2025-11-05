package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev") //
public class MensajeDevService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("*************************************************");
        System.out.println("BIENVENIDO AL GESTOR (Modo DEV)");
        System.out.println("Iniciando aplicación en modo de desarrollo...");
        System.out.println("*************************************************");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("*************************************************");
        System.out.println("Cerrando aplicación (Modo DEV). ¡Feliz coding!");
        System.out.println("*************************************************");
    }
}