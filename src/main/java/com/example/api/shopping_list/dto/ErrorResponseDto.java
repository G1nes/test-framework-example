package com.example.api.shopping_list.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorResponseDto {
    private String code;
    private String message;
    @JsonProperty("error_code")
    private String errorCode;
}
