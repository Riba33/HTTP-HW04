package Controller;

import Model.ApiResponse;
import Model.User;
import Service.UserService;
import lombok.SneakyThrows;

import java.io.IOException;

public class UserUpdateByUserName extends BaseController{
    public static UserUpdateByUserName userController;

    @SneakyThrows
    public static synchronized UserUpdateByUserName getInstance() {
        if (userController == null) {
            userController = new UserUpdateByUserName();
        }
        return userController;
    }

    public ApiResponse updateUserByUsername() throws IOException {
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
        if(i == true) {
            user = makeUser();
            return userService.updateByUserName(userName, user);
        }
        return null;
    }
}
