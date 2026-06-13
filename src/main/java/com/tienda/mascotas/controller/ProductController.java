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

    /**Busca el producto por id, actualiza*/
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product){

        Optional<Product> existingProduct = productService.getProductById(id);

        if(existingProduct.isEmpty()){
            return ResponseEntity.status(404).body("Producto no encontrado");
        }

        Product updatedProduct = productService.updateProduct(id, product);

        return ResponseEntity.ok(updatedProduct);
    }

    /*** Elimina un producto por su ID.* Devuelve 404 si el producto no existe.*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){

        Optional<Product> existingProduct = productService.getProductById(id);

        if(existingProduct.isEmpty()){
            return ResponseEntity.status(404).body("Producto no encontrado");
        }

        productService.deleteProduct(id);
        return ResponseEntity.ok("Producto eliminado");
    }
}
