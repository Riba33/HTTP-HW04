package Repository;

import Model.ApiResponse;
import Model.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RetrofitClientUser {

    @POST("user/createWithList")
    Call<ApiResponse> addListOfUsers(@Body List<User> users);

    @GET("user/{userName}")
    Call<User> getUserByUsername(@Path("userName") String userName);

    @PUT("user/{username}")
    Call<ApiResponse> updateByUserName(@Path("username") String username, @Body User user);

    @DELETE("user/{username}")
    Call<ApiResponse> deleteByUserName(@Path("username") String username);

    @GET("user/login")
    Call<ApiResponse> loginUser(@Query("username") String username, @Query("password") String password);

    @GET("user/login")
    Call<ApiResponse> logoutUser();

    @POST("user/createWithArray")
    Call<ApiResponse> addArrayOfUsers(@Body User[] users);

    @POST("user")
    Call<ApiResponse> addUser(@Body User user);
}
