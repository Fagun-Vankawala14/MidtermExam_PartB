/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermreview;

import java.util.Scanner;
import static midtermreview.VendingMachineItem.candies;
import static midtermreview.VendingMachineItem.itemAvailability;
import static midtermreview.VendingMachineItem.prices;

/**
 *
 * @author user
 */
public class Main {
    
    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < 4; i++) {
            System.out.println((i+1) + ". " + candies[i] + " - $" + prices[i]);
        }
    }
    
    
    public static void selectItem(int itemIndex, double moneyInserted) {
        if (itemIndex < 0 || itemIndex >= candies.length) {
            System.out.println("Invalid selection.");
            return;
        }

        if (!itemAvailability[itemIndex]) {
            System.out.println("Sorry, " + candies[itemIndex] + " is sold out.");
            return;
        }

        if (moneyInserted < prices[itemIndex]){
            System.out.println("Insufficient funds. Please insert at least $" + prices[itemIndex]);
            return;
        }

        // Process the purchase
        itemAvailability[itemIndex] = false; // Mark the item as sold out
        double change = moneyInserted - prices[itemIndex];
        System.out.println("Dispensing " + candies[itemIndex]);
        System.out.printf("Your change is $%.2f\n", change);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Please select an item by entering the corresponding number (or 0 to exit):");
            int selection = sc.nextInt();
            if (selection == 0) {
                System.out.println("Exiting the vending machine. Thank you!");
                break;
            }

            System.out.println("Please insert money:");
            double moneyInserted = sc.nextDouble();

            // Adjust selection to match array index
            selectItem(selection - 1, moneyInserted);
        }

        sc.close();
}
    
}
