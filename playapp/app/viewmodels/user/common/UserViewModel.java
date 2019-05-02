package viewmodels.user.common;

public class UserViewModel {
    private final String id;
    private final String name;

    public UserViewModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
