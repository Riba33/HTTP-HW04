package Controller;

import Model.User;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class UserPostFromList extends BaseController{
    public static UserPostFromList userController;

    @SneakyThrows
    public static synchronized UserPostFromList getInstance() {
        if (userController == null) {
            userController = new UserPostFromList();
        }
        return userController;
    }


    public List<User> makeUserList(){
        List<User> list = new ArrayList<>();
        do {
            list.add(makeUser());
            System.out.println("Add 1 more item?");
        } while (yesOrNo());
        return list;
    }



}
