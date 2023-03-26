package com.example.api;

import com.example.api.shopping_list.client.ShoppingListClient;
import com.example.api.shopping_list.dto.ErrorResponseDto;
import com.example.api.shopping_list.dto.ShoppingListResponseDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ShoppingListTest extends BaseApiTest {

    private final ShoppingListClient shoppingListClient = new ShoppingListClient();

    @Test
    public void testCreationDefaultShoppingList() {
        String id = createAndGetShoppingListId();
        ShoppingListResponseDto shoppingListResponse = shoppingListClient.getShoppingListById(id);
        soft.assertThat(shoppingListResponse.getList().getId()).isEqualTo(id);
        soft.assertThat(shoppingListResponse.getContent().isEmpty()).isTrue();
        soft.assertAll();
    }

    @Test
    public void testShoppingListNotFoundAfterDeletion() {
        String id = createAndGetShoppingListId();
        shoppingListClient.deleteShoppingList(id);

        Response response = shoppingListClient.getShoppingListByIdRawResponse(id);
        soft.assertThat(response.statusCode()).isEqualTo(200);
        soft.assertThat(response.as(ErrorResponseDto.class)
                                .getMessage())
                .isEqualTo("shoppingList.notFound");
        soft.assertAll();
    }

    private String createAndGetShoppingListId() {
        ShoppingListResponseDto shoppingListCreationResponse = shoppingListClient.createShoppingList("some name",
                                                                                                     false);
        return shoppingListCreationResponse.getList().getId();
    }
}
