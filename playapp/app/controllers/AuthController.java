package controllers;

import com.google.inject.Inject;
import com.nrslib.clArc.UseCaseBus;
import com.nrslib.usecases.account.commons.AccountInfo;
import com.nrslib.usecases.auth.login.AuthLoginInputData;
import com.nrslib.usecases.auth.login.AuthLoginOutputData;
import lib.auth.AppAccountInfo;
import lib.auth.LoginService;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodels.auth.AuthCheckViewModel;
import viewmodels.auth.login.AuthLoginForm;

public class AuthController extends Controller {
    private final Form<AuthLoginForm> authLoginForm;

    @Inject
    private UseCaseBus bus;

    @Inject
    private LoginService loginService;

    @Inject
    public AuthController(FormFactory formFactory){
        authLoginForm = formFactory.form(AuthLoginForm.class);
    }

    public Result login() {
        return ok(views.html.auth.login.render(authLoginForm));
    }

    public Result submit() {
        Form<AuthLoginForm> requestForm = authLoginForm.bindFromRequest();
        if(requestForm.hasErrors()) {
            return badRequest(views.html.auth.login.render(requestForm));
        }

        AuthLoginForm form = requestForm.get();

        AuthLoginInputData inputData = new AuthLoginInputData(form.id, form.password);
        AuthLoginOutputData outputData = bus.handle(inputData);

        if(outputData.isSuccess()) {
            AccountInfo accountInfo = outputData.getAccountInfo();
            AppAccountInfo appAccountInfo = new AppAccountInfo(accountInfo.getId(), accountInfo.getName());
            loginService.login(accountInfo.getId(), appAccountInfo);

            return redirect(routes.AuthController.check());
        }else{
            return redirect(routes.AuthController.login());
        }
    }

    public Result logout() {
        loginService.logout();
        return redirect(routes.AuthController.check());
    }

    public Result check() {
        AuthCheckViewModel viewModel = new AuthCheckViewModel(loginService.isLogin());
        return ok(views.html.auth.check.render(viewModel));
    }
}
