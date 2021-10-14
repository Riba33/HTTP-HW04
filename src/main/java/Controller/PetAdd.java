package Controller;

import Model.Category;
import Model.Pet;
import Model.PetStatus;
import Model.Tag;
import Service.PetService;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class PetAdd extends BaseController{
    public static PetAdd petController;

    @SneakyThrows
    public static synchronized PetAdd getInstance() {
        if (petController == null) {
            petController = new PetAdd();
        }
        return petController;
    }
    public Pet addPet(){
        Pet pet = makePet();
        return PetService.getInstance().addPet(pet);
    }
    Pet makePet(){
        Pet pet = new Pet();
        System.out.println("Enter petId.");
        pet.setId(getId());
        Category category = makeCategory();
        pet.setCategory(category);
        System.out.println("Enter petName");
        pet.setName(scanner.next());
        pet.setPhotoUrls(makePhotoUrls());
        pet.setTags(makeTags());
        pet.setStatus(getStatus());
    return pet;
    }
    Category makeCategory(){
        Category category = new Category();
        System.out.println("Enter categoryId");
        category.setId(getId());
        System.out.println("Enter categoryName");
        category.setName(scanner.next());
        return category;
    }
    String[] makePhotoUrls(){
        List<String> list= new ArrayList<String>();
        do {
            System.out.println("Enter photo url");
            list.add(scanner.next());
            System.out.println("Do you want to add another photo url?");

        } while (yesOrNo());
        return list.toArray(new String[list.size()]);
    }
    Tag[] makeTags(){
        List<Tag> list = new ArrayList<Tag>();
        do {
            Tag tag = new Tag();
            System.out.println("Enter tagId");
            tag.setId(getId());
            System.out.println("Enter tagName");
            tag.setName(scanner.next());
            list.add(tag);
            System.out.println("Do you want to add another petTag?");
        } while (yesOrNo());
        return list.toArray(new Tag[list.size()]);
    }
    PetStatus getStatus(){
        System.out.println("Select petStatus. 1 - available, 2 - pending, 3 - sold.");
        int i = selectNumber(3,1);
        PetStatus petStatus =null;
        switch (i) {
            case 1:
                petStatus = PetStatus.available;
                break;
            case 2:
                petStatus = PetStatus.pending;
                break;
            case 3:
                petStatus = PetStatus.sold;
                break;
        }
        return petStatus;
    }
    Long checkPetId(){
        Pet pet;
        PetService petService = PetService.getInstance();
        Long id;
        boolean i;
        do {
            i = false;
            System.out.println("Enter petId");
            id = getId();
            pet = petService.getPetById(id);
            if (pet == null) {
                System.out.println("This Pet is not found.\nDo you want enter another petId?");
                i = yesOrNo();
            }
        } while (i);
        return id;
    }
}
