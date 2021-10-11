package Controller;

import Model.ApiResponse;
import Service.PetService;
import lombok.SneakyThrows;

public class PetUploadImage extends BaseController{
    public static PetUploadImage petController;

    @SneakyThrows
    public static synchronized PetUploadImage getInstance() {
        if (petController == null) {
            petController = new PetUploadImage();
        }
        return petController;
    }
    public ApiResponse uploadImage(){
        System.out.println("Enter petId");
        Long id = getId();
        System.out.println("Enter additional metadata");
        String metaData = scanner.next();
        System.out.println("Enter url for image");
        String url = scanner.next();
        return PetService.getInstance().uploadImage(id,url,metaData);
    }
}
