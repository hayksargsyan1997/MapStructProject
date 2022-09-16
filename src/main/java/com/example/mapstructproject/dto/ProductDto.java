package com.example.mapstructproject.dto;

import com.example.mapstructproject.model.Item;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int id;
    private String name;
    private String description;
    private String quantity;
    private double price;
    private String itemId;

//    private List<Item> itemsList;




}
