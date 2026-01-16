package com.ponscio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ponscio.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    public List<Producto> findByNombre(String name);
    public List<Producto> findByCantidad(int cantidad);

    //@Modifying(clearAutomatically = true)
    //@Query("UPDATE productos p set p.cantidad = p.cantidad + :newCantidad where p.id = :id")
    //Boolean updateProducto(@Param("newCantidad") int newCantidad, @Param("id") Long id);
    
}
