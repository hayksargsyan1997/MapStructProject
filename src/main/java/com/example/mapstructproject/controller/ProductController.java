package com.example.mapstructproject.controller;

import com.example.mapstructproject.dto.ProductDto;
import com.example.mapstructproject.mapper.ProductMapper;
import com.example.mapstructproject.model.Product;
import com.example.mapstructproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productRepository.save(
                productMapper.dtoToModel(productDto)), HttpStatus.CREATED);

    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll(){
        return new ResponseEntity<>(productMapper
                .modelsToDto(productRepository.findAll()),HttpStatus.OK);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable ("id") int id){
        return new ResponseEntity<>(productMapper.modelToDto(productRepository
                .findById(id).get()),HttpStatus.OK);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ("id") int id){
        ProductDto productDto = productMapper.modelToDto(productRepository.findById(id).get());
        productRepository.deleteById(productDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }
}
