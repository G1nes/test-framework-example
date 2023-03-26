package com.example.api.shopping_list.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateShoppingListReqBodyDto {

    private String name;
    private Boolean primary;
}
