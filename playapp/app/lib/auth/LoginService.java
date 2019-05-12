package lib.auth;

import com.google.inject.Inject;
import jdk.nashorn.internal.ir.ReturnNode;
import play.cache.CacheApi;
import play.mvc.Http;
import scala.App;

import java.util.UUID;

public class LoginService {
    private final int cacheDuration = 20 * 60;
    private final String tokenName = "token";

    @Inject
    private CacheApi cache;

    public void login(String id, AppAccountInfo accountInfo) {
        Http.Context context = Http.Context.current();
        context.session().clear();

        String cacheId = UUID.randomUUID().toString();
        cache.set(cacheId, accountInfo, cacheDuration);

        context.session().put(tokenName, cacheId);
    }

    public void logout() {
        Http.Context context = Http.Context.current();
        context.session().clear();
    }

    public boolean isLogin() {
        Http.Context context = Http.Context.current();
        String cacheId = context.session().get(tokenName);
        AppAccountInfo accountInfo = cache.get(cacheId);
        return accountInfo != null;
    }

    public AppAccountInfo getCurrent() {
        Http.Context context = Http.Context.current();
        String cacheId = context.session().get(tokenName);
        AppAccountInfo accountInfo = cache.get(cacheId);
        return accountInfo;
    }
}
