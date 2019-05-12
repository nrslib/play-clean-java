package viewmodels.auth.login;

import play.data.validation.Constraints;

public class AuthLoginForm {
    @Constraints.Required(message="input id")
    @Constraints.MinLength(3)
    @Constraints.MaxLength(10)
    public String id;

    @Constraints.Required(message="input password")
    public String password;
}
