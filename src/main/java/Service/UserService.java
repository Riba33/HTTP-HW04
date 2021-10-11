package Service;

import Model.ApiResponse;
import Model.User;
import Repository.RetrofitClientUser;
import Util.RetrofitConfig;
import lombok.SneakyThrows;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

public class UserService {
    private static UserService service;
    @SneakyThrows
    public static synchronized UserService getInstance(){
        if (service == null) {
            service = new UserService();
        }
        return service;
    }
    RetrofitClientUser clientUser = RetrofitConfig.createClient(RetrofitClientUser.class);

    @SneakyThrows
    public ApiResponse addListOfUser(List<User> users){
        Call<ApiResponse> call = clientUser.addListOfUsers(users);
        return RetrofitConfig.execute(call);
    }


    public User getUserByUserName(String userName) throws IOException {
        Call<User> call;
        User user;
        try {
            call = clientUser.getUserByUsername(userName);
            user = RetrofitConfig.execute(call);
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    @SneakyThrows
    public ApiResponse updateByUserName(String userName, User user){
        Call<ApiResponse> call = clientUser.updateByUserName(userName, user);
        return RetrofitConfig.execute(call);
    }
    @SneakyThrows
    public ApiResponse deleteByUserName(String userName){
        Call<ApiResponse> call = clientUser.deleteByUserName(userName);
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse loginUser(String userName, String password){
        Call<ApiResponse> call = clientUser.loginUser(userName, password);
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse logOutUser(){
        Call<ApiResponse> call = clientUser.logoutUser();
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse addArrayOfUsers(User[] users){
        Call<ApiResponse> call = clientUser.addArrayOfUsers(users);
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse addUser(User user){
        Call<ApiResponse> call = clientUser.addUser(user);
        return RetrofitConfig.execute(call);
    }
}
