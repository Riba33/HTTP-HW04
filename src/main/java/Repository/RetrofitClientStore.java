package Repository;

import Model.ApiResponse;
import Model.Order;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface RetrofitClientStore {

    @GET("store/inventory")
    @Headers("Content-Type: application/json")
    Call<Map<String,Integer>> getInventori();

    @POST("store/order")
    @Headers("Content-Type: application/json")
    Call<Order> addOrder(@Body Order order);

    @GET("store/order/{orderId}")
    @Headers("Content-Type: application/json")
    Call<Order> getOrderById(@Path("orderId") Long id);

    @DELETE("store/order/{orderId}")
    @Headers("Content-Type: application/json")
    Call<ApiResponse> deleteById(@Path("orderId") Long id);

}
