package Controller;

import Model.ApiResponse;
import Model.Pet;
import lombok.SneakyThrows;

import java.util.List;

public class PetController extends BaseController {
    public static PetController petController;

    @SneakyThrows
    public static synchronized PetController getInstance() {
        if (petController == null) {
            petController = new PetController();
        }
        return petController;
    }

    public void petMenu(){
        System.out.println("Select query.\n" +
                "1 - Upload image to pet.\n" +
                "2 - Add new pet to store.\n" +
                "3 - Update an existing pet\n" +
                "4 - Find pets by status.\n" +
                "5 - Find pet by Id.\n" +
                "6 - Update name and status by petId.\n" +
                "7 - Delete pet by Id.\n" +
                "0 - Return to previous menu.");
        int i = selectNumber(7, 0);
        switchSelected(i);
    }

    private void switchSelected(int i){
        switch (i) {
            case 1:
                ApiResponse apiResponse = PetUploadImage.getInstance().uploadImage();
                System.out.println(apiResponse);
                break;
            case 2:
                Pet pet = PetAdd.getInstance().addPet();
                System.out.println(pet);
                break;
            case 3:
                Pet pet1 = PetUpdate.getInstance().petUpdate();
                System.out.println(pet1);
                break;
            case 4:
                List<Pet> list = PetFindByStatus.getInstance().petFindByStatus();
                System.out.println(list);
                break;
            case 5:
                Pet pet2 = PetFindById.getInstance().petFindById();
                System.out.println(pet2);
                break;
            case 6:
                ApiResponse apiResponse1 = PetUpdateById.getInstance().petUpdateById();
                System.out.println(apiResponse1);
                break;
            case 7:
                ApiResponse apiResponse2 = PetDeleteById.getInstance().deletePetById();
                System.out.println(apiResponse2);
                break;
            case 0:
                Console.getInstance().start();
                break;
        }
    }
}