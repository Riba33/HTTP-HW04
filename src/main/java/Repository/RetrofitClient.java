package Repository;

import Model.Pet;
import Model.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RetrofitClient {
    @GET("user")
    @Headers("Content-Type: application/json")
    Call<List<User>> getUsers();



    @GET("users")
    @Headers("Content-Type: application/json")
    Call<List<User>> getUserFromUsername(@Query("username") String username);

    @GET("posts/10/comments")
    @Headers("Content-Type: application/json")
    Call<List<String>> getPosts();

    @GET("users/{id}/todos?completed=false")
    @Headers("Content-Type: application/json")
    Call<List<User>> getTodos(@Path("id") int id);

    @POST("users")
    @Headers("Content-Type: application/json")
    Call<User> newUser(@Body User user);

    @PUT ("posts/1")
    @Headers("Content-Type: application/json")
    Call<User> updateUser(@Body User post);

    @DELETE ("posts/1")
    @Headers("Content-Type: application/json")
    Call<User> deleteUser(@Query("id") int id);

}
