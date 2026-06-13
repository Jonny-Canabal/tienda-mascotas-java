package com.tienda.mascotas.service;

import com.tienda.mascotas.entity.Product;
import com.tienda.mascotas.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    /** Obtiene el producto según su ID*/
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    /** Guarda un nuevo producto*/
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /** Actualiza el producto, se establece lo que pude actualizar*/
    public Product updateProduct(Long id, Product product) {

        Optional<Product> optional = productRepository.findById(id);

        Product existingProduct = optional.get();

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setStock(product.getStock());

        return productRepository.save(existingProduct);
    }

    /**Busca producto por Id, lo elimina*/
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
