package Controller;

import Model.ApiResponse;
import Model.User;
import Service.UserService;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

public class UserController extends BaseController{
    public static UserController userController;

    @SneakyThrows
    public static synchronized UserController getInstance() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }
    public void userMenu() throws IOException {
        System.out.println("Select query.\n" +
                "1 - add users from list.\n" +
                "2 - get user by username.\n" +
                "3 - update user by username.\n" +
                "4 - delete user by username.\n" +
                "5 - logs user into the system.\n" +
                "6 - logs out current logged in user session.\n" +
                "7 - add users from array.\n" +
                "8 - add user.\n" +
                "0 - return to previous menu.");
        int i = selectNumber(8, 0);
        switchSelected(i);
    }
    private void switchSelected(int i) throws IOException {
        switch (i){
            case 1:
                List<User> users = UserPostFromList.getInstance().makeUserList();
                ApiResponse apiResponse = UserService.getInstance().addListOfUser(users);
                System.out.println(apiResponse);
                break;
            case 2:
                User user = UserGetByUsername.getInstance().getUserByUserName();
                System.out.println(user);
                break;
            case 3:
                ApiResponse apiResponse1 = UserUpdateByUserName.getInstance().updateUserByUsername();
                System.out.println(apiResponse1);
                break;
            case 4:
                ApiResponse apiResponse2 = UserDeleteByUsername.getInstance().userDeleteByUserName();
                System.out.println(apiResponse2);
                break;
            case 5:
                ApiResponse apiResponse3 = UserLogIn.getInstance().userLogIn();
                System.out.println(apiResponse3);
                break;
            case 6:
                ApiResponse apiResponse4 = UserLogOut.getInstance().userLogOut();
                System.out.println(apiResponse4);
                break;
            case 7:
                ApiResponse apiResponse5 = UserAddOfArray.getInstance().usersAddOfArray();
                System.out.println(apiResponse5);
                break;
            case 8:
                User user1 = makeUser();
                ApiResponse apiResponse6 = UserService.getInstance().addUser(user1);
                System.out.println(apiResponse6);
                break;
            case 0: Console.getInstance().start();
            break;
        }
    }

}
