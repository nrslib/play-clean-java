package controllers;

import com.google.inject.Inject;
import com.nrslib.clArc.UseCaseBus;
import com.nrslib.usecases.account.commons.AccountInfo;
import com.nrslib.usecases.account.getInfo.AccountGetInfoInputData;
import com.nrslib.usecases.account.getInfo.AccountGetInfoOutputData;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodels.account.AccountIndexViewModel;

public class AccountController extends Controller {
    @Inject
    private UseCaseBus bus;

    public Result index(){
        AccountGetInfoInputData inputData = new AccountGetInfoInputData();
        AccountGetInfoOutputData outputData = bus.handle(inputData);

        AccountInfo accountInfo = outputData.getAccountInfo();
        AccountIndexViewModel viewModel = new AccountIndexViewModel(accountInfo.getId(), accountInfo.getName());

        return ok(views.html.account.index.render(viewModel));
    }
}
