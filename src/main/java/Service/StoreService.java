package Service;

import Model.ApiResponse;
import Model.Order;
import Repository.RetrofitClientStore;
import Util.RetrofitConfig;
import lombok.SneakyThrows;
import retrofit2.Call;

import java.util.Map;

public class StoreService {
    private static StoreService service;
    @SneakyThrows
    public static synchronized StoreService getInstance(){
        if (service == null) {
            service = new StoreService();
        }
        return service;
    }
    RetrofitClientStore store = RetrofitConfig.createClient(RetrofitClientStore.class);

    @SneakyThrows
    public Map<String,Integer> getInventory(){
        Call<Map<String, Integer>> inventori = store.getInventori();
        return RetrofitConfig.execute(inventori);
    }

    @SneakyThrows
    public Order addOder(Order order){
        Call<Order> orderCall = store.addOrder(order);
        return RetrofitConfig.execute(orderCall);
    }

    @SneakyThrows
    public Order getOrderById(Long id){
        Call<Order> orderCall = store.getOrderById(id);
        return RetrofitConfig.execute(orderCall);
    }

    @SneakyThrows
    public ApiResponse deleteOrderById(Long id){
        Call<ApiResponse> call = store.deleteById(id);
        return RetrofitConfig.execute(call);
    }
}
