package viewmodels.user;

public class UserDetailViewModel {
    private final String id;
    private final String name;

    public UserDetailViewModel(String id, String name) {
        this.id  = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
