package viewmodels.user;

import viewmodels.user.common.UserViewModel;

import java.util.List;

public class UserGetListViewModel {
    private final List<UserViewModel> users;

    public UserGetListViewModel(List<UserViewModel> users) {
        this.users = users;
    }

    public List<UserViewModel> getUsers() {
        return users;
    }
}
