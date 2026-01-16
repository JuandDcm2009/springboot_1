package com.ponscio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ponscio.model.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    
} 
