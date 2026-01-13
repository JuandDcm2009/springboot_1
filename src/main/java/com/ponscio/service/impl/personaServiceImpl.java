package com.ponscio.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ponscio.service.personaService;

@Service
public class personaServiceImpl implements personaService {
    
    @Override
    public void createPersona(String cedula, String nombre) {
        System.out.println("asdjkhasjidghijas");
    }

    @Override
    public List<String> listPersonas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listPersonas'");
    }
    
}