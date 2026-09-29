package com.maldonado.app.test.infrastructure.adapter.in.web;

import com.maldonado.app.test.application.port.in.ProductUseCase;
import com.maldonado.app.test.domain.Product;
import com.maldonado.app.test.infrastructure.adapter.in.web.dto.ProductDto;
import com.maldonado.app.test.infrastructure.adapter.in.web.mapper.WebProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;
    private final WebProductMapper mapper;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductDto requestDto) {
        Product productDomain = mapper.toDomain(requestDto);
        Product createdProduct = productUseCase.create(productDomain);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toDto(createdProduct));
    }
    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAll() {
        List<Product> products = productUseCase.getAll();
        return ResponseEntity.ok(mapper.toDtoList(products));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        Product product = productUseCase.getById(id);
        return ResponseEntity.ok(mapper.toDto(product));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id,@Valid @RequestBody ProductDto requestDto) {
        Product product = productUseCase.update(id, mapper.toDomain(requestDto));
        return ResponseEntity.ok(mapper.toDto(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}