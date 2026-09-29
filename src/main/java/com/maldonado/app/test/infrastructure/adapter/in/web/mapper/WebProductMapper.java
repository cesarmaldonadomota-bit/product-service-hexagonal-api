package com.maldonado.app.test.infrastructure.adapter.in.web.mapper;

import com.maldonado.app.test.domain.Product;
import com.maldonado.app.test.infrastructure.adapter.in.web.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WebProductMapper {

    Product toDomain(ProductDto dto);

    ProductDto toDto(Product domain);
    List<ProductDto> toDtoList(List<Product> domainList);
}