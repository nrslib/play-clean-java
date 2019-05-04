package viewmodels.user;


public class UserDetailViewModel {
    private final String id;
    private final String name;
    private final String roleId;

    public UserDetailViewModel(String id, String name, String roleId) {
        this.id  = id;
        this.name = name;
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoleId() { return roleId; }
}
