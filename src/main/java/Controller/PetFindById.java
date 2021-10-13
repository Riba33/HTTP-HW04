package Controller;

import Model.Order;
import Model.Pet;
import Service.PetService;
import Service.StoreService;
import lombok.SneakyThrows;

public class PetFindById extends PetAdd{
    public static PetFindById petController;

    @SneakyThrows
    public static synchronized PetFindById getInstance() {
        if (petController == null) {
            petController = new PetFindById();
        }
        return petController;
    }
    public Pet petFindById(){
        Long id = checkPetId();
        return PetService.getInstance().getPetById(id);
    }

}
