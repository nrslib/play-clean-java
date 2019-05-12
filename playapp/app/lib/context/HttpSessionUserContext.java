package lib.context;

import com.google.inject.Inject;
import com.nrslib.domain.context.UserContext;
import lib.auth.LoginService;

public class HttpSessionUserContext implements UserContext {
    @Inject
    private LoginService loginService;

    @Override
    public String getId() {
        if(!loginService.isLogin()){
            return null;
        }

        return loginService.getCurrent().getId();
    }
}
