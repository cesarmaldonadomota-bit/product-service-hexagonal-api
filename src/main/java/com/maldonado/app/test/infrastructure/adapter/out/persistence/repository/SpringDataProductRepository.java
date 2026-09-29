package com.maldonado.app.test.infrastructure.adapter.out.persistence.repository;

import com.maldonado.app.test.infrastructure.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {

}
