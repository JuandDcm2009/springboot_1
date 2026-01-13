package com.ponscio.model;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Entidad SQL
@Table(name = "autores") // Referencia a tabla
@Getter
@Setter
@AllArgsConstructor //Generar Constructor con todos los atributos
@NoArgsConstructor // Generar Constructor vacio
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column(nullable = false)
    private String cedula;
    @Column
    protected int edad;
}