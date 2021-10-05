import Model.*;
import Service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        UserService service = UserService.getInstance();
        User user = User.builder()
                .id(1L)
                .username("Anton")
                .lastName("Anton")
                .firstName("Kolukov")
                .email("gluk@gmail.com")
                .userStatus(2)
                .build();
        User user1 = User.builder()
                .id(2L)
                .username("Vova")
                .lastName("Baran")
                .firstName("Ovtc")
                .email("baran@gmail.com")
                .userStatus(4)
                .build();
        User[] users = {user,user1};
        System.out.println(service.addUser(user));
        System.out.println(service.addUser(user1));
    }
}
