package controllers;

import com.google.inject.Inject;
import com.nrslib.clArc.UseCaseBus;
import com.nrslib.usecases.user.getList.UserGetListInputData;
import com.nrslib.usecases.user.getList.UserGetListOutputData;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
    public Result index()
    {
        return ok(index.render("Your new application is ready."));
    }
}
