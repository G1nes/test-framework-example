package ui.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthorizationDto {

    private final String email;
    private final String password;
}
