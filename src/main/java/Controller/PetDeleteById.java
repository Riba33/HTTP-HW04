package Controller;

import Model.ApiResponse;
import Service.PetService;
import lombok.SneakyThrows;

public class PetDeleteById extends PetAdd{
    public static PetDeleteById petController;

    @SneakyThrows
    public static synchronized PetDeleteById getInstance() {
        if (petController == null) {
            petController = new PetDeleteById();
        }
        return petController;
    }
    public ApiResponse deletePetById(){
        System.out.println("Enter petId");
        Long id = getId();
        return PetService.getInstance().deletePetById(id);
    }
}
