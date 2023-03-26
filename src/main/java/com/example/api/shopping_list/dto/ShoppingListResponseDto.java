package com.example.api.shopping_list.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class ShoppingListResponseDto {

    private ShoppingListDto list;
    private JsonNode content;
}
