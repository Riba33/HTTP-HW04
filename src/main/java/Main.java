import Controller.Console;
import Model.ApiResponse;
import Service.PetService;
import Service.UserService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Console.getInstance().start();
        //System.out.println(UserService.getInstance().deleteByUserName("string"));ApiResponse apiResponse = PetService.getInstance().uploadImage(2L,"C:\\Users\\riba3\\Pictures\\FredaBookImage.jpg", "Cherep");
        //System.out.println(apiResponse);
    }
}
