package com.gestion.gestion_productos.repository;


import com.gestion.gestion_productos.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre);
}