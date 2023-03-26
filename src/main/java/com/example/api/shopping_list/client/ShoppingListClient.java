package com.example.api.shopping_list.client;

import com.example.api.BaseClient;
import com.example.api.shopping_list.dto.CreateShoppingListReqBodyDto;
import com.example.api.shopping_list.dto.ShoppingListResponseDto;
import io.restassured.response.Response;

public class ShoppingListClient extends BaseClient {

    private final static String ENDPOINT = "/list/v2";

    public ShoppingListResponseDto createShoppingList(String name, boolean primary) {
        CreateShoppingListReqBodyDto body = CreateShoppingListReqBodyDto.builder()
                .name(name)
                .primary(primary)
                .build();
        return post(ENDPOINT, body, ShoppingListResponseDto.class);
    }

    public ShoppingListResponseDto getShoppingListById(String id) {
        return get(buildUriWithPathParam(id), ShoppingListResponseDto.class);
    }

    public Response getShoppingListByIdRawResponse(String id) {
        return get(buildUriWithPathParam(id));
    }

    public void deleteShoppingList(String id) {
        delete(buildUriWithPathParam(id));
    }

    private String buildUriWithPathParam(String pathParam) {
        return String.format(ENDPOINT + "/%s", pathParam);
    }
}
