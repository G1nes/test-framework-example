package ui.steps;

import ui.dto.AuthorizationDto;
import ui.pages.home.UnauthorizedHomePage;

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
