package com.ponscio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ponscio.model.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Long>{
}
