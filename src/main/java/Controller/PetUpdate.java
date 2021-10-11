package Controller;

import Model.Pet;
import Service.PetService;
import lombok.SneakyThrows;

public class PetUpdate extends PetAdd{
    public static PetUpdate petController;

    @SneakyThrows
    public static synchronized PetUpdate getInstance() {
        if (petController == null) {
            petController = new PetUpdate();
        }
        return petController;
    }
    public Pet petUpdate(){
        Pet pet = makePet();
        return PetService.getInstance().updatePet(pet);
    }
}
