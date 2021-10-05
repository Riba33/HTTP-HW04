package Service;

import Model.ApiResponse;
import Model.User;
import Repository.RetrofitClientUser;
import Util.RetrofitConfig;
import lombok.SneakyThrows;
import retrofit2.Call;

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
    RetrofitClientUser store = RetrofitConfig.createClient(RetrofitClientUser.class);

    @SneakyThrows
    public ApiResponse addListOfUser(List<User> users){
        Call<ApiResponse> call = store.addListOfUsers(users);
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public User getUserByUserName(String userName){
        Call<User> call = store.getUserByUsername(userName);
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse updateByUserName(String userName, User user){
        Call<ApiResponse> call = store.updateByUserName(userName, user);
        return RetrofitConfig.execute(call);
    }
    @SneakyThrows
    public ApiResponse deleteByUserName(String userName){
        Call<ApiResponse> call = store.deleteByUserName(userName);
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse loginUser(String userName, String password){
        Call<ApiResponse> call = store.loginUser(userName, password);
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse logoutUser(){
        Call<ApiResponse> call = store.logoutUser();
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse addArrayOfUsers(User[] users){
        Call<ApiResponse> call = store.addArrayOfUsers(users);
        return RetrofitConfig.execute(call);
    }

    @SneakyThrows
    public ApiResponse addUser(User user){
        Call<ApiResponse> call = store.addUser(user);
        return RetrofitConfig.execute(call);
    }
}
