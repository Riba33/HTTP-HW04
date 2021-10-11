package Controller;

import Model.ApiResponse;
import Service.UserService;
import lombok.SneakyThrows;

public class UserLogIn extends BaseController{
    public static UserLogIn userController;

    @SneakyThrows
    public static synchronized UserLogIn getInstance() {
        if (userController == null) {
            userController = new UserLogIn();
        }
        return userController;
    }

    public ApiResponse userLogIn() {
        System.out.println("Enter user name for login.");
        String userName = scanner.next();
        System.out.println("Enter password for login.");
        String password = scanner.next();
        return UserService.getInstance().loginUser(userName,password);
    }
}
