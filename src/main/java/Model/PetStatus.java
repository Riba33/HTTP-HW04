package Model;

public enum PetStatus {
    AVAILABLE ("available"),
    PENDING ("pending"),
    SOLD ("sold");
    private String name;

    PetStatus(String name) {
        this.name = name;
    }
}
