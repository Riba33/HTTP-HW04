package Controller;

import Model.Pet;
import Service.PetService;
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
        System.out.println("Enter petId");
        Long id = getId();
        return PetService.getInstance().getPetById(id);
    }
}
