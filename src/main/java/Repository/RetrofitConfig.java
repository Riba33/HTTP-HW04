package Repository;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitConfig {
    public static <T> T createClient(String apiUrl, Class<T> clientClass) {
        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(clientClass);
    }

    public static <T> T execute(Call <T> call) throws IOException {
        Response<T> response = call.execute();
        if (response.isSuccessful()) return response.body();
        else{
            String errorMessage = "HTTP code : " + response.code() + " -> " + response.errorBody().string();
            System.out.println(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }
}