package com.maldonado.app.test.application.service;


import com.maldonado.app.test.application.port.in.ProductUseCase;
import com.maldonado.app.test.application.port.out.ProductRepositoryPort;
import com.maldonado.app.test.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {
    private final ProductRepositoryPort repositoryPort;



    @Override
    public Product create(Product product) {
        return repositoryPort.save(product);
    }

    @Override
    public Product getById(Long id) {
        return repositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    @Override
    public List<Product> getAll() {
        return repositoryPort.findAll();
    }

    @Override
    public Product update(Long id, Product product) {
        Product existingProduct = getById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        return repositoryPort.save(existingProduct);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repositoryPort.deleteById(id);
    }
}
