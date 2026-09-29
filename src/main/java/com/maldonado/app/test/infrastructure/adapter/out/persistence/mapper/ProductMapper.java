package com.maldonado.app.test.infrastructure.adapter.out.persistence.mapper;


import com.maldonado.app.test.domain.Product;
import com.maldonado.app.test.infrastructure.adapter.out.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toDomain(ProductEntity entity);
    ProductEntity toEntity(Product domain);
}
