package Controller;

import Model.User;
import Service.UserService;
import lombok.SneakyThrows;

import java.io.IOException;

public class UserGetByUsername extends BaseController{
    public static UserGetByUsername userController;

    @SneakyThrows
    public static synchronized UserGetByUsername getInstance() {
        if (userController == null) {
            userController = new UserGetByUsername();
        }
        return userController;
    }

    public User getUserByUserName() throws IOException {
        String userName;
        UserService userService = UserService.getInstance();
        User user;
        boolean i = false;
        do {
            userName = getUsername();
            user = userService.getUserByUserName(userName);
            if (user == null) {
                System.out.println("This userName is not found.\nDo you want enter another userName?");
                i = yesOrNo();
            } else i = false;
        } while (i == true);
        return user;
    }
}
