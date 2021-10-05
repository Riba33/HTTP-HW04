package Model;

public enum PetStatus {
    available ("available"),
    pending ("pending"),
    sold ("sold");
    private String name;

    PetStatus(String name) {
        this.name = name;
    }
}
