package com.maldonado.app.test.infrastructure.adapter.out.persistence;

import com.maldonado.app.test.application.port.out.ProductRepositoryPort;
import com.maldonado.app.test.domain.Product;
import com.maldonado.app.test.infrastructure.adapter.out.persistence.entity.ProductEntity;
import com.maldonado.app.test.infrastructure.adapter.out.persistence.mapper.ProductMapper;
import com.maldonado.app.test.infrastructure.adapter.out.persistence.repository.SpringDataProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductRepositoryPort {
    private final SpringDataProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapper.toEntity(product);
        ProductEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
