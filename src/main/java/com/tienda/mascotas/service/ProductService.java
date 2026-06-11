package com.tienda.mascotas.service;

import com.tienda.mascotas.entity.Product;
import com.tienda.mascotas.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contiene la lógica de negocio relacionada con los productos.
 * Actúa como intermediario entre el Controller y el Repository.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    /** Obtiene todos los productos registrados en la base de datos. */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
