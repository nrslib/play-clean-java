package viewmodels.user.add;

import play.data.validation.Constraints;

public class UserAddForm {
    @Constraints.Required(message="type name")
    @Constraints.MaxLength(10)
    public String name;

    @Constraints.Required(message="check role")
    public String roleId;
}
