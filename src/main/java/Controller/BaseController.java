package Controller;

import Model.User;

import java.util.Scanner;

public abstract class BaseController {
    Scanner scanner = new Scanner(System.in);
    Boolean selectIsGood(int i, int max, int min) {
        if (i >= min && i <= max) return true;
        else {
            return false;
        }
    }
    int selectNumber(int max, int min){
        int i;
        do {
            System.out.println("Make your choice from the suggested values!");
            while (!scanner.hasNextInt()){
                System.out.println("Please enter a number from "+min+" to "+max+"!");
                scanner.next();
            }
            i = scanner.nextInt();
        }
        while (!selectIsGood(i,max,min));
        return i;
    }
    boolean yesOrNo(){
        System.out.println("1 - YES !, 0 - NO !.");
        int i;
        do { System.out.println("Please enter only 1 or 0!");
            i = getInt();
        } while (!selectIsGood(i,1,0));
        if (i == 1) return true;
        return false;
    }
    int getInt(){
        int i;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter digit value!");
            scanner.next();
        }
        i = scanner.nextInt();
        return i;
    }
    Long getId(){
        Long id;
        while (!scanner.hasNextInt()){
            System.out.println("Please enter digit value!");
            scanner.next();
        }
        id = scanner.nextLong();
        return id;
    }
    User makeUser(){
        User user = new User();
        System.out.println("Enter userId");
        user.setId(getId());
        System.out.println("Enter userName");
        user.setUsername(scanner.next());
        System.out.println("Enter firstName");
        user.setFirstName(scanner.next());
        System.out.println("Enter lastName");
        user.setLastName(scanner.next());
        System.out.println("Enter email");
        user.setEmail(scanner.next());
        System.out.println("Enter password");
        user.setPassword(scanner.next());
        System.out.println("Enter phone");
        user.setPhone(scanner.next());
        System.out.println("Enter userStatus");
        user.setUserStatus(getInt());
        return user;
    }
    String getUsername() {
        System.out.println("Enter userName");
        return scanner.next();
    }
}
