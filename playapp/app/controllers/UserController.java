package controllers;

import com.google.inject.Inject;
import com.nrslib.clArc.UseCaseBus;
import com.nrslib.usecases.user.add.UserAddInputData;
import com.nrslib.usecases.user.delete.UserDeleteInputData;
import com.nrslib.usecases.user.getDetail.UserGetDetailInputData;
import com.nrslib.usecases.user.getDetail.UserGetDetailOutputData;
import com.nrslib.usecases.user.getList.UserGetListInputData;
import com.nrslib.usecases.user.getList.UserGetListOutputData;
import com.nrslib.usecases.user.update.UserUpdateInputData;
import lib.view.converter.user.UserRoleConverter;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodels.user.UserDetailViewModel;
import viewmodels.user.UserGetListViewModel;
import viewmodels.user.add.UserAddForm;
import viewmodels.user.add.UserAddInputViewModel;
import viewmodels.user.common.UserViewModel;
import viewmodels.user.update.UserUpdateForm;
import viewmodels.user.update.UserUpdateInputViewModel;
import views.html.user.detail;
import views.html.user.index;

import java.util.List;
import java.util.stream.Collectors;

public class UserController extends Controller {
    private final Form<UserAddForm> userAddForm;
    private final Form<UserUpdateForm> userUpdateForm;

    @Inject
    private UseCaseBus bus;

    @Inject
    private UserRoleConverter userRoleConverter;

    @Inject
    public UserController(FormFactory formFactory){
        userAddForm = formFactory.form(UserAddForm.class);
        userUpdateForm = formFactory.form(UserUpdateForm.class);
    }

    public Result index() {
        UserGetListInputData inputData = new UserGetListInputData();
        UserGetListOutputData outputData = bus.handle(inputData);

        List<UserViewModel> userViewModels = outputData.getUsers().stream()
                .map(user -> new UserViewModel(user.getId(), user.getName()))
                .collect(Collectors.toList());

        UserGetListViewModel viewModel = new UserGetListViewModel(userViewModels);

        return ok(index.render(viewModel));
    }

    public Result addInput () {
        return ok(views.html.user.add.input.render(new UserAddInputViewModel(), userAddForm));
    }

    public Result addInputSubmit(){
        Form<UserAddForm> requestForm = userAddForm.bindFromRequest();
        if(requestForm.hasErrors()){
            return badRequest(views.html.user.add.input.render(new UserAddInputViewModel(), requestForm));
        }

        UserAddForm form = requestForm.get();

        UserAddInputData inputData = new UserAddInputData(form.name, userRoleConverter.convert(form.roleId));
        bus.handle(inputData);

        return redirect(routes.UserController.index());
    }

    public Result detail(String id) {
        UserGetDetailInputData inputData = new UserGetDetailInputData(id);
        UserGetDetailOutputData outputData = bus.handle(inputData);

        if(!outputData.getUserData().isPresent()){
            return redirect(routes.UserController.index());
        }

        UserDetailViewModel viewModel = outputData.getUserData()
                .map(x -> new UserDetailViewModel(id, x.getName(), userRoleConverter.convert(x.getRole())))
                .get();

        return ok(detail.render(viewModel));
    }

    public Result updateInput(String id) {
        UserGetDetailInputData inputData = new UserGetDetailInputData(id);
        UserGetDetailOutputData outputData = bus.handle(inputData);

        if(!outputData.getUserData().isPresent()){
            return notFound();
        }

        UserUpdateForm initialForm = new UserUpdateForm();
        initialForm.name = outputData.getUserData().map(x -> x.getName()).get();

        userUpdateForm.fill(initialForm);

        return ok(views.html.user.update.input.render(new UserUpdateInputViewModel(id), userUpdateForm));
    }

    public Result updateInputSubmit(String id){
        Form<UserUpdateForm> requestForm = userUpdateForm.bindFromRequest();
        if(requestForm.hasErrors()){
            return badRequest(views.html.user.update.input.render(new UserUpdateInputViewModel(id), requestForm));
        }

        UserUpdateForm form = requestForm.get();

        UserUpdateInputData inputData = new UserUpdateInputData.Builder(id).name(form.name).build();
        bus.handle(inputData);

        return redirect(routes.UserController.detail(id));
    }

    public Result deleteSubmit(String id) {
        UserDeleteInputData inputData = new UserDeleteInputData(id);
        bus.handle(inputData);

        return redirect(routes.UserController.index());
    }
}
