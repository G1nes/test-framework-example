package com.example.ui.steps;

import com.example.ui.dto.AuthorizationDto;
import com.example.ui.pages.home.UnauthorizedHomePage;

public class AuthorizationSteps {

    private final AuthorizationDto authorization;

    public AuthorizationSteps(AuthorizationDto authorization) {
        this.authorization = authorization;
    }

    public void authorizeByEmail() {
        validateAuthorization();
        new UnauthorizedHomePage()
                .clickLogin()
                .fillEmailOrPhoneNumber(authorization.getEmail())
                .pressContinue()
                .fillPassword(authorization.getPassword())
                .pressLogin();
    }

    private void validateAuthorization() {
        if (authorization.getEmail() == null ||
            authorization.getPassword() == null) {
            throw new RuntimeException("email or password is null");
        }
    }
}
