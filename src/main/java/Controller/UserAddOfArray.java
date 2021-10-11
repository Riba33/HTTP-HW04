package Controller;

import Model.ApiResponse;
import Model.User;
import Service.UserService;
import lombok.SneakyThrows;

import java.util.List;

public class UserAddOfArray extends BaseController{
    public static UserAddOfArray userController;

    @SneakyThrows
    public static synchronized UserAddOfArray getInstance() {
        if (userController == null) {
            userController = new UserAddOfArray();
        }
        return userController;
    }
    public ApiResponse usersAddOfArray(){
        List<User> users = UserPostFromList.getInstance().makeUserList();
        User[] arrayUsers = users.toArray(new User[users.size()]);
        return UserService.getInstance().addArrayOfUsers(arrayUsers);
    }
}
