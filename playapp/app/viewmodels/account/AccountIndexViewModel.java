package viewmodels.account;

public class AccountIndexViewModel {
    private final String id;
    private final String name;

    public AccountIndexViewModel(String id, String name) {
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
