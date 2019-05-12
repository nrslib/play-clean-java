package lib.auth;

public class AppAccountInfo {
    private final String id;
    private final String name;

    public AppAccountInfo(String id, String name) {
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
