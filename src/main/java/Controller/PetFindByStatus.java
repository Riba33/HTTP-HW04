package Controller;

import Model.Pet;
import Model.PetStatus;
import Service.PetService;
import lombok.SneakyThrows;

import java.util.List;

public class PetFindByStatus extends PetAdd{
    public static PetFindByStatus petController;

    @SneakyThrows
    public static synchronized PetFindByStatus getInstance() {
        if (petController == null) {
            petController = new PetFindByStatus();
        }
        return petController;
    }
    public List<Pet> petFindByStatus(){
        PetStatus petStatus = getStatus();
        return PetService.getInstance().listPetByStatus(petStatus);
    }
}
