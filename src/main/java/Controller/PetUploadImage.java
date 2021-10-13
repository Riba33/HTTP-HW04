package Controller;

import Model.ApiResponse;
import Service.PetService;
import lombok.SneakyThrows;

public class PetUploadImage extends PetAdd{
    public static PetUploadImage petController;

    @SneakyThrows
    public static synchronized PetUploadImage getInstance() {
        if (petController == null) {
            petController = new PetUploadImage();
        }
        return petController;
    }
    public ApiResponse uploadImage(){
        Long id = checkPetId();
        scanner.nextLine();
        System.out.println("Enter additional metadata");
        String metaData = scanner.nextLine();
        System.out.println("Enter url for image");
        String url = scanner.nextLine();
        return PetService.getInstance().uploadImage(id,url,metaData);
    }
}
