package com.example.mapstructproject.mapper;

import com.example.mapstructproject.dto.ProductDto;
import com.example.mapstructproject.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface ProductMapper {

    ProductMapper instance= Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
//    @Mapping(source = "product.items",target = "itemsList")
    ProductDto modelToDto(Product product);

    List<ProductDto> modelsToDto(List<Product> products);

    @InheritInverseConfiguration
    Product dtoToModel(ProductDto productDto);


}
