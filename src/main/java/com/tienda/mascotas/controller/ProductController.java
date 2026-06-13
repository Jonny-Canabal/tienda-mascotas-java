package com.tienda.mascotas.controller;

import com.tienda.mascotas.entity.Product;
import com.tienda.mascotas.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    /*** Busca un producto por su ID. Retorna el producto si existe o un mensaje de error 404 si no es encontrado.*/
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.getProductById(id);

        if(product.isEmpty()){
            return ResponseEntity.status(404).body("Producto no encontrado");
        }

        return ResponseEntity.ok(product.get());
    }

    /** Crea un nuevo producto*/
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
