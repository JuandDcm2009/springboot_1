package com.ponscio.service;
import java.util.List;

public interface personaService {
    void createPersona(String cedula, String nombre);
    
    List<String> listPersonas();
} 