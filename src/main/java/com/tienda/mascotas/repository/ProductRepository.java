package com.tienda.mascotas.repository;

import com.tienda.mascotas.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository hereda el contrato definido por JpaRepository.
 *
 * Repositorio encargado de las operaciones de acceso a datos
 * para la entidad Product.
 *
 * Spring Data JPA implementa automáticamente los métodos
 * básicos como guardar, buscar, actualizar y eliminar.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
