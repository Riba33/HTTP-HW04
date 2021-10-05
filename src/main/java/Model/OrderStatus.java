package Model;

public enum OrderStatus {
    placed ("placed"),
    approved ("approved"),
    delivered ("delivered");
    private String name;

    OrderStatus(String name) {
        this.name = name;
    }
}
