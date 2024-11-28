package com.gestion.gestion_productos.service;
import com.gestion.gestion_productos.model.Producto;
import com.gestion.gestion_productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public List<Producto> listarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto modificarProducto(Long id, Producto producto) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto productoExistente = optionalProducto.get();
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setValor(producto.getValor());
            productoExistente.setCantidad(producto.getCantidad());
            return productoRepository.save(productoExistente);
        }
        return null;
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}