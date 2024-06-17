package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    public double price;
    
    public static String[] candies = {"chocolate bar", "sour candy", "soft drink", "potato chips"};
    public static double[] prices = {1.50, 1.20, 1.80, 2.00};
    public static boolean[] itemAvailability = {true, true, true, true}; 
    
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
        System.out.println("Enter the quantity of items that you want to buy:");
        int choice = sc.nextInt();
        
        if (choice < 1 || choice > candies.length) {
            System.out.println("Invalid Quantity.Try again.");
        } else {
            int index = choice - 1;
            if (itemAvailability[index]) {
                System.out.println("You have selected " + candies[index] + " which costs $" + prices[index]);
                System.out.println("Please insert the amount: ");
                double amountInserted = sc.nextDouble();
                
                if (amountInserted >= prices[index]) {
                    double change = amountInserted - prices[index];
                    System.out.println("Thank you for your purchasing: Your change is $" + change);
                    itemAvailability[index] = false; 
                } else {
                    System.out.println("Insufficient amount. Transaction cancelled.");
                }
            } else {
                System.out.println("Sorry, the item is out of stock. Please select another item.");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            selectItem();
            System.out.println("Do you want to purchase another item? (yes/no)");
            String continueChoice = sc.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Thank you for using this vending machine");
    }
}