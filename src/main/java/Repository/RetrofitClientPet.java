package Repository;

import Model.ApiResponse;
import Model.Pet;
import Model.PetStatus;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RetrofitClientPet {

    @GET("pet/{petId}")
    Call<Pet> getPet(@Path("petId") Long id);

    @Multipart
    @POST("pet/{petId}/uploadImage")
    Call<ApiResponse> uploadPetImage(@Path("petId") Long id, @Part MultipartBody.Part file, @Part MultipartBody.Part additionalMetadata);

    @POST("pet")
    Call<Pet> addPet(@Body Pet pet);

    @PUT("pet")
    Call<Pet> updatePet(@Body Pet pet);

    @GET("pet/findByStatus")
    Call<List<Pet>> listPetByStatus(@Query("status") PetStatus status);

    @FormUrlEncoded
    @POST("pet/{petId}")
    Call<ApiResponse> updateById(@Path("petId") Long id, @Field("name") String name, @Field("status") PetStatus status);

    @DELETE("pet/{petId}")
    Call<ApiResponse> deleteById(@Path("petId") Long id);
}
