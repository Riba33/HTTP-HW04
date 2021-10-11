package Service;

import Model.ApiResponse;
import Model.Pet;
import Model.PetStatus;
import Repository.RetrofitClientPet;
import Util.RetrofitConfig;
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

import java.io.File;
import java.util.List;

public class PetService {
    private static PetService service;
    @SneakyThrows
            public static synchronized PetService getInstance(){
        if (service == null) {
            service = new PetService();
        }
        return service;
    }

    RetrofitClientPet clientPet = RetrofitConfig.createClient(RetrofitClientPet.class);
    @SneakyThrows
    public ApiResponse uploadImage(Long id, String fileName, String metaData){
        File file = new File(fileName);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                "file",
                file.getName(),
                RequestBody.create(file, MediaType.parse("image/*")));
        MultipartBody.Part metaDataPart = MultipartBody.Part.createFormData("additionalMetadata",metaData);
        Call<ApiResponse> apiResponse = clientPet.uploadPetImage(id, filePart, metaDataPart);
        return RetrofitConfig.execute(apiResponse);
    }
    @SneakyThrows
    public Pet addPet(Pet pet) {
        Call<Pet> petCall = clientPet.addPet(pet);
        return RetrofitConfig.execute(petCall);
    }
    @SneakyThrows
    public Pet updatePet(Pet pet) {
        Call<Pet> updatedPet = clientPet.updatePet(pet);
        return RetrofitConfig.execute(updatedPet);
    }
    @SneakyThrows
    public List<Pet> listPetByStatus(PetStatus status) {
        Call<List<Pet>> listCall = clientPet.listPetByStatus(status);
        return RetrofitConfig.execute(listCall);
    }
    @SneakyThrows
    public Pet getPetById(Long id){
        Call<Pet> petCall = clientPet.getPet(id);
        return RetrofitConfig.execute(petCall);
    }
    @SneakyThrows
    public ApiResponse updatePetById(Long id, String name, PetStatus status){
        Call<ApiResponse> call = clientPet.updateById(id, name, status);
        return RetrofitConfig.execute(call);
    }
    @SneakyThrows
    public ApiResponse deletePetById(Long id){
        Call<ApiResponse> call = clientPet.deleteById(id);
        return RetrofitConfig.execute(call);
    }
}
