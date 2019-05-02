package viewmodels.user.update;

public class UserUpdateInputViewModel {
    private final String id;

    public UserUpdateInputViewModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
