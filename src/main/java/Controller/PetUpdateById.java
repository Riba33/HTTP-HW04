package Controller;

import Model.ApiResponse;
import Model.PetStatus;
import Service.PetService;
import lombok.SneakyThrows;

public class PetUpdateById extends PetAdd{
    public static PetUpdateById petController;

    @SneakyThrows
    public static synchronized PetUpdateById getInstance() {
        if (petController == null) {
            petController = new PetUpdateById();
        }
        return petController;
    }
    public ApiResponse petUpdateById(){
        System.out.println("Enter petId");
        Long id = getId();
        System.out.println("Enter petName.");
        String name = scanner.nextLine();
        PetStatus status = getStatus();
        return PetService.getInstance().updatePetById(id, name, status);
    }
}
