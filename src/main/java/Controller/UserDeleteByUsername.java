package Controller;

import Model.ApiResponse;
import Model.User;
import Service.UserService;
import lombok.SneakyThrows;

import java.io.IOException;

public class UserDeleteByUsername extends BaseController{
    public static UserDeleteByUsername userController;

    @SneakyThrows
    public static synchronized UserDeleteByUsername getInstance() {
        if (userController == null) {
            userController = new UserDeleteByUsername();
        }
        return userController;
    }
    public ApiResponse userDeleteByUserName() throws IOException {
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
            } else {i = true; break;}
        } while (i == true);
        if(i == true)
        {
            return userService.deleteByUserName(userName);
        }
        return null;
    }
}
