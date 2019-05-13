package viewmodels.user.update;

import play.data.validation.Constraints;

public class UserUpdateForm {
    @Constraints.Required(message="type name")
    @Constraints.MinLength(3)
    @Constraints.MaxLength(10)
    public String name;
}
