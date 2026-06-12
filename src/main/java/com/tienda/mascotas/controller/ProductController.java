package com.tienda.mascotas.controller;

import com.tienda.mascotas.entity.Product;
import com.tienda.mascotas.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST encargado de recibir las peticiones relacionadas
 * con los productos y devolver las respuestas al cliente.
 *
 * Actúa como punto de entrada de la aplicación.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*** Obtiene todos los productos registrados. ** @return Lista de productos.*/
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
