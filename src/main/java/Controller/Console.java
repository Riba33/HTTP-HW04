package Controller;

import lombok.SneakyThrows;

import java.util.Scanner;

public class Console extends BaseController{
    public static Console console;
    private Scanner scanner = new Scanner(System.in);

    @SneakyThrows
    public static synchronized Console getInstance() {
        if (console == null) {
            console = new Console();
        }
        return console;
    }
    public void start() {
        do {
            System.out.println("Select model: 1 - Pet, 2 - Store, 3 - User.");
            int i = selectNumber(3, 0);
            switchSelected(i);
            System.out.println("Do you want to return to MainMenu?");
        } while (yesOrNo());
    }
    @SneakyThrows
    private void switchSelected(int i) {
        switch (i){
            case 1:
                PetController.getInstance().petMenu();
                break;
            case 2:
                OrderController.getInstance().orderMenu();
                break;
            case 3:
                UserController.getInstance().userMenu();
                break;
        }
    }
}
