package Controller;

import Model.ApiResponse;
import Service.UserService;
import lombok.SneakyThrows;

public class UserLogOut {
    public static UserLogOut userController;

    @SneakyThrows
    public static synchronized UserLogOut getInstance() {
        if (userController == null) {
            userController = new UserLogOut();
        }
        return userController;
    }
    public ApiResponse userLogOut(){
        return UserService.getInstance().logOutUser();
    }
}
