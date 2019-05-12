package viewmodels.auth;

public class AuthCheckViewModel {
    private final boolean login;

    public AuthCheckViewModel(boolean login) {
        this.login = login;
    }

    public boolean isLogin(){ return login; }
}
