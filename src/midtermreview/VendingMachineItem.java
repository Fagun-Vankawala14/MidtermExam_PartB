package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    public double price;
    
    public static String[] candies = {"chocolate bar", "sour candy", "soft drink", "potato chips"};
    public static double[] prices = {1.50, 1.20, 1.80, 2.00};
    public static boolean[] itemAvailability = {true, true, true, true}; // Initially all items are available
    
    public VendingMachineItem() {
        // Constructor left blank intentionally
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double givenPrice) {
        price = givenPrice;
    }
    
    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < candies.length; i++) {
            String availability = itemAvailability[i] ? "Available" : "Unavailable";
            System.out.println((i+1) + ". " + candies[i] + " - $" + prices[i] + " - " + availability);
        }
    }
    
    public static void selectItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of the items you want to buy:");
        int choice = sc.nextInt();
        
        if (choice < 1 || choice > candies.length) {
            System.out.println("Invalid selection. Please try again.");
        } else {
            int index = choice - 1;
            if (itemAvailability[index]) {
                System.out.println("You have selected " + candies[index] + " which costs $" + prices[index]);
                System.out.println("Please insert the price: ");
                double amountInserted = sc.nextDouble();
                
                if (amountInserted >= prices[index]) {
                    double change = amountInserted - prices[index];
                    System.out.println("Thanks for your purchasing! Your change is $" + change);
                    itemAvailability[index] = false; // Update the item as unavailable after purchase
                } else {
                    System.out.println("Not enough amount inserted. Transaction cancelled.");
                }
            } else {
                System.out.println("Item is unavailable. Choose another item.");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            selectItem();
            System.out.println("Do you want to purchase another item? (yes or no)");
            String continueChoice = sc.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Thanks for using the vending machine!");
    }
}