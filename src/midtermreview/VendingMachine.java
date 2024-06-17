//Aayush Soni - 991730544

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermreview;

/**
 *
 * @author AAYUSH SONI
 */
import java.util.Scanner;

public class VendingMachine {
    private static VendingMachineItem[] items = {
        new VendingMachineItem("chocolate bar", 1.50, true),
        new VendingMachineItem("sour candy", 1.20, true),
        new VendingMachineItem("soft drink", 1.80, true),
        new VendingMachineItem("potato chips", 2.00, true)
    };

    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].getName() + " - $" + items[i].getPrice());
        }
    }

    public static void selectItem(int choice) {
        int index = choice - 1;
        if (index >= 0 && index < items.length) {
            if (items[index].isAvailable()) {
                System.out.println("You have selected: " + items[index].getName());
                System.out.println("Please insert $" + items[index].getPrice());
                items[index].setAvailable(false);
            } else {
                System.out.println("Sorry, " + items[index].getName() + " is currently unavailable.");
            }
        } else {
            System.out.println("Invalid selection. Please choose a number from 1 to " + items.length);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();

        System.out.print("Enter your choice (1-" + items.length + "): ");
        int choice = sc.nextInt();

        selectItem(choice);
    }
}
