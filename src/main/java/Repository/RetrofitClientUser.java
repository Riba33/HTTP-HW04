package Repository;

import Model.ApiResponse;
import Model.Order;
import Model.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RetrofitClientUser {

    @POST("user/createWithList")
    @Headers("Content-Type: application/json")
    Call<ApiResponse> addListOfUsers(@Body List<User> users);

    @POST("user/{username}")
    @Headers("Content-Type: application/json")
    Call<User> getUserByUsername(@Path("username") String userName);

    @PUT("user/{username}")
    @Headers("Content-Type: application/json")
    Call<ApiResponse> updateByUserName(@Path("username") String username, @Body User user);

    @DELETE("user/{username}")
    @Headers("Content-Type: application/json")
    Call<ApiResponse> deleteByUserName(@Path("username") String username);

    @GET("user/login")
    @Headers("Content-Type: application/json")
    Call<ApiResponse> loginUser(@Query("username") String username, @Query("password") String password);

    @GET("user/login")
    @Headers("Content-Type: application/json")
    Call<ApiResponse> logoutUser();

    @POST("user/createWithArray")
    @Headers("Content-Type: application/json")
    Call<ApiResponse> addArrayOfUsers(@Body User[] users);

    @POST("user")
    @Headers("Content-Type: application/json")
    Call<ApiResponse> addUser(@Body User user);
}
